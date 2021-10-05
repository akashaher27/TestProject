package com.example.common.view.bottmoSheet

import android.app.Dialog
import android.os.Bundle
import android.view.View
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/**
 * Created by akash on 27,09,2021
 */
open class BaseBottomSheet() : BottomSheetDialogFragment() {

    private var bottomSheetCallbackListener: BottomSheetCallbackListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState)
    }


    private fun bottomSheetCallBack() = object : BottomSheetBehavior.BottomSheetCallback() {
        override fun onStateChanged(bottomSheet: View, newState: Int) {
            bottomSheetCallbackListener?.onStateChanged(bottomSheet, newState)
        }

        override fun onSlide(bottomSheet: View, slideOffset: Float) {
            bottomSheetCallbackListener?.onSlide(bottomSheet, slideOffset)

        }
    }

    fun setupBottomSheetCallbackListener(listener: BottomSheetCallbackListener) {
        bottomSheetCallbackListener = listener
    }
}