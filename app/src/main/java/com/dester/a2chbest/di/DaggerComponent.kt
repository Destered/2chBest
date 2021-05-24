package com.dester.a2chbest.di

import com.dester.a2chbest.fragment.main.MainScreenVM
import com.dester.a2chbest.fragment.post.PostVM
import com.dester.a2chbest.fragment.settings.SettingsVM
import com.dester.a2chbest.fragment.sub_category.SubCategoryVM
import com.dester.a2chbest.fragment.thread.ThreadVM
import dagger.Component

@Component()
interface DaggerComponent {
    fun getMainScreenVM(): MainScreenVM
    fun getSettingsVM(): SettingsVM
    fun getSubCategoryVM(): SubCategoryVM
    fun getThreadVM(): ThreadVM
    fun getPostVM(): PostVM
}