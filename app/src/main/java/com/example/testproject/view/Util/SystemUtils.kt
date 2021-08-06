package com.example.testproject.view.Util

import android.os.Build

/**
 * Created by akash on 01,08,2021
 */



fun isDeviceSDKGreaterThan(sdkInt: Int): Boolean = Build.VERSION.SDK_INT > sdkInt
