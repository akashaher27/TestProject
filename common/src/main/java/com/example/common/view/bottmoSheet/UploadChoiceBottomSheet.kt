package com.example.common.view.bottmoSheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.common.databinding.UploadChoiceBottomSheetBinding

/**
 * Created by akash on 29,10,2021
 */
class UploadChoiceBottomSheet() : BaseBottomSheet() {

    companion object {
        fun getInstance(): UploadChoiceBottomSheet {
            return UploadChoiceBottomSheet()
        }

        var TAG = UploadChoiceBottomSheet.javaClass.simpleName
    }

    private lateinit var binding: UploadChoiceBottomSheetBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = UploadChoiceBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()

    }

    private fun initView() {
        setupListener()
    }

    private fun setupListener() {
        binding.camera.setOnClickListener {  }
        binding.gallery.setOnClickListener {  }
        binding.drive.setOnClickListener {  }
        binding.file.setOnClickListener {  }
    }

}