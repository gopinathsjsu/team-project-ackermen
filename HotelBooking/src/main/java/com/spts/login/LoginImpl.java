package com.spts.login;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.spts.interfaces.ILogin;
import com.spts.signup.User;

@Component
public class LoginImpl implements ILogin{
	//private static final Logger log = LoggerFactory.getLogger(LoginImpl.class);
	@Autowired
	private JdbcTemplate loginJdbcTemplate;
	
	@Override
	public User userLoginCheck(String userName, String passWord) {
		String sql = "select * from user where email = ? and password = ?";  
		List<User> currentuser = new ArrayList<>();
		String encryptedPassword = getEncryptedPassword(passWord);
		try{
			currentuser = loginJdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(User.class),userName,encryptedPassword);
		}
		catch(InvalidResultSetAccessException rs) {
        	throw new RuntimeException(rs);
        }
        catch(DataAccessException da) {
        	throw new RuntimeException(da);
        }
		return currentuser.isEmpty()? new User():currentuser.get(0);
	}
	public String getEncryptedPassword(String password) {
		StringBuffer sb = new StringBuffer();
		for(char c:password.toCharArray()) {
			sb.append(c-'a');
			sb.append('%');
		}
		return sb.toString();
	}
}
