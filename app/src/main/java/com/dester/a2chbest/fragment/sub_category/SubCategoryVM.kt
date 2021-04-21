package com.dester.a2chbest.fragment.sub_category

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import com.dester.a2chbest.api.ApiFactory
import com.dester.a2chbest.api.response.AllBoardCategoryResponse
import com.dester.a2chbest.base.fragment.BaseViewModel
import com.dester.a2chbest.utils.StringHelper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class SubCategoryVM(
    owner: LifecycleOwner,
    val categoryName: String
) : BaseViewModel() {
    val subCategoryAdapter: SubCategoryAdapter = SubCategoryAdapter()
    val boardSubCategoryResponse = MutableLiveData<AllBoardCategoryResponse>()

    init {
        boardSubCategoryResponse.observe(owner, {
            subCategoryAdapter.setItems(StringHelper.getSubcategoryByName(it, categoryName))
        })

        initBoards()
    }

    private fun initBoards() {
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