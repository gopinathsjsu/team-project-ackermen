package com.spts.interfaces;

import com.spts.booking.Booking;

public interface IModifyReservation {
	public String deleteBooking(int booking_id);
	public String changeBooking(int booking_id, Booking newBooking);

}
