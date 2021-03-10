package com.dester.a2chbest.api.response


import com.google.gson.annotations.SerializedName

data class AllBoardCategoryResponse(
    @SerializedName("Взрослым")
    val adult: List<BoardCategoryResponse>,
    @SerializedName("Игры")
    val game: List<BoardCategoryResponse>,
    @SerializedName("Политика")
    val policy: List<BoardCategoryResponse>,
    @SerializedName("Пользовательские")
    val userCreated: List<BoardCategoryResponse>,
    @SerializedName("Разное")
    val common: List<BoardCategoryResponse>,
    @SerializedName("Творчество")
    val art: List<BoardCategoryResponse>,
    @SerializedName("Тематика")
    val thematic: List<BoardCategoryResponse>,
    @SerializedName("Техника и софт")
    val techAndSoft: List<BoardCategoryResponse>,
    @SerializedName("Японская культура")
    val japanCulture: List<BoardCategoryResponse>
)