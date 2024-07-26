package com.itlearn360.testcases;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


import com.itlearn360.pages.LoginPage;
import com.itlearn360.utilities.BaseTest;


public class TC001_LoginTest extends BaseTest {
	
	@Test
	public void verifyLogin() throws IOException {
		
	
		LoginPage lp = new LoginPage(driver);
		
		 
		
	    try {
	    	
	        lp.loginToPortal(config.getUsername(), config.getPassword());
	        //System.out.println("Login successful ");
	        

           if (driver.getTitle().contains("ITLearn360")){
	            // Login success
	            System.out.println("Login successful");
	            System.out.println("Title of Dashboard Page: " + driver.getTitle());
	            
	            // 1).change here the name of test case you needs to get screenshot
	            captureScreenShot(driver, "TC001_LoginTest_Screenshot_Success");
	            
	        } else {
	            // Login failure
	            System.out.println("Login failed");
	            WebElement errorMessageElement = driver.findElement(By.xpath("//*[@id=\"login_error\"]"));
	            String errorMessage = errorMessageElement.getText();
	            System.out.println("Error message: " + errorMessage);
	            
	            //2).change here the name of test case you needs to get screenshot
	            captureScreenShot(driver, "TC001_LoginTest_Screenshot_failure");
	        }
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
            e.printStackTrace();

            // Capture screenshot
            // 3).change here the name of test case you needs to get screenshot
            captureScreenShot(driver, "TC001_LoginTest_Screenshot_error occurred");
        }
    }
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	
	}


		




