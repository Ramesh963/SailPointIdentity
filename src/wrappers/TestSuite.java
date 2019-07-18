package wrappers;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.sailpoint.pages.LoginPage;

import utilsFiles.ReadDataFromExcel;

public class TestSuite extends BaseTest {
@BeforeSuite
public void beforeSuite() {
	startReport();
	loadingObject();
}
@BeforeTest
public void beforeTest() {
	
	invokeApp("chrome", prob.getProperty("URL"));
	new LoginPage(driver, test).enterUserName().enterPassword().clickTheLoginButton();
}
@AfterTest
public void afterTest() {
	
	close();
}
@AfterSuite
public void afterSuite() {
	unloadObject();
	endReport();
}

@AfterMethod
public void afterMethod() {
	endTest();
}

	
	@DataProvider(name="fetchdata") public static Object[][] getDataFromExcel()
	  throws IOException{ 
		return ReadDataFromExcel.getData();
	  }
	 }
