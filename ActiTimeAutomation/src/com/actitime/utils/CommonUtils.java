package com.actitime.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.By;

import com.actitime.base.BaseClass;

public class CommonUtils extends BaseClass {

	public static void main(String args[]) throws IOException
	{
		writeResultsToFile("login_001","Pass");
		writeResultsToFile("login_002","Pass");
	}
	
	public static boolean logintoActiTimeApplicationExcel() throws Exception
	{
		boolean logoutDisplayed = false;
		//WebElement userName = driver.findElement(By.xpath("//input[@id='username'])"));
		//userName.sendKeys("admin");
		driver.findElement(By.xpath((getLocatorData("login","UserName_EditBox")))).sendKeys("admin");
		driver.findElement(By.xpath((getLocatorData("login","Password_EditBox")))).sendKeys("manager");
		
		//driver.findElement(By.xpath("//input[@id='keepLoggedInCheckBox']")).click();
		
		driver.findElement(By.xpath((getLocatorData("login","Login Button")))).click();
		
		try
		{
		logoutDisplayed = driver.findElement(By.xpath((getLocatorData("Home","Logout_Link")))).isDisplayed();
		}
		catch(Exception e)
		{
			e.printStackTrace();	
			}

		return logoutDisplayed;
		//driver.close();
			
}
	
	public static void writeResultsToFile(String testCaseName,String status) throws IOException
	{
		File f = new File("./results/results.txt");
		
		FileWriter fw = new FileWriter(f,true);
		
		fw.write(testCaseName+"-------"+status+"\n");
		fw.flush();
		fw.close();
		
	}
	
	public static void writeResultsToFile(String str) throws IOException
	{
File f = new File("./results/results.txt");
		
		FileWriter fw = new FileWriter(f,true);
		fw.write(str+"\n");
		fw.flush();
		fw.close();
		
	}
}
