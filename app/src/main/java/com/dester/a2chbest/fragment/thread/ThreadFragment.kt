package com.dester.a2chbest.fragment.thread

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.dester.a2chbest.base.fragment.BaseFragment
import com.dester.a2chbest.databinding.FragmentTreadBinding
import com.dester.a2chbest.di.DaggerDaggerComponent

class ThreadFragment : BaseFragment<ThreadVM>() {

    lateinit var binding: FragmentTreadBinding
    lateinit var subCategoryIndex: String
    var firstErrorLoading = false
    var secondErrorLoading = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTreadBinding.inflate(layoutInflater)
        viewModel = DaggerDaggerComponent.create().getThreadVM()
        binding.refresh.setOnRefreshListener {
            viewModel.loadPostList(subCategoryIndex)
            firstErrorLoading = false
            secondErrorLoading = false
        }
        subCategoryIndex = arguments?.getString("subCategory") ?: "po"
        viewModel.currentTheme = subCategoryIndex
        binding.apply {
            lifecycleOwner = this@ThreadFragment
            vm = viewModel
            threadRecycleList.adapter = viewModel.subCategoryAdapter
        }
        initViewModel()
        return binding.root
    }

    private fun initViewModel() {
        viewModel.apply {
            postListResponse.observe(viewLifecycleOwner, {
                Log.d("dest/Thread", "observe boardCategory = ${it.size}")
                viewModel.subCategoryAdapter.setItems(it)
            })
            isCompleteLoading.observe(viewLifecycleOwner, {
                binding.refresh.isRefreshing = false
            })
            isConnectionError.observe(viewLifecycleOwner, {
                if (it) {
                    Toast.makeText(
                        requireContext(),
                        "Connection error. Trying reload after 3 sec...",
                        Toast.LENGTH_SHORT
                    ).show()
                    Thread.sleep(3000)
                    if (!firstErrorLoading && !secondErrorLoading) {
                        viewModel.loadPostList(subCategoryIndex)
                        firstErrorLoading = true
                    } else if (!secondErrorLoading) {
                        viewModel.loadPostListWithoutPages(subCategoryIndex)
                        secondErrorLoading = true
                    } else {
                        Toast.makeText(
                            requireContext(),
                            "Server Error. Try after...",
                            Toast.LENGTH_SHORT
                        ).show()
                        viewModel.previousArrowVisibility.postValue(View.INVISIBLE)
                        viewModel.nextArrowVisibility.postValue(View.INVISIBLE)
                    }

                }
            })
            setOpenPost { name -> openPost(name) }
            loadPostList(subCategoryIndex)
        }
    }

    fun openPost(number: String) {
        val action =
            ThreadFragmentDirections.actionTreadFragmentToPostFragment(number, subCategoryIndex)
        navigationController.navigate(action)
    }


}