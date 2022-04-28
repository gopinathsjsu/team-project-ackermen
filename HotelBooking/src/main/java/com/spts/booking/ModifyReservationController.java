package com.spts.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@RestController
public class ModifyReservationController {
	@Autowired
	private ModifyReservationImpl modifyReservation;
	
	@DeleteMapping(value = "/deleteBooking")
	public String deleteBooking(@RequestBody Booking booking) {
		String json="";
		int code = -2;
		   ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		code = modifyReservation.deleteBooking(booking);
		switch(code) {
		   case 1111 : json = "Booking cancelled succesfully";
		   break;
		   case 2222 : json = "Something went wrong while cancelling your booking";
		   break;
		   case 4444 : json = "No booking record exists with provided booking id, Please check";
		   break;
		   case 5555 : json = "One of the mandatory values is null, Please check";
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
	
	@PutMapping(value = "/changeBooking")
	public String changeBooking(@RequestBody Booking newBooking) {
		String json="";
		int code = -2;
		   ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		 code  = modifyReservation.changeBooking(newBooking);
		 switch(code) {
		 
		 case 0: json = "Problem in modifying booking, try again";
		 break;
		 case 1111: json = "Stay duration more than 7 days, cant book";
		 break;
		 case 2222: json = "Booking email can't be null";
		 break;
		 case 3333: json = "One of the mandatory values in null";
		 break;
		 case 4444 : json = "No booking record exists with provided booking id, Please check";
	     break;
	     case 5555 : json = "Invalid user is, Please check";
	     break;
		 case 1: json = "Booking modified successfully";
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
