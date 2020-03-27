package com.zoho.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(id="userName") private WebElement unTB;
	public void setUsername(String un)
	{
		unTB.sendKeys(un);
	}
	
	@FindBy(id="passWord") private WebElement pwTB;
	public void setPassword(String pwd)
	{
		pwTB.sendKeys(pwd);
	}
	
	
	@FindBy(xpath="//input[@title='Sign In']") private WebElement signInBtn;
	public void clickSignInBtn()
	{
		signInBtn.click();
	}
	
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
}
