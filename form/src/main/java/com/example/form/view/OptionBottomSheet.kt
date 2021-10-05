package com.example.form.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.common.view.bottmoSheet.BaseBottomSheet
import com.example.common.view.bottmoSheet.BottomSheetCallbackListener
import com.example.form.R
import com.example.form.adapter.OptionAdapter
import com.example.form.databinding.ViewOptionBottomSheetBinding
import com.example.form.model.Option
import com.google.android.material.bottomsheet.BottomSheetBehavior

/**
 * Created by akash on 31,08,2021
 */
class OptionBottomSheet : BaseBottomSheet() {

    companion object {
        var TAG: String = OptionBottomSheet.javaClass.simpleName

        private const val KEY_OPTIONS = "KEY_OPTIONS"
        fun getInstance(options: ArrayList<Option>): OptionBottomSheet {
            return OptionBottomSheet().apply {
                arguments = Bundle().apply {
                    putParcelableArrayList(KEY_OPTIONS, options)
                }
            }
        }
    }

    private lateinit var viewOptionBottomSheetBinding: ViewOptionBottomSheetBinding
    private var options: ArrayList<Option>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        options = arguments?.getParcelableArrayList(KEY_OPTIONS)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewOptionBottomSheetBinding =
            ViewOptionBottomSheetBinding.inflate(inflater, container, false)
        return viewOptionBottomSheetBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialiseView()
    }

    private fun initialiseView() {
        viewOptionBottomSheetBinding.toolbar.setBackgroundColor(resources.getColor(R.color.white,null))
        viewOptionBottomSheetBinding.toolbar.navigationIcon = ResourcesCompat.getDrawable(resources,R.drawable.ic_close_24,null)
        viewOptionBottomSheetBinding.rvOptions.layoutManager = LinearLayoutManager(requireContext())
        val list = options?.map {
            com.example.form.adapter.Option(
                it.label,
                it.id,
                it.icon,
                it.isSelected
            )
        }
            ?.toMutableList() ?: mutableListOf()
        viewOptionBottomSheetBinding.rvOptions.adapter = OptionAdapter(list)
    }

    private fun optionBottomSheetCallback() = object : BottomSheetCallbackListener {
        override fun onStateChanged(bottomSheet: View, newState: Int) {
            when (newState) {
                BottomSheetBehavior.STATE_EXPANDED -> {
                    Log.d("OptionBottomSheet", "onStateChanged:")
                }
                BottomSheetBehavior.STATE_HALF_EXPANDED -> {
                    Log.d("OptionBottomSheet", "onStateChanged:")
                }
                BottomSheetBehavior.STATE_COLLAPSED -> {
                    Log.d("OptionBottomSheet", "onStateChanged:")
                }
                BottomSheetBehavior.STATE_HIDDEN -> {
                    Log.d("OptionBottomSheet", "onStateChanged:")
                }
                BottomSheetBehavior.STATE_SETTLING -> {
                    Log.d("OptionBottomSheet", "onStateChanged:")
                }
            }
        }

        override fun onSlide(bottomSheet: View, slideOffset: Float) {
        }
    }

    override fun getTheme(): Int {
        return R.style.Style_BottomSheet_Modal_Choices
    }
}
