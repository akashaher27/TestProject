package com.example.common.util

import android.content.Context
import android.net.Uri
import android.provider.OpenableColumns
import androidx.core.content.FileProvider
import com.example.common.model.FileDetail
import java.io.File

/**
 * Created by akash on 22,11,2021
 */


fun getTempFileUri(context: Context): Uri? {
    val tempFile = File.createTempFile("temp", null, context.cacheDir)
    return try {
        FileProvider.getUriForFile(
            context.applicationContext,
            "com.example.testproject.provider",
            tempFile
        )
    } catch (e: Exception) {
        null
    }
}

fun getFileDetail(context: Context, uri: Uri): FileDetail {
    var name: String? = null
    var size: Long? = null
    context.contentResolver.query(uri, null, null, null, null)?.use { cursor ->
        val nameIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
        val sizeIndex = cursor.getColumnIndex(OpenableColumns.SIZE)
        cursor.moveToFirst()
        name = cursor.getString(nameIndex).toString()
        size = cursor.getLong(sizeIndex)
    }
    return FileDetail(name, size, uri)
}

fun toMegaByte(byte: Long):Float {
        return (byte/(1024*1024)).toFloat()
}
