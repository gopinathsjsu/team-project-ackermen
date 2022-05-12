package com.spts.admin;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.spts.signup.User;

@RestController
public class GetAllUsersController {

	private static final Logger log = LoggerFactory.getLogger(GetAllUsersController.class);

	@Autowired
	private GetAllUsers users;
	private final String notLoggedIn = "Must be logged in.";

	@GetMapping(value = "/getAllUsers", produces = "application/json")

	public String getAllBookings(HttpServletRequest request) {

		User user = (User) request.getSession().getAttribute("user");

		if (user == null) 
			return notLoggedIn;
		if(user.getUserType().equals("c"))
			return "Permission denied";

		String json="";
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

		try {
			json = ow.writeValueAsString(users.getUserRecords(user));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}

}