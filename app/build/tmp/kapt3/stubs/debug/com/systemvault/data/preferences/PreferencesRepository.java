package com.systemvault.data.preferences;

import android.content.Context;
import dagger.hilt.android.qualifiers.ApplicationContext;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\tJ\u000e\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\tJ\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\fJ\u000e\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/systemvault/data/preferences/PreferencesRepository;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "prefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "getExcludeCache", "", "getExcludeMedia", "getLastBackup", "", "getScriptVersion", "", "getUserPreferences", "Lcom/systemvault/data/preferences/UserPreferences;", "setExcludeCache", "", "enabled", "setExcludeMedia", "setLastBackup", "timestamp", "setScriptVersion", "version", "Companion", "app_debug"})
public final class PreferencesRepository {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    private final android.content.SharedPreferences prefs = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String PREFS_NAME = "systemvault_prefs";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_LAST_BACKUP = "last_backup";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_EXCLUDE_MEDIA = "exclude_media";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_EXCLUDE_CACHE = "exclude_cache";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_SCRIPT_VERSION = "script_version";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_COMPRESSION_LEVEL = "compression_level";
    @org.jetbrains.annotations.NotNull()
    public static final com.systemvault.data.preferences.PreferencesRepository.Companion Companion = null;
    
    @javax.inject.Inject()
    public PreferencesRepository(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    public final void setLastBackup(@org.jetbrains.annotations.NotNull()
    java.lang.String timestamp) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLastBackup() {
        return null;
    }
    
    public final void setExcludeMedia(boolean enabled) {
    }
    
    public final boolean getExcludeMedia() {
        return false;
    }
    
    public final void setExcludeCache(boolean enabled) {
    }
    
    public final boolean getExcludeCache() {
        return false;
    }
    
    public final void setScriptVersion(int version) {
    }
    
    public final int getScriptVersion() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.systemvault.data.preferences.UserPreferences getUserPreferences() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/systemvault/data/preferences/PreferencesRepository$Companion;", "", "()V", "KEY_COMPRESSION_LEVEL", "", "KEY_EXCLUDE_CACHE", "KEY_EXCLUDE_MEDIA", "KEY_LAST_BACKUP", "KEY_SCRIPT_VERSION", "PREFS_NAME", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}