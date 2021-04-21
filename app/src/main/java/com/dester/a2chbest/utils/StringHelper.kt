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
                this.add(getEmptyCategory(categoryResponse.adult))
                this.add(getEmptyCategory(categoryResponse.art))
                this.add(getEmptyCategory(categoryResponse.common))
                this.add(getEmptyCategory(categoryResponse.game))
                this.add(getEmptyCategory(categoryResponse.japanCulture))
                this.add(getEmptyCategory(categoryResponse.policy))
                this.add(getEmptyCategory(categoryResponse.techAndSoft))
                this.add(getEmptyCategory(categoryResponse.thematic))
                this.add(getEmptyCategory(categoryResponse.userCreated))
            }
            return categoryList
        }

        fun getSubcategoryByName(
            categories: AllBoardCategoryResponse,
            categoryName: String
        ): List<SubCategory> {
            var returnList = arrayListOf<SubCategory>()
            when (categoryName) {
                "Взрослым" -> {
                    categories.adult.forEach {
                        returnList.add(SubCategory(it.name, it.id))
                    }
                }
                "Пользовательские" -> {
                    categories.userCreated.forEach {
                        returnList.add(SubCategory(it.name, it.id))
                    }
                }
                "Политика" -> {
                    categories.policy.forEach {
                        returnList.add(SubCategory(it.name, it.id))
                    }
                }
                "Игры" -> {
                    categories.game.forEach {
                        returnList.add(SubCategory(it.name, it.id))
                    }
                }
                "Разное" -> {
                    categories.common.forEach {
                        returnList.add(SubCategory(it.name, it.id))
                    }
                }
                "Творчество" -> {
                    categories.art.forEach {
                        returnList.add(SubCategory(it.name, it.id))
                    }
                }
                "Тематика" -> {
                    categories.thematic.forEach {
                        returnList.add(SubCategory(it.name, it.id))
                    }
                }
                "Техника и софт" -> {
                    categories.techAndSoft.forEach {
                        returnList.add(SubCategory(it.name, it.id))
                    }
                }
                "Японская культура" -> {
                    categories.japanCulture.forEach {
                        returnList.add(SubCategory(it.name, it.id))
                    }
                }
            }
            return returnList
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
            var answerCategory: Category = Category(category.first().category, arrayListOf())
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