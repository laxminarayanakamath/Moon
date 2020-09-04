/**
 * @author:Avaneesha K
   @Company: Bixbytes Solutions
 */
package com.bixbytes.qa.cbooster.pagesactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bixbytes.qa.cbooster.base.Base_Main;
import com.bixbytes.qa.cbooster.commonmethods.DriverWait;
import com.bixbytes.qa.cbooster.commonmethods.GetTableData;
import com.bixbytes.qa.cbooster.commonmethods.VisibilityCheck;

public class ConfigPage_Currency extends Base_Main {

	WebDriver driver;
	VisibilityCheck visibilitycheck;
	DriverWait driverwait;
	GetTableData gettabledata;

	/* Page Objects for Currency Add page */
	@FindBy(xpath = "//span[contains(text(),'Configure')]")
	WebElement configure;

	@FindBy(xpath = "//h2[@class='header_name mb-0']")
	WebElement configuretext;

	@FindBy(xpath = "//a[contains(text(),'Currency')]")
	WebElement currency;

	@FindBy(css = "input[name=currency_title]")
	WebElement currency_title;

	@FindBy(css = "input[name=description]")
	WebElement currency_description;

	@FindBy(css = "input[name=round_factor]")
	WebElement round_factor;

	@FindBy(xpath = "//button[contains(text(),'ADD')]")
	WebElement add_button;

	@FindBy(xpath = "//p[contains(text(),'already been taken')][2]")
	WebElement already_taken_msg;

	@FindBy(xpath = "//div[@id='formSubmit']//p[1]")
	WebElement success_msg;

	@FindBy(xpath = "//span[contains(text(),'Choose currency title')]")
	WebElement mandat_check;

	/* Variable to find the row and column count */
	String rowsxpath = "//table[@class='table global_table  table-borderless box_shadow mb-0']/tbody/tr";
	String colpath = "//table[@class='table global_table  table-borderless box_shadow mb-0']/tbody/tr[1]/td";
	
	 // Variables to identify the dynamic xpaths which can find all the elements of grid
	
	String beforexpath = "//table[@class='table global_table  table-borderless box_shadow mb-0']/tbody/tr[";
	String afterxpath = "]/td[";
	public static String verficationcontent;

	/* Initializing the Pagefactory */

	public ConfigPage_Currency(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		visibilitycheck = new VisibilityCheck();
		driverwait = new DriverWait();
		gettabledata = new GetTableData();
	}

	/* Action Methods starts from here */

	public Boolean click_validate_configurepage() throws InterruptedException, Error {

		visibilitycheck.checkIsAvailable(configure);
		configure.click();
		driverwait.driverwait(configuretext);
		Boolean isDisplayed = configuretext.isDisplayed();
		return isDisplayed;

	}

	/* Click & Check the visibility of Currency Page */
	public Boolean click_currency_btn() throws InterruptedException, Error {
		visibilitycheck.checkIsAvailable(currency);
		currency.click();
		driverwait.driverwait(currency_title);
		Boolean isDisplayed = currency_title.isDisplayed();
		return isDisplayed;

	}

	/* Adding Currency to the grid- Linked with Data Driven Method */
	public void add_new_currency(String currencytitle, String description, String roundfactor)
			throws InterruptedException, Error {
		/* Check the visibility of related elements in the page */
		driverwait.driverwait(currency_title);
		visibilitycheck.checkIsAvailable(currency_title);
		visibilitycheck.checkIsAvailable(currency_description);
		visibilitycheck.checkIsAvailable(round_factor);
		visibilitycheck.checkIsAvailable(add_button);

		verficationcontent = currencytitle;

		/* Fetch data from the test case and click Add */
		currency_title.sendKeys(currencytitle);
		currency_description.sendKeys(description);
		round_factor.sendKeys(roundfactor);
		add_button.click();
		Thread.sleep(5000);
		/* Switching to the alert & checking the message */

		String mywindowhandle = driver.getWindowHandle();
		driver.switchTo().window(mywindowhandle);

		Thread.sleep(5000);
		if (success_msg.isDisplayed()) {
			logger.info("New data inserted to the grid successfully");
		} else if (already_taken_msg.isDisplayed()) {
			logger.info("It looks like data you are trying to insert already exist in the grid");
		} else {
			logger.info("Alert pop up not displayed");
		}

		driver.switchTo().defaultContent();

	}

	/* Verifying the added Currency exist in grid Or not */
	public String verify_currency_addedData() {

		String content = gettabledata.getGridRows(rowsxpath, colpath, beforexpath, afterxpath, verficationcontent);
		return content;

	}

	/* Action Method for Negative Case - trying to insert empty data */
	public Boolean click_add_button() throws InterruptedException, Error {

		visibilitycheck.checkIsAvailable(add_button);
		add_button.click();
		Boolean check = mandat_check.isDisplayed();
		return check;
	}

}
