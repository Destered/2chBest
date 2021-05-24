package com.dester.a2chbest.fragment.sub_category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.dester.a2chbest.base.fragment.BaseFragment
import com.dester.a2chbest.databinding.FragmentSubcategoryBinding
import com.dester.a2chbest.di.DaggerDaggerComponent
import com.dester.a2chbest.utils.StringHelper

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
        viewModel = DaggerDaggerComponent.create().getSubCategoryVM()
        initSubCategoryVM()
        binding.apply {
            vm = viewModel
            lifecycleOwner = this@SubCategoryFragment
            categoryRecycleList.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            categoryRecycleList.adapter = viewModel.subCategoryAdapter
        }
        return binding.root
    }

    private fun initSubCategoryVM() {
        viewModel.apply {
            boardSubCategoryResponse.observe(viewLifecycleOwner, {
                subCategoryAdapter.setItems(StringHelper.getSubcategoryByName(it, category))
            })
            setOpenSubCategory { name -> openSubCategory(name) }
            initBoards()
        }
    }

    fun openSubCategory(subCategoryName: String) {
        val action =
            SubCategoryFragmentDirections.actionSubCategoryFragmentToTreadFragment(subCategoryName)
        navigationController.navigate(action)
    }
}