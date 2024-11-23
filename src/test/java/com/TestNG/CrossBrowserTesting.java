package com.TestNG;

import org.testng.annotations.Test;

import com.baseclass.BaseClass;

public class CrossBrowserTesting extends BaseClass{
	
	@Test(priority = 2)
	private void edgeBrowser() {
		launchBrowser("edge");
		launchUrl("https://www.google.com");
		System.out.println("Browser ID: "+ Thread.currentThread().getId());
		terminateBrowser();
	}
	
	@Test(priority = 3)
	private void chromeBrowser() {
		launchBrowser("chrome");
		launchUrl("https://www.google.com");
		System.out.println("Browser ID: "+ Thread.currentThread().getId());
		terminateBrowser();
	}
	
	@Test(priority = 1)
	private void firefoxBrowser() {
		launchBrowser("firefox");
		launchUrl("https://www.google.com");
		System.out.println("Browser ID: "+ Thread.currentThread().getId());
		terminateBrowser();
	}
}