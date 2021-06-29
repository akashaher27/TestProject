package com.example.testproject.data.store

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by akash on 20,06,2021
 */

@Singleton
class UserStore @Inject constructor(@ApplicationContext context: Context) : BaseSharePref() {

    companion object {
        private const val STORE_NAME = "USER_STORE"
        private const val KEY_USER_NAME = "KEY_USER_NAME"
        private const val KEY_USER_AGE = "KEY_USER_AGE"
        private const val KEY_USER_PINCODE = "KEY_USER_PINCODE"
        private const val KEY_USER_IS_USER_REGISTER = "KEY_USER_IS_USER_REGISTER"
    }

    private val preferences: SharedPreferences = EncryptedSharedPreferences.create(
        STORE_NAME,
        MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC),
        context,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    var username: String?
        get() = preferences.getValue(KEY_USER_NAME)
        set(value) = preferences.setValue(KEY_USER_NAME, value)

    var userAge: Int?
        get() = preferences.getValue(KEY_USER_AGE)
        set(value) = preferences.setValue(KEY_USER_AGE, value)

    var userPincode: Float?
        get() = preferences.getValue(KEY_USER_PINCODE)
        set(value) = preferences.setValue(KEY_USER_PINCODE, value)

    var isUserRegister: Boolean?
        get() = preferences.getValue(KEY_USER_IS_USER_REGISTER)
        set(value) = preferences.setValue(KEY_USER_IS_USER_REGISTER, value)


    override fun clearStore() {
        preferences.edit().clear().apply()
    }

}