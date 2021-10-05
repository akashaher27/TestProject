package com.example.testproject

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.testproject.presenter.MainViewModel
import com.example.testproject.view.PostLoginActivity

class MainActivity :PostLoginActivity() {

    private val mainViewModel: MainViewModel  by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
