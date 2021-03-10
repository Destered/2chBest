package com.dester.a2chbest.api.response


import com.google.gson.annotations.SerializedName

data class Icon(
    @SerializedName("name")
    val name: String,
    @SerializedName("num")
    val num: Int,
    @SerializedName("url")
    val url: String
)