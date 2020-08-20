/**
 * @author:Avaneesha K
   @Company: Bixbytes Solutions
 */

package com.bixbytes.qa.cbooster.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bixbytes.qa.cbooster.base.Base_Main;
import com.bixbytes.qa.cbooster.pagesactions.DashBoard;
import com.bixbytes.qa.cbooster.pagesactions.SignInPage;

public class SignIn_Negative_Cases extends Base_Main {

	/* TestNG annotations are used in below test cases */
	SignInPage signinpage;
	WebDriverWait wbwait;

	/* Constructor which points to Base_Main() super class methods */
	public SignIn_Negative_Cases() {
		super();

	}

	
	@BeforeMethod(alwaysRun=true)
	public void setup() {

		browsersetups();
		signinpage = new SignInPage(driver);

	}

	@Test(priority=1,groups= {"SmokeTest"})
	public void signin_checktitle_action_case() throws InterruptedException {
		Thread.sleep(1000);
		String title = signinpage.checktitle_action();
		Assert.assertEquals(title, "CBooster PM Tool");
		
	}

	@Test(priority = 2,groups= {"FunctionalNegative"})
	public void signin_case_invalid_unpwd() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String un = prop.getProperty("invalid_username");
		String pawd = prop.getProperty("invalid_password");
		DashBoard db=signinpage.login_action(un, pawd);

	}
	
	@Test(priority = 3,groups= {"FunctionalNegative"})
	public void signin_invalid_unpwd_checkalert() throws InterruptedException
	{
		
		Boolean check_alert = signinpage.check_ivalidlogin_alert();
		String check_alert_value=Boolean.toString(check_alert);
		Assert.assertEquals(check_alert_value, "true");
			

	}
	
	@Test(priority = 3,groups= {"FunctionalNegative"})
	public void signin_case_invalid_pwd() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String un = prop.getProperty("username");
		String pawd = prop.getProperty("invalid_password");
		signinpage.login_action(un, pawd);
	}

	@Test(priority = 4,groups= {"FunctionalNegative"})
	public void signin_invalid_pwd_checkalert() throws InterruptedException
	{
		Boolean check_alert = signinpage.check_ivalidlogin_alert();
		String check_alert_value=Boolean.toString(check_alert);
		Assert.assertEquals(check_alert_value, "true");

	}
	

	@AfterMethod(alwaysRun=true)

	public void exitbrowser() {
		driver.close();
		driver.quit();
		logger.info("Clean up activity: Closed all browser instances..");
	}

}
