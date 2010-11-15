package com.summitbid.coach

abstract class BaseDomain {
	String name
    static constraints = {
		name(nullable:false)
    }
	
	static mapping = {
		tablePerHierarchy false
	  }
	
	/**
	* Validates and saves the supplied domain object.
	* Issues are printed to standard out.
	*/
   def validateAndSave = { flushStatus ->
	 def savedObj
	 def valid = this.validate()
 
	 if (valid) {
	   savedObj = this.save(flush:flushStatus)
	 }
 
	 if(!valid || !savedObj) {
	   println("Error saving " + this)
	   println this.errors
	 }
 
	 savedObj
   }
}
