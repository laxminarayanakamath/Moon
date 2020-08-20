/**
 * @author:Avaneesha K
   @Company: Bixbytes Solutions
 */

package com.bixbytes.qa.cbooster.utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListner extends Takescreenshot implements ITestListener {

	public void onFinish(ITestContext tcname) {

	}

	public void onStart(ITestContext tcname) {

		System.out.println("On Start:");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

	}

	public void onTestFailure(ITestResult tcname) 
	{

		String testcasename = tcname.getMethod().getMethodName();
		try 
		{
			 WebDriver driver=(WebDriver) tcname.getTestClass().getRealClass().getField("dr").get(tcname.getInstance());
		
			screenshot(testcasename,driver);
		}
		 catch (IOException | IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("FAILED TEST:" + testcasename);

	}

	public void onTestSkipped(ITestResult tcname) {
		String testcasename = tcname.getMethod().getMethodName();
		System.out.println("This Test is Skipped:" + testcasename);

	}

	public void onTestStart(ITestResult tcname) {
		String testcasename = tcname.getMethod().getMethodName();
		System.out.println("This Test is Started:" + testcasename);

	}

	public void onTestSuccess(ITestResult tcname) {

		String testcasename = tcname.getMethod().getMethodName();
		try 
		{
			 WebDriver driver=(WebDriver) tcname.getTestClass().getRealClass().getField("dr").get(tcname.getInstance());
		
			screenshot(testcasename,driver);
		}
		 catch (IOException | IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("FAILED TEST:" + testcasename);

	}
}
