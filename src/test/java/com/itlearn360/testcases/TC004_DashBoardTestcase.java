package com.itlearn360.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.itlearn360.pages.DashBoardPage;
import com.itlearn360.pages.LoginPage;
import com.itlearn360.utilities.BaseTest;
import com.itlearn360.utilities.ReadExcelFile;

public class TC004_DashBoardTestcase extends BaseTest {

	
	
	String fileName = "J:\\Eclipse programs\\itlearn360\\TestData\\ExcelReader.xlsx";
	
	@Test(priority = 1)
	void DashBoardTest() throws IOException  {
        LoginPage lp = new LoginPage(driver);
        String username = ReadExcelFile.getCellValue(fileName, "Login Credentials", 1, 0);
        String password = ReadExcelFile.getCellValue(fileName, "Login Credentials", 1, 1);
        lp.loginToPortal(username, password);
        
        
        DashBoardPage dp=new DashBoardPage(driver);
        
        dp.dashBoardClick();
        
        try {
            String expectedTitle ="Itlearn 360";
            String actualTitle = driver.getTitle();
            System.out.println("Title of Dashboard Page: " + actualTitle);

            if (actualTitle.contains(expectedTitle)) {
                System.out.println("successfully done for subscription");
                
                // 1).change here the name of test case you needs to get screenshot
                captureScreenShot(driver, "TC004_DashBoardTestcase_Screenshot_success");
            } else {
                System.out.println("failed subscription");
                
                // 2).change here the name of test case you needs to get screenshot
                captureScreenShot(driver, "TC004_DashBoardTestcase_Screenshot_failure");
            }
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
            
            // 3).change here the name of test case you needs to get screenshot
            captureScreenShot(driver, "TC004_DashBoardTestcase_Screenshot_error_occurred");
        }
    }
        
        
}


