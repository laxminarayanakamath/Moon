/**
 * @author:Avaneesha K
   @Company: Bixbytes Solutions
 */
package com.bixbytes.qa.cbooster.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bixbytes.qa.cbooster.base.Base_Main;
import com.bixbytes.qa.cbooster.commonmethods.GeneralAdminLogin;
import com.bixbytes.qa.cbooster.pagesactions.ConfigPage;
import com.bixbytes.qa.cbooster.pagesactions.SignInPage;

public class Configure_Positive_Testcases extends Base_Main {

	/* TestNG annotations are used in below test cases */
	SignInPage signinpage;
	ConfigPage configpage;
	GeneralAdminLogin generaladminlogin;

	/* Constructor which points to Base_Main() super class methods */
	public Configure_Positive_Testcases() {
		super();

	}

	@BeforeMethod(alwaysRun = true)
	public void setup() throws InterruptedException {

		browsersetups();

		signinpage = new SignInPage(driver);
		configpage = new ConfigPage(driver);
		generaladminlogin = new GeneralAdminLogin();
		generaladminlogin.login();

	}

	@Test(priority = 1, groups = { "SmokeTest" })
	public void tc1_validate_configpage() throws InterruptedException, Error {
		logger.info("Smoke Test");
		Boolean isDisplayed = configpage.click_validate_configurepage();
		String actual = Boolean.toString(isDisplayed);
		Assert.assertEquals(actual, "true");
		logger.info("Validating navigated page is Config Page Or not:" + actual);
	}

	@Test(priority = 2, groups = { "FunctionalPositive" })
	public void tc2_click_overview_btn() throws InterruptedException {
		configpage.click_validate_configurepage();
		configpage.click_overview_btn();
		logger.info("Clicked on Over view button");
	}

	@Test(priority = 3, groups = { "FunctionalPositive" })
	public void tc3_click_producttype_btn() throws InterruptedException {
		configpage.click_validate_configurepage();
		Boolean isDisplayed = configpage.click_producttype_btn();
		String actual = Boolean.toString(isDisplayed);
		Assert.assertEquals(actual, "true");
		logger.info("Clicked on Product Type button:" + actual);
	}

	@Test(priority = 4, groups = { "FunctionalPositive" })
	public void tc4_add_producttype() {

	}

	@AfterMethod(alwaysRun = true)
	public void exitbrowser() {
		driver.close();
		driver.quit();
		logger.info("Clean up activity: Closed all browser instances..");
	}

}
