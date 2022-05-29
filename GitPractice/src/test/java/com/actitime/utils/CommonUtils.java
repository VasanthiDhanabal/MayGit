package com.actitime.utils;

import java.io.IOException;

import org.openqa.selenium.By;

import com.actitime.base.BaseClass;

public class CommonUtils extends BaseClass{
	
	
	public static boolean loginToActiTimeApplication() throws IOException
	{
		boolean logoutDisaplyed = false;		
		
		driver.findElement(By.xpath(getLocatorDataFromMap("Login", "UserName_EditBox"))).sendKeys(getTestDataFromMap("Login", "UserName_EditBox"));
		driver.findElement(By.xpath(getLocatorDataFromMap("Login", "Password_EditBox"))).sendKeys(getTestDataFromMap("Login", "Password_EditBox"));		
		driver.findElement(By.xpath(getLocatorDataFromMap("Login", "Login_Button"))).click();
						
		try {
			logoutDisaplyed = driver.findElement(By.xpath(getLocatorDataFromMap("Home", "Logout_Link"))).isDisplayed();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return logoutDisaplyed;
		
	}
	
	
	public static boolean loginToActiTimeApplication(String userName, String password) throws IOException
	{
		boolean logoutDisaplyed = false;		
		
		driver.findElement(By.xpath(getLocatorData("Login", "UserName_EditBox"))).sendKeys(userName);
		driver.findElement(By.xpath(getLocatorData("Login", "Password_EditBox"))).sendKeys(password);		
		driver.findElement(By.xpath(getLocatorData("Login", "Login_Button"))).click();
						
		try {
			logoutDisaplyed = driver.findElement(By.xpath(getLocatorData("Home", "Logout_Link"))).isDisplayed();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return logoutDisaplyed;
		
	}
	
	

}
