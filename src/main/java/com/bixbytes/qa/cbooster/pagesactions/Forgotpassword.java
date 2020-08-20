/**
 * @author:Avaneesha K
   @Company: Bixbytes Solutions
 */
package com.bixbytes.qa.cbooster.pagesactions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bixbytes.qa.cbooster.base.Base_Main;

public class Forgotpassword extends Base_Main
{
	WebDriver driver;
	
	@FindBy(xpath="//a[contains(text(),'Forgot Your Password?')]")
	WebElement forgot_pwd;
	
	@FindBy(xpath="//input[@type='email']")
	WebElement email_address;
	
	@FindBy(xpath="//button[contains(text(),'Submit')]")
	WebElement submit_btn;
	
	@FindBy(xpath="//button[contains(text(),'Cancel')]")
	WebElement cancel_btn;
	
	@FindBy(xpath="//h4[contains(text(),'Enter Your Registered Email')]")
	WebElement forgot_pwd_page;
	
	
	
		public Forgotpassword(WebDriver driver) {
			// TODO Auto-generated constructor stub
			this.driver = driver;
			PageFactory.initElements(driver, this);
		
		}
	
	/* Positive Test Actions */
	public boolean case_forgorpassword_displayed() throws InterruptedException
	{
		boolean forgotpwd_displayed = false;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(forgot_pwd.isDisplayed())
		{
		forgotpwd_displayed=forgot_pwd.isDisplayed();
			
		}
		else
		{
			System.out.println("Forgot Password Link Not Found");
		}
		return forgotpwd_displayed;
	}
	
	
	public String case_validate_forgorpwd_page() throws InterruptedException
	{
		forgot_pwd.click();
		Thread.sleep(5000);
		String page_text=forgot_pwd_page.getText();
		System.out.println(page_text);
		return page_text;
	}
	
	public void forgorpassword_submit(String eaddress) throws InterruptedException
	{
		forgot_pwd.click();
	
		email_address.sendKeys(eaddress);
		submit_btn.click();
		
	}
	
	/*Negative Test Actions */
	
	public void forgotpassword_cancel(String eaddress) throws InterruptedException
	{
		forgot_pwd.click();
	
		email_address.sendKeys(eaddress);
		submit_btn.click();
		Thread.sleep(5000);
	}
	
	public void wrong_forgot_pwd(String eaddress) throws InterruptedException
	{
		forgot_pwd.click();
	
		email_address.sendKeys(eaddress);
		cancel_btn.click();
		Thread.sleep(5000);
	}
	
}
