package com.systemvault.data.repository;

import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/systemvault/data/repository/ShellRepository;", "", "scriptManager", "Lcom/systemvault/data/repository/ScriptManager;", "shellExecutor", "Lcom/systemvault/data/repository/ShellExecutor;", "(Lcom/systemvault/data/repository/ScriptManager;Lcom/systemvault/data/repository/ShellExecutor;)V", "ensureScriptInstalled", "Ljava/io/File;", "runCommand", "Lkotlinx/coroutines/flow/Flow;", "", "command", "app_debug"})
public final class ShellRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.systemvault.data.repository.ScriptManager scriptManager = null;
    @org.jetbrains.annotations.NotNull()
    private final com.systemvault.data.repository.ShellExecutor shellExecutor = null;
    
    @javax.inject.Inject()
    public ShellRepository(@org.jetbrains.annotations.NotNull()
    com.systemvault.data.repository.ScriptManager scriptManager, @org.jetbrains.annotations.NotNull()
    com.systemvault.data.repository.ShellExecutor shellExecutor) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.String> runCommand(@org.jetbrains.annotations.NotNull()
    java.lang.String command) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.io.File ensureScriptInstalled() {
        return null;
    }
}