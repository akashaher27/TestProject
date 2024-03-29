package com.example.testproject.data.store

import android.content.SharedPreferences
import androidx.core.content.edit

/**
 * Created by akash on 22,06,2021
 */
abstract class BaseSharePref {

    /**
     * puts a key value pair in shared prefs if doesn't exists, otherwise updates value on given [key]
     */
    fun SharedPreferences.setValue(key: String, value: Any?) {
        when (value) {
            is String? -> edit { putString(key, value) }
            is Int -> edit { putInt(key, value) }
            is Boolean -> edit { putBoolean(key, value) }
            is Float -> edit { putFloat(key, value) }
            is Long -> edit { putLong(key, value) }
            else -> throw UnsupportedOperationException("Not yet implemented")
        }
    }

    /**
     * finds value on given key.
     * [T] is the type of value
     * @param defaultValue optional default value - will take null for strings, false for bool and -1 for numeric values if [defaultValue] is not specified
     */
    inline  fun <reified T : Any> SharedPreferences.getValue(key: String, defaultValue: T? = null): T? {
        return when (T::class) {
            String::class -> getString(key, defaultValue as? String) as T?
            Int::class -> getInt(key, defaultValue as? Int ?: -1) as T?
            Boolean::class -> getBoolean(key, defaultValue as? Boolean ?: false) as T?
            Float::class -> getFloat(key, defaultValue as? Float ?: -1f) as T?
            Long::class -> getLong(key, defaultValue as? Long ?: -1) as T?
            else -> throw UnsupportedOperationException("Not yet implemented")
        }
    }


    abstract fun clearStore()
}