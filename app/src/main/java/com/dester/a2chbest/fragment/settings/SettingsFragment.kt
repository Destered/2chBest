package com.dester.a2chbest.fragment.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dester.a2chbest.base.fragment.BaseFragment
import com.dester.a2chbest.di.DaggerDaggerComponent

class SettingsFragment : BaseFragment<SettingsVM>() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = DaggerDaggerComponent.create().getSettingsVM()
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}