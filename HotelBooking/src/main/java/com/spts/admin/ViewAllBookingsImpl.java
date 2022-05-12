package com.spts.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.spts.booking.Booking;
import com.spts.interfaces.IViewAllBookings;
import com.spts.signup.User;

@Component
public class ViewAllBookingsImpl implements IViewAllBookings {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Booking> getBookingRecords(User user) {

		List<Booking> allBookings = new ArrayList<>();
		
		String sql = "select * from booking";
		
		if("c".equals(user.getUserType()))
			return new ArrayList<Booking>();
		try {
			allBookings = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Booking.class)); 
		}
		catch(DataAccessException da) {
			throw new RuntimeException(da);
		}
		return allBookings;

	}

}
