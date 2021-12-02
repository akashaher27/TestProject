package com.example.testproject.view.coroutine

import android.os.Bundle
import com.example.testproject.databinding.ActivityCoroutineBinding
import com.example.testproject.view.PostLoginActivity

/**
 * Created by akash on 26,11,2021
 */
class CoroutineActivity() : PostLoginActivity() {

    private lateinit var binding: ActivityCoroutineBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoroutineBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btCoroutine.setOnClickListener {
        }


        fun simpleFun1(lamda: () -> Unit) {
            lamda()
        }
    }
}