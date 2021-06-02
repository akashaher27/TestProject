package com.example.testproject.view.Util

import android.annotation.TargetApi
import android.os.Build
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import java.security.Key
import java.security.KeyStore
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.spec.GCMParameterSpec

/**
 * Created by akash on 19,05,2021
 */
@TargetApi(Build.VERSION_CODES.M)
object KeystoreManager {

    private const val KEYSTORE_PROVIDER = "AndroidKeyStore"
    private const val MASTER_SYM_KEY_ALIAS = "SYMMETRIC_MASTER_KEY"
    private const val KEY_SIZE = 256
    private const val TRANSFORMATION = "AES/GCM/NoPadding"

    private lateinit var keystore: KeyStore

    fun getCipher(): Cipher {
        val cipher = Cipher.getInstance(TRANSFORMATION)
        return cipher
    }

    fun getMasterKey(): Key {
        createAndroidKeystore()
        if (!keystore.containsAlias(MASTER_SYM_KEY_ALIAS)){
            generateSymmetricKey()
        }
        return keystore.getKey(MASTER_SYM_KEY_ALIAS,null)
    }

    private fun createAndroidKeystore() {
        keystore = KeyStore.getInstance(KEYSTORE_PROVIDER).apply {
            this.load(null)
        }
    }

    private fun generateSymmetricKey() {
        val generator = KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, KEYSTORE_PROVIDER)
        val keySpec =
            KeyGenParameterSpec.Builder(MASTER_SYM_KEY_ALIAS, KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT)
                .setBlockModes(KeyProperties.BLOCK_MODE_GCM)
                .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
                .setKeySize(KEY_SIZE)
                .setUserAuthenticationRequired(false)
                .build()

        generator.init(keySpec)
        generator.generateKey()
    }
}