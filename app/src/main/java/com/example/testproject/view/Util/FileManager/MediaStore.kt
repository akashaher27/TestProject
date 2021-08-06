package com.example.testproject.view.Util.FileManager

import android.graphics.Bitmap
import android.net.Uri

/**
 * Created by akash on 28,07,2021
 */
interface MediaStore {

    fun saveImage(fileName: String, bitmap: Bitmap,format:ImageFormat): Boolean

    fun saveAudio():Uri?

    fun saveVideo(): Uri?
}