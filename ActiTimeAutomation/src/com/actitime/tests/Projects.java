package com.actitime.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.actitime.base.BaseClass;

public class Projects extends BaseClass{

	
	@Test
	public static void sampletest()
	{
		System.out.println("THis is Sample test case using xml");	
	}
	
	@BeforeTest(alwaysRun = true)
	public static void beoreTest()
	{
		System.out.println("This method runs before every Test of the suite");
	}
	
	@AfterTest(alwaysRun = true)
	public static void afterTest()
	{
		System.out.println("This method runs after every Test of the suite");
	}
	
	@BeforeSuite(alwaysRun = true)
	public static void beforeSuite()
	{
		System.out.println("This method is the first method to run");
	}
	
	@AfterSuite(alwaysRun = true)
	public static void afterSuite()
	{
		System.out.println("This method runs after the entire suite");
	}
	
	@BeforeClass(alwaysRun = true)
	public static void beforeClass()
	{
		System.out.println("This method runs before each class");
	}
	
	@AfterClass(alwaysRun = true)
	public static void afterClass()
	{
		System.out.println("This method runs after each class");
	}
	

	
}
