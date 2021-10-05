package com.example.form.view.field

import android.content.Context
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
        etValue.text = textFieldViewModel.value.toEditable()
    }

    override fun updateFormField(formFieldViewModel: FormFieldViewModel) {
        if (formFieldViewModel is TextFieldViewModel) {
            textFieldViewModel = formFieldViewModel
        }
        populateView()
    }

}