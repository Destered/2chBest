package com.dester.a2chbest.api.model


import com.google.gson.annotations.SerializedName

data class SingleBoard(
    @SerializedName("board")
    val board: String,
    @SerializedName("info")
    val info: String,
    @SerializedName("name")
    val name: String
)