/**
 * @author:Avaneesha K
   @Company: Bixbytes Solutions
 */
package com.bixbytes.qa.cbooster.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bixbytes.qa.cbooster.base.Base_Main;
import com.bixbytes.qa.cbooster.pagesactions.DashBoard;
import com.bixbytes.qa.cbooster.pagesactions.SignInPage;

public class DashBoard_Positive_Testcases extends Base_Main {
	DashBoard db1;
	SignInPage sp;

	public DashBoard_Positive_Testcases() {
		super();
	}


	@BeforeMethod(alwaysRun=true)
	public void setup() throws InterruptedException {
		browsersetups();
		sp = new SignInPage();
		String un = prop.getProperty("username");
		String pawd = prop.getProperty("password");
		sp.login_action(un, pawd);
	}

	@Test(priority = 1,groups= {"SmokeTest"})
	public void dashboard_checktitle_action_case() throws InterruptedException {

		Thread.sleep(5000);
		db1 = new DashBoard();
		Boolean text_displayed = db1.check_title_action();
		String actual = Boolean.toString(text_displayed);
		Assert.assertEquals(actual, "true");
	}

	@AfterMethod(alwaysRun=true)
	public void exitbrowser() {
		dr.quit();
	}

}
