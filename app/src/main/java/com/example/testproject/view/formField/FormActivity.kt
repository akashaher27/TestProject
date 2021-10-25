package com.example.testproject.view.formField

import android.os.Bundle
import com.example.form.model.DateFieldViewModel
import com.example.form.model.DropDownFieldViewModel
import com.example.form.model.Option
import com.example.form.model.TextFieldViewModel
import com.example.form.view.field.DateFormFieldView
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
                isVisible = true,
                description = ""
            )

        val dropdownField = DropDownFieldViewModel(
            label = "City",
            value = "",
            isEditable = true,
            isRequired = true,
            isVisible = true,
            option = arrayListOf(
                Option("Chennai", id = 10, isSelected = false),
                Option("Mumbai", id = 11, isSelected = false),
                Option("Kolkata", id = 12, isSelected = false),
                Option("Delhi", id = 13, isSelected = false),
                Option("Bangalore", id = 14, isSelected = false),
                Option("Pune", id = 15, isSelected = false),
                Option("Nagpur", id = 16, isSelected = false),
                Option("Hyderabad", id = 17, isSelected = false)
            )
        )

        val dateField = DateFieldViewModel(
            label = "DOB",
            value = "",
            isEditable = true,
            isRequired = true,
            isVisible = true,
            startDate = "10/02/2020",
            endDate = "10/04/2020"
        )

        formFieldBinding.formFieldContainer.addView(TextFormFieldView(this, textField))
        formFieldBinding.formFieldContainer.addView(DropDownFormFieldView(this, dropdownField))
        formFieldBinding.formFieldContainer.addView(DateFormFieldView(this, dateField))
    }

    private fun setupToolbar() {
        //formFieldBinding.appbar.toolbar.title = "form"
    }

}