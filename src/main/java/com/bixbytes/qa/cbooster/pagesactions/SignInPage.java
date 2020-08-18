/**
 * @author:Avaneesha K
   @Company: Bixbytes Solutions
 */
package com.bixbytes.qa.cbooster.pagesactions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.bixbytes.qa.cbooster.base.Base_Main;

public class SignInPage extends Base_Main {
	/* Using Pagefactory and storing the webelments */

	@FindBy(id = "email")
	WebElement id;

	@FindBy(id = "password")
	WebElement pwd;

	@FindBy(xpath = "//button[contains(text(),'Login')]")
	WebElement loginbtn;

	@FindBy(linkText = "//a[contains(text(),'Forgot Your Password?')]")
	WebElement forgotpwd;

	@FindBy(xpath = "//span[contains(text(),'Dashboard')]")
	WebElement dashboard_page_ele;

	@FindBy(xpath = "//p[contains(text(),'Invalid Credentials')][2]")
	
	WebElement invalid_cred;

	/* Initializing the Pagefactory */
	public SignInPage() {
		PageFactory.initElements(dr, this);

	}

	/* Actions Positive Case */
	public String checktitle_action() throws InterruptedException {
		Thread.sleep(1000);
		return dr.getTitle();
	}

	public DashBoard login_action(String un, String pawd) throws InterruptedException {

		Thread.sleep(1000);
		id.sendKeys(un);
		pwd.sendKeys(pawd);
		loginbtn.click();
		return new DashBoard();

		
	}

	public boolean check_title_action_dashboard() {

		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		boolean textdisplayed = dashboard_page_ele.isDisplayed();
		return textdisplayed;

	}

	

	/* Actions for Negative case */

	public boolean check_ivalidlogin_alert() {
	
		String myWindowHandle = dr.getWindowHandle();
		dr.switchTo().window(myWindowHandle);
		Boolean check_alert = invalid_cred.isDisplayed();
		return check_alert;
	}
}
