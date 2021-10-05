package com.example.form.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.DrawableRes
import com.example.form.R
import com.example.testproject.view.common.recyclerview.BaseAdapter
import com.example.testproject.view.common.recyclerview.BaseViewHolder
import com.example.testproject.view.common.recyclerview.Item


/**
 * Created by akash on 06,09,2021
 */
class OptionAdapter(options: MutableList<Option>) :
    BaseAdapter<Option>(options) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Option> {
        return OptionViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_option, parent, false), this
        )
    }

    override fun onBindViewHolder(holder: BaseViewHolder<Option>, position: Int) {
        var viewholder = holder as OptionViewHolder
        viewholder.bindData(baseList[position])
    }
}


class OptionViewHolder(view: View, adapter: OptionAdapter) : BaseViewHolder<Option>(view, adapter) {
    private var label = view.findViewById(R.id.tvLabel) as TextView

    init {
        view.setOnClickListener(this)
    }

    override fun bindData(item: Option) {
        label.text = item.label
    }
}

data class Option(
    var label: String,
    var id: Int? = null,

    @DrawableRes
    var icon: Int? = null,
    var isSelected: Boolean = false
) : Item()