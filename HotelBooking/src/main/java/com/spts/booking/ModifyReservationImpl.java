package com.spts.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.spts.interfaces.IModifyReservation;

@Component
public class ModifyReservationImpl implements IModifyReservation {
	
	@Autowired
	private JdbcTemplate modifyTemplate;
	
	public String deleteBooking(int booking_id) {
		String message = "null";
		String sql = "DELETE FROM booking WHERE booking_id = "+booking_id;
		modifyTemplate.execute(sql);
		sql = "select * from booking WHERE booking_id = "+booking_id;
		message = "Reservation cancelled";
		return message;
	}
	
	public String changeBooking(int booking_id, Booking newBooking) {
		String message = "null";
		String sql = "DELETE FROM booking WHERE booking_id = "+booking_id;
		modifyTemplate.execute(sql);
		sql = "select * from booking WHERE booking_id = "+booking_id;
		Booking testBooking  = modifyTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Booking.class));
		if(testBooking == null)
			message = "Reservation cancelled";
		else
			message = "Problem occured while deleting reservation";
		return message;
	}

}
