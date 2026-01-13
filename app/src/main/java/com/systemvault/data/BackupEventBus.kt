package com.systemvault.data

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

object BackupEventBus {
    private val _events = MutableSharedFlow<BackupEvent>(extraBufferCapacity = 64)
    val events = _events.asSharedFlow()

    fun emit(event: BackupEvent) {
        _events.tryEmit(event)
    }
}

data class BackupEvent(
    val message: String,
    val isError: Boolean = false
)
