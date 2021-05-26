package com.dester.a2chbest.fragment.thread

import android.view.View
import androidx.lifecycle.MutableLiveData
import com.dester.a2chbest.api.ApiFactory
import com.dester.a2chbest.api.model.Post
import com.dester.a2chbest.api.model.Thread
import com.dester.a2chbest.base.fragment.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ThreadVM @Inject constructor() : BaseViewModel() {
    private lateinit var openPost: ((String) -> Unit)
    val subCategoryAdapter: ThreadAdapter = ThreadAdapter({ threadNum -> openPost(threadNum) })
    val postListResponse = MutableLiveData<List<Post>>()
    var currentPage = "0"
    var maxPages = 0
    val isConnectionError = MutableLiveData(false)
    val isCompleteLoading = MutableLiveData(false)
    val pagesCountView = MutableLiveData("")
    var currentTheme = "abu"
    var clickableArrow = MutableLiveData(true)
    var nextArrowVisibility = MutableLiveData(View.VISIBLE)
    var previousArrowVisibility = MutableLiveData(View.INVISIBLE)

    fun setOpenPost(method: ((String) -> Unit)) {
        openPost = method
    }

    fun increaseCurrentPage() {
        if (currentPage == "0") currentPage = "1"
        else currentPage = (Integer.parseInt(currentPage) + 1).toString()
        checkArrow()
        loadPostList(currentTheme)
    }

    fun decreaseCurrentPage() {
        if (currentPage == "1") currentPage = "0"
        else currentPage = (Integer.parseInt(currentPage) - 1).toString()
        checkArrow()
        loadPostList(currentTheme)
    }

    private fun checkArrow() {
        when {
            maxPages == 0 -> {
                nextArrowVisibility.postValue(View.INVISIBLE)
                previousArrowVisibility.postValue(View.INVISIBLE)
            }
            Integer.parseInt(currentPage) == 0 -> {
                previousArrowVisibility.postValue(View.INVISIBLE)
                nextArrowVisibility.postValue(View.VISIBLE)
            }
            Integer.parseInt(currentPage) == maxPages -> {
                nextArrowVisibility.postValue(View.INVISIBLE)
                previousArrowVisibility.postValue(View.VISIBLE)
            }
            else -> {
                nextArrowVisibility.postValue(View.VISIBLE)
                previousArrowVisibility.postValue(View.VISIBLE)
            }
        }
        checkCurrentPage()
    }

    private fun checkCurrentPage() {
        val currentPageConverted = Integer.parseInt(currentPage)
        pagesCountView.postValue("${currentPageConverted + 1}/${maxPages + 1}")
    }

    fun loadPostList(categoryId: String) {
        postListResponse.postValue(arrayListOf())
        val currentPageForRequest =
            if (currentPage == "0") "index"
            else currentPage
        addDisposable(
            ApiFactory.dvachApi.getThreadsForPages(categoryId, currentPageForRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    val postList = arrayListOf<Post>()
                    it.threads.forEach {
                        postList.add(it.posts.first())
                    }
                    maxPages = it.pages.size - 1
                    checkArrow()
                    checkCurrentPage()
                    postListResponse.postValue(postList)
                    isCompleteLoading.postValue(true)
                    isConnectionError.postValue(false)
                }, {
                    isConnectionError.postValue(true)
                })
        )
    }

    fun loadPostListWithoutPages(categoryId: String) {
        postListResponse.postValue(arrayListOf())
        addDisposable(
            ApiFactory.dvachApi.getThreads(categoryId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    val postList = arrayListOf<Post>()
                    it.threads.forEach { thread ->
                        postList.add(createPostFromThread(thread))
                    }
                    maxPages = 0
                    checkArrow()
                    checkCurrentPage()
                    postListResponse.postValue(postList)
                    isCompleteLoading.postValue(true)
                    isConnectionError.postValue(false)
                }, {
                    isConnectionError.postValue(true)
                })
        )
    }

    fun createPostFromThread(thread: Thread): Post {
        return Post(
            thread.banned,
            thread.closed,
            thread.comment,
            thread.date,
            thread.email,
            thread.endless,
            thread.files,
            thread.files.count(),
            thread.lasthit,
            thread.name,
            thread.num,
            0,
            thread.parent,
            thread.postsCount,
            thread.sticky,
            thread.subject,
            thread.tags,
            thread.timestamp,
            thread.trip
        )
    }
}