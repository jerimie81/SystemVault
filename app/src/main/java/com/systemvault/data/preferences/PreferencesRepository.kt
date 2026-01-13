package com.systemvault.data.preferences

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class PreferencesRepository @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun setLastBackup(timestamp: String) {
        prefs.edit().putString(KEY_LAST_BACKUP, timestamp).apply()
    }

    fun getLastBackup(): String = prefs.getString(KEY_LAST_BACKUP, "Never") ?: "Never"

    fun setExcludeMedia(enabled: Boolean) {
        prefs.edit().putBoolean(KEY_EXCLUDE_MEDIA, enabled).apply()
    }

    fun getExcludeMedia(): Boolean = prefs.getBoolean(KEY_EXCLUDE_MEDIA, false)

    fun setExcludeCache(enabled: Boolean) {
        prefs.edit().putBoolean(KEY_EXCLUDE_CACHE, enabled).apply()
    }

    fun getExcludeCache(): Boolean = prefs.getBoolean(KEY_EXCLUDE_CACHE, true)

    fun setScriptVersion(version: Int) {
        prefs.edit().putInt(KEY_SCRIPT_VERSION, version).apply()
    }

    fun getScriptVersion(): Int = prefs.getInt(KEY_SCRIPT_VERSION, 0)

    fun getUserPreferences(): UserPreferences = UserPreferences(
        excludeMedia = getExcludeMedia(),
        compressionLevel = prefs.getInt(KEY_COMPRESSION_LEVEL, 6),
        excludeCache = getExcludeCache()
    )

    companion object {
        private const val PREFS_NAME = "systemvault_prefs"
        private const val KEY_LAST_BACKUP = "last_backup"
        private const val KEY_EXCLUDE_MEDIA = "exclude_media"
        private const val KEY_EXCLUDE_CACHE = "exclude_cache"
        private const val KEY_SCRIPT_VERSION = "script_version"
        private const val KEY_COMPRESSION_LEVEL = "compression_level"
    }
}
