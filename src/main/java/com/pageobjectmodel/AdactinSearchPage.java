package com.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;
import com.interfaceelements.AdactinApplicationElements;
import com.srcmainresorces.FileReaderManager;

public class AdactinSearchPage extends BaseClass implements AdactinApplicationElements {
	
	@FindBy(id = locationid)
	private WebElement location;
	
	@FindBy(id = hotels_id)
	private WebElement hotel;
	
	@FindBy(id = roomtype_id)
	private WebElement roomType;
	
	@FindBy(id = numberofrooms_id)
	private WebElement noOfRooms;
	
	@FindBy(id = checkin_id)
	private WebElement checkin;
	
	@FindBy(id = checkout_id)
	private WebElement checkout;
	
	@FindBy(id = adultroom_id)
	private WebElement adultRoom;
	
	@FindBy(id = childroom_id)
	private WebElement childRoom;
	
	@FindBy(id = searchbtn)
	private WebElement searchElement;
	
	@FindBy(id = selectbtn_id)
	private WebElement select;
	
	@FindBy(id = countinue_id)
	private WebElement countinueBtn;
	
	public AdactinSearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void searchHotel() {
		FileReaderManager search = new FileReaderManager();
		selectVisibleText(location, search.getDataProperty("Location"));
		selectVisibleText(hotel, search.getDataProperty("Hotels"));
		selectVisibleText(roomType, search.getDataProperty("RoomType"));
		selectVisibleText(noOfRooms, search.getDataProperty("Numberofrooms"));
		passValues(checkin, search.getDataProperty("Checkindate"));
		passValues(checkout, search.getDataProperty("Checkoutdate"));
		selectVisibleText(adultRoom, search.getDataProperty("Adultsperroom"));
		selectVisibleText(childRoom, search.getDataProperty("Childrenperroom"));
		clickElement(searchElement);
		clickElement(select);
		clickElement(countinueBtn);
	}
}