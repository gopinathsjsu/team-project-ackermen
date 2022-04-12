package com.spts.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogOutController {
	
	/*@PostMapping(value = "/logout")
	public String login(@RequestBody User currentUser, HttpServletRequest request) throws Exception{
		
            if(request.getSession().getAttribute(currentUser.getEmail()) != null)
            	request.getSession()
		return "Log out success";
	}*/

}
