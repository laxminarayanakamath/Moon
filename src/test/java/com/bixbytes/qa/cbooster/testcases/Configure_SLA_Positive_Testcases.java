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
import com.bixbytes.qa.cbooster.pagesactions.ConfigPage_ProductType;
import com.bixbytes.qa.cbooster.pagesactions.ConfigPage_SLA;
import com.bixbytes.qa.cbooster.pagesactions.SignInPage;
import com.bixbytes.qa.cbooster.utilities.TestDataReader;

public class Configure_SLA_Positive_Testcases extends Base_Main {

	/* TestNG annotations are used in below test cases */
	SignInPage signinpage;
	ConfigPage_SLA configpage;
	GeneralAdminLogin generaladminlogin;
	TestDataReader dataReader;
	String[][] getData = null;

	/* Constructor which points to Base_Main() super class methods */
	public Configure_SLA_Positive_Testcases() {
		super();

	}

	@BeforeMethod(alwaysRun = true)
	public void setup() throws InterruptedException {

		browsersetups();

		signinpage = new SignInPage(driver);
		configpage = new ConfigPage_SLA(driver);
		dataReader = new TestDataReader();
		generaladminlogin = new GeneralAdminLogin();
		generaladminlogin.login();

	}

	@Test(priority = 1, groups = { "FunctionalPositive" })
	public void tc1_click_sla_btn() throws InterruptedException {
		configpage.click_validate_configurepage();
		Boolean isDisplayed = configpage.click_sla_btn();
		String actual = Boolean.toString(isDisplayed);
		Assert.assertEquals(actual, "true");
		logger.info("Clicked on SLA  button and SLA page displayed:" + actual);
	}

	@Test(priority = 2, groups = { "FunctionalPositive" })
	public void tc2_add_sla() throws IOException, InterruptedException, Error {
		configpage.click_validate_configurepage();
		configpage.click_sla_btn();
		getData = dataReader.getcelldata("AddSLA");
		configpage.add_new_sla(getData[1][0], getData[1][1], getData[1][2], getData[1][3]);

	}

	@Test(priority = 3, dependsOnMethods = { "tc2_add_sla" }, groups = { "FunctionalPositive" })
	public void tc3_verify_added_sla() throws InterruptedException, Error, IOException {
		configpage.click_validate_configurepage();
		configpage.click_sla_btn();
		String content = configpage.verify_sla_addedData();
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
