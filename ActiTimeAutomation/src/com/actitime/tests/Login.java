package com.actitime.tests;

import java.io.File;
import java.io.FileWriter;

//package com.actitime.package com.actitime.tests;

//package com.actitime.package com.actitime.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.actitime.base.BaseClass;
import com.actitime.utils.CommonUtils;
import com.google.common.io.Files;

public class Login extends BaseClass{

	@Test
	public static void login_001() throws Exception
	{
		boolean result = false;		


		writeResultsToLogs("Starting the Test Case Login_001");		
		launchActiTimeApplication1("url");

		writeResultsToLogs("Trying to login to the actitime application by calling login method..");		
		result = CommonUtils.logintoActiTimeApplicationExcel();

		// Checking the result to be equal to true
		Assert.assertTrue(result, "Could not login to ActiTime application..");	

		//Assert.assertFalse(result, "aadDWDAD"); // To check a condition to be false.

		int expectedCount = 10;
		int actualCount = 10;

		// Used for checking two values or strings for equality
		Assert.assertEquals(expectedCount, actualCount,"Both counts does not match");	

		writeResultsToFile("Login_001", "Pass");	

		//closeBrowser();
	}



	}

		


