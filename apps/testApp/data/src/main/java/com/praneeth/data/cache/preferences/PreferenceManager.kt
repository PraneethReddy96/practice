package com.praneeth.data.cache.preferences

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
open class PreferenceManager @Inject constructor(context: Context) {

    companion object {
        private const val PREFERENCE_NAME = "com.praneeth.testApp"
        private const val USER_CURRENT_ACTIVITY_STATE = "user_last_activity"

    }

    private val preferences: SharedPreferences
    var startTime = 0L
    var currentTime = 0L

    init {
        preferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
    }

    fun setCurrentValue(currentTimeMillis: Long) {

        if (startTime == 0L) {
            startTime = currentTimeMillis
        } else {
            currentTime = currentTimeMillis - startTime
            startTime = currentTimeMillis
        }
    }

    var userCurrentActivityState: Long
        get() = preferences.getLong(USER_CURRENT_ACTIVITY_STATE, currentTime)
        set(value) = preferences.edit().putLong(USER_CURRENT_ACTIVITY_STATE, value).apply()

}