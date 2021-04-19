package com.dester.a2chbest.api.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Post(
    @SerializedName("comment")
    @Expose
    private var comment: String? = null,

    @SerializedName("date")
    @Expose
    private var date: String? = null,

    @SerializedName("email")
    @Expose
    private var email: String? = null,

    @SerializedName("num")
    @Expose
    private var num: String? = null,

    @SerializedName("name")
    @Expose
    private var name: String? = null,

    @SerializedName("trip")
    @Expose
    private var trip: String? = null,

    @SerializedName("subject")
    @Expose
    private var subject: String? = null,

    @SerializedName("op")
    @Expose
    private var op: String? = null,

    @SerializedName("files")
    @Expose
    private var files: List<Files>? = null
)