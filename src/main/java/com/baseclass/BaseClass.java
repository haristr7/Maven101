package com.baseclass;

import java.io.File;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseClass {

	public static WebDriver driver;

	protected static WebDriver launchBrowser(String browsername) {
		try {
			if (browsername.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			} else if (browsername.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			} else if (browsername.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			}

		} catch (Exception e) {
			Assert.fail("Error: Occur During Browser Opening!");
		}
		driver.manage().window().maximize();
		return driver;
	}

	protected static WebDriver launchUrl(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			Assert.fail("Error: Occur During Opening The Url!");
		}
		return driver;
	}
	
	protected static void terminateBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			Assert.fail("Error: Occur During Quit The Browser!");
		}
		
		
	}

	protected static void passValues(WebElement element, String value) {
		try {
			element.sendKeys(value);
		} catch (Exception e) {
			Assert.fail("Error: Occur During Passing The Values To Browser!");
		}
	}

	protected static void clickElement(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			Assert.fail("Error: Occur During Clicking The Element!");
		}
	}

	protected static Select dropDownObject(WebElement element) {
		Select select = new Select(element);
		return select;
	}

	protected static void selectVisibleText(WebElement element, String text) {
		try {
			dropDownObject(element).selectByVisibleText(text);
		} catch (Exception e) {
			Assert.fail("Error: Occur During Select By Visible Text!");
		}
	}

	protected static void selectByValue(WebElement element, String value) {
		try {
			dropDownObject(element).selectByValue(value);
		} catch (Exception e) {
			Assert.fail("Error: Occur During Select By Value!");
		}
	}

	protected static JavascriptExecutor javaScriptMedthod(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor;
	}

	protected static void scrollDown() {

		try {
			javaScriptMedthod(driver).executeScript("window.scrollBy(0, 1000);");
		} catch (Exception e) {
			Assert.fail("Error: Occur During Scroll Down!");
		}
	}

	protected static void screenShot() {
		TakesScreenshot ts = (TakesScreenshot) driver;
		try {
			File source = ts.getScreenshotAs(OutputType.FILE);
			File destination = new File("D:\\MavenProject\\Screenshots\\image.png");
			FileHandler.copy(source, destination);
		} catch (Exception e) {
			Assert.fail("Error: Occur During Taking ScreenShot");
		}
	}

	protected static void implictWait(int seconds) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
		} catch (Exception e) {
			Assert.fail("Error: Occur During Implict Wait");
		}
	}
	protected static void explicitWait(WebElement element, int seconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.invisibilityOf(element));
		} catch (Exception e) {
			Assert.fail("Error: Occur During Explict Wait");
		}
	}

	private static void jseElementClick(WebElement element) {
		try {
			javaScriptMedthod(driver).executeScript("arguments[0].click();",element);
		} catch (Exception e) {
			Assert.fail("Error: Occur During JSE Click!");
		}
	}
}