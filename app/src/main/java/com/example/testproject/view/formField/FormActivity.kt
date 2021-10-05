package com.example.testproject.view.formField

import android.os.Bundle
import com.example.form.model.DropDownFieldViewModel
import com.example.form.model.Option
import com.example.form.model.TextFieldViewModel
import com.example.form.view.field.DropDownFormFieldView
import com.example.form.view.field.TextFormFieldView
import com.example.testproject.databinding.ActivityFormFieldBinding
import com.example.testproject.view.PostLoginActivity


/**
 * Created by akash on 30,08,2021
 */
class FormActivity() : PostLoginActivity() {

    private lateinit var formFieldBinding: ActivityFormFieldBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        formFieldBinding = ActivityFormFieldBinding.inflate(layoutInflater)
        val view = formFieldBinding.root
        setContentView(view)
        initView()
    }

    private fun initView() {
        setupToolbar()
        setupForm()
    }

    private fun setupForm() {
        val textField =
            TextFieldViewModel(
                label = "Name",
                value = "",
                isEditable = true,
                isRequired = true,
                description = ""
            )

        val dropdownField = DropDownFieldViewModel(
            label = "City",
            value = "",
            isEditable = true,
            isRequired = true,
            option = arrayListOf(
                Option("Chennai", isSelected = true),
                Option("Mumbai", isSelected = false),
                Option("Kolkata", isSelected = false),
                Option("Chennai", isSelected = true),
                Option("Mumbai", isSelected = false),
                Option("Kolkata", isSelected = false),
                Option("Delhi", isSelected = false),
                Option("Chennai", isSelected = true),
                Option("Mumbai", isSelected = false),
                Option("Kolkata", isSelected = false),
                Option("Delhi", isSelected = false),
                Option("Chennai", isSelected = true),
                Option("Mumbai", isSelected = false),
                Option("Kolkata", isSelected = false),
                Option("Delhi", isSelected = false),
                Option("Chennai", isSelected = true),
                Option("Mumbai", isSelected = false),
                Option("Kolkata", isSelected = false),
                Option("Delhi", isSelected = false),
                Option("Chennai", isSelected = true),
                Option("Mumbai", isSelected = false),
                Option("Kolkata", isSelected = false),
                Option("Delhi", isSelected = false),
                Option("Chennai", isSelected = true),
                Option("Mumbai", isSelected = false),
                Option("Kolkata", isSelected = false),
                Option("Delhi", isSelected = false),
                Option("Chennai", isSelected = true),
                Option("Mumbai", isSelected = false),
                Option("Kolkata", isSelected = false),
                Option("Delhi", isSelected = false),
                Option("Delhi", isSelected = false)
            )
        )

        formFieldBinding.formFieldContainer.addView(TextFormFieldView(this, textField))
        formFieldBinding.formFieldContainer.addView(DropDownFormFieldView(this, dropdownField))
    }

    private fun setupToolbar() {
        //formFieldBinding.appbar.toolbar.title = "form"
    }

}