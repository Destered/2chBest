package com.dester.a2chbest.api.model


import com.google.gson.annotations.SerializedName

data class Post(
    @SerializedName("banned")
    val banned: Int,
    @SerializedName("closed")
    val closed: Int,
    @SerializedName("comment")
    val comment: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("endless")
    val endless: Int,
    @SerializedName("files")
    val files: List<File>,
    @SerializedName("files_count")
    val filesCount: Int,
    @SerializedName("lasthit")
    val lasthit: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("num")
    val num: String,
    @SerializedName("op")
    val op: Int,
    @SerializedName("parent")
    val parent: String,
    @SerializedName("posts_count")
    val postsCount: Int,
    @SerializedName("sticky")
    val sticky: Int,
    @SerializedName("subject")
    val subject: String,
    @SerializedName("tags")
    val tags: String,
    @SerializedName("timestamp")
    val timestamp: Int,
    @SerializedName("trip")
    val trip: String
)