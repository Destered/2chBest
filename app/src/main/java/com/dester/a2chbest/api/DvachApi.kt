package com.dester.a2chbest.api

import com.dester.a2chbest.api.model.Post
import com.dester.a2chbest.api.response.AllBoardCategoryResponse
import com.dester.a2chbest.api.response.ThreadListForPagesResponse
import com.dester.a2chbest.api.response.ThreadListResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DvachApi : BaseService {

    @GET("makaba/mobile.fcgi?task=get_boards")
    fun getAllBoardsCategory(): Single<AllBoardCategoryResponse>

    @GET("/{id}/catalog.json")
    fun getThreads(@Path("id") boardId: String): Single<ThreadListResponse>

    @GET("/{id}/{page}.json")
    fun getThreadsForPages(
        @Path("id") boardId: String,
        @Path("page") page: String
    ): Single<ThreadListForPagesResponse>

    @GET("/makaba/mobile.fcgi?task=get_thread&post=0")
    fun getPostFromThread(
        @Query("board") board: String,
        @Query("thread") thread: String,
    ): Single<List<Post>>

    @GET("/makaba/mobile.fcgi")
    fun getPosts(
        @Query("task") task: String,
        @Query("board") board: String,
        @Query("thread") thread: String,
        @Query("post") post: Int
    ): Single<List<Post>>

}