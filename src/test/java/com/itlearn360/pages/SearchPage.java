package com.itlearn360.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {

	 WebDriver driver;
	    WebDriverWait wait;

	    @SuppressWarnings("deprecation")
	    public SearchPage(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, 10);
	        PageFactory.initElements(driver, this);
	    }

	    @FindBy(name = "search_course")
	    WebElement searchInput;

	    @FindBy(xpath = "//*[@id=\"primary_menu\"]/nav[1]/form/button")
	    WebElement searchButton;

	    public void searchCourse(String courseName) {
	        searchInput.sendKeys(courseName);
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".modal-backdrop")));
	        searchButton.click();
    
	    }
	        
    
    
    
    
    
    
    
    
}

		

