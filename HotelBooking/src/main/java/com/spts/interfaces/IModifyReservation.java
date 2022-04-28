package com.spts.interfaces;

import com.spts.booking.Booking;

public interface IModifyReservation {
	public int deleteBooking(Booking booking);
	public int changeBooking(Booking newBooking);

}
