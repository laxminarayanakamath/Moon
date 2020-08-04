/**
 * @author:Avaneesha K
   @Company: Bixbytes Solutions
 */
package com.bixbytes.qa.cbooster.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bixbytes.qa.cbooster.base.Base_Main;
import com.bixbytes.qa.cbooster.pagesactions.DashBoard;
import com.bixbytes.qa.cbooster.pagesactions.SignInPage;

public class SignIn_Testcases extends Base_Main
{

	/* TestNG annotations are used in below test cases */
	SignInPage si;
	DashBoard db;
	
	SignIn_Testcases()
	{
		super();
		
	}
	
	@BeforeMethod
	public void setup()
	{
		browsersetups();
		si=new SignInPage();
		System.out.println("Hi");
	}
	
	@Test(priority=1)
	public void checktitle_action_case() throws InterruptedException
	{
		Thread.sleep(1000);
		String title=si.checktitle_action();
		AssertJUnit.assertEquals(title, "CBooster PM Tool");
	}
	
	@Test(priority=2)
	public void login_case() throws InterruptedException
	{
		Thread.sleep(1000);
		String un=System.getProperty("username");
		String pawd=System.getProperty("password");
		db=si.login_action("usha.karanth@bixbytessolutions.com", "Aa12345678!");
		
	}
	
	@AfterMethod
	public void exitbrowser()
	{
		dr.quit();
	}
	
}
