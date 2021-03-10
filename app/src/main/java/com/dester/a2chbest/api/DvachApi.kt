package com.dester.a2chbest.api

import com.dester.a2chbest.api.response.AllBoardCategoryResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DvachApi {

    @GET("makaba/mobile.fcgi?task=get_boards")
    suspend fun getAllBoardsCategory(): AllBoardCategoryResponse

    @GET("{board}/catalog.json")
    suspend fun getThreadsFromBoard(
        @Path("board") board:String
    ): Nothing

}