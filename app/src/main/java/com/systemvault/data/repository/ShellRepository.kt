package com.systemvault.data.repository

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ShellRepository @Inject constructor(
    private val scriptManager: ScriptManager,
    private val shellExecutor: ShellExecutor
) {
    fun runCommand(command: String): Flow<String> = shellExecutor.runCommand(command)

    fun ensureScriptInstalled() = scriptManager.ensureScriptInstalled()
}
