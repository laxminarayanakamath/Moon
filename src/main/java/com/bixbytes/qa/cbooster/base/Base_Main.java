package com.bixbytes.qa.cbooster.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Base_Main 
{
	public static WebDriver dr;
	public static Properties prop;
	public static String path;
	
	//Directory Is : D:\Workspace\CBooster\cboostertest
	
	public void Base_Main() 
	{
		prop=new Properties();
		FileInputStream fis;
		try {
			
		//	This is C:\Users\OFFICE\git\repository\Test
			
			fis=new FileInputStream("C:\\Users\\OFFICE\\git\\repository\\cboostertest\\src\\main\\java\\com\\bixbytes\\qa\\cbooster\\configurations\\config.properties");
			//fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/bixbytes/qa/configurations/config.properties");
			prop.load(fis);
			
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void browsersetups()
	{
		
		/*
		
		if (prop.getProperty("browser").equals("chrome")) {

			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/resources/drivers/chromedriver.exe");

			dr = new ChromeDriver();

			} else if (prop.getProperty("browser").equals("firefox")) {

			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/src/main/resources/drivers/geckodriver.exe");

			dr = new FirefoxDriver();

			}*/

		System.setProperty("webdriver.gecko.driver", "C:\\Users\\OFFICE\\Desktop\\Eclipse\\geckodriver\\geckodriver.exe");
		dr=new FirefoxDriver();
		
	
		
		
		dr.manage().window().maximize();
		dr.manage().deleteAllCookies();
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		dr.get("http://217.160.26.191/cbooster/login");
	}
	
	

}
