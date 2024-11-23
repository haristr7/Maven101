package com.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;
import com.interfaceelements.AdactinApplicationElements;
import com.srcmainresorces.FileReaderManager;

public class AdactinLoginPage extends BaseClass implements AdactinApplicationElements{
	
	@FindBy(id = username_id)
	private WebElement username;
	
	@FindBy(name = user_pass)
	private WebElement password;
	
	@FindBy(xpath = login_xpath)
	private WebElement login;
	
   public AdactinLoginPage(WebDriver driver) {
	   PageFactory.initElements(driver, this);
	}

	public void validUserNameAndValidPassword() {
		FileReaderManager data = new FileReaderManager();
		passValues(username,data.getDataProperty("username"));
		passValues(password,data.getDataProperty("password"));
		clickElement(login);
	}
	
}