package com.spts.booking;

import java.util.List;

/**
 *  @author Teja Ganapati Jaddipal - 015957526
 */

public interface UserRecord {
	
	abstract public int addNewUserRecord(User user) throws Exception;
	abstract public List<User> getUserRecords() throws Exception;

}
