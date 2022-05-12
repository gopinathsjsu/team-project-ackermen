package com.spts.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.spts.booking.Booking;
import com.spts.signup.User;

@RestController
public class CheckOutController {

	@Autowired
	CheckoutImpl checkout;
	private final String notLoggedIn = "Must be logged in.";

	@PostMapping(value = "/checkout/{bookingId}", produces = "application/json")

	public String createPerson(@PathVariable int bookingId, HttpServletRequest request){
		User user = (User) request.getSession().getAttribute("user");

		if (user == null) 
			return notLoggedIn;
		if(user.getUserType().equals("c"))
			return "Permission denied";

		String json="";
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		int result = checkout.checkoutRooms(bookingId);

		switch(result) {
		case 0 : json = "Something went wrong while checking out..Please try again";
		break;
		case 1 : json = "Checkout successful";
		break;
		case 1111 : json = "Invalid Booking";
		break;
		default: json = "Unknown error";
		}

		try {
			json = ow.writeValueAsString(json);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;

	}


}
