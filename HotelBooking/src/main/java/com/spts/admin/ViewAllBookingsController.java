package com.spts.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.spts.signup.User;

@RestController
public class ViewAllBookingsController {

	@Autowired
	private ViewAllBookingsImpl viewAllBookings;
	private final String notLoggedIn = "Must be logged in.";

	@GetMapping(value = "/getAllBookings", produces = "application/json")

	public String getAllBookings(HttpServletRequest request) {

		User user = (User) request.getSession().getAttribute("user");

		if (user == null) 
			return notLoggedIn;
		if(user.getUserType().equals("c"))
			return "Permission denied";

		String json="";
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

		try {
			json = ow.writeValueAsString(viewAllBookings.getBookingRecords());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}

}
