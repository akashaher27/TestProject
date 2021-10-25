package com.example.form.view.field

import android.content.Context
import android.text.InputType
import android.view.LayoutInflater
import com.example.common.util.DateUtil
import com.example.common.util.getFragmentManager
import com.example.common.util.toEditable
import com.example.form.databinding.ViewDateFieldBinding
import com.example.form.model.DateFieldViewModel
import com.example.form.model.FormFieldViewModel
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.MaterialDatePicker

/**
 * Created by akash on 07,10,2021
 */
class DateFormFieldView(context: Context, var dateFieldViewModel: DateFieldViewModel) :
    FormFieldView(context, dateFieldViewModel) {

    private val TAG = "DateFormFieldView"

    private var binding: ViewDateFieldBinding? = null

    init {
        initialiseView()
        resetViewToInitialState()
        populateView()
    }

    private fun populateView() {

    }

    private fun resetViewToInitialState() {
        binding?.tlDate?.hint = dateFieldViewModel.label
        binding?.etDate?.text = "".toEditable()
        binding?.etDate?.inputType = InputType.TYPE_DATETIME_VARIATION_DATE

        setupListener()
    }

    private fun setupListener() {
        binding?.etDate?.isFocusable = false
        binding?.etDate?.setOnClickListener {
            showDateSelectionDialog()
        }
    }

    private fun showDateSelectionDialog() {
        val builder = MaterialDatePicker.Builder.datePicker()
        val startDate = dateFieldViewModel.startDate
        val endDate = dateFieldViewModel.endDate
        if (startDate != null || endDate != null) {
            val startMilli = DateUtil.toMilli(startDate!!,DateUtil.PATTERN_DD_MM_UUUU)
            val endMilli = DateUtil.toMilli(endDate!!,DateUtil.PATTERN_DD_MM_UUUU)
            if (startMilli != null && endMilli != null) {
                val bound = CalendarConstraints.Builder()
                    .setStart(startMilli)
                    .setEnd(endMilli)
                    .build()
                builder.setCalendarConstraints(bound)
            }
        }else{
            builder.setInputMode(MaterialDatePicker.INPUT_MODE_TEXT)
        }
        val dateRangePicker = builder.build()
        getFragmentManager(context)?.let {
            dateRangePicker.show(it, TAG)
        }
        dateRangePicker.addOnPositiveButtonClickListener {
            DateUtil.dateToString(DateUtil.toLocalDate(it),DateUtil.PATTERN_DD_MMM_UUUU)?.let {
                binding?.etDate?.text = it.toEditable()
            }
        }

    }

    private fun initialiseView() {
        binding = ViewDateFieldBinding.inflate(LayoutInflater.from(context))
        addView(binding?.root)
    }

    override fun updateFormField(formFieldViewModel: FormFieldViewModel) {

    }
}