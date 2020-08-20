/**
 * 
 */
package com.bixbytes.qa.cbooster.testcases;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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

	SignInPage signinpage;
	Forgotpassword forgotpassword;
	WebDriverWait wbwait;
	
	public ForgotPassword_Positive_Testcases()
	{
		super();
	}
	
	@BeforeMethod(alwaysRun=true)
	public void setup()
	{
		browsersetups();
		signinpage = new SignInPage(driver);
		forgotpassword=new Forgotpassword(driver);
	}
	
	@Test(priority=1,groups= {"FunctionalPositive1"})
	public void forgorpassword_displayed_check_case() throws InterruptedException 
	{
		String actual=Boolean.toString(forgotpassword.case_forgorpassword_displayed());
		Assert.assertEquals(actual, "true");
	}
	
	@Test(priority=2,groups= {"FunctionalPositive1"})
	public void validate_forgorpwd_page_case() throws InterruptedException
	{
		String page_text_displayed=forgotpassword.case_validate_forgorpwd_page();
		Assert.assertEquals(page_text_displayed, "ENTER YOUR REGISTERED EMAIL");
	}
	
	@Test(priority=3,groups= {"FunctionalPositive1"})
	public void forgot_password_submit_valid_case() throws InterruptedException
	{
		String email_address=prop.getProperty("username");
		forgotpassword.forgorpassword_submit(email_address);
	}
	
	
	
	
	@AfterMethod(alwaysRun=true)
	public void exitbrowser()
	{
		driver.close();
		driver.quit();
		logger.info("Clean up activity: Closed all browser instances..");
	}
}
