package com.example.testproject.view.photo

import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testproject.R
import com.example.testproject.presenter.photo.PhotoListViewModel
import com.example.testproject.view.PostLoginActivity
import com.example.testproject.view.common.recyclerview.EmptyErrorView
import com.example.testproject.view.common.recyclerview.OnRecyclerViewOnItemClickListener
import com.example.testproject.view.photo.adapter.PhotoItem
import com.example.testproject.view.photo.adapter.PhotoListAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_photo_list.*

/**
 * Created by akash on 29,04,2021
 */

@AndroidEntryPoint
class PhotoListActivity() : PostLoginActivity() {

    var adapter = PhotoListAdapter(mutableListOf(
            PhotoItem("", "akash"),
            PhotoItem("", "akash"),
            PhotoItem("", "akash"),
            PhotoItem("", "akash")
        ))
    private val photoListViewModel:PhotoListViewModel by viewModels()


    override fun setLayoutId(): Int? {
        return R.layout.activity_photo_list
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    private fun initView() {
        textView.setOnClickListener {
           adapter.clearData()
        }
        rvPhotoList.initRecyclerView {
            it.layoutManager = LinearLayoutManager(this)
            it.adapter = adapter
        }
        adapter.setItemClickListener(OnRecyclerViewOnItemClickListener { parent, view, position -> })
        rvPhotoList.addErrorView(EmptyErrorView(this))
        getPhotoList()
    }

    private fun getPhotoList(){
        adapter.addItems(photoListViewModel.getPhotoList())
    }
}