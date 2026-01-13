package com.systemvault.data.repository

import android.os.StatFs
import javax.inject.Inject

class StorageRepository @Inject constructor() {
    fun getStorageStatus(path: String): StorageStatus {
        return try {
            val statFs = StatFs(path)
            val blockSize = statFs.blockSizeLong
            val total = statFs.blockCountLong * blockSize
            val available = statFs.availableBlocksLong * blockSize
            StorageStatus(totalBytes = total, availableBytes = available)
        } catch (exception: IllegalArgumentException) {
            StorageStatus(totalBytes = 0, availableBytes = 0)
        }
    }
}

data class StorageStatus(
    val totalBytes: Long,
    val availableBytes: Long
) {
    fun format(): String {
        if (totalBytes <= 0) {
            return "Unavailable"
        }
        val totalGb = totalBytes / (1024.0 * 1024.0 * 1024.0)
        val availableGb = availableBytes / (1024.0 * 1024.0 * 1024.0)
        return "Total: %.2f GB, Free: %.2f GB".format(totalGb, availableGb)
    }
}
