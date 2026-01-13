package com.systemvault.data.preferences

data class UserPreferences(
    val excludeMedia: Boolean,
    val compressionLevel: Int,
    val excludeCache: Boolean
)
