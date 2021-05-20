package com.example.testproject.view.Util

import java.security.Key
import java.security.SecureRandom
import javax.crypto.Cipher
import javax.crypto.SecretKey
import javax.crypto.spec.GCMParameterSpec
import javax.crypto.spec.IvParameterSpec

/**
 * Created by akash on 19,05,2021
 */
object CryptoHelper {
    lateinit var iv: ByteArray

    fun encryptData(data: ByteArray, cipher: Cipher, key: Key): ByteArray {
        cipher.init(Cipher.ENCRYPT_MODE, key)
        iv  = cipher.iv
        return cipher.doFinal(data)
    }

    fun decryptData(data: ByteArray, cipher: Cipher, key: Key): ByteArray {
        val spec = GCMParameterSpec(128,iv)
        cipher.init(Cipher.DECRYPT_MODE, key,spec)
        return cipher.doFinal(data)
    }




    private fun generateIV(size: Int = 12): ByteArray {
        val random = SecureRandom()
        val iv = ByteArray(size)
        random.nextBytes(iv)
        return iv
    }
}