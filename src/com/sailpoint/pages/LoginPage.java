package com.sailpoint.pages;



import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.BaseTest;

public class LoginPage extends BaseTest {
	public LoginPage(RemoteWebDriver driver1,ExtentTest test1) {
		this.driver=driver1;
		this.test=test1;
	}
	
public LoginPage enterUserName() {
	EnterDataByXpath(prob.getProperty("enterUserName"),prob.getProperty("userName"));
	return this;
}
public LoginPage enterPassword() {
	EnterDataByXpath(prob.getProperty("enterPassword"), prob.getProperty("passWord"));
	return this;
}
public HomePage clickTheLoginButton() {
	clickByXpath(prob.getProperty("clickTheLoginButton"));
	return new HomePage(driver, test);
}

}
