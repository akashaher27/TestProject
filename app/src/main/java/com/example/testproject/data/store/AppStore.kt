package com.example.testproject.data.store

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by akash on 28,06,2021
 */
@Singleton
class AppStore @Inject constructor(@ApplicationContext context: Context) : BaseSharePref() {

    companion object {
        private const val STORE_NAME = "APP_STORE"
        private const val KEY_APP_VERSION = "KEY_APP_VERSION"
    }

    private val preferences: SharedPreferences by lazy {
        context.getSharedPreferences(STORE_NAME, Context.MODE_PRIVATE)
    }



    //region Enter Properties Here

    var appVersion: Int?
        get() = preferences.getValue(KEY_APP_VERSION)
        set(value) = preferences.setValue(KEY_APP_VERSION, value)



    //endregion Properties region end


    override fun clearStore() {
        preferences.edit().clear().apply()
    }
}