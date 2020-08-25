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
		logger.info("Checking LoginPage Title Completed:"+title);
	}

	@Test(priority = 2, groups = { "FunctionalNegative" })
	public void tc2_signin_case_invalid_unpwd() throws InterruptedException {
		logger.info("Functional Test");
		String un = prop.getProperty("invalid_username");
		String pawd = prop.getProperty("invalid_password");
		signinpage.login_action(un, pawd);

		Boolean check_alert = signinpage.check_ivalidlogin_alert();

		String check_alert_value = Boolean.toString(check_alert);
		Assert.assertEquals(check_alert_value, "true");
		logger.info("Checking the alert for invalid username and passwords:"+check_alert_value);
	}

	@AfterMethod(alwaysRun = true)

	public void exitbrowser() {
		driver.close();
		driver.quit();
		logger.info("Clean up activity: Closed all browser instances..");
	}

}
