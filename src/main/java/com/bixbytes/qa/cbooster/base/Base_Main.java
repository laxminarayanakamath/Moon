/**
 * @author:Avaneesha K
   @Company: Bixbytes Solutions
 */

package com.bixbytes.qa.cbooster.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Base_Main {
	public static WebDriver driver;
	public static Properties prop;
	public static String path;
	public static Logger logger;
	public String base_path;

	public Base_Main() {

		/* Constructor for reading the Properties file */
		/* D:\Workspace\CBooster Project\cboostertest */
		
		base_path=System.getProperty("user.dir");
		String log4jConfPath = base_path + "/log4j.properties";
		logger = Logger.getLogger("CBooster");
		PropertyConfigurator.configure(log4jConfPath);
		prop = new Properties();

		try {

			FileInputStream fis = new FileInputStream(base_path+ "/src/main/java/com/bixbytes/qa/cbooster/configurations/config.properties");
			prop.load(fis);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File Is not Found" + e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IO Exception occured" + e);
		}

	}

	/*
	 * Method to check which browser needs to be used and to Initialize the Browser
	 * driver
	 */
	public WebDriver browsersetups() {
		
	

		if (prop.getProperty("browser").equals("chrome")) {
			
			logger.info("Chrome browser is started..");
			System.setProperty("webdriver.chrome.driver",base_path + "/src/main/resources/drivers/chromedriver.exe");

			driver = new ChromeDriver();

		} else if (prop.getProperty("browser").equals("firefox")) {

			logger.info("Firefox browser is started..");
			System.setProperty("webdriver.gecko.driver",base_path + "/src/main/resources/drivers/geckodriver.exe");

			driver = new FirefoxDriver();

		}
		else if(prop.getProperty("browser").equals("Edge"))
		{
			logger.info("Microsoft Edge browser is started..");
			System.setProperty("webdriver.edge.driver",base_path + "/src/main/resources/drivers/msedgedriver.exe");

			driver = new EdgeDriver();
		}
		

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		return driver;
	}

	public String randomestring() {
		String generatedstring = RandomStringUtils.randomAlphabetic(6);
		return (generatedstring);
	}

	public static String randomeNum() {
		String generatednum = RandomStringUtils.randomNumeric(6);
		return (generatednum);
	}

}
