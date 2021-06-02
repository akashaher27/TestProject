package com.example.testproject.view.Util

import android.content.Context
import android.content.SharedPreferences
import java.lang.Byte
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
    private val IV_SIZE = 12
    private val KEY_SIZE = 256
    private val KEYSTORE_IV_NAME = "KeyStoreIV"
    private val SHARED_PREFERENCES_NAME = "KeyStoreSettings"


    fun encryptData(data: ByteArray, cipher: Cipher, key: Key): ByteArray {
        cipher.init(Cipher.ENCRYPT_MODE, key, cipher.parameters)
        iv = cipher.iv
        return cipher.doFinal(data)
    }

    fun decryptData(data: ByteArray, cipher: Cipher, key: Key): ByteArray {
        val spec = GCMParameterSpec(128,iv)
        cipher.init(Cipher.DECRYPT_MODE, key,spec)
        return cipher.doFinal(data)
    }


    fun byteArrayToHex(bytes: ByteArray) : String{
        val hexChars = "0123456789ABCDEF".toCharArray()
        val result = StringBuffer()

        bytes.forEach {
            val octet = it.toInt()
            val firstIndex = (octet and 0xF0).ushr(4)
            val secondIndex = octet and 0x0F
            result.append(hexChars[firstIndex])
            result.append(hexChars[secondIndex])
        }

        return result.toString()
    }

    fun hexToByteArray(hex: String) : ByteArray{
        val hexChars = "0123456789ABCDEF".toCharArray()
        val result = ByteArray(hex.length / 2)

        for (i in 0 until hex.length step 2) {
            val firstIndex = hexChars.indexOf(hex[i]);
            val secondIndex = hexChars.indexOf(hex[i + 1]);

            val octet = firstIndex.shl(4).or(secondIndex)
            result.set(i.shr(1), octet.toByte())
        }

        return result
    }
}