package com.actitime.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v100.page.Page.CaptureScreenshotFormat;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.actitime.base.BaseClass;
import com.actitime.utils.CommonUtils;

public class Login extends BaseClass{
	
		
	@Test
	public static void login_001() throws Exception
	{
		boolean result = false;			
	   		
		writeInfoLogs("Trying to login to the actitime application by calling login method..");		
		result = CommonUtils.loginToActiTimeApplication();		
		
		// Checking the result to be equal to true
		Assert.assertTrue(result, "Could not login to ActiTime application..");
			
			
		
	}
	
	@Test
	public static void login_002() throws Exception
	{
		boolean result = false;			
   		
		writeInfoLogs("Trying to login to the actitime application by calling login method..");		
		result = CommonUtils.loginToActiTimeApplication();		
		
		// Checking the result to be equal to true
		Assert.assertFalse(result, "Could not login to ActiTime application..");
			
		
	}

	//@Parameters({"username","password","personage"})
	//@Test
	public static void login_003(String username, String password,String personage) throws Exception
	{
	
		int age = Integer.parseInt(personage);
		
		boolean result = false;			
	   		
		writeInfoLogs("Trying to login to the actitime application by calling login method..");		
		result = CommonUtils.loginToActiTimeApplication(username,password);		
		
		// Checking the result to be equal to true
		Assert.assertTrue(result, "Could not login to ActiTime application..");		
			
		
	}
	
	//@Test(dataProvider = "logindata") // taking the dataprovider from the same class
	//@Test(dataProvider = "logindata",dataProviderClass = com.actitime.dataproviders.DataProviders.class)
	public static void login_004(String username, String password) throws Exception
	{
		
		boolean result = false;			
	   		
		writeInfoLogs("Trying to login to the actitime application by calling login method..");		
		result = CommonUtils.loginToActiTimeApplication(username,password);		
		
		// Checking the result to be equal to true
		Assert.assertTrue(result, "Could not login to ActiTime application..");		
			
		
	}
	
	/*
	
	@DataProvider(name = "logindata")
	public static Object[][] loginDataprovider()
	{
		Object[][] obj = new String[3][2];
		
		obj[0][0] = "admin";
		obj[0][1] = "manager";
		obj[1][0] = "admin";
		obj[1][1] = "manager";
		obj[2][0] = "admin";
		obj[2][1] = "manager";
		
		return obj;
	}
	
	
	*/
	
}
