package com.zoho.genericLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.zoho.pom.LoginPage;

public abstract class BaseTest implements AutoConsts {
	public static WebDriver driver;

	@BeforeClass
	public void openBrowser() throws Throwable {
		FileLib flib = new FileLib();
		String browser = flib.getKeyPropertyValue(PROP_PATH, "browser");
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty(CHROME_KEY, CHROME_VALUE);
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty(GECKO_KEY, GECKO_VALUE);
			driver = new FirefoxDriver();
		}

		driver.get(flib.getKeyPropertyValue(PROP_PATH, "url"));
	}
	
	@BeforeMethod
	public void loginToApp() throws Throwable {
		Thread.sleep(3000);
		FileLib flib=new FileLib();
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(flib.getKeyPropertyValue(PROP_PATH, "username"));
		lp.setPassword(flib.getKeyPropertyValue(PROP_PATH, "password"));
		lp.clickSignInBtn();
		Thread.sleep(3000);
	}

	@AfterMethod
	public void logoutFromApp() {

	}
	
	@AfterClass(enabled=false)
	public void closeBrowser() {
		driver.quit();
	}
}
