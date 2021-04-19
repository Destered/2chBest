package com.dester.a2chbest.utils

import com.dester.a2chbest.api.model.Category
import com.dester.a2chbest.api.model.SubCategory
import com.dester.a2chbest.api.response.AllBoardCategoryResponse
import com.dester.a2chbest.api.response.BoardCategoryResponse

class StringHelper {

    companion object {

        fun getAllEmptyCategory(categoryResponse: AllBoardCategoryResponse): List<Category> {
            val categoryList = arrayListOf<Category>()
            categoryList.apply {
                this.add(getCategory(categoryResponse.adult))
                this.add(getCategory(categoryResponse.art))
                this.add(getCategory(categoryResponse.common))
                this.add(getCategory(categoryResponse.game))
                this.add(getCategory(categoryResponse.japanCulture))
                this.add(getCategory(categoryResponse.policy))
                this.add(getCategory(categoryResponse.techAndSoft))
                this.add(getCategory(categoryResponse.thematic))
                this.add(getCategory(categoryResponse.userCreated))
            }
            return categoryList
        }

        fun getAllCategory(categoryResponse: AllBoardCategoryResponse): List<Category> {
            val categoryList = arrayListOf<Category>()
            categoryList.apply {
                this.add(getCategory(categoryResponse.adult))
                this.add(getCategory(categoryResponse.art))
                this.add(getCategory(categoryResponse.common))
                this.add(getCategory(categoryResponse.game))
                this.add(getCategory(categoryResponse.japanCulture))
                this.add(getCategory(categoryResponse.policy))
                this.add(getCategory(categoryResponse.techAndSoft))
                this.add(getCategory(categoryResponse.thematic))
                this.add(getCategory(categoryResponse.userCreated))
            }
            return categoryList
        }

        fun getEmptyCategory(category: List<BoardCategoryResponse>): Category {
            var answerCategory: Category = Category(category.first().name, arrayListOf())
            return answerCategory
        }


        fun getCategory(category: List<BoardCategoryResponse>): Category {
            var firstElement = true
            var subCategoryList = ArrayList<SubCategory>()
            var answerCategory: Category = Category("", arrayListOf())
            for (boardInfo in category) {
                if (!firstElement) {
                    subCategoryList.add(SubCategory(boardInfo.name, boardInfo.id))
                } else {
                    answerCategory.name = boardInfo.name
                    firstElement = false
                }
            }
            return answerCategory
        }


    }

}