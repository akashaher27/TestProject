package com.example.testproject.view.formField

import android.os.Bundle
import com.example.form.model.*
import com.example.form.view.field.DateFormFieldView
import com.example.form.view.field.DropDownFormFieldView
import com.example.form.view.field.TextFormFieldView
import com.example.form.view.field.UploadFormFieldView
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

        val patientName =
            TextFieldViewModel(
                label = "Patient Name",
                value = "Ramesh",
                isEditable = false,
                isRequired = true,
                isVisible = true,
                description = ""
            )

        val email =
            TextFieldViewModel(
                label = "Email",
                value = "",
                isEditable = true,
                isRequired = true,
                isVisible = true,
                description = ""
            )

        val doa = DateFieldViewModel(
            label = "DOA",
            value = "",
            isEditable = true,
            isRequired = true,
            isVisible = true,
            startDate = "10/02/2020",
            endDate = "10/04/2020"
        )

        val dod = DateFieldViewModel(
            label = "DOD",
            value = "",
            isEditable = true,
            isRequired = true,
            isVisible = true,
            startDate = "10/02/2020",
            endDate = "10/04/2020"
        )

        val reasonOfReimbursement = DropDownFieldViewModel(
            label = "Reason Of Reimbursement",
            value = "",
            isEditable = true,
            isRequired = true,
            isVisible = true,
            option = arrayListOf(
                Option("Not aware of cashless process", id = 10, isSelected = false),
                Option("Pre/Post hospitalisation claim", id = 11, isSelected = false),
                Option("Hospital advised reimbursement", id = 12, isSelected = false),
                Option("Health/Insurance ID card not available", id = 13, isSelected = false),
                Option("Other", id = 14, isSelected = false)
            )
        )

        val uploadMedicalBill = UploadFieldViewModel(
            label = "Upload Medical Bill",
            value = "",
            isEditable = true,
            isRequired = true,
            isVisible = false,
            attachment = null
        )

        formFieldBinding.formFieldContainer.addView(TextFormFieldView(this,patientName ))
        formFieldBinding.formFieldContainer.addView(TextFormFieldView(this,email ))
        formFieldBinding.formFieldContainer.addView(DateFormFieldView(this, doa))
        formFieldBinding.formFieldContainer.addView(DateFormFieldView(this, dod))
        formFieldBinding.formFieldContainer.addView(DropDownFormFieldView(this, reasonOfReimbursement))
        formFieldBinding.formFieldContainer.addView(UploadFormFieldView(this, uploadMedicalBill))
    }

    private fun setupToolbar() {
        formFieldBinding.appbar.toolbar.title = "form"
    }
}