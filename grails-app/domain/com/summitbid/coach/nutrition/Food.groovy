package com.summitbid.coach.nutrition
import com.summitbid.coach.BaseDomain
import com.summitbid.coach.Property

class Food extends BaseDomain {

	NutritionInfo nutritionInfo
	static hasMany = [properties : Property]
	
    static constraints = {
		nutritionInfo(nullable:true)
    }
	
//	String toString()
//	{
//		println "food: ${this.name}"
//	}
}
