package com.example.testproject.view.Util.FileManager

/**
 * Created by akash on 28,07,2021
 */
interface FileManager {

    fun saveFileToSharedStorage(fileDetail: FileDetail):Boolean

    fun saveFileToExternalStorage(fileDetail: FileDetail):Boolean

    fun saveFileToInternalStorage(fileDetail: FileDetail):Boolean

}