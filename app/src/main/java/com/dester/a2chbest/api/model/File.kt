package com.dester.a2chbest.api.model


import com.google.gson.annotations.SerializedName

data class File(
    @SerializedName("displayname")
    val displayname: String,
    @SerializedName("duration")
    val duration: String,
    @SerializedName("duration_secs")
    val durationSecs: Int,
    @SerializedName("fullname")
    val fullname: String,
    @SerializedName("height")
    val height: Int,
    @SerializedName("md5")
    val md5: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("nsfw")
    val nsfw: Int,
    @SerializedName("path")
    val path: String,
    @SerializedName("size")
    val size: Int,
    @SerializedName("thumbnail")
    val thumbnail: String,
    @SerializedName("tn_height")
    val tnHeight: Int,
    @SerializedName("tn_width")
    val tnWidth: Int,
    @SerializedName("type")
    val type: Int,
    @SerializedName("width")
    val width: Int
)