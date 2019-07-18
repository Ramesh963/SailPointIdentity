package com.sailpoint.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.BaseTest;

public class HomePage extends BaseTest{
	public HomePage(RemoteWebDriver driver1,ExtentTest test1) {
		this.driver=driver1;
		this.test=test1;
	}
	
	public HomePage clickOnApplications() {
		clickByXpath(prob.getProperty("clickOnApplications"));
		return this;
		}
	public HomePage clickOnIdentites() {
		clickByXpath("(//*[@class='dropdown-toggle'])[2]");
		return this;
	}
	public IdentityWareHouse clickOnIdentityWareHouse() {
		clickByXpath("//*[@role='menuitem' and contains(text(),'Identity Warehouse')]");
		return new IdentityWareHouse(driver, test);
	}
	

}
