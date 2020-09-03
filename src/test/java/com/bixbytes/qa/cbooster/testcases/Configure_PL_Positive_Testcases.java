/**
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
import com.bixbytes.qa.cbooster.pagesactions.ConfigPage_ProductLevel;
import com.bixbytes.qa.cbooster.pagesactions.ConfigPage_ProductType;
import com.bixbytes.qa.cbooster.pagesactions.SignInPage;
import com.bixbytes.qa.cbooster.utilities.TestDataReader;

public class Configure_PL_Positive_Testcases extends Base_Main {

	/* TestNG annotations are used in below test cases */
	SignInPage signinpage;
	ConfigPage_ProductLevel configpage;
	GeneralAdminLogin generaladminlogin;
	TestDataReader dataReader;
	String[][] getData = null;

	/* Constructor which points to Base_Main() super class methods */
	public Configure_PL_Positive_Testcases() {
		super();

	}

	@BeforeMethod(alwaysRun = true)
	public void setup() throws InterruptedException {

		browsersetups();

		signinpage = new SignInPage(driver);
		configpage = new ConfigPage_ProductLevel(driver);
		dataReader = new TestDataReader();
		generaladminlogin = new GeneralAdminLogin();
		generaladminlogin.login();

	}

	@Test(priority = 1, groups = { "FunctionalPositive" })
	public void tc1_click_productlevel_btn() throws InterruptedException {
		configpage.click_validate_configurepage();
		Boolean isDisplayed = configpage.click_productlevel_btn();
		String actual = Boolean.toString(isDisplayed);
		Assert.assertEquals(actual, "true");
		logger.info("Clicked on Product Level  button and PL page displayed:" + actual);
	}

	@Test(priority = 2, groups = { "FunctionalPositive" })
	public void tc2_add_productlevel() throws IOException, InterruptedException, Error {
		configpage.click_validate_configurepage();
		configpage.click_productlevel_btn();

		getData = dataReader.getcelldata("AddProductLevel");
		configpage.add_productlevel(getData[1][0], getData[1][1], getData[1][2]);

	}

	@Test(priority = 3, dependsOnMethods = { "tc2_add_productlevel" }, groups = { "FunctionalPositive" })
	public void tc5_verify_addedProductlevel() throws InterruptedException, Error, IOException {
		configpage.click_validate_configurepage();
		configpage.click_productlevel_btn();
		String content = configpage.verify_productlevel_addedData();
		Assert.assertNotNull(content, "Data is not available");
		logger.info("Test case passed,verified product in the grid is:" + content);

	}

	@AfterMethod(alwaysRun = true)
	public void exitbrowser() {
		driver.close();
		driver.quit();
		logger.info("Clean up activity: Closed all browser instances..");
	}

}
