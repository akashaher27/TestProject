package com.example.form.view.field

import android.content.Context
import android.text.InputType
import android.view.View
import com.example.common.util.toEditable
import com.example.form.R
import com.example.form.model.FormFieldViewModel
import com.example.form.model.TextFieldViewModel
import kotlinx.android.synthetic.main.view_text_form_field.view.*


/**
 * Created by akash on 26,08,2021
 */
class TextFormFieldView(context: Context, var textFieldViewModel: TextFieldViewModel) :
    FormFieldView(context, textFieldViewModel) {

    init {
        initialiseView()
        resetViewToInitialState()
        populateView()
    }

    private fun initialiseView() {
        inflate(context, R.layout.view_text_form_field, this)
    }

    private fun resetViewToInitialState() {
        tlTextField.hint = textFieldViewModel.label
        etValue.text = "".toEditable()
    }

    private fun populateView() {
        if (textFieldViewModel.isVisible){
            container.visibility = View.VISIBLE
        }else{
            container.visibility = View.GONE
        }
        etValue.text = textFieldViewModel.value.toEditable()
        if (textFieldViewModel.isEditable){
            etValue.isFocusableInTouchMode = true
            etValue.alpha = 1.0f
            tlTextField.alpha = 1.0f

        }else{
            etValue.inputType = InputType.TYPE_NULL
            etValue.isFocusableInTouchMode = false
            etValue.alpha = 0.6f
            tlTextField.alpha = 0.8f
        }
    }

    override fun updateFormField(formFieldViewModel: FormFieldViewModel) {
        if (formFieldViewModel is TextFieldViewModel) {
            textFieldViewModel = formFieldViewModel
        }
        populateView()
    }

}