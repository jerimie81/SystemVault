package com.systemvault.data.repository

import com.topjohnwu.superuser.Shell
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.InputStreamReader
import javax.inject.Inject

class ShellExecutor @Inject constructor() {
    fun runCommand(command: String): Flow<String> = flow {
        val rootCheck = Shell.cmd("id").exec()
        if (!rootCheck.isSuccess) {
            emit("ERROR: root access unavailable")
            return@flow
        }

        val process = ProcessBuilder("su", "-c", command)
            .redirectErrorStream(true)
            .start()

        withContext(Dispatchers.IO) {
            BufferedReader(InputStreamReader(process.inputStream)).useLines { lines ->
                lines.forEach { line ->
                    emit(line)
                }
            }
        }

        val exitCode = process.waitFor()
        if (exitCode != 0) {
            emit("ERROR: exitCode=$exitCode")
        }
    }
}
