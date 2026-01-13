package com.systemvault.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.os.PowerManager
import android.util.Log
import androidx.core.app.NotificationCompat
import com.systemvault.data.BackupEvent
import com.systemvault.data.BackupEventBus
import com.systemvault.domain.usecase.BackupOptions
import com.systemvault.domain.usecase.ExecuteBackupUseCase
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class BackupService : Service() {

    @Inject lateinit var executeBackupUseCase: ExecuteBackupUseCase

    private val serviceScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private var wakeLock: PowerManager.WakeLock? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        createNotificationChannel()
        startForeground(NOTIFICATION_ID, buildNotification("Backup running"))

        val backupPath = intent?.getStringExtra(EXTRA_BACKUP_PATH).orEmpty()
        val excludeMedia = intent?.getBooleanExtra(EXTRA_EXCLUDE_MEDIA, false) ?: false
        val excludeCache = intent?.getBooleanExtra(EXTRA_EXCLUDE_CACHE, true) ?: true
        if (backupPath.isNotBlank()) {
            acquireWakeLock()
            serviceScope.launch {
                executeBackupUseCase.execute(
                    BackupOptions(
                        backupPath = backupPath,
                        excludeMedia = excludeMedia,
                        excludeCache = excludeCache
                    )
                ).collect { line ->
                    val display = if (line.startsWith("PROGRESS:")) {
                        "Progress ${line.removePrefix("PROGRESS:").trim()}%"
                    } else {
                        line
                    }
                    Log.i("SystemVault", display)
                    BackupEventBus.emit(BackupEvent(display, isError = line.startsWith("ERROR")))
                    val notification = buildNotification(display)
                    val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                    manager.notify(NOTIFICATION_ID, notification)
                }
                releaseWakeLock()
                stopSelf()
            }
        } else {
            stopSelf()
        }

        return START_NOT_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onDestroy() {
        releaseWakeLock()
        serviceScope.coroutineContext.cancel()
        super.onDestroy()
    }

    private fun buildNotification(text: String) = NotificationCompat.Builder(this, CHANNEL_ID)
        .setContentTitle("SystemVault")
        .setContentText(text)
        .setSmallIcon(android.R.drawable.stat_sys_upload)
        .setOngoing(true)
        .build()

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "Backup Operations",
                NotificationManager.IMPORTANCE_LOW
            )
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }

    companion object {
        const val CHANNEL_ID = "systemvault_backup"
        const val NOTIFICATION_ID = 1001
        const val EXTRA_BACKUP_PATH = "extra_backup_path"
        const val EXTRA_EXCLUDE_MEDIA = "extra_exclude_media"
        const val EXTRA_EXCLUDE_CACHE = "extra_exclude_cache"
    }

    private fun acquireWakeLock() {
        if (wakeLock == null) {
            val powerManager = getSystemService(Context.POWER_SERVICE) as PowerManager
            wakeLock = powerManager.newWakeLock(
                PowerManager.PARTIAL_WAKE_LOCK,
                "SystemVault:Backup"
            ).apply { acquire() }
        }
    }

    private fun releaseWakeLock() {
        wakeLock?.let {
            if (it.isHeld) {
                it.release()
            }
        }
        wakeLock = null
    }
}
