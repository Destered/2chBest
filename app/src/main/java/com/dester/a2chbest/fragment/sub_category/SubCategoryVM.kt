package com.dester.a2chbest.fragment.sub_category

import androidx.lifecycle.MutableLiveData
import com.dester.a2chbest.api.ApiFactory
import com.dester.a2chbest.api.response.AllBoardCategoryResponse
import com.dester.a2chbest.base.fragment.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class SubCategoryVM @Inject constructor() : BaseViewModel() {
    val subCategoryAdapter: SubCategoryAdapter =
        SubCategoryAdapter({ name -> openSubCategory(name) })
    val boardSubCategoryResponse = MutableLiveData<AllBoardCategoryResponse>()
    private lateinit var openSubCategory: ((String) -> Unit)

    fun setOpenSubCategory(method: ((String) -> Unit)) {
        openSubCategory = method
    }

    fun initBoards() {
        addDisposable(
            ApiFactory.dvachApi.getAllBoardsCategory()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    boardSubCategoryResponse.postValue(it)
                }, { Timber.d("2chException: getAllBoard:$it") })
        )
    }
}