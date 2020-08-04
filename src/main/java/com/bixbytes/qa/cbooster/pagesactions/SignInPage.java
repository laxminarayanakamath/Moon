/**
 * @author:Avaneesha K
   @Company: Bixbytes Solutions
 */
package com.bixbytes.qa.cbooster.pagesactions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bixbytes.qa.cbooster.base.Base_Main;

public class SignInPage extends Base_Main {
	/* Using Pagefactory and storing the webelments */

	@FindBy(id = "email")
	WebElement id;

	@FindBy(id = "password")
	WebElement pwd;

	@FindBy(xpath = "//button[contains(text(),'Login')]")
	WebElement loginbtn;

	@FindBy(linkText = "//a[contains(text(),\"Forgot Your Password?)]")
	WebElement forgotpwd;

	/* Initializing the pagefactory */
	public SignInPage() {
		PageFactory.initElements(dr, this);

	}

	/* Actions */
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

	public Forgotpassword Forgotpwd_Action() throws InterruptedException {
		Thread.sleep(1000);
		forgotpwd.click();
		return new Forgotpassword();
	}

}
