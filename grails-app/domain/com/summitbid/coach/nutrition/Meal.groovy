package com.summitbid.coach.nutrition


import com.summitbid.coach.nutrition.Meal;

class Meal {
  static hasMany = [foods:Food]
  
    static constraints = {
    }
}
