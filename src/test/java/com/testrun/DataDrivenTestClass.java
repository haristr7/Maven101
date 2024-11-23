package com.testrun;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.utility.ReadExcelData;

public class DataDrivenTestClass {

	public static void main(String[] args) throws InvalidFormatException, IOException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		String username = ReadExcelData.readParticularData("sheet1", 1, 1);
		String password = ReadExcelData.readParticularData("Sheet1", 1, 2);
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.name("pass")).sendKeys(password);
	}
}