package com.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;
import com.interfaceelements.AdactinApplicationElements;
import com.srcmainresorces.FileReaderManager;

public class AdactinHotelBooking extends BaseClass implements AdactinApplicationElements{
	
	@FindBy(id = firstname_id)
	private WebElement firstName;
	
	@FindBy(id = lastname_id)
	private WebElement lastname;
	
	@FindBy(id = address_id)
	private WebElement address;
	
	@FindBy(id = creditno_id)
	private WebElement creditCardNum;
	
	@FindBy(id = credittype_id)
	private WebElement creditCardType;
	
	@FindBy(id = selectmonth_id)
	private WebElement selectMonth;
	
	@FindBy(id = selecetyear_id)
	private WebElement selectYear;
	
	@FindBy(id = ccvnumber)
	private WebElement ccvNumber;
	
	@FindBy(id = booknow_id)
	private WebElement bookNow;
	
	@FindBy(id = logout_xpath)
	private WebElement logout;
	
	public AdactinHotelBooking(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void hotelBook() {
		FileReaderManager bookHotel = new FileReaderManager();

		passValues(firstName,bookHotel.getDataProperty("Firstname"));
		passValues(lastname,bookHotel.getDataProperty("Lastname"));
		passValues(address,bookHotel.getDataProperty("BillingAddress"));
		passValues(creditCardNum,bookHotel.getDataProperty("Creditcard"));
		selectVisibleText(creditCardType, bookHotel.getDataProperty("Credittype"));
		selectVisibleText(selectMonth, bookHotel.getDataProperty("Expirymonth"));
		selectVisibleText(selectYear, bookHotel.getDataProperty("Expiryyear"));
		passValues(ccvNumber,bookHotel.getDataProperty("CCV"));
		clickElement(bookNow);
//		implictWait(20);
		explicitWait(bookNow, 10);
		scrollDown();
		screenShot();
//		clickElement(logout);s
		explicitWait(logout, 10);
	}
}