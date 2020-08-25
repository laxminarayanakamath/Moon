/**
 * @author:Avaneesha K
   @Company: Bixbytes Solutions
 */
package com.bixbytes.qa.cbooster.commonmethods;

import org.openqa.selenium.By;

import com.bixbytes.qa.cbooster.base.Base_Main;

public class GeneralAdminLogin extends Base_Main{
	
	public void login() throws InterruptedException
	{
		String uname=prop.getProperty("username");
		String pwd=prop.getProperty("password");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(uname);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pwd);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		Thread.sleep(5000);
	}

}
