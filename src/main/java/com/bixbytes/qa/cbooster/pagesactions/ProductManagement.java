/**
 * @author:Avaneesha K
   @Company: Bixbytes Solutions
 */
package com.bixbytes.qa.cbooster.pagesactions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductManagement {

	@FindBy(xpath="//label[contains(text(),'Choose Product Type')]")
	WebElement choose_producttype;
	
	@FindBy(css="span[id='product_level_id-button']")
	WebElement choose_productlevel;
	
	
}
