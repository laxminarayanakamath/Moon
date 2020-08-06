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

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Base_Main {
	public static WebDriver dr;
	public static Properties prop;
	public static String path;

	 public Base_Main() {
		
		/* Constructor for reading the Properties file */
		/* D:\Workspace\CBooster Project\cboostertest */

	
		
		prop = new Properties();

		try {

			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/bixbytes/qa/cbooster/configurations/config.properties");
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
	public void browsersetups() {

		if (prop.getProperty("browser").equals("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver.exe");

			dr = new ChromeDriver();

		} else if (prop.getProperty("browser").equals("firefox")) {

			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "/src/main/resources/drivers/geckodriver.exe");

			dr = new FirefoxDriver();

		} 

	

		dr.manage().window().maximize();
		dr.manage().deleteAllCookies();
		dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		dr.get("http://217.160.26.191/cbooster/login");
	}

}
