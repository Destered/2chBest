package com.dester.a2chbest.api.response


import com.dester.a2chbest.api.model.SingleBoard
import com.dester.a2chbest.api.model.Thread
import com.google.gson.annotations.SerializedName

data class ThreadListForPagesResponse(
    @SerializedName("advert_bottom_image")
    val advertBottomImage: String,
    @SerializedName("advert_bottom_link")
    val advertBottomLink: String,
    @SerializedName("advert_mobile_image")
    val advertMobileImage: String,
    @SerializedName("advert_mobile_link")
    val advertMobileLink: String,
    @SerializedName("advert_top_image")
    val advertTopImage: String,
    @SerializedName("advert_top_link")
    val advertTopLink: String,
    @SerializedName("Board")
    val board: String,
    @SerializedName("board_banner_image")
    val boardBannerImage: String,
    @SerializedName("board_banner_link")
    val boardBannerLink: String,
    @SerializedName("BoardInfo")
    val boardInfo: String,
    @SerializedName("BoardInfoOuter")
    val boardInfoOuter: String,
    @SerializedName("BoardName")
    val boardName: String,
    @SerializedName("board_speed")
    val boardSpeed: Int,
    @SerializedName("bump_limit")
    val bumpLimit: Int,
    @SerializedName("current_page")
    val currentPage: Int,
    @SerializedName("current_thread")
    val currentThread: Int,
    @SerializedName("default_name")
    val defaultName: String,
    @SerializedName("enable_dices")
    val enableDices: Int,
    @SerializedName("enable_flags")
    val enableFlags: Int,
    @SerializedName("enable_icons")
    val enableIcons: Int,
    @SerializedName("enable_images")
    val enableImages: Int,
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
    @SerializedName("enable_video")
    val enableVideo: Int,
    @SerializedName("is_board")
    val isBoard: Int,
    @SerializedName("is_index")
    val isIndex: Int,
    @SerializedName("max_comment")
    val maxComment: Int,
    @SerializedName("max_files_size")
    val maxFilesSize: Int,
    @SerializedName("pages")
    val pages: List<Int>,
    @SerializedName("tags")
    val tags: List<String>,
    @SerializedName("threads")
    val threads: List<Thread>,
    @SerializedName("top")
    val top: List<SingleBoard>
)