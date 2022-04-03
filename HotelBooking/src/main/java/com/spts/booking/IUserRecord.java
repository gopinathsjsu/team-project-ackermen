package com.spts.booking;

import java.util.List;

/**
 *  @author Teja Ganapati Jaddipal - 015957526
 */

public interface IUserRecord {
	
	public abstract int addNewUserRecord(User user);
	public abstract List<User> getUserRecords();

}
