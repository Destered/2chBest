package com.dester.a2chbest.api.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Thread(
    @SerializedName("comment")
    @Expose
    private var comment: String? = null,

    @SerializedName("date")
    @Expose
    private var date: String? = null,

    @SerializedName("files")
    @Expose
    private var files: List<Files>? = null,

    @SerializedName("name")
    @Expose
    private var name: String? = null,

    @SerializedName("num")
    @Expose
    private var num: String? = null,

    @SerializedName("files_count")
    @Expose
    private var filesCount: String? = null,

    @SerializedName("posts_count")
    @Expose
    private var postsCount: String? = null,

    @SerializedName("trip")
    @Expose
    private var trip: String? = null,

    @SerializedName("subject")
    @Expose
    private var subject: String? = null,
)