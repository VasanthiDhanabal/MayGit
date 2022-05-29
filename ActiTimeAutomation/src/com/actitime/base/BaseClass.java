package com.actitime.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	public static String url = "";
	 protected static WebDriver driver = null;
	
	public static String getDataFromPropertiesFile(String key) throws IOException
	{
		String value;
		
		File f = new File("./data/configdata.properties");
		
		FileInputStream fis = new FileInputStream(f);
		
		Properties p = new Properties();
		
		p.load(fis);
		value = p.getProperty(key);
		
		return value;
	}
	
	public static String getLocatorData(String pageName,String elementName) throws Exception
	{
		String locator="";
		
		File f = new File("./data/locator.xlsx");
		
		FileInputStream fis = new FileInputStream(f);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet ws = wb.getSheet("Sheet1");
		
		int rows = ws.getLastRowNum();
		
		System.out.println(rows);
		
		for(int i=1;i<=rows;i++)
		{
		String pagenam = ws.getRow(i).getCell(0).getStringCellValue();	
			
		String elenam = ws.getRow(i).getCell(1).getStringCellValue();	
		
		if(pagenam.equalsIgnoreCase(pageName) && (elenam.equalsIgnoreCase(elementName)))
		{
			locator = ws.getRow(i).getCell(2).getStringCellValue();
		}
		}
		wb.close();
		
			return locator;	
	}
	public static String getTestData(String pageName,String elementName) throws Exception
	{
		String locator="";
		
		File f = new File("./data/testdata.xlsx");
		
		FileInputStream fis = new FileInputStream(f);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet ws = wb.getSheet("Sheet1");
		
		int rows = ws.getLastRowNum();
		
		System.out.println(rows);
		
		for(int i=1;i<=rows;i++)
		{
		String pagenam = ws.getRow(i).getCell(0).getStringCellValue();	
			
		String elenam = ws.getRow(i).getCell(1).getStringCellValue();	
		
		if(pagenam.equalsIgnoreCase(pageName) && (elenam.equalsIgnoreCase(elementName)))
		{
			locator = ws.getRow(i).getCell(2).getStringCellValue();
		}
		}
		wb.close();
		
			return locator;	
	}
	
	public static void launchActiTimeApplication1(String url) throws IOException
	{
		
			url = getDataFromPropertiesFile("url");
		
		String browser=getDataFromPropertiesFile("browser");
		
		System.out.println("Your Browser is="+browser);
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","./Utilities/chromedriver.exe");
			//System.setProperty("webdriver.chrome.driver","./Utilities/chromedriver.exe");
			driver=new ChromeDriver();
		}
	
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","./Utilities/geckodriver.exe");
			driver=new FirefoxDriver();
		}
			
			
		String time=getDataFromPropertiesFile("timeout");
		int timeout=Integer.parseInt(time);
		System.out.println("Wait for seconds="+timeout);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
		
		driver.get(url);
		
		driver.manage().window().maximize();	
		
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
	
	public static void writeResultsToLogs(String str) throws IOException
	{
File f = new File("./results/logs.txt");
		
		FileWriter fw = new FileWriter(f,true);
		fw.write(str+"\n");
		fw.flush();
		fw.close();
		
	}
	

	
}
