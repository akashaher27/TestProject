package com.example.form.view.field

import android.content.Context
import android.widget.FrameLayout
import com.example.form.model.FormFieldViewModel

/**
 * Created by akash on 26,08,2021
 */
abstract class FormFieldView(context: Context, private var formFieldViewModel: FormFieldViewModel) :
    FrameLayout(context) {

    fun updateField(formFieldViewModel: FormFieldViewModel) {
        updateFormField(formFieldViewModel)
    }

    abstract fun updateFormField(formFieldViewModel: FormFieldViewModel)
}