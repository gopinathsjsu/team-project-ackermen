package com.spts.admin;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.spts.signup.User;

@RestController
public class AddHotelController {

	@Autowired
	private AddHotelImpl addHotels;
	private final String notLoggedIn = "Must be logged in.";

	@PostMapping(value = "/addHotels", produces = "application/json")
	public String getAllBookings(@RequestBody NewHotel newHotel, HttpServletRequest request) {

		User user = (User) request.getSession().getAttribute("user");

		if (user == null) 
			return notLoggedIn;

		if(user.getUserType().equals("c") || user.getUserType().equals("e"))
			return "Permission denied";

		String json="";
		int result = addHotels.addHotel(newHotel, user);
		switch(result) {
		case 0: json = "Unable to add hotel";
		break;
		case 1111: json = "Invalid user";
		break;
		case 1: json = "Hotel added successfully";
		break;
		default: json = "Something went wrong";
		}

		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

		try {
			json = ow.writeValueAsString(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;

	}
}
