package com.dester.a2chbest.fragment.post

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.dester.a2chbest.base.fragment.BaseFragment
import com.dester.a2chbest.databinding.FragmentPostBinding
import com.dester.a2chbest.di.DaggerDaggerComponent

class PostFragment : BaseFragment<PostVM>() {

    lateinit var binding: FragmentPostBinding
    lateinit var postNumber: String
    lateinit var thread: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPostBinding.inflate(layoutInflater)
        viewModel = DaggerDaggerComponent.create().getPostVM()
        postNumber = arguments?.getString("postNumber") ?: "0"
        thread = arguments?.getString("thread") ?: "po"
        binding.refresh.setOnRefreshListener {
            viewModel.loadAllPosts(thread, postNumber)
        }
        binding.apply {
            lifecycleOwner = this@PostFragment
            vm = viewModel
            postRecycleList.adapter = viewModel.postAdapter
        }
        initViewModel()
        return binding.root
    }

    fun initViewModel() {
        viewModel.apply {
            postList.observe(viewLifecycleOwner, {
                Log.d("dest/MainScreenVM", "observe boardCategory = ${it.size}")
                viewModel.postAdapter.setItems(it)
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
                    viewModel.loadAllPosts(thread, postNumber)
                }
            })
        }
        viewModel.loadAllPosts(thread, postNumber)
    }
}