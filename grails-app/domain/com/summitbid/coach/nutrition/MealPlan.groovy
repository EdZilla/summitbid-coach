package com.summitbid.coach.nutrition

import com.summitbid.coach.BaseDomain

import com.summitbid.coach.nutrition.MealPlan;

class MealPlan extends BaseDomain {

	static hasMany = [foods:Food]
    static constraints = {
    }
}
