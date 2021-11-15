package com.example.form.view.field

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.example.form.databinding.ViewUploadFieldBinding
import com.example.form.model.AttachmentViewModel
import com.example.form.model.FormFieldViewModel
import com.example.form.model.UploadFieldViewModel
import kotlinx.android.synthetic.main.view_upload_field.view.*

/**
 * Created by akash on 26,10,2021
 */
class UploadFormFieldView(context: Context, var uploadFieldViewModel: UploadFieldViewModel) :
    FormFieldView(context, uploadFieldViewModel) {

    private var binding: ViewUploadFieldBinding? = null

    init {
        initialiseView()
        resetViewToInitialState()
        populateView()
    }

    private fun populateView() {
        uploadFieldViewModel.attachment?.forEach {
            binding?.attachmentContainer?.addView(Attachment(context, it, actionHandler()))
        }
    }

    private fun resetViewToInitialState() {
        binding?.tvLabel?.text = uploadFieldViewModel.label
        binding?.tvDescription?.text = uploadFieldViewModel.description
        setupListener()
    }

    private fun setupListener() {
        ivAttachment.setOnClickListener {  }
    }

    private fun initialiseView() {
        binding = ViewUploadFieldBinding.inflate(LayoutInflater.from(context))
        addView(binding?.root)
    }

    override fun updateFormField(formFieldViewModel: FormFieldViewModel) {
        if (formFieldViewModel is UploadFieldViewModel) {
            uploadFieldViewModel = formFieldViewModel
        }
        populateView()
    }

    private fun addAttachment() {}

    private fun removeAttachment(attachment: View) {
        binding?.attachmentContainer?.removeView(attachment)
    }

    private fun removeAllAttachment() {
        val attachmentCount = binding?.attachmentContainer?.childCount ?: 0
        if (attachmentCount > 0) {
            binding?.attachmentContainer?.removeAllViews()
        }
    }

    private fun actionHandler() = object : Attachment.ActionHandler {
        override fun onDelete(view: View, attachment: AttachmentViewModel) {
            removeAttachment(view)
        }
    }
}