package com.example.form.view.field

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.example.form.databinding.ViewAttachmentBinding
import com.example.form.model.AttachmentViewModel

/**
 * Created by akash on 27,10,2021
 */
class Attachment(
    context: Context,
    var attachment: AttachmentViewModel,
    var attachmentActionHandler: ActionHandler?
) : FrameLayout(context) {

    private var binding: ViewAttachmentBinding? = null
    private var actionhandler: ActionHandler? = null

    init {
        initialiseView()
        resetViewToInitialState()
        populateView()
    }

    private fun populateView() {
        var name = attachment.name
        if (name.contains(".", true)) {
            name = attachment.name.substring(0, attachment.name.indexOf("."))
        }
        binding?.tvName?.text = name.substring(0, 1).toUpperCase() + name.substring(1);
        attachment.size?.let { binding?.tvSize?.text = attachment.size }

    }

    private fun resetViewToInitialState() {
        setupListener()
        actionhandler = attachmentActionHandler
    }

    private fun setupListener() {
        binding?.ivDelete?.setOnClickListener {
            actionhandler?.onDelete(it.parent.parent as FrameLayout, attachment)
        }
    }

    private fun initialiseView() {
        binding = ViewAttachmentBinding.inflate(LayoutInflater.from(context))
        addView(binding?.root)
    }

    interface ActionHandler {
        fun onDelete(view: View, attachment: AttachmentViewModel)
    }
}