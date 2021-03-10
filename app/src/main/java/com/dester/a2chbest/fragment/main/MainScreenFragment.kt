package com.dester.a2chbest.fragment.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.dester.a2chbest.databinding.FragmentMainBinding
import com.dester.a2chbest.base.BaseFragment



class MainScreenFragment : BaseFragment<MainScreenVM>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = MainScreenVM(
                this,
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMainBinding.inflate(inflater)

        binding.apply {
            lifecycleOwner = this@MainScreenFragment
            vm = viewModel
            categoryRecycleList.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
            categoryRecycleList.adapter = viewModel.mainScreenAdapter
        }

        return binding.root
    }




}