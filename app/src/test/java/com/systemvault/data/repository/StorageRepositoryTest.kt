package com.systemvault.data.repository

import org.junit.Assert.assertNotNull
import org.junit.Test

class StorageRepositoryTest {
    @Test
    fun formatHandlesZero() {
        val status = StorageStatus(totalBytes = 0, availableBytes = 0)
        assertNotNull(status.format())
    }
}
