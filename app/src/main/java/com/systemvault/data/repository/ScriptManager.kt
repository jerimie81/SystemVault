package com.systemvault.data.repository

import android.content.Context
import com.systemvault.data.preferences.PreferencesRepository
import com.topjohnwu.superuser.Shell
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.File
import javax.inject.Inject

class ScriptManager @Inject constructor(
    @ApplicationContext private val context: Context,
    private val preferencesRepository: PreferencesRepository
) {
    private val scriptName = "secure_backup.sh"

    fun ensureScriptInstalled(): File {
        val target = File(context.filesDir, scriptName)
        val currentVersion = preferencesRepository.getScriptVersion()
        if (!target.exists() || currentVersion != SCRIPT_VERSION) {
            context.assets.open("scripts/$scriptName").use { input ->
                target.outputStream().use { output ->
                    input.copyTo(output)
                }
            }
            Shell.cmd("chmod 755 ${target.absolutePath}").exec()
            preferencesRepository.setScriptVersion(SCRIPT_VERSION)
        }
        return target
    }

    companion object {
        private const val SCRIPT_VERSION = 1
    }
}
