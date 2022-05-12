package com.spts.misc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetRewardsController {
	
	@Autowired
	private GetRewardsImpl rewards;
	@GetMapping(value = "/getRewards/{userId}", produces = "application/json")
	public Rewards getRewards(@PathVariable int userId) {
		Rewards json=null;
		try {
			json = rewards.getRewards(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		    return json;
		}

}
