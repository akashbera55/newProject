package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass 
{
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Username is provided");
		lp.setPassword(password);
		logger.info("Password is provided");
		lp.clickSubmit();
		
		//Thread.sleep(4000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();
		logger.info("Customer details....");
		addcust.custName("Akash");
		addcust.custgender("male");
		addcust.custdob("01", "23", "99");
		Thread.sleep(3000);
		addcust.custaddress("India");
		addcust.custcity("Bangalore");
		addcust.custstate("London");
		addcust.custpinno(216264);
		addcust.custtelephoneno(2526272);
		String email=randomstring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword(randomnumstring());
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		logger.info("Validation started...");
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("Testcase passed");
		}
		else
		{
			captureScreen(driver, "addnewcust");
			Assert.assertTrue(false);
		}
	}

}
