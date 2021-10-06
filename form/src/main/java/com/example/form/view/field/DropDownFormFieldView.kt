package com.example.form.view.field

import android.content.Context
import android.view.View
import androidx.fragment.app.FragmentActivity
import com.example.common.util.toEditable
import com.example.form.R
import com.example.form.model.DropDownFieldViewModel
import com.example.form.model.FormFieldViewModel
import com.example.form.model.Option
import com.example.form.view.OptionBottomSheet
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.view_drop_down_field.view.*
import kotlinx.android.synthetic.main.view_option_bottom_sheet.view.*

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
        etDropdown.isFocusableInTouchMode = false
        addListener()
    }

    private fun addListener() {
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

    private fun showOptionSheet(options:ArrayList<Option>?) {
        options?.let {
            val optionSheet = OptionBottomSheet.getInstance("City",it)
            optionSheet.show(
                (context as FragmentActivity).supportFragmentManager,
                OptionBottomSheet.TAG
            )
            (context as FragmentActivity).supportFragmentManager.executePendingTransactions()
            var modalBottomSheetBehavior = (optionSheet.dialog as BottomSheetDialog).behavior
            modalBottomSheetBehavior.addBottomSheetCallback(bottomSheetCallback)
        }
    }

    val bottomSheetCallback = object : BottomSheetBehavior.BottomSheetCallback() {

        override fun onStateChanged(bottomSheet: View, newState: Int) {
            when(newState){
                BottomSheetBehavior.STATE_COLLAPSED -> {
                    bottomSheet.appBarLayout.visibility = View.GONE
                }
                BottomSheetBehavior.STATE_EXPANDED->{
                    bottomSheet.appBarLayout.visibility = View.VISIBLE
                }
            }
        }

        override fun onSlide(bottomSheet: View, slideOffset: Float) {
            // Do something for slide offset.
        }
    }
}