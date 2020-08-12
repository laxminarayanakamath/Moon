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

import com.bixbytes.qa.cbooster.base.Base_Main;

public class DashBoard extends Base_Main {
	@FindBy(xpath = "//span[contains(text(),'Dashboard')]")
	WebElement dashboard_page_ele;

	public DashBoard() 
	{
		PageFactory.initElements(dr, this);
	}

	public boolean check_title_action() throws InterruptedException {
		Thread.sleep(5000);
		boolean textdisplayed = dashboard_page_ele.isDisplayed();
		return textdisplayed;

	}

}
