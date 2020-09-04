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
import com.bixbytes.qa.cbooster.pagesactions.ConfigPage_Currency;
import com.bixbytes.qa.cbooster.pagesactions.ConfigPage_ProductLevel;
import com.bixbytes.qa.cbooster.pagesactions.SignInPage;

public class Configure_Currency_Negative_Testcases extends Base_Main {

	SignInPage signinpage;
	ConfigPage_Currency configpage;
	GeneralAdminLogin generaladminlogin;

	public Configure_Currency_Negative_Testcases() {
		super();

	}

	@BeforeMethod(alwaysRun = true)
	public void setup() throws InterruptedException {

		browsersetups();

		signinpage = new SignInPage(driver);
		configpage = new ConfigPage_Currency(driver);
		generaladminlogin = new GeneralAdminLogin();
		generaladminlogin.login();

	}

	@Test(priority = 1, groups = { "FunctionalNegative" })
	public void tc1_clickadd_withoutdata() throws InterruptedException, Error {
		configpage.click_validate_configurepage();
		configpage.click_currency_btn();
		Boolean text = configpage.click_add_button();
		String actual = Boolean.toString(text);
		Assert.assertEquals(actual, "true");
		logger.info("Clicking on add button without entering the details");
	}

	@AfterMethod(alwaysRun = true)
	public void exitbrowser() {
		driver.close();
		driver.quit();
		logger.info("Clean up activity: Closed all browser instances..");
	}

}
