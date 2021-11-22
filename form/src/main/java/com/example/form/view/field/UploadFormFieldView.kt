package com.example.form.view.field

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.FragmentActivity
import com.example.common.model.FileDetail
import com.example.common.util.toMegaByte
import com.example.common.view.bottmoSheet.UploadChoiceBottomSheet
import com.example.form.databinding.ViewUploadFieldBinding
import com.example.form.model.AttachmentViewModel
import com.example.form.model.FormFieldViewModel
import com.example.form.model.UploadFieldViewModel

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
            addAttachment(it)
        }
    }

    private fun resetViewToInitialState() {
        binding?.tvLabel?.text = uploadFieldViewModel.label
        binding?.tvDescription?.text = uploadFieldViewModel.description
        setupListener()
    }

    private fun setupListener() {
        binding?.ivAttachment?.setOnClickListener {
            showUploadChoiceBottomSheet()
        }
    }

    private fun showUploadChoiceBottomSheet() {
        val bottomSheet = UploadChoiceBottomSheet.getInstance()
        bottomSheet.setFileSelectionListener(object :
            UploadChoiceBottomSheet.FileSelectionListener {
            override fun onFileSelected(fileDetail: FileDetail) {
                var attachment = AttachmentViewModel()
                fileDetail.name?.let { attachment.name = it }
                fileDetail.size?.let {
                    attachment.size = toMegaByte(it).toString().plus(" mb")
                }
                attachment.pathUri = fileDetail.uri
                addAttachment(attachment)
            }
        })
        bottomSheet.show(
            (context as FragmentActivity).supportFragmentManager,
            UploadChoiceBottomSheet.TAG
        )
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

    private fun addAttachment(attachmentViewModel: AttachmentViewModel) {
        binding?.attachmentContainer?.addView(
            Attachment(
                context,
                attachmentViewModel,
                actionHandler()
            )
        )
    }

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