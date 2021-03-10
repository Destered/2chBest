package com.dester.a2chbest.utils

import com.dester.a2chbest.api.response.AllBoardCategoryResponse

class StringHelper {

    companion object{
        fun getAllCategory(categoryResponse: AllBoardCategoryResponse):List<String>{
            return arrayListOf(
                    categoryResponse.thematic.first().category,
                    categoryResponse.techAndSoft.first().category,
                    categoryResponse.policy.first().category,
                    categoryResponse.japanCulture.first().category,
                    categoryResponse.game.first().category,
                    categoryResponse.common.first().category,
                    categoryResponse.art.first().category,
                    categoryResponse.adult.first().category,
                    categoryResponse.userCreated.first().category
            )
    }


    }

}