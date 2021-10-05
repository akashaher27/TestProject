package com.example.form.view

import com.example.form.model.FormFieldViewModel

/**
 * Created by akash on 30,08,2021
 */

fun getHelperText(formFieldViewModel: FormFieldViewModel): String {
    var helperString = StringBuilder()
    if (formFieldViewModel.isRequired){

    }
    if (formFieldViewModel.description.isNotBlank()){

    }
    return helperString.toString()
}