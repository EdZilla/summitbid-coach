package com.summitbid.coach.nutrition


scenario "User wants to see a meal, from an existing meal plan",{
	given "A set of meals from a meal plan."
	
	when "I choose a meal from the plan"
	
	then "The meal is displayed."
}

scenario "User wants to create a meal, from a set of foods",{
	given "A set of foods to choose from."

	when "I choose a food, it gets added to the meal"
	
	then "The foodcount for the meal increases by 1"

}

scenario "User wants to add a food to a meal.",{
	given "A set of foods to choose from."
	
	when "I choose a food, it gets added to the meal"

	then "The foodcount for the meal increases by 1"

}