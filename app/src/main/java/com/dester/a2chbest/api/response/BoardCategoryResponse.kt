package com.dester.a2chbest.api.response


import com.dester.a2chbest.api.model.Icon
import com.google.gson.annotations.SerializedName

data class BoardCategoryResponse(

    @SerializedName("bump_limit")
    val bumpLimit: Int,
    @SerializedName("category")
    val category: String,
    @SerializedName("default_name")
    val defaultName: String,
    @SerializedName("enable_dices")
    val enableDices: Int,
    @SerializedName("enable_flags")
    val enableFlags: Int,
    @SerializedName("enable_icons")
    val enableIcons: Int,
    @SerializedName("enable_likes")
    val enableLikes: Int,
    @SerializedName("enable_names")
    val enableNames: Int,
    @SerializedName("enable_oekaki")
    val enableOekaki: Int,
    @SerializedName("enable_posting")
    val enablePosting: Int,
    @SerializedName("enable_sage")
    val enableSage: Int,
    @SerializedName("enable_shield")
    val enableShield: Int,
    @SerializedName("enable_subject")
    val enableSubject: Int,
    @SerializedName("enable_thread_tags")
    val enableThreadTags: Int,
    @SerializedName("enable_trips")
    val enableTrips: Int,
    @SerializedName("icons")
    val icons: List<Icon>,
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("pages")
    val pages: Int,
    @SerializedName("sage")
    val sage: Int,
    @SerializedName("tripcodes")
    val tripcodes: Int
)