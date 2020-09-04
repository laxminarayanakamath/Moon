/*
 * @author:Avaneesha K
   @Company: Bixbytes Solutions
 */
package com.bixbytes.qa.cbooster.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bixbytes.qa.cbooster.base.Base_Main;
import com.bixbytes.qa.cbooster.commonmethods.GeneralAdminLogin;
import com.bixbytes.qa.cbooster.pagesactions.ConfigPage_Currency;
import com.bixbytes.qa.cbooster.pagesactions.ConfigPage_ProductLevel;
import com.bixbytes.qa.cbooster.pagesactions.SignInPage;
import com.bixbytes.qa.cbooster.utilities.TestDataReader;

public class Configure_Currency_Positive_Testcases extends Base_Main {

	/* TestNG annotations are used in below test cases */
	SignInPage signinpage;
	ConfigPage_Currency configpage;
	GeneralAdminLogin generaladminlogin;
	TestDataReader dataReader;
	String[][] getData = null;

	/* Constructor which points to Base_Main() super class methods */
	public Configure_Currency_Positive_Testcases() {
		super();

	}

	@BeforeMethod(alwaysRun = true)
	public void setup() throws InterruptedException {

		browsersetups();

		signinpage = new SignInPage(driver);
		configpage = new ConfigPage_Currency(driver);
		dataReader = new TestDataReader();
		generaladminlogin = new GeneralAdminLogin();
		generaladminlogin.login();

	}
	
	@Test(priority = 1, groups = { "FunctionalPositive" })
	public void tc1_click_currency_btn() throws InterruptedException {
		configpage.click_validate_configurepage();
		Boolean isDisplayed = configpage.click_currency_btn();
		String actual = Boolean.toString(isDisplayed);
		Assert.assertEquals(actual, "true");
		logger.info("Clicked on Currency  button and Currency Add page displayed:" + actual);
	}

	@Test(priority = 2, groups = { "FunctionalPositive" })
	public void tc2_add_currency() throws IOException, InterruptedException, Error {
		configpage.click_validate_configurepage();
		configpage.click_currency_btn();

		getData = dataReader.getcelldata("AddCurrency");
		configpage.add_new_currency(getData[1][0], getData[1][1], getData[1][2]);

	}
	
	@Test(priority = 3, dependsOnMethods = { "tc2_add_currency" }, groups = { "FunctionalPositive" })
	public void tc3_verify_addedCurrency() throws InterruptedException, Error, IOException {
		configpage.click_validate_configurepage();
		configpage.click_currency_btn();
		String content = configpage.verify_currency_addedData();
		Assert.assertNotNull(content, "Data is not available");
		logger.info("Test case passed,verified Currency in the grid is:" + content);

	}
	
	@AfterMethod(alwaysRun = true)
	public void exitbrowser() {
		driver.close();
		driver.quit();
		logger.info("Clean up activity: Closed all browser instances..");
	}
}
