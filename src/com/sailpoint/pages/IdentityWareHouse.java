package com.sailpoint.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.BaseTest;

public class IdentityWareHouse extends BaseTest{
	
	public IdentityWareHouse(RemoteWebDriver driver1,ExtentTest test1) {
		this.driver=driver1;
		this.test=test1;
	}

	
	public IdentityWareHouse enterTheUserName(String data) {
		EnterDataByXpath("//*[contains(@id,'searchfield') and @placeholder='Filter by Identity Name']", data);
		return this;
	}
	public IdentityWareHouse clickTheSearchIcon() {
		
		clickByXpath("//*[@class='x-trigger-index-1 x-form-trigger x-form-search-trigger x-form-trigger-last x-unselectable']");
//x-trigger-index-1 x-form-trigger x-form-search-trigger x-form-trigger-last x-unselectable
		return this;
	}
	public AttributesPage clickOnUserName(String data) {
		
		WebElement togetrow=driver.findElementByXPath("//table[@class='x-grid-table x-grid-table-resizer']/tbody");
		java.util.List<WebElement> totalrow= togetrow.findElements(By.tagName("tr"));
		int count=totalrow.size();
		//System.out.println(count);
		int count2=0;
		for(int i=1;i<=count-1;i++) {
			
			String name=driver.findElementByXPath("(//*[@class=' x-grid-cell x-grid-cell-gridcolumn-1019   x-grid-cell-first'])["+i+"]").getText();
		
		//System.out.println(name);
	
		if(name.equalsIgnoreCase(data)) {
		try {
			clickByXpath("(//*[@class=' x-grid-cell x-grid-cell-gridcolumn-1019   x-grid-cell-first'])["+i+"]");
			break;
		} catch (NoSuchElementException e) {
			System.out.println("no such element found");
		}
		System.out.println("user clicked succesfulyy");
		} 
		else {
			count2=count2+1;
			if(count2==count-1) {
			logStatus("fail", "User not found in sailpoint", true);
			System.out.println("User not found");
		}
		}
		}
		return new AttributesPage(driver, test);
	}
}
