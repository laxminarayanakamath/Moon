/**
 * @author:Avaneesha K
   @Company: Bixbytes Solutions
 */
package com.bixbytes.qa.cbooster.pagesactions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.bixbytes.qa.cbooster.base.Base_Main;

public class SignInPage extends Base_Main {
	/* Using Pagefactory and storing the webelments */
	WebDriver driver;
	
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
	public SignInPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}

	

	/* Actions Positive Case */
	public String checktitle_action() throws InterruptedException {
		Thread.sleep(1000);
		return driver.getTitle();
	}

	public DashBoard login_action(String un, String pawd) throws InterruptedException {

		Thread.sleep(1000);
		id.sendKeys(un);
		pwd.sendKeys(pawd);
		loginbtn.click();
		return new DashBoard(driver);

		
	}

	public boolean check_title_action_dashboard() {

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		boolean textdisplayed = dashboard_page_ele.isDisplayed();
		return textdisplayed;

	}

	

	/* Actions for Negative case */

	public boolean check_ivalidlogin_alert() throws InterruptedException {
	
		String myWindowHandle = driver.getWindowHandle();
		driver.switchTo().window(myWindowHandle);
		Thread.sleep(5000);
		Boolean check_alert = invalid_cred.isDisplayed();
		return check_alert;
	}
}
