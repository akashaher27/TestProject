package com.example.testproject.view

import androidx.activity.result.contract.ActivityResultContracts

/**
 * Created by akash on 13,01,2021
 */
abstract class PostLoginActivity():BaseActivity() {

    val registerCameraActivity = registerForActivityResult(ActivityResultContracts.TakePicture()) {
        if (it) {

        }
    }
}