package com.summitbid.coach.activity
import com.summitbid.coach.BaseDomain
import com.summitbid.coach.Property

class Activity extends BaseDomain {
	
	Date start
	Date end
	def duration 
	
	//static hasMany = [properties: Property]
	
	static constraints = {
	}
}
