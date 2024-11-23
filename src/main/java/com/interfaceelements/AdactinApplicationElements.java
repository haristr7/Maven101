package com.interfaceelements;

public interface AdactinApplicationElements {

	//Login Page Elements
	String username_id = "username";
	String user_pass = "password";
	String login_xpath = "//input[@type='Submit']";
	
	//Search Page Element
	String locationid = "location";
	String hotels_id = "hotels";
	String roomtype_id = "room_type";
	String numberofrooms_id = "room_nos";
	String checkin_id = "datepick_in";
	String checkout_id = "datepick_out";
	String adultroom_id = "adult_room";
	String childroom_id = "child_room";
	String searchbtn = "Submit";

	String selectbtn_id = "radiobutton_0";
	
	String countinue_id = "continue";
	
	//Book Hotel Page
	String firstname_id = "first_name";
	String lastname_id = "last_name";
	String address_id = "address";
	String creditno_id = "cc_num";
	String credittype_id = "cc_type";
	String selectmonth_id = "cc_exp_month";
	String selecetyear_id = "cc_exp_year";
	String ccvnumber = "cc_cvv";
	String booknow_id = "book_now";
	
	String logout_xpath = "(//input[@type='button'])[3]";
}