package com.systemvault.data.repository;

import android.content.Context;
import com.systemvault.data.preferences.PreferencesRepository;
import com.topjohnwu.superuser.Shell;
import dagger.hilt.android.qualifiers.ApplicationContext;
import java.io.File;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0019\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/systemvault/data/repository/ScriptManager;", "", "context", "Landroid/content/Context;", "preferencesRepository", "Lcom/systemvault/data/preferences/PreferencesRepository;", "(Landroid/content/Context;Lcom/systemvault/data/preferences/PreferencesRepository;)V", "scriptName", "", "ensureScriptInstalled", "Ljava/io/File;", "Companion", "app_debug"})
public final class ScriptManager {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final com.systemvault.data.preferences.PreferencesRepository preferencesRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String scriptName = "secure_backup.sh";
    private static final int SCRIPT_VERSION = 1;
    @org.jetbrains.annotations.NotNull()
    public static final com.systemvault.data.repository.ScriptManager.Companion Companion = null;
    
    @javax.inject.Inject()
    public ScriptManager(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.systemvault.data.preferences.PreferencesRepository preferencesRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.io.File ensureScriptInstalled() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/systemvault/data/repository/ScriptManager$Companion;", "", "()V", "SCRIPT_VERSION", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}