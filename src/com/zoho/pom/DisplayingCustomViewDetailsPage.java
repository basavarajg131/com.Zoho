package com.zoho.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;

public class DisplayingCustomViewDetailsPage {

	@FindBy(xpath="//input[@value='New Campaign']") 
	private WebElement newCampaignBtn;
	
	public WebElement newCampaignBtn()
	{
		return newCampaignBtn;
		
	}
	
	@FindBy(xpath="(//td[@class='tableData']/..)[1]/td[3]")
	private WebElement campaignNameInCampList;
	public WebElement campaignNameInCampList()
	{
		return campaignNameInCampList;
		
	}
	
	
	public DisplayingCustomViewDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
