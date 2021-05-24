package com.dester.a2chbest.fragment.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dester.a2chbest.base.fragment.BaseFragment
import com.dester.a2chbest.databinding.FragmentMainBinding
import com.dester.a2chbest.di.DaggerDaggerComponent
import com.dester.a2chbest.utils.StringHelper


class MainScreenFragment : BaseFragment<MainScreenVM>() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentMainBinding.inflate(inflater)

        viewModel = DaggerDaggerComponent.create().getMainScreenVM()
        initViewModel()

        binding.apply {
            lifecycleOwner = this@MainScreenFragment
            vm = viewModel
            categoryRecycleList.adapter = viewModel.mainScreenAdapter
        }


        return binding.root
    }

    fun initViewModel() {
        viewModel.boardCategoryResponse.observe(viewLifecycleOwner, {
            Log.d("dest/MainScreenVM", "observe boardCategory = ${it.japanCulture.size}")
            viewModel.mainScreenAdapter.setItems(StringHelper.getAllEmptyCategory(it))
        })
        viewModel.setOpenSubCategoryMethod { name -> openSubCategory(name) }
    }

    fun openSubCategory(categoryName: String) {
        val action =
            MainScreenFragmentDirections.actionMainScreenFragmentToSubCategoryFragment(categoryName)
        navigationController.navigate(action)
    }


}