package com.itlearn360.utilities;//This line specifies the package name for the Java class.

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;//This line imports the WebDriver class from the Selenium library, which is used for browser automation.
import org.testng.annotations.AfterClass;// This line imports the @AfterClass annotation from TestNG, which is used to mark a method to be run after a test class.

import org.testng.annotations.BeforeClass;//This line imports the @BeforeClass annotation from TestNG, which is used to mark a method to be run before a test class.

import com.itlearn360.utilities.BrowserFactory;//This line imports the BrowserFactory class from the com.itlearn360.utilities package, which is likely a custom class for managing browser instances.
import com.itlearn360.utilities.ConfigDataProvider;//This line imports the ConfigDataProvider class from the com.itlearn360.utilities package, which is likely a custom class for providing configuration data.

//This line begins the declaration of the BaseTest class.
public class BaseTest {

	public WebDriver driver; //This line declares a public variable 'driver' of type WebDriver.
	public ConfigDataProvider config;//This line declares a public variable 'config' of type ConfigDataProvider.
	
	
	public BaseTest() {
        config = new ConfigDataProvider(); // Initialize the config object
    }
	
	
	// This annotation marks the following method to be run before the test class.
	@BeforeClass
	
	// This line begins the declaration of the setUp method, which is annotated with @BeforeClass.
	public void setUp()
	{
		//This line calls the startApplication method of the BrowserFactory class to launch the browser and assigns the resulting WebDriver instance to the 'driver' variable.
		driver=BrowserFactory.startApplication(driver,config.getBrowser(),config.getStagingUrl());
	}
	
//This annotation marks the following method to be run after the test class.	
 @AfterClass
 
 //This line begins the declaration of the tearDown method, which is annotated with @AfterClass.
	public void tearDown()
	{
	 
	 
	 // This line calls the quitBrowser method of the BrowserFactory class to close the browser instance.

		BrowserFactory.quitBrowser(driver);
	}
 
 
 
 public void captureScreenShot(WebDriver driver,String testName) throws IOException
 {
	 // Convert webdriver object to TakesScreenshot interface
	 TakesScreenshot screenshot= ((TakesScreenshot)driver);
	 
	 // Step 2 :call getScreenshotAs method to capture image file
	 
	 File src= screenshot.getScreenshotAs(OutputType.FILE);
	 File srcpath=new File("."+"//Screenshots//"+ testName + ".png");
	 //System.out.println("This is screenshots section");
	 
	 // Step 3 : copy image file to destination 
	 FileUtils.copyFile(src, srcpath);
	 
 }
 
}



//This class appears to be a base class for test classes, providing setup and teardown methods for launching and closing a browser instance using the BrowserFactory class.