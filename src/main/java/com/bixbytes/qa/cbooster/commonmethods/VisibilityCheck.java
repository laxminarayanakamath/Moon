/**
 * @author:Avaneesha K
   @Company: Bixbytes Solutions
 */
package com.bixbytes.qa.cbooster.commonmethods;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bixbytes.qa.cbooster.base.Base_Main;


public class VisibilityCheck extends Base_Main
{
public void checkIsAvailable(WebElement element) throws Error, InterruptedException
	
	{
        	WebDriverWait wt=new WebDriverWait(driver,10);
        	wt.until(ExpectedConditions.visibilityOf(element));
        	
        	if(element.isDisplayed()==true)
        	{
        		logger.info("This element is displayed,proceeding with further actions..."+element);
        	}
        
        	else
        	{
        	System.out.println("Element is not available - Method-checkIsAvailable ");
        	logger.info("Element is not available - Method-checkIsAvailable...");
        	}
        
	}
}
