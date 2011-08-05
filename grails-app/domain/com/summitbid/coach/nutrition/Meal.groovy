package com.summitbid.coach.nutrition

import com.summitbid.coach.BaseDomain
import com.summitbid.coach.Property


class Meal extends BaseDomain {
  static hasMany = [ foods:Food ]
  
    static constraints = {
    }
}
