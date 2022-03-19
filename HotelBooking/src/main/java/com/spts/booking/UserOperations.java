package com.spts.booking;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 *  @author Teja Ganapati Jaddipal - 015957526
 */

@Component
public class UserOperations implements UserRecord{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public int addNewUserRecord(User newUser) throws Exception {
        String sql = "INSERT INTO user (id, firstName, lastName, email, password, country, cityOrtown, address, zipcode) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int result = jdbcTemplate.update(sql, newUser.getId(), newUser.getFirstName(), newUser.getLastName(),
        		newUser.getEmail(),newUser.getPassword(),newUser.getCountry(),newUser.getCity(),newUser.getAddress(),newUser.getZipcode());
         
        return result;
         
    }
	@Override
	public List<User> getUserRecords() throws Exception {
		String sql = "select * from user";
		List<User> userList = new ArrayList<>();
		userList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(User.class)); 
		return userList;
	}
}
