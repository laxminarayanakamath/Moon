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
import com.bixbytes.qa.cbooster.commonmethods.DriverWait;
import com.bixbytes.qa.cbooster.commonmethods.GetTableData;
import com.bixbytes.qa.cbooster.commonmethods.VisibilityCheck;

public class ConfigPage extends Base_Main {
	WebDriver driver;
	VisibilityCheck visibilitycheck;
	DriverWait driverwait;
	GetTableData gettabledata;

	/* Element in the overview page */
	@FindBy(xpath = "//span[contains(text(),'Configure')]")
	WebElement configure;

	@FindBy(xpath = "//h2[@class='header_name mb-0']")
	WebElement configuretext;

	@FindBy(xpath = "//a[contains(text(),'OVERVIEW')]")
	WebElement overview;

	@FindBy(xpath = "//a[contains(text(),'Product Type')]")
	WebElement producttype;

	@FindBy(xpath = "//a[contains(text(),'Product Level')]")
	WebElement productlevel;

	@FindBy(xpath = "//a[contains(text(),'SLA')]")
	WebElement sla;

	@FindBy(xpath = "//a[contains(text(),'Currency')]")
	WebElement currency;

	/* Elements in the Product Type Page */
	@FindBy(css = "input[name=product_type]")
	WebElement producttype_name;

	@FindBy(css = "input[name='code']")
	WebElement producttype_code;

	@FindBy(css = "input[name='description']")
	WebElement producttype_description;

	@FindBy(xpath = "//button[contains(text(),'ADD')]")
	WebElement add_button;

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
	public ConfigPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		visibilitycheck = new VisibilityCheck();
		driverwait = new DriverWait();
		gettabledata = new GetTableData();
	}

	/* Action Methods */

	public Boolean click_validate_configurepage() throws InterruptedException, Error {

		visibilitycheck.checkIsAvailable(configure);
		configure.click();
		driverwait.driverwait(configuretext);
		Boolean isDisplayed = configuretext.isDisplayed();
		return isDisplayed;

	}

	public void click_overview_btn() throws InterruptedException {

		driverwait.driverwait(overview);
		visibilitycheck.checkIsAvailable(overview);
		overview.click();

	}

	public Boolean click_producttype_btn() throws InterruptedException, Error {

		visibilitycheck.checkIsAvailable(producttype);
		producttype.click();
		driverwait.driverwait(producttype_name);
		Boolean isDisplayed = producttype_name.isDisplayed();
		return isDisplayed;

	}

	/* Linked with Data Driven Method */
	public void add_producttype(String producttypes, String code, String description)
			throws InterruptedException, Error {
		/* Check the visibility of related elements in the page */
		driverwait.driverwait(producttype_name);
		visibilitycheck.checkIsAvailable(producttype_name);
		visibilitycheck.checkIsAvailable(producttype_code);
		visibilitycheck.checkIsAvailable(producttype_description);
		visibilitycheck.checkIsAvailable(add_button);

		verficationcontent = producttypes;

		/* Fetch data from the test case and click Add */
		producttype_name.sendKeys(producttypes);
		producttype_code.sendKeys(code);
		producttype_description.sendKeys(description);
		add_button.click();
	}

	/* Verifying the added product displays in grid Or not */
	public String verify_producttype_addedData() {

		String content = gettabledata.getGridRows(rowsxpath, colpath, beforexpath, afterxpath, verficationcontent);
		return content;

	}

}
