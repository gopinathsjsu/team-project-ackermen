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



@Component
public class ViewAllBookingsImpl implements IViewAllBookings {

	@Autowired
	private JdbcTemplate jdbcTemplate;


	@Override
	public List<Booking> getBookingRecords() {

		List<Booking> allBookings = new ArrayList<>();
		String sql = "select booking_id as bookingId, user_id as userId, hotel_id as hotelId, booking_email as bookingEmail, "
				+"adult_count as adultCount, children_count as childrenCount, check_in_date as checkinDate, "
				+ "check_out_date as checkoutDate, single_rooms_booked as singleroomsBooked, double_rooms_booked as doubleroomsBooked, "
				+ "suites_booked as suitesBooked, final_price as finalPrice, booking_status as bookingStatus, daily_con_bf as breakfast, "
				+"gym as gym, pool as pool, parking as parking, meals as meals from booking";

		String rewardsQuery = "select reward_points from rewards where user_id = ?";
		try {
			allBookings = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Booking.class)); 
			if(!allBookings.isEmpty()) {
				for(Booking b : allBookings) {
					b.setStatusMessage("View all bookings success");
					int intelist = jdbcTemplate.queryForObject(rewardsQuery, Integer.class,b.getUserId());
					b.setRewardPoints(intelist);
				}
			}
		}
		catch(DataAccessException da) {
			throw new RuntimeException(da);
		}
		return allBookings;

	}

}


