package com.summitbid.coach

import com.summitbid.coach.activity.Activity
import com.summitbid.coach.nutrition.Food
import com.summitbid.coach.nutrition.Meal
import com.summitbid.coach.nutrition.MealPlan

/**
 
 */
class Property extends BaseDomain {
	
	String value

	static belongsTo = [ Food]
  
	static constraints = {
	  value(nullable:false)
	}

}
