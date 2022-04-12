package com.spts.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModifyReservationController {
	@Autowired
	private ModifyReservationImpl modifyReservation;
	
	@DeleteMapping(value = "/deleteBooking/{booking_id}")
	public String deleteBooking(@PathVariable(value="booking_id") int booking_id) {
		String message = modifyReservation.deleteBooking(booking_id);
		return message;
	}
	
	@PutMapping(value = "/changeBooking/{booking_id}")
	public String changeBooking(@PathVariable(value="booking_id") int booking_id, Booking newBooking) {
		String message = modifyReservation.changeBooking(booking_id, newBooking);
		return message;
	}

}
