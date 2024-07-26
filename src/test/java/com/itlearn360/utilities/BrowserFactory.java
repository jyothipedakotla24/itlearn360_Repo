//1. Defines the package name for the Java class.
package com.itlearn360.utilities;

//Imports the TimeUnit class for managing timeouts.
import java.util.concurrent.TimeUnit;

// Imports the WebDriver interface for browser interaction.
import org.openqa.selenium.WebDriver;

//Imports the ChromeDriver class for Chrome browser interaction.
import org.openqa.selenium.chrome.ChromeDriver;

// Imports the ChromeOptions class for configuring ChromeDriver.
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumOptions;
// Imports the EdgeDriver class for Edge browser interaction.
import org.openqa.selenium.edge.EdgeDriver;

// Imports the FirefoxDriver class for Firefox browser interaction.
import org.openqa.selenium.firefox.FirefoxDriver;

//Defines the BrowserFactory class.
public class BrowserFactory {

	//Defines a method to start a browser application.
	public static WebDriver startApplication(WebDriver driver,String browserName,String appUrl)
	{
		//Checks if the browser name is "Chrome".
		if(browserName.equals("Chrome"))
		{
			//Sets the property for the ChromeDriver executable.
			System.setProperty("webdriver.chrome.driver", "J:\\Eclipse programs\\itlearn360\\Drivers\\chromedriver.exe");
			

			
	         driver = new ChromeDriver();
		}
		//Checks if the browser name is "Edge".
		else if(browserName.equals("Edge"))
		{
			//Sets the property for the EdgeDriver executable.
			System.setProperty("webdriver.edge.driver", "J:\\Eclipse programs\\itlearn360\\Drivers\\msedgedriver.exe");
	        //Creates a new instance of EdgeDriver. 
			driver = new EdgeDriver();
		}
		//Checks if the browser name is "Firefox".
		else if(browserName.equals("Firefox"))
		{
			//Sets the property for the GeckoDriver executable (note: should be webdriver.firefox.driver).
			System.setProperty("webdriver.firefox.driver", "./Drivers/firefoxdriver.exe");
			
			//20. Creates a new instance of FirefoxDriver.
			driver = new FirefoxDriver();
		}
		else//21. If the browser name is not recognized.

		{    // Prints a message indicating unsupported browser.
			System.out.println("We do not support this browser ");
		}

		//23. Maximizes the browser window.
		driver.manage().window().maximize();
		//24.  Navigates to the given application URL.
		driver.get(appUrl);
		//Sets an implicit wait of 30 seconds.
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	    // Returns the WebDriver instance.
		return driver;

	}
	// Defines a method to quit the browser.
	public static void quitBrowser(WebDriver driver)
	{
		//28. Quits the WebDriver instance.
         driver.quit();
	}
}
