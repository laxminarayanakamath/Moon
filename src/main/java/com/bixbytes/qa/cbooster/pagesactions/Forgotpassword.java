/**
 * @author:Avaneesha K
   @Company: Bixbytes Solutions
 */
package com.bixbytes.qa.cbooster.pagesactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bixbytes.qa.cbooster.base.Base_Main;

public class Forgotpassword extends Base_Main
{
	WebDriverWait wt;
	
	@FindBy(xpath="//a[contains(text(),'Forgot Your Password?')]")
	WebElement forgot_pwd;
	
	@FindBy(xpath="//input[@type='email']")
	WebElement email_address;
	
	@FindBy(xpath="//button[@type='button']//button[contains(text(),'Submit')]")
	WebElement submit_btn;
	
	@FindBy(xpath="//button[@type='button']//button[contains(text(),'Cancel')]")
	WebElement cancel_btn;
	
	
	public Forgotpassword()
	{
		PageFactory.initElements(dr, this);
	}
	
	
/*	public boolean click_check_forgorpassword() throws InterruptedException
	{
		if(forgot_pwd.isEnabled())
		{
		wt.until(ExpectedConditions.elementToBeClickable(forgot_pwd));
		forgot_pwd.click();
		Thread.sleep(5000);
		boolean emailadd=email_address.isDisplayed();
		return emailadd;
		
		}
		else
		{
			System.out.println("Forgot Password Link Not Found");
		}
		*/
	
	
	public void validate_forgorpwd_page()
	{
		
	}
	
	public void forgorpassword_submit()
	{
		
	}
	
	public void forgotpassword_cancel()
	{
		
	}
	
}
