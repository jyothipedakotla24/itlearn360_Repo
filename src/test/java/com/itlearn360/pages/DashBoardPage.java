package com.itlearn360.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashBoardPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	
	public DashBoardPage(WebDriver driver) {
	
	this.driver = driver;
    this.wait = new WebDriverWait(driver, 10);
    PageFactory.initElements(driver, this);
	
	}
	
	
	 @FindBy(xpath = "//*[@id=\"login-list\"]/li[1]/a")
	 WebElement dashBoardClick;
	
	 
	 @FindBy(xpath = "//*[@id=\"learn-press-user-profile\"]/ul/li[3]/a")
	 WebElement offerAcademiesClick;
	 
	 
	 @FindBy(xpath = "//*[@id=\"tab-academies\"]/div/div/ul/li[4]/form/div/button")
	 WebElement subscribeButton;
	
	 
	 public void dashBoardClick() {
		 
		 wait.until(ExpectedConditions.elementToBeClickable(dashBoardClick)).click();
		 
		 wait.until(ExpectedConditions.elementToBeClickable(offerAcademiesClick)).click();
		    
		 wait.until(ExpectedConditions.elementToBeClickable(subscribeButton)).click();
		
	 }
	
	
	}






