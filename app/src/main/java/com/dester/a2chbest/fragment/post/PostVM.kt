package com.dester.a2chbest.fragment.post

import androidx.lifecycle.MutableLiveData
import com.dester.a2chbest.api.ApiFactory
import com.dester.a2chbest.api.model.Post
import com.dester.a2chbest.base.fragment.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PostVM @Inject constructor() : BaseViewModel() {
    val postAdapter = PostAdapter()
    val postList = MutableLiveData<List<Post>>()
    val isConnectionError = MutableLiveData(false)
    val isCompleteLoading = MutableLiveData(false)

    fun loadAllPosts(board: String, post: String) {
        addDisposable(
            ApiFactory.dvachApi.getPostFromThread(board, post)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    postList.postValue(it)
                    isCompleteLoading.postValue(true)
                    isConnectionError.postValue(false)
                }, {
                    isConnectionError.postValue(true)
                })
        )
    }
}