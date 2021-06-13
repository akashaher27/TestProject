package com.example.testproject.view.Util

import android.os.Build

/**
 * Created by akash on 02,06,2021
 */


fun isSdiVersionGreaterThanMarshmallow(): Boolean {
    return Build.VERSION.SDK_INT >= 23
}