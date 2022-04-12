package com.spts.booking;

public class Booking {
	private int booking_id;
	private int user_id;
	private int hotel_id;
	private int adult_count;
	private int children_count;
	private String check_in_date;
	private String check_out_date;
	private int single_rooms_booked;
	private int double_rooms_booked;
	private int suites_booked;
	public int getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getHotel_id() {
		return hotel_id;
	}
	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}
	public int getAdult_count() {
		return adult_count;
	}
	public void setAdult_count(int adult_count) {
		this.adult_count = adult_count;
	}
	public int getChildren_count() {
		return children_count;
	}
	public void setChildren_count(int children_count) {
		this.children_count = children_count;
	}
	public String getCheck_in_date() {
		return check_in_date;
	}
	public void setCheck_in_date(String check_in_date) {
		this.check_in_date = check_in_date;
	}
	public String getCheck_out_date() {
		return check_out_date;
	}
	public void setCheck_out_date(String check_out_date) {
		this.check_out_date = check_out_date;
	}
	public int getSingle_rooms_booked() {
		return single_rooms_booked;
	}
	public void setSingle_rooms_booked(int single_rooms_booked) {
		this.single_rooms_booked = single_rooms_booked;
	}
	public int getDouble_rooms_booked() {
		return double_rooms_booked;
	}
	public void setDouble_rooms_booked(int double_rooms_booked) {
		this.double_rooms_booked = double_rooms_booked;
	}
	public int getSuites_booked() {
		return suites_booked;
	}
	public void setSuites_booked(int suites_booked) {
		this.suites_booked = suites_booked;
	}

}
