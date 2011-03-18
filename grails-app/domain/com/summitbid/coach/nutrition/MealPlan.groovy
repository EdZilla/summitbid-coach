package com.summitbid.coach.nutrition


import com.summitbid.coach.nutrition.MealPlan;


class MealPlan {
static hasMany = [foods:Food]
    static constraints = {
    }
}
