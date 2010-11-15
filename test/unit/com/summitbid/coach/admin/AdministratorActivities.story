package com.summitbid.coach.admin


description "Stuff an administrator of the application does"

narrative "An administrators duties and privileges ", {
	as_a "Administrator..."
	i_want "to update my food nutrition information"
	so_that "i can keep the nutrition information up to date"
	and "users can see food information"
}

tags "TestAdmin"

scenario "see list of food nutrition providers", { }

scenario "select food nutrition info provider", { }

scenario "Once having seen the list of nutrition info providers, and selected one, update nutrition info",{
}

narrative "Create new Roles in the application, that we had not forseen", {
	as_a "Administrator..."
	i_want "to create a new role"
	so_that "we can keep the application agile and updated"
}

scenario "Create a new role", { }

narrative "Grant users privileges by giving them new roles", {
	as_a "Administrator..."
	i_want "to assign a user a new role"
	so_that "we can allow users additional privileges"
}

scenario "Assign a user a new role", { }