/**
 * 
 */
package com.bixbytes.qa.cbooster.testcases;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bixbytes.qa.cbooster.base.Base_Main;
import com.bixbytes.qa.cbooster.pagesactions.Forgotpassword;
import com.bixbytes.qa.cbooster.pagesactions.SignInPage;

/**
 * @author:Avaneesha K
   @Company: Bixbytes Solutions
 */
public class ForgotPassword_Positive_Testcases extends Base_Main
{

	SignInPage si;
	Forgotpassword fp;
	WebDriverWait wt;
	
	public ForgotPassword_Positive_Testcases()
	{
		super();
	}
	
	@BeforeMethod(alwaysRun=true)
	public void setup()
	{
		browsersetups();
		si = new SignInPage();
	}
	
/*	@Test(priority=1,groups= {"FunctionalPositive"})
	public void forgotpassword_click_case()
	{
		fp=new Forgotpassword();
		fp.click_check_forgorpassword();
		
	}
	*/
	
	
	
	@AfterMethod(alwaysRun=true)
	public void exitbrowser()
	{
		dr.close();
	}
}
