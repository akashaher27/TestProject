package com.example.testproject.presenter.photo

import com.example.testproject.presenter.BaseViewModel
import com.example.testproject.view.photo.adapter.PhotoItem

/**
 * Created by akash on 17,06,2021
 */
class PhotoListViewModel() : BaseViewModel() {

    fun getPhotoList(): List<PhotoItem> {
        return mutableListOf(
            PhotoItem("", "aher"),
            PhotoItem("", "aher"),
            PhotoItem("", "aher"),
            PhotoItem("", "aher")
        )
    }
}