package com.example.form.view.field

import android.content.Context
import androidx.fragment.app.FragmentActivity
import com.example.common.util.toEditable
import com.example.common.view.bottmoSheet.BottomSheetOnItemClickListener
import com.example.common.view.bottmoSheet.OptionBottomSheet
import com.example.form.R
import com.example.form.model.DropDownFieldViewModel
import com.example.form.model.FormFieldViewModel
import com.example.form.model.Option
import kotlinx.android.synthetic.main.view_drop_down_field.view.*

/**
 * Created by akash on 30,08,2021
 */
class DropDownFormFieldView(context: Context, var dropDownFieldViewModel: DropDownFieldViewModel) :
    FormFieldView(context, dropDownFieldViewModel) {

    init {
        initialiseView()
        resetViewToInitialState()
        populateView()
    }

    private fun populateView() {
        etDropdown.text = dropDownFieldViewModel.value.toEditable()
    }

    private fun initialiseView() {
        inflate(context, R.layout.view_drop_down_field, this)
    }

    private fun resetViewToInitialState() {
        tlDropdown.hint = dropDownFieldViewModel.label
        etDropdown.text = "".toEditable()
        etDropdown.isFocusable = false
        setupListener()
    }

    private fun setupListener() {
        etDropdown.setOnClickListener {

            showOptionSheet(dropDownFieldViewModel.option)
        }
    }

    override fun updateFormField(formFieldViewModel: FormFieldViewModel) {
        if (formFieldViewModel is DropDownFieldViewModel) {
            dropDownFieldViewModel = formFieldViewModel
        }
        populateView()
    }

    private fun showOptionSheet(options: ArrayList<Option>?) {
        var optionList = ArrayList<com.example.common.view.bottmoSheet.Option>()
        options?.map {
            optionList.add(
                com.example.common.view.bottmoSheet.Option(
                    it.label,
                    it.id,
                    it.icon,
                    it.isSelected
                )
            )
        }
        val optionSheet = OptionBottomSheet.getInstance(dropDownFieldViewModel.label, optionList)
        optionSheet.setupBottomSheetOnItemClickListener(bottomSheetOnItemClickListener())
        optionSheet.show(
            (context as FragmentActivity).supportFragmentManager,
            OptionBottomSheet.TAG
        )
        (context as FragmentActivity).supportFragmentManager.executePendingTransactions()
    }

    private fun bottomSheetOnItemClickListener() = object :BottomSheetOnItemClickListener<com.example.common.view.bottmoSheet.Option>{
        override fun onItemClick(item: com.example.common.view.bottmoSheet.Option) {
            updateDropDownFieldView(item)
        }
    }

    private fun updateDropDownFieldView(item: com.example.common.view.bottmoSheet.Option) {
        dropDownFieldViewModel.value = item.label
        dropDownFieldViewModel.option?.map {
            if (it.id == item.id && !it.isSelected) {
                it.isSelected = true
            }
            if (it.id != item.id && it.isSelected){
                it.isSelected = false
            }
        }
        updateField(dropDownFieldViewModel)
    }
}