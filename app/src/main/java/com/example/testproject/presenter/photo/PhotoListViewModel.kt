package com.example.testproject.presenter.photo

import com.example.testproject.data.UserStore
import com.example.testproject.presenter.BaseViewModel
import com.example.testproject.view.photo.adapter.PhotoItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by akash on 17,06,2021
 */
@HiltViewModel
class PhotoListViewModel @Inject constructor(userStore: UserStore) : BaseViewModel() {

    fun getPhotoList(): List<PhotoItem> {
        return mutableListOf(
            PhotoItem("", "aher"),
            PhotoItem("", "aher"),
            PhotoItem("", "aher"),
            PhotoItem("", "aher")
        )
    }
}