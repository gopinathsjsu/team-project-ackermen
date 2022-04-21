package com.spts.signup;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	
	private static final Logger log = LoggerFactory.getLogger(UserRecordImpl.class);
	
	@Override
	public int addNewUserRecord(User newUser){
		int result = 0;
		int currentUserId = -1;
		List<User> testuser = new ArrayList<>();
		String encryptedPassword = getEncryptedPassword(newUser.getPassword());
        String sql = "INSERT INTO user (firstName, lastName, email, password, country, city, address, zipcode, usertype) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)";
        String sql2 = "select * from user where email = ?"; 
        String sql3 = "SELECT LAST_INSERT_ID()";
        //if some of the parameters are null you can't add record 
        
        if(newUser.getFirstName().equals("") || newUser.getEmail().equals("") 
        		|| newUser.getPassword().equals("") || newUser.getZipcode().equals("") || newUser.getAddress().equals("") 
        		|| newUser.getCountry() .equals("") || newUser.getCity().equals("") || newUser.getUserType().equals("")) {
        	
        	return 2222;
        }
        try {   
        	    //if userid already exists, throw an error
        	    testuser = jdbcTemplate.query(sql2, BeanPropertyRowMapper.newInstance(User.class),newUser.getEmail());
        	    if(!testuser.isEmpty())
        	    	result = 1111;
        	    else {
	                result = jdbcTemplate.update(sql, newUser.getFirstName(), newUser.getLastName(),
	        		newUser.getEmail(),encryptedPassword,newUser.getCountry(),newUser.getCity(),newUser.getAddress(),newUser.getZipcode(), newUser.getUserType());
	                //SELECT LAST_INSERT_ID(); to get last insert id and return it to user use same thing for booking
	                currentUserId = jdbcTemplate.queryForObject(sql3, Integer.class);
	                log.info("newly inserted id = "+currentUserId);
	                // as soon as you create user, create rewards table entry and add 100 points
	                // as soon as hotel is booked, based on total price add reward points
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
	public String getEncryptedPassword(String password) {
		StringBuffer sb = new StringBuffer();
		for(char c:password.toCharArray()) {
			sb.append(c-'a');
			sb.append('%');
		}
		return sb.toString();
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
