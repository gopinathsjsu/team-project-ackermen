package com.spts.booking;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 *  @author Teja Ganapati Jaddipal - 015957526
 */

@Component
public class UserRecordImpl implements IUserRecord{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public int addNewUserRecord(User newUser){
		int result = 0;
        String sql = "INSERT INTO user (id, firstName, lastName, email, password, country, cityOrtown, address, zipcode, userType) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
        try {
                result = jdbcTemplate.update(sql, newUser.getId(), newUser.getFirstName(), newUser.getLastName(),
        		newUser.getEmail(),newUser.getPassword(),newUser.getCountry(),newUser.getCity(),newUser.getAddress(),newUser.getZipcode(), newUser.getUserType());
        }
        catch(InvalidResultSetAccessException rs) {
        	throw new RuntimeException(rs);
        }
        catch(DataAccessException da) {
        	throw new RuntimeException(da);
        }
         
        return result;
         
    }
	@Override
	public List<User> getUserRecords(){
		String sql = "select * from user";
		List<User> userList = new ArrayList<>();
		try {
		  userList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(User.class)); 
		}
		catch(DataAccessException da) {
	        throw new RuntimeException(da);
	    }
		return userList;
	}
}
