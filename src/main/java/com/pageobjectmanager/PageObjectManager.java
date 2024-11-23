package com.pageobjectmanager;

import com.baseclass.BaseClass;
import com.pageobjectmodel.AdactinHotelBooking;
import com.pageobjectmodel.AdactinLoginPage;
import com.pageobjectmodel.AdactinSearchPage;
import com.srcmainresorces.FileReaderManager;

public class PageObjectManager extends BaseClass {
	
	FileReaderManager reader;
	AdactinLoginPage loginPage;
	AdactinSearchPage searchPage;
	AdactinHotelBooking hotelBooking;

	public FileReaderManager getReader() {
		if (reader == null) {
			reader = new FileReaderManager();
		}
		return reader;
	}
	
	public AdactinLoginPage getLoginPage() {
		if (loginPage == null) {
			loginPage = new AdactinLoginPage(driver);
		}
		return loginPage;
	}

	public AdactinSearchPage getSearchPage() {
		if (searchPage == null) {
			searchPage = new AdactinSearchPage(driver);
		}
		return searchPage;
	}

	public AdactinHotelBooking getHotelBooking() {
		if (hotelBooking == null) {
			hotelBooking = new AdactinHotelBooking(driver);
		}
		return hotelBooking;
	}

}