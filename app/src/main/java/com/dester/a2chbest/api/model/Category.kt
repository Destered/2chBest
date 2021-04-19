package com.dester.a2chbest.api.model


data class Category(
    var name: String,
    var subCategory: List<SubCategory>
)