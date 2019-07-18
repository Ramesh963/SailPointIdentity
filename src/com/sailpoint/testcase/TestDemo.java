package com.sailpoint.testcase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestDemo {
	/*
	 * static Date date=new Date(); static SimpleDateFormat formatter = new
	 * SimpleDateFormat("dd MM yyyy hh:mm:ss"); static String strDate=
	 * formatter.format(date); public static void main(String[] args) {
	 * 
	 * System.out.println(strDate);
	 * 
	 * }
	 */
@Test
	public void handle() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://google.com");
		try {
			driver.findElementByXPath("//*[@name='btn']").click();
		} catch (NoSuchElementException exception) {
			System.out.println("no such element");
		}
		
	}
}
