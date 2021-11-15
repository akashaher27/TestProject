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
    open var isVisible: Boolean,
    open var description: String
)

open class TextFieldViewModel(
    override var label: String,
    override var value: String,
    override var isRequired: Boolean = false,
    override var isEditable: Boolean = true,
    override var isVisible: Boolean,
    override var description: String = ""
) :
    FormFieldViewModel(label, value, isRequired, isEditable, isVisible, description)

open class DropDownFieldViewModel(
    override var label: String,
    override var value: String,
    override var isRequired: Boolean = false,
    override var isEditable: Boolean = true,
    override var isVisible: Boolean,
    override var description: String = "",
    var option: ArrayList<Option>? = null
) :
    FormFieldViewModel(label, value, isRequired, isEditable, isVisible, description)

open class DateFieldViewModel(
    override var label: String,
    override var value: String,
    override var isRequired: Boolean = false,
    override var isEditable: Boolean = true,
    override var isVisible: Boolean,
    override var description: String = "",
    var startDate: String? = null,
    var endDate: String? = null
) : FormFieldViewModel(label, value, isRequired, isEditable, isVisible, description)

open class UploadFieldViewModel(
    override var label: String,
    override var value: String,
    override var isRequired: Boolean = false,
    override var isEditable: Boolean = true,
    override var isVisible: Boolean,
    override var description: String = "",
    var attachment: MutableList<AttachmentViewModel>?
) : FormFieldViewModel(label, value, isRequired, isEditable, isVisible, description)

@Parcelize
data class Option(
    var label: String,
    var id: Int? = null,
    @DrawableRes
    var icon: Int? = null,
    var isSelected: Boolean = false
) : Parcelable

data class AttachmentViewModel(var name: String,
                               var size: String,
                               var id: Long)
