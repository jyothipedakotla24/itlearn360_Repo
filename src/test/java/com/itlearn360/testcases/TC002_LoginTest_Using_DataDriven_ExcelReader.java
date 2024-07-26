package com.itlearn360.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.itlearn360.pages.LoginPage;
import com.itlearn360.utilities.BaseTest;

public class TC002_LoginTest_Using_DataDriven_ExcelReader extends BaseTest {

	
	@Test
	public void loginTest_DataDriver_ExcelReader() throws IOException {
		
		LoginPage lp = new LoginPage(driver);
		
		
		//specify the location of excel file
		File src=new File("J:\\Eclipse programs\\itlearn360\\TestData\\ExcelReader.xlsx");
				
		//load the file
		FileInputStream fis= new FileInputStream(src);
				
		//load workbook
		XSSFWorkbook wb =new XSSFWorkbook(fis);
				
		//Load work sheet
		XSSFSheet sh=wb.getSheet("Login Credentials");
				
		//print the load sheet name
		System.out.println(sh.getSheetName());
		
		// Get the number of rows in the sheet
        int rowCount = sh.getLastRowNum();

        // Iterate through each row in the sheet
        for (int i = 1; i <= rowCount; i++) {
            // Get the row
            org.apache.poi.xssf.usermodel.XSSFRow row = sh.getRow(i);

            // Get the username and password from the row
            String username = row.getCell(0).getStringCellValue();
            String password = row.getCell(1).getStringCellValue();

            try {
                // Perform the login test using the username and password
                lp.loginToPortal(username, password);

                // Check if login was successful
                if (driver.getTitle().contains("ITLearn360")){
    	            // Login success
    	            System.out.println("Login successful");
    	            System.out.println("Title of Dashboard Page: " + driver.getTitle());
    	            
    	            
    	            //change here the name of test case you needs to get screenshot
    	            captureScreenShot(driver, "TC002_LoginTest_Using_DataDriven_ExcelReader_Screenshot_success");
                    
                } else {
                    System.out.println("Login failure");

                    // Retrieve error message from webpage
                    WebElement errorMessageElement = driver.findElement(By.xpath("//*[@id=\"login_error\"]"));
                    String errorMessage = errorMessageElement.getText();
                    System.out.println("Error message: " + errorMessage);

                    // Capture screenshot
                  //change here the name of test case you needs to get screenshot
                    captureScreenShot(driver, "TC002_LoginTest_Using_DataDriven_ExcelReader_Screenshot_failure");
                }
            } catch (Exception e) {
                System.out.println("Error occurred: " + e.getMessage());
                e.printStackTrace();

                // Capture screenshot
              //change here the name of test case you needs to get screenshot
                captureScreenShot(driver, "TC002_LoginTest_Using_DataDriven_ExcelReader_Screenshot_error occurred");
            }
        }
    }
            
            
            
            
            
            
        
    }
		
       
     


