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

 
public class SignIn_Positive_Testcases extends Base_Main {
	
	/* TestNG annotations are used in below test cases */
	SignInPage si;
	DashBoard db;
	
	/*Constructor which points to Base_Main() super class methods*/
public SignIn_Positive_Testcases()
	{
		super();
		
	}
	
	@BeforeMethod
	public void setup()
	{
	
		browsersetups();
		si=new SignInPage();
		
	}
	
	@Test(priority=1)
	public void checktitle_action_case() throws InterruptedException
	{
		Thread.sleep(1000);
		String title=si.checktitle_action();
		Assert.assertEquals(title, "CBooster PM Tool");
		// AssertJUnit.assertEquals(title, "CBooster PM Tool");
	}
	
	@Test(priority=2)
	public void login_case() throws InterruptedException
	{
		Thread.sleep(1000);
		String un=prop.getProperty("username");
		String pawd=prop.getProperty("password");
		
		db=si.login_action(un,pawd);
		
	}
	
	@AfterMethod
	public void exitbrowser()
	{
		dr.quit();
	}

}
