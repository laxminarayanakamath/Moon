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

public class ConfigPage_SLA extends Base_Main {

	WebDriver driver;
	VisibilityCheck visibilitycheck;
	DriverWait driverwait;
	GetTableData gettabledata;

	@FindBy(xpath = "//span[contains(text(),'Configure')]")
	WebElement configure;

	@FindBy(xpath = "//h2[@class='header_name mb-0']")
	WebElement configuretext;

	@FindBy(xpath = "//a[contains(text(),'SLA')]")
	WebElement sla;

	@FindBy(css = "input[name=sla_title]")
	WebElement sla_name;

	@FindBy(css = "input[name=description]")
	WebElement sla_description;

	@FindBy(css = "input[name=days]")
	WebElement sla_days;

	@FindBy(css = "input[name=hours]")
	WebElement sla_hours;

	@FindBy(xpath = "//button[contains(text(),'Add')]")
	WebElement add_button;

	@FindBy(xpath = "//p[contains(text(),'already been taken')][2]")
	WebElement already_taken_msg;

	@FindBy(xpath = "//div[@id='formSubmit']//p[1]")
	WebElement success_msg;

	@FindBy(xpath = "//span[contains(text(),'SLA name is required')]")
	WebElement mandat_check;

	/* Variable to find the row and column count */
	String rowsxpath = "//table[@class='table global_table  table-borderless box_shadow mb-0']/tbody/tr";
	String colpath = "//table[@class='table global_table  table-borderless box_shadow mb-0']/tbody/tr[1]/td";

	/*
	 * Variables to find write the dynamic xpaths which can find all the elements of
	 * a table
	 */

	String beforexpath = "//table[@class='table global_table  table-borderless box_shadow mb-0']/tbody/tr[";
	String afterxpath = "]/td[";
	public static String verficationcontent;

	/* Initializing the Pagefactory */

	public ConfigPage_SLA(WebDriver driver) {
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

	/* Check the visibility of SLA */
	public Boolean click_sla_btn() throws InterruptedException, Error {

		visibilitycheck.checkIsAvailable(sla);
		sla.click();
		driverwait.driverwait(sla_name);
		Boolean isDisplayed = sla_name.isDisplayed();
		return isDisplayed;

	}

	/* Adding SLA to the grid- Linked with Data Driven Method */
	public void add_new_sla(String slaname, String description, String days, String hours)
			throws InterruptedException, Error {
		/* Check the visibility of related elements in the page */
		driverwait.driverwait(sla_name);
		visibilitycheck.checkIsAvailable(sla_name);
		visibilitycheck.checkIsAvailable(sla_description);
		visibilitycheck.checkIsAvailable(sla_days);
		visibilitycheck.checkIsAvailable(sla_hours);
		visibilitycheck.checkIsAvailable(add_button);

		verficationcontent = slaname;

		/* Fetch data from the test case and click Add */
		sla_name.sendKeys(slaname);
		sla_description.sendKeys(description);
		sla_days.sendKeys(days);
		sla_hours.sendKeys(hours);
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

	/* Verifying the added LSA exist in grid Or not */
	public String verify_sla_addedData() {

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
