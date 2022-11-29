package com.hybridframework.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hybridframework.pageObjects.LoginPage;

public class TC_Login_001 extends BaseClass{
	
	@Test
     public void logintest() throws InterruptedException, IOException {
    	 
		 driver.get(baseURL);
		 logger.info("URL entered");
		 driver.manage().window().maximize();
		 Thread.sleep(3000);
		 driver.switchTo().frame("gdpr-consent-notice");
		
		 LoginPage lp=new LoginPage(driver);
    	 
    	 lp.clickAccept();
    	 lp.setUsername(username);
    	 lp.setPassword(password);
    	 logger.info("Login details are entered");
    	 lp.submit();
    	 
    	
    	 if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
    	 {
    		 Assert.assertTrue(true);
    		 logger.info("User logged in Succssfully");
    	 }
    	 else
    	 {
    		 captureScreenshot(driver, "loginTest");
    		 Assert.assertTrue(false);
    		 logger.info("Login test failed");
    	 }
    	 
     }
}
