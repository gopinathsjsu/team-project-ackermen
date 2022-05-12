package com.spts.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.spts.admin.NewHotel;
import com.spts.signup.User;

@Component
public class AddHotelImpl {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private String getUserSql = "select * from user";

	private String addHotelSql = "INSERT INTO hotels\n"
			+ "(hotel_name,country,city,address,available_single_rooms,available_double_rooms,available_suites,single_price,double_price,\n"
			+ "suite_price,daily_con_bf,gym,pool,parking,meals)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

	public int addHotel(NewHotel newHotel, User user){
		List<User> userList = new ArrayList<>();
		int code = -1;
		try {
			userList = jdbcTemplate.query(getUserSql, BeanPropertyRowMapper.newInstance(User.class)); 
			if(userList.isEmpty())
				return 1111;
			code = jdbcTemplate.update(addHotelSql,newHotel.getHotelName(),newHotel.getCountry(),newHotel.getCity(),
					newHotel.getAddress(),newHotel.getAvailableSingleRooms(),newHotel.getAvailableDoubleRooms(),newHotel.getAvailableSuites(),
					newHotel.getSinglePrice(),newHotel.getDoublePrice(),newHotel.getSuitePrice(),newHotel.getBreakfastPrice(),newHotel.getGymPrice(),
					newHotel.getPoolPrice(),newHotel.getParkingPrice(),newHotel.getAllMealsPrice());
		}
		catch(DataAccessException da) {
			throw new RuntimeException(da);
		}
		return code;
	}

}
