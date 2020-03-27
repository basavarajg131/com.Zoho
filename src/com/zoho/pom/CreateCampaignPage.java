package com.zoho.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {

	@FindBy(xpath="//input[@name='property(Campaign Name)']")
	private WebElement campaignNameTB;
	public WebElement campaignNameTB()
	{
		return campaignNameTB;
		
	}
	
	@FindBy(xpath="(//input[@value='Save'])[1]")
	private WebElement saveBtn;
	public WebElement saveBtn()
	{
		return saveBtn;
		
	}
	public CreateCampaignPage(WebDriver driver)
	
		{
			PageFactory.initElements(driver, this);
		}
	
}
