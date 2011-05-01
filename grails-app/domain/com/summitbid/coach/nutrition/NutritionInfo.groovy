package com.summitbid.coach.nutrition

import com.summitbid.coach.BaseDomain


class NutritionInfo extends BaseDomain {

	int calories
	int gramsFat

	static belongsTo = Food
	
    static constraints = {
    }
}
