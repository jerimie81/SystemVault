package com.systemvault.domain.usecase

import com.systemvault.data.repository.ShellRepository
import com.systemvault.data.repository.StorageRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class ExecuteBackupUseCase @Inject constructor(
    private val shellRepository: ShellRepository,
    private val storageRepository: StorageRepository
) {
    fun execute(options: BackupOptions): Flow<String> {
        val status = storageRepository.getStorageStatus(options.backupPath)
        if (status.availableBytes < options.minimumFreeBytes) {
            return flowOf("ERROR: insufficient storage")
        }

        val script = shellRepository.ensureScriptInstalled()
        val excludeMediaFlag = if (options.excludeMedia) "1" else "0"
        val excludeCacheFlag = if (options.excludeCache) "1" else "0"
        val command = "${script.absolutePath} \"${options.backupPath}\" $excludeMediaFlag $excludeCacheFlag"
        return shellRepository.runCommand(command)
    }
}

data class BackupOptions(
    val backupPath: String,
    val excludeMedia: Boolean,
    val excludeCache: Boolean,
    val minimumFreeBytes: Long = 512L * 1024L * 1024L
)
