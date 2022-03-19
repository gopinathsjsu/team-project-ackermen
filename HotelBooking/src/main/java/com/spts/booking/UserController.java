package com.spts.booking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

/**
 *  @author Teja Ganapati Jaddipal - 015957526
 */

@RestController
public class UserController{

	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserOperations userOperations;
	@GetMapping(value = "/getAllUsers", produces = "application/json")
	public String greeting() {
		String json="";
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		try {
			json = ow.writeValueAsString(userOperations.getUserRecords());
		} catch (Exception e) {
			e.printStackTrace();
		}
		    return json;
		}
	
	       @PostMapping(
			  value = "/createUser", consumes = "application/json", produces = "application/json")
			public String createPerson(@RequestBody User newUser) throws Exception {
	    	   String json="Record inserted successfully";
	   		   ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
	    	   int result = userOperations.addNewUserRecord(newUser);
	    	   if(result > 0) {
	    		   json = "New row has been inserted successfully";
	    	   }
	    	   else {
	    		   json = "Error in inserting row";
	    	   }
	    	   try {
	   			json = ow.writeValueAsString(json);
	   		} catch (JsonProcessingException e) {
	   			e.printStackTrace();
	   		}
	   		    return json;
			
}
}