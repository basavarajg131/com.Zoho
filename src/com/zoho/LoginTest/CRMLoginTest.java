package com.zoho.LoginTest;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.zoho.genericLib.BaseTest;
import com.zoho.genericLib.FileLib;
import com.zoho.genericLib.WebDriverCommonLib;
import com.zoho.pom.CampaignsDetailsPage;
import com.zoho.pom.CreateCampaignPage;
import com.zoho.pom.DisplayingCustomViewDetailsPage;
import com.zoho.pom.HomePage;

@Listeners(com.zoho.genericLib.MyListener.class)
public class CRMLoginTest extends BaseTest{
	WebDriverCommonLib wlib;
	FileLib flib;
	HomePage hp;
	DisplayingCustomViewDetailsPage dcp;
	CreateCampaignPage ccp;
	CampaignsDetailsPage cdp;
	
	@Test
	public void verifyCRMValidLoginTest() throws Throwable
	{
		wlib=new WebDriverCommonLib();
		flib=new FileLib();
		dcp=new DisplayingCustomViewDetailsPage(driver);
		ccp=new CreateCampaignPage(driver);
		cdp=new CampaignsDetailsPage(driver);
		
		wlib.verifyTitle(flib.getKeyPropertyValue(PROP_PATH, "LoginTitle"));
		loginToApp();
		wlib.verifyTitle(flib.getKeyPropertyValue(PROP_PATH, "HomePageTitle"));
	
		hp=new HomePage(driver);
		if(hp.campaignTab().isDisplayed())
		{
			Reporter.log("Campaign Tab is displayed",true);
			hp.campaignTab().click();
		}
		else
		{
			Reporter.log("Campaign Tab is not displayed",true);
		}
	
	
	
		dcp.newCampaignBtn().click();
		ccp.campaignNameTB().sendKeys(flib.getExcelData(EXCEL_PATH, "CreateCampaign", 1, 0));
		
		ccp.saveBtn().click();
		
		String actualCampName = cdp.campaignName().getText();
		wlib.verify("Campaign Name ",actualCampName, flib.getExcelData(EXCEL_PATH, "CreateCampaign", 1, 0));
	
		hp.campaignTab().click();
		
		String actCampNameText = dcp.campaignNameInCampList().getText();
		wlib.verify("Actual Camp Name Text", actCampNameText, flib.getExcelData(EXCEL_PATH, "CreateCampaign", 1, 0));
	}
	
	
	
	
}
