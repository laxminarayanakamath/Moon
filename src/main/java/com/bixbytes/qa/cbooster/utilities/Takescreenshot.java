/**
 * @author:Avaneesha K
   @Company: Bixbytes Solutions
 */
package com.bixbytes.qa.cbooster.utilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.bixbytes.qa.cbooster.base.Base_Main;

import org.apache.commons.io.FileUtils;

public class Takescreenshot extends Base_Main{
	
	public void screenshot(String testcasename,WebDriver dr) throws IOException
	{
	 
    TakesScreenshot scrShot =((TakesScreenshot)dr);
    File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
    LocalDateTime dt=LocalDateTime.now();
    String testcasename_time=testcasename+dt;
    File DestFile=new File(System.getProperty("user.dir") + "/test-output/Screenshots/"+testcasename+".png");
    FileUtils.copyFile(SrcFile, DestFile);
	
	}

}
