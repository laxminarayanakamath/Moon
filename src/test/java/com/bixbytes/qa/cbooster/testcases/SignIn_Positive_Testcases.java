/**
 * @author:Avaneesha K
   @Company: Bixbytes Solutions
 */
package com.bixbytes.qa.cbooster.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bixbytes.qa.cbooster.base.Base_Main;
import com.bixbytes.qa.cbooster.pagesactions.DashBoard;
import com.bixbytes.qa.cbooster.pagesactions.SignInPage;

public class SignIn_Positive_Testcases extends Base_Main {

	/* TestNG annotations are used in below test cases */
	SignInPage signinpage;

	/* Constructor which points to Base_Main() super class methods */
	public SignIn_Positive_Testcases() {
		super();

	}

	@BeforeMethod(alwaysRun = true)
	public void setup() {

		browsersetups();
		signinpage = new SignInPage(driver);

	}

	@Test(priority = 1, groups = { "SmokeTest" })
	public void tc1_signin_checktitle_action_case() throws InterruptedException {
		logger.info("Smoke Test");
		String title = signinpage.checktitle_action();
		Assert.assertEquals(title, "CBooster PM Tool");
		logger.info("Checking LoginPage Title Completed:" + title);

	}

	@Test(priority = 2, groups = { "FunctionalPositive" })
	public void tc2_sign_case_valid() throws InterruptedException {
		logger.info("Functional Test");
		String un = prop.getProperty("username");
		String pawd = prop.getProperty("password");
		signinpage.login_action(un, pawd);
		logger.info("Clicked on Login Button");

	}

	@Test(priority = 3, groups = { "FunctionalPositive" })
	public void tc3_checktitle_afterlogin_case() throws InterruptedException {
		logger.info("Functional Test");
		String uname = prop.getProperty("username");
		String pwd = prop.getProperty("password");

		signinpage.login_action(uname, pwd);
		logger.info("Successfully logged in...");
		Boolean text_displayed = signinpage.check_title_action_dashboard();
		String actual = Boolean.toString(text_displayed);
		Assert.assertEquals(actual, "true");
		logger.info("Checking Dashboard page title after Login:" + actual);
	}

	@AfterMethod(alwaysRun = true)
	public void exitbrowser() {
		driver.close();
		driver.quit();
		logger.info("Clean up activity: Closed all browser instances..");
	}

}
