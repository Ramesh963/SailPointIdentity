package com.sailpoint.pages;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.impl.AttributeGroupRefImpl;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import freemarker.core.ReturnInstruction.Return;
import utilsFiles.WriteDataForApp;
import wrappers.BaseTest;

public class AttributesPage extends BaseTest{
	public AttributesPage(RemoteWebDriver driver1,ExtentTest test1) {
		this.driver=driver1;
		this.test=test1;
	}
	
	public AttributesPage verifyTheFirstName(String text) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String actual=driver.findElementByXPath("//*[@id=\"editForm:attributeContentA4J\"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/span").getText();

		if(text.equalsIgnoreCase(actual)) {
			try {
				utilsFiles.WriteData1.WriteExcel("Pass",text);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			logStatus("pass", "Fistname is "+" '"+actual+"' "+"matching successfull", true);
		}else {
			try {
				utilsFiles.WriteData1.WriteExcel("Fail",text);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			logStatus("fail", "Fistname is "+" '"+actual+"' "+"not matching", true);
		}
		return this;
	}
	public AttributesPage verifyTheLastName(String text) {
		String actual=driver.findElementByXPath("//*[@id=\"editForm:attributeContentA4J\"]/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/span").getText();
		if(text.equalsIgnoreCase(actual)) {
			try {
				utilsFiles.WriteData1.WriteExcel("Pass",text);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			logStatus("pass", "Lastname is "+" '"+actual+"' "+"matching successfull", false);
		}else {
			try {
				utilsFiles.WriteData1.WriteExcel("Fail",text);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			logStatus("fail", "Lastname is "+" '"+actual+"' "+"not matching", false);
		}
		return this;
	}
	public AttributesPage verifyTheEmployeeID(String text) {
		String actual=driver.findElementByXPath("//*[@id=\"editForm:attributeContentA4J\"]/table/tbody/tr/td/table/tbody/tr[7]/td[2]/span").getText();
		if(text.equalsIgnoreCase(actual)) {
			try {
				utilsFiles.WriteData1.WriteExcel("Pass",text);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			logStatus("pass", "Employee ID is "+" '"+actual+"' "+"matching successfull", false);
		}else {
			try {
				utilsFiles.WriteData1.WriteExcel("Fail",text);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			logStatus("fail", "Employee ID is "+" '"+actual+"' "+"not matching", false);
		}
		return this;
	}  
	public AttributesPage verifyTheEISource(String text) {
		String actual=driver.findElementByXPath("//*[@id=\"editForm:attributeContentA4J\"]/table/tbody/tr/td/table/tbody/tr[16]/td[2]/span").getText();
		if(text.equalsIgnoreCase(actual)) {
			try {
				utilsFiles.WriteData1.WriteExcel("Pass",text);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			logStatus("pass", "EI source is "+" '"+actual+"' "+"matching successfull", false);
		}else {
			try {
				utilsFiles.WriteData1.WriteExcel("Fail",text);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			logStatus("fail", "EI source is "+" '"+actual+"' "+"not matching", false);
		}
		return this;
	}
	public AttributesPage clickOnApplicationAccount() {
		clickByXpath("//*[@id='tab-1027-btnInnerEl']");
		return this;
	}
	
	public AttributesPage getListOfApplication(String username) throws IOException {
		String attribute="";
		WebElement togetrow=driver.findElementByXPath("//table[@id='appAcctTbl']/tbody");
		java.util.List<WebElement> totalrow= togetrow.findElements(By.tagName("tr"));
		int count=totalrow.size();
		System.out.println(count);
		for(int i=1;i<=count/2-1;i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			attribute=attribute+driver.findElementByXPath("(//*[@class='identityLinkListApplicationColumn'])["+i+"]").getText()+",";
			
			
	}
		System.out.println(attribute);
		logStatus("pass", "List of Application having this user :"+attribute, false);
		WriteDataForApp.writedata(attribute, username, 4);
		return this;
	}
	public AttributesPage getAttributes(String username) throws IOException {
		WebElement togetrow=driver.findElementByXPath("//table[@id='appAcctTbl']/tbody");
		java.util.List<WebElement> totalrow= togetrow.findElements(By.tagName("tr"));
		int count=totalrow.size();
		//System.out.println(count);
		String atrribute = null;
		String value = null;
		String attributes="";
		for(int i=1;i<=count/2-1;i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElementByXPath("(//*[@title='Click to view the application account details.'])["+i+"]").click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
			WebElement togetrowatrri=driver.findElementByXPath("//*[@class='detailsPanelContent']");
			java.util.List<WebElement> totalrowattri= togetrowatrri.findElements(By.xpath("//*[@style='padding: 2px; padding-right: 5px']"));
			int atrricount=totalrowattri.size();
			System.out.println(atrricount);
			for(int j=1;j<=atrricount;j++) {
			 atrribute=driver.findElementByXPath("(//*[@style='padding: 2px; padding-right: 5px'])["+j+"]").getText();
			 value=driver.findElementByXPath("(//*[@style='padding: 2px'])["+j+"]").getText();
			 attributes=attributes+atrribute+":"+value+",";
			 System.out.println(atrribute +"::"+value);
			// WriteDataForApp.writedata(atrribute +"::"+value, username, j+4);
			 	logStatus("pass", "atrributes of : "+atrribute+"=="+value, false);
			 
			}
			
		
		
		return this;
	}

	
	
}
