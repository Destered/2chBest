package com.dester.a2chbest.api

import retrofit2.Retrofit

interface BaseService

internal inline fun <reified T : BaseService> Retrofit.make(): T =
    create(T::class.java)