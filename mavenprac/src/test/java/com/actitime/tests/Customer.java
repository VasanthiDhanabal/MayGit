package com.actitime.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.actitime.base.BaseClass;
import com.actitime.utils.CommonUtils;

public class Customer extends BaseClass{
	
	//@Test(groups = { "smoke", "customer","customer_001" })	
	public static void customer_001() throws Exception
	{
	
		boolean result = false;	
			 
		
		writeLogs("Trying to login to the actitime application by calling login method..");		
		result = CommonUtils.loginToActiTimeApplication();
			
		// Checking the result to be equal to true
		Assert.assertTrue(result, "Could not login to ActiTime application..");
					
		
	}

}
