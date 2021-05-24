package com.dester.a2chbest.fragment.main


import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.dester.a2chbest.api.ApiFactory
import com.dester.a2chbest.api.response.AllBoardCategoryResponse
import com.dester.a2chbest.base.fragment.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject


class MainScreenVM @Inject constructor() : BaseViewModel() {

    val boardCategoryResponse = MutableLiveData<AllBoardCategoryResponse>()

    val mainScreenAdapter: MainScreenAdapter = MainScreenAdapter({ name -> openSubCategory(name) })

    private lateinit var openSubCategory: ((String) -> Unit)

    fun setOpenSubCategoryMethod(method: ((String) -> Unit)) {
        openSubCategory = method
    }


    init {
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