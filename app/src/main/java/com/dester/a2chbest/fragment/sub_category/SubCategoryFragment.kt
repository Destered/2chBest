package com.dester.a2chbest.fragment.sub_category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.dester.a2chbest.base.fragment.BaseFragment
import com.dester.a2chbest.databinding.FragmentSubcategoryBinding

class SubCategoryFragment : BaseFragment<SubCategoryVM>() {

    lateinit var binding: FragmentSubcategoryBinding
    lateinit var category: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSubcategoryBinding.inflate(layoutInflater)
        category = arguments?.getString("parentName") ?: "Пользовательское"
        viewModel = SubCategoryVM(viewLifecycleOwner, category)
        binding.apply {
            vm = viewModel
            lifecycleOwner = this@SubCategoryFragment
            categoryRecycleList.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            categoryRecycleList.adapter = viewModel.subCategoryAdapter
        }
        return binding.root
    }


}