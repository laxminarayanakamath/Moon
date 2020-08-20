/**
 * @author:Avaneesha K
   @Company: Bixbytes Solutions
 */

package com.bixbytes.qa.cbooster.testcases;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import com.bixbytes.qa.cbooster.base.Base_Main;
import com.bixbytes.qa.cbooster.pagesactions.Forgotpassword;
import com.bixbytes.qa.cbooster.pagesactions.SignInPage;


public class Forgotpassword_Negative_Testcases extends Base_Main{
	
	SignInPage signinpage;
	Forgotpassword forgotpassword;
	WebDriverWait wbtait;
	
	public Forgotpassword_Negative_Testcases()
	{
		super();
	}
	
	@BeforeMethod(alwaysRun=true)
	public void setup()
	{
		browsersetups();
		signinpage = new SignInPage(driver);
		forgotpassword=new Forgotpassword(driver);
	}
	public void forgot_password_submit_invalid_case() throws InterruptedException
	{
		String email_address=prop.getProperty("invalid_username");
		forgotpassword.forgorpassword_submit(email_address);
		
	}

}
