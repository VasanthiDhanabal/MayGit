package com.actitime.tests;

import com.actitime.base.BaseClass;

public class TestRunner extends BaseClass{

	public static void main(String[] args)  {
		
		try {
			Login.login_001();
		} catch (Exception e) {			
			e.printStackTrace();
		}
		try {
			Login.login_002();
		} catch (Exception e) {
			e.printStackTrace();
		}
				

	}

}

