package com.systemvault.ui.viewmodel

import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.systemvault.data.BackupEventBus
import com.systemvault.data.preferences.PreferencesRepository
import com.systemvault.data.repository.StorageRepository
import com.systemvault.domain.usecase.ExtractScriptUseCase
import com.systemvault.service.BackupService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
class BackupViewModel @Inject constructor(
    private val extractScriptUseCase: ExtractScriptUseCase,
    private val preferencesRepository: PreferencesRepository,
    private val storageRepository: StorageRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(BackupUiState())
    val uiState: StateFlow<BackupUiState> = _uiState

    init {
        viewModelScope.launch {
            BackupEventBus.events.collect { event ->
                val running = when {
                    event.message.contains("Backup complete") -> false
                    event.message.startsWith("ERROR") -> false
                    else -> _uiState.value.isRunning
                }
                _uiState.update {
                    it.copy(
                        statusMessage = event.message,
                        logs = (it.logs + event.message).takeLast(200),
                        isRunning = running
                    )
                }
            }
        }
    }

    fun initialize() {
        viewModelScope.launch {
            extractScriptUseCase.execute()
            val storageStatus = storageRepository.getStorageStatus("/data").format()
            _uiState.update {
                it.copy(
                    statusMessage = "Script ready",
                    storageStatus = storageStatus,
                    lastBackup = preferencesRepository.getLastBackup(),
                    excludeMedia = preferencesRepository.getExcludeMedia(),
                    excludeCache = preferencesRepository.getExcludeCache()
                )
            }
        }
    }

    fun onExcludeMediaChanged(enabled: Boolean) {
        preferencesRepository.setExcludeMedia(enabled)
        _uiState.update { it.copy(excludeMedia = enabled) }
    }

    fun onExcludeCacheChanged(enabled: Boolean) {
        preferencesRepository.setExcludeCache(enabled)
        _uiState.update { it.copy(excludeCache = enabled) }
    }

    fun onBackupClicked(context: Context, backupPath: String) {
        val intent = Intent(context, BackupService::class.java).apply {
            putExtra(BackupService.EXTRA_BACKUP_PATH, backupPath)
            putExtra(BackupService.EXTRA_EXCLUDE_MEDIA, uiState.value.excludeMedia)
            putExtra(BackupService.EXTRA_EXCLUDE_CACHE, uiState.value.excludeCache)
        }
        context.startForegroundService(intent)
        preferencesRepository.setLastBackup(formattedNow())
        _uiState.update {
            it.copy(
                lastBackup = preferencesRepository.getLastBackup(),
                isRunning = true
            )
        }
    }

    private fun formattedNow(): String {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        return Instant.now().atZone(ZoneId.systemDefault()).format(formatter)
    }
}

data class BackupUiState(
    val statusMessage: String = "Idle",
    val logs: List<String> = emptyList(),
    val lastBackup: String = "Never",
    val storageStatus: String = "Unknown",
    val excludeMedia: Boolean = false,
    val excludeCache: Boolean = true,
    val isRunning: Boolean = false
)
