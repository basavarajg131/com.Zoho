package com.zoho.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsDetailsPage {

	@FindBy(id="value_Campaign Name")
	private WebElement campaignName;
	public WebElement campaignName()
	{
		return campaignName;
		
	}
	
	public CampaignsDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
