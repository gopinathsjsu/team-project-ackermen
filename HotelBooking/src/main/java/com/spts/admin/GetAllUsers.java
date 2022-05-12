package com.spts.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.spts.signup.User;

@Component
public class GetAllUsers {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private String getUserSql = "select * from user";

	public List<User> getUserRecords(User user){

		List<User> userList = new ArrayList<>();

		if("c".equals(user.getUserType()))
			return new ArrayList<User>();

		try {
			userList = jdbcTemplate.query(getUserSql, BeanPropertyRowMapper.newInstance(User.class)); 
		}
		catch(DataAccessException da) {
			throw new RuntimeException(da);
		}
		return userList;
	}

}
