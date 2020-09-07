/**
 * @author:Avaneesha K
   @Company: Bixbytes Solutions
 */
package com.bixbytes.qa.cbooster.commonmethods;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bixbytes.qa.cbooster.base.Base_Main;

public class DriverWait extends Base_Main{
	
	public void driverwait(WebElement element)
	{
		try {
	
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
		}
		catch(Exception e)
		{
			 e.printStackTrace();
			 logger.info("ELement is not found in the Webpage"+element);
		}
	}

}
