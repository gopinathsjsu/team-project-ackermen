package com.spts.signup;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.spts.interfaces.IUserRecord;

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
		List<User> testuser = new ArrayList<>();
        String sql = "INSERT INTO user (id, firstName, lastName, email, password, country, cityOrtown, address, zipcode, userType) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
        String sql2 = "select * from user where id = ?"; 
        //if some of the parameters are null you can't add record 
        
        if(newUser.getId().toString().equals("") || newUser.getFirstName().equals("") || newUser.getEmail().equals("") 
        		|| newUser.getPassword().equals("") || newUser.getZipcode().equals("") || newUser.getAddress().equals("") 
        		|| newUser.getCountry() .equals("") || newUser.getCity().equals("") || newUser.getUserType().equals("")) {
        	
        	return 2222;
        }
        try {   
        	    //if userid already exists, throw an error
        	    testuser = jdbcTemplate.query(sql2, BeanPropertyRowMapper.newInstance(User.class),newUser.getId());
        	    if(!testuser.isEmpty())
        	    	result = 1111;
        	    else {
	                result = jdbcTemplate.update(sql, newUser.getId(), newUser.getFirstName(), newUser.getLastName(),
	        		newUser.getEmail(),newUser.getPassword(),newUser.getCountry(),newUser.getCity(),newUser.getAddress(),newUser.getZipcode(), newUser.getUserType());
                }       
                
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
