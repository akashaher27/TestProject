package com.example.testproject.view

import android.os.Bundle
import com.example.testproject.view.Util.CryptoHelper
import com.example.testproject.view.Util.KeystoreManager
import kotlinx.android.synthetic.main.activity_crypto.*
import java.nio.charset.Charset

/**
 * Created by akash on 19,05,2021
 */
class CryptoOperation() : PostLoginActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //initView()
    }

    private fun initView() {

        btEncrypt.setOnClickListener {
            val data = etData.text.toString()
            if (data.isNotEmpty()){
                encryptData(data)
            }
        }
    }

    private fun encryptData(data: String) {

        val t = CryptoHelper.encryptData(data.toByteArray(), KeystoreManager.getCipher(), KeystoreManager.getMasterKey())
        tvEncrypt.text = t.toString()
        val v = CryptoHelper.decryptData(t,KeystoreManager.getCipher(),KeystoreManager.getMasterKey())
        tvDecrypt.text = String(v, Charset.defaultCharset())
    }

    private fun decryptData(data:String){
//        val decryptedData = CryptoHelper.decryptData(data.toByteArray(),KeystoreManager.getCipher(),KeystoreManager.getMasterKey())
//        tvDecrypt.text = decryptedData.toString(),
    }
}