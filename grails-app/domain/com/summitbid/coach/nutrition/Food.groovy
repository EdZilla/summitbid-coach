package com.summitbid.coach.nutrition
import com.summitbid.coach.BaseDomain
class Food extends BaseDomain {

	NutritionInfo nutritionInfo
	
    static constraints = {
		nutritionInfo(nullable:true)
    }
}
