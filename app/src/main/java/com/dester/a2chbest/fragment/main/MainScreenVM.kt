package com.dester.a2chbest.fragment.main


import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import com.dester.a2chbest.api.ApiFactory
import com.dester.a2chbest.api.response.AllBoardCategoryResponse
import com.dester.a2chbest.base.BaseViewModel
import com.dester.a2chbest.utils.StringHelper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber


class MainScreenVM(
        owner: LifecycleOwner
): BaseViewModel() {

    val boardCategoryResponse = MutableLiveData<AllBoardCategoryResponse>()

    val mainScreenAdapter:MainScreenAdapter = MainScreenAdapter()


 init {
     boardCategoryResponse.observe(owner, {
         mainScreenAdapter.setItems(StringHelper.getAllEmptyCategory(it))
     })
     addDisposable(
         ApiFactory.dvachApi.getAllBoardsCategory()
             .subscribeOn(Schedulers.io())
             .observeOn(AndroidSchedulers.mainThread())
             .subscribe({
                 boardCategoryResponse.postValue(it)
             }, { Timber.d("2chException: getAllBoard:$it") })
     )


 }

}