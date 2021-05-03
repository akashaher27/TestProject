package com.example.testproject

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.testproject.presenter.MainViewModel
import com.example.testproject.view.PostLoginActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity :PostLoginActivity() {

    private val mainViewModel: MainViewModel  by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    override fun setLayoutId(): Int? {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
