package com.spts.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.spts.booking.Booking;
import com.spts.helper.UpdateRoomAvailability;
import com.spts.interfaces.ICheckOut;

@Component
public class CheckoutImpl implements ICheckOut{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private UpdateRoomAvailability available;

	@Override
	public int checkoutRooms(int bookingId) {
		int code = -1;
		code = changeBookingStatus(bookingId);
		return code;

	}
	public int changeBookingStatus(int bookingId) {

		String getBooking = "select * from booking where booking_id = ?";
		int code = -1;

		List<Booking> bookinglist = jdbcTemplate.query(getBooking, BeanPropertyRowMapper.newInstance(Booking.class),bookingId);

		if(bookinglist.isEmpty())
			return 1111;

		String updateBookingQuery = "UPDATE booking SET booking_status = ? where booking_id = ?";

		code = jdbcTemplate.update(updateBookingQuery,"CheckedOut",bookingId);

		if(code != 1)
			return code;
		code = available.updateRooms(bookinglist.get(0),"CheckOut");
		return code;
	}
}
