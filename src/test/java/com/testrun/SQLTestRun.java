package com.testrun;

import java.sql.SQLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.JdbcConnector;

public class SQLTestRun {

	public static void facebookPage() throws SQLException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		String fname = JdbcConnector.getParticularData();
		driver.findElement(By.id("email")).sendKeys(fname);
	}

	public static void youtubePage() throws SQLException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.youtube.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		@SuppressWarnings("unused")
		String fname = JdbcConnector.getParticularData();
		driver.findElement(By.name("search_query"));
	}
	
	public static void main(String[] args) throws SQLException {
//		facebookPage();
		youtubePage();
	}
}