package com.dester.a2chbest.fragment.main


import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import com.dester.a2chbest.api.ApiFactory
import com.dester.a2chbest.api.response.AllBoardCategoryResponse
import com.dester.a2chbest.base.fragment.BaseViewModel
import com.dester.a2chbest.utils.StringHelper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber


class MainScreenVM(
    owner: LifecycleOwner,
    val openSubCategory: (String) -> Unit
) : BaseViewModel() {

    val boardCategoryResponse = MutableLiveData<AllBoardCategoryResponse>()

    val mainScreenAdapter: MainScreenAdapter = MainScreenAdapter({ name -> openSubCategory(name) })


    init {
        boardCategoryResponse.observe(owner, {
            Log.d("dest/MainScreenVM", "observe boardCategory = ${it.japanCulture.size}")
            mainScreenAdapter.setItems(StringHelper.getAllEmptyCategory(it))
        })
        initBoards()
    }

    fun initBoards() {
        addDisposable(
            ApiFactory.dvachApi.getAllBoardsCategory()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.d("dest/MainScreenVM", "getAllBoard:$it")
                    boardCategoryResponse.postValue(it)
                }, { Timber.d("dest/2chException: getAllBoard:$it") })
        )
    }

}