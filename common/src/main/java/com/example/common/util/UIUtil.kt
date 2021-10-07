package com.example.common.util

import android.app.Activity
import android.text.Editable
import android.util.TypedValue
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

/**
 * Created by akash on 13,01,2021
 */

fun addFragment(holder: Int, fragManager: FragmentManager, fragment: Fragment, tag: String?) {
    fragManager.beginTransaction()
        .add(holder, fragment, tag)
        .addToBackStack(null)
        .commit()
}

fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)

fun View.hideKeyBoard(){
    val imm = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(this.windowToken, 0)
}

fun getActionBarHeight(activity: Activity): Int {

    var actionBarHeight = 0
    var typeValue = TypedValue()
    try {
        if (activity.theme.resolveAttribute(android.R.attr.actionBarSize, typeValue, true)) {
            actionBarHeight = TypedValue.complexToDimensionPixelSize(
                typeValue.data,
                activity.resources.displayMetrics
            )
        }
    } catch (e: Exception) {
    }
    return actionBarHeight
}