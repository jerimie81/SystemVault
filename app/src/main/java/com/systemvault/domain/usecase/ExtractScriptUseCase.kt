package com.systemvault.domain.usecase

import com.systemvault.data.repository.ShellRepository
import javax.inject.Inject

class ExtractScriptUseCase @Inject constructor(
    private val shellRepository: ShellRepository
) {
    fun execute() = shellRepository.ensureScriptInstalled()
}
