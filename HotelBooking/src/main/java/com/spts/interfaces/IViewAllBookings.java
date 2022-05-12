package com.spts.interfaces;

import java.util.List;

import com.spts.booking.Booking;
import com.spts.signup.User;

public interface IViewAllBookings {

	public List<Booking> getBookingRecords(User user);

}
