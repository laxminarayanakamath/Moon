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
	SignInPage si;

	/* Constructor which points to Base_Main() super class methods */
	public SignIn_Positive_Testcases() {
		super();

	}


	@BeforeMethod(alwaysRun=true)
	public void setup() {

		browsersetups();
		si = new SignInPage();

	}

	@Test(priority=1,groups= {"SmokeTest"})
	public void signin_checktitle_action_case() throws InterruptedException {
		Thread.sleep(1000);
		String title = si.checktitle_action();
		Assert.assertEquals(title, "CBooster PM Tool");
	
	}

	@Test(priority = 2,groups= {"FunctionalPositive"})
	public void sign_case_valid() throws InterruptedException {
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String un = prop.getProperty("username");
		String pawd = prop.getProperty("password");
		si.login_action(un, pawd);

		Boolean text_displayed = si.check_title_action_dashboard();
		String actual = Boolean.toString(text_displayed);
		Assert.assertEquals(actual, "true");

	}

	@AfterMethod(alwaysRun=true)
	public void exitbrowser() {
		dr.quit();
	}

}
