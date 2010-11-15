package com.summitbid.coach.nutrition


description "<b>A user should be able to select a meal from a meal plan and" +
	" log that he or she has consumed that meal" + 
	" and examine the meal nutrition information and calories, etc</b>"
	
	narrative "A user should be able to select a meal plan", {
		as_a "A normal user"
		i_want "to view meal plans and select one"
		so_that "I can start a diet"
	}
	
shared_behavior "list all Meal Plans", {
		given "The user has access to the meal plan list"
		and
		given "There are a number of meals"
		and
		given "There are a number of meal plans"
		when "the user navigates to the meal plan list"
}


shared_behavior "select a meal in Meal Plan", { 
	it_behaves_as "list all Meal Plans"
	when "the user selects a meal plan"
	then "The selected meal plan view appears"
	and 
	then "The list of meals in the meal plan is visible"
	when "the user selects a meal in the meal plan's meal list"
}

scenario "View all meal plans",{
	it_behaves_as "list all Meal Plans"
	then "The meal plan list view appears"
}

scenario "Select a meal plan from the meal plan list view",{
	it_behaves_as "select a meal in Meal Plan"
	then "The selected meal appears in the meal view"
}

scenario "Record an actual meal from a meal plan meal", {
	when "the user selects a meal from a meal plan"
	and
	when "the user selects \"log the meal\""
	then "the meal detail view appears"
	and
	then "The user can enter amounts and variations"
	and
	then "the meal calories and nutrition info are available for reports"
}

shared_behavior "hello world string shared behaviors", {
	given "a string", {
	  var = ""
	}
	
	when "the string is hello world", {
	  var = "hello world"
	}
  }


  scenario "first shared behavior test scenario", {
	it_behaves_as "hello world string shared behaviors"
	
	then "the string should start with hello", {
	  var.shouldStartWith "hello"
	}
  }
  
  scenario "second shared behavior test scenario", {
	it_behaves_as "hello world string shared behaviors"
	
	then "the string should end with world", {
	  var.shouldEndWith "world"
	}
  }