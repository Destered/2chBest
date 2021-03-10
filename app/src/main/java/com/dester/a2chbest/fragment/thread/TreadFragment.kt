package com.dester.a2chbest.fragment.thread

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dester.a2chbest.R

class TreadFragment : Fragment() {

    companion object {
        fun newInstance() = TreadFragment()
    }

    private lateinit var viewModel: TreadViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.tread_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TreadViewModel::class.java)
        // TODO: Use the ViewModel
    }

}