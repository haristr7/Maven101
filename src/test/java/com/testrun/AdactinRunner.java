package com.testrun;

import com.baseclass.BaseClass;
import com.pageobjectmanager.PageObjectManager;

public class AdactinRunner extends BaseClass {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {

		PageObjectManager pageobj = new PageObjectManager();

		launchBrowser(pageobj.getReader().getDataProperty("browser"));
		launchUrl(pageobj.getReader().getDataProperty("url"));
		
		pageobj.getLoginPage().validUserNameAndValidPassword();
		
		pageobj.getSearchPage().searchHotel();
		
		pageobj.getHotelBooking().hotelBook();
	}
}