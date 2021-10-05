package com.example.testproject.view.photo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.testproject.R
import com.example.common.view.recyclerview.BaseAdapter
import com.example.common.view.recyclerview.BaseViewHolder
import com.example.common.view.recyclerview.Item


/**
 * Created by akash on 01,05,2021
 */


class PhotoListAdapter(list:MutableList<PhotoItem>): BaseAdapter<PhotoItem>(list) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<PhotoItem> {
        return PhotoViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_photo, parent, false),this)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<PhotoItem>, position: Int) {
        holder.bindData(baseList[position])
    }
}

class PhotoViewHolder(view:View,adapter: PhotoListAdapter): BaseViewHolder<PhotoItem>(view,adapter) {

    private var tvView = view.findViewById<TextView>(R.id.tvPhoto)

    init {
        view.setOnClickListener(this)
    }

    override fun bindData(item: PhotoItem) {
        tvView.text = item.name
    }
}

data class PhotoItem(
    val uri: String,
    val name: String
): Item()