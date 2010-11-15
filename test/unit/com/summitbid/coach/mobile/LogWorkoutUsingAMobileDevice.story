package com.summitbid.coach.mobile

scenario "Log a bike ride using his mobile device",{
	
	narrative "I want to go on a bike ride, and after I ride, I want to conveniently record " + 
	"where, when, how many miles, vertical feet, heart rate, ", {
		as_a "user"
		i_want "to log my mt bike ride on my mobile device"
		so_that "I can later log the ride and review the workout."
	}
	
	given "I hava a mobile device and an account on the app"
	when "the user enters the bike ride info"
	then "the info is translated into a message"
	and
	then "the message is transmitted to the app"
	and
	then "the info is stored in the user's account workout info"
	
}


scenario "log a soccer game using his mobile device",{
	
	narrative "I want to play a soccer, and after the game, I want to conveniently record " +
	"where, when, who played, who won and some notes, and have it stored in the online app", {
		as_a "user"
		i_want "to log my soccer game on my mobile device"
		so_that "I can later log the game and review the workout."
	}
	
	given "I hava a mobile device and an account on the app"
	when "the user enters the soccer game team: "
	and
	when "the user enters the game time"
	and
	when "the user enters the description"
	
	then "the info is translated into a message"
	and
	then "the message is transmitted to the app"
	and
	then "the info is stored in the user's account workout info"
	
	
}