/**
 * @author:Avaneesha K
   @Company: Bixbytes Solutions
 */
package com.bixbytes.qa.cbooster.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.bixbytes.qa.cbooster.base.Base_Main;

import org.apache.commons.io.FileUtils;

public class Takescreenshot extends Base_Main
{
	
	public void screenshot(String testcasename,WebDriver dr) throws IOException
	{
	 
	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
	
    TakesScreenshot scrShot =((TakesScreenshot)dr);
    File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
    LocalDateTime dt=LocalDateTime.now();
    String screenshotname=testcasename+timeStamp+".png";
    File DestFile=new File(System.getProperty("user.dir") + "/test-output/Screenshots/"+screenshotname);
    FileUtils.copyFile(SrcFile, DestFile);
	
	}

}
