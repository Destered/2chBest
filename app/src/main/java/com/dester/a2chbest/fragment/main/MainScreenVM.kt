package com.dester.a2chbest.fragment.main

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import com.dester.a2chbest.api.ApiFactory
import com.dester.a2chbest.api.DvachApi
import com.dester.a2chbest.api.response.AllBoardCategoryResponse
import com.dester.a2chbest.base.BaseViewModel
import com.dester.a2chbest.utils.StringHelper
import kotlinx.coroutines.runBlocking


class MainScreenVM(
        owner: LifecycleOwner
): BaseViewModel() {

    val boardCategoryResponse = MutableLiveData<AllBoardCategoryResponse>()

    val mainScreenAdapter:MainScreenAdapter = MainScreenAdapter()


 init{
     boardCategoryResponse.observe(owner,{
         mainScreenAdapter.setItems(StringHelper.getAllCategory(it))
     })
        /*runBlocking {
            boardCategoryResponse.postValue(ApiFactory.dvachApi.getAllBoardsCategory())
        }*/

 }

}