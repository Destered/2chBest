package com.dester.a2chbest.fragment.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dester.a2chbest.base.fragment.BaseFragment
import com.dester.a2chbest.databinding.FragmentMainBinding


class MainScreenFragment : BaseFragment<MainScreenVM>() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMainBinding.inflate(inflater)

        viewModel = MainScreenVM(
            this,
            { name -> openSubCategory(name) }
        )

        binding.apply {
            lifecycleOwner = this@MainScreenFragment
            vm = viewModel
            categoryRecycleList.adapter = viewModel.mainScreenAdapter


        }


        return binding.root
    }

    fun openSubCategory(categoryName: String) {
        val action =
            MainScreenFragmentDirections.actionMainScreenFragmentToSubCategoryFragment(categoryName)
        navigationController.navigate(action)
    }


}