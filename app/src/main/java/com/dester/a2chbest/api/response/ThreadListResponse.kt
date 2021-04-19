package com.dester.a2chbest.api.response

import com.dester.a2chbest.api.model.Thread
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class ThreadListResponse(
    @SerializedName("BoardName")
    @Expose
    private var boardName: String? = null,

    @SerializedName("default_name")
    @Expose
    private var defaultName: String? = null,

    @SerializedName("threads")
    @Expose
    private var threads: List<Thread>? = null
)