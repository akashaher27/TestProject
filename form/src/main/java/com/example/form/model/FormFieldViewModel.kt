package com.example.form.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

/**
 * Created by akash on 26,08,2021
 */
sealed class FormFieldViewModel(
    open var label: String,
    open var value: String,
    open var isRequired: Boolean,
    open var isEditable: Boolean,
    open var description: String
)

open class TextFieldViewModel(
    override var label: String,
    override var value: String,
    override var isRequired: Boolean = false,
    override var isEditable: Boolean = true,
    override var description: String
) :
    FormFieldViewModel(label, value, isRequired, isEditable,description)

open class DropDownFieldViewModel(
    override var label: String,
    override var value: String,
    override var isRequired: Boolean = false,
    override var isEditable: Boolean = true,
    override var description: String = "",
    var option: ArrayList<Option>? = null
) :
    FormFieldViewModel(label, value, isRequired, isEditable, description)


enum class FieldType {
    TEXT, DROPDOWN
}

@Parcelize
data class Option(
    var label: String,
    var id: Int? = null,
    @DrawableRes
    var icon: Int? = null,
    var isSelected: Boolean = false
):Parcelable
