package com.systemvault.domain.usecase;

import com.systemvault.data.repository.ShellRepository;
import com.systemvault.data.repository.StorageRepository;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/systemvault/domain/usecase/ExecuteBackupUseCase;", "", "shellRepository", "Lcom/systemvault/data/repository/ShellRepository;", "storageRepository", "Lcom/systemvault/data/repository/StorageRepository;", "(Lcom/systemvault/data/repository/ShellRepository;Lcom/systemvault/data/repository/StorageRepository;)V", "execute", "Lkotlinx/coroutines/flow/Flow;", "", "options", "Lcom/systemvault/domain/usecase/BackupOptions;", "app_debug"})
public final class ExecuteBackupUseCase {
    @org.jetbrains.annotations.NotNull()
    private final com.systemvault.data.repository.ShellRepository shellRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.systemvault.data.repository.StorageRepository storageRepository = null;
    
    @javax.inject.Inject()
    public ExecuteBackupUseCase(@org.jetbrains.annotations.NotNull()
    com.systemvault.data.repository.ShellRepository shellRepository, @org.jetbrains.annotations.NotNull()
    com.systemvault.data.repository.StorageRepository storageRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.String> execute(@org.jetbrains.annotations.NotNull()
    com.systemvault.domain.usecase.BackupOptions options) {
        return null;
    }
}