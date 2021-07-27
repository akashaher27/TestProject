package com.example.testproject.view.Util

import android.content.Intent

/**
 * Created by akash on 27,07,2021
 */
class SAFUtil {

    fun openFileIntent(mimeType: ArrayList<String> = arrayListOf()): Intent {
        return Intent(Intent.ACTION_OPEN_DOCUMENT)
            .apply {
                addCategory(Intent.CATEGORY_OPENABLE)
                if (mimeType.size == 1) {
                    type = Intent.normalizeMimeType(mimeType[0])
                } else {
                    if (mimeType.isEmpty())
                        type = Intent.normalizeMimeType("*/*")
                    else
                        putExtra(Intent.EXTRA_MIME_TYPES, mimeType)
                }
            }
    }
}