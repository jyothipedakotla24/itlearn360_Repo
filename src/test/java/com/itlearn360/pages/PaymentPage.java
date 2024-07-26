package com.itlearn360.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage {
	
	
	WebDriver driver;
	WebDriverWait wait;
	
	
	public PaymentPage(WebDriver driver)
	{
		this.driver = driver;
	    this.wait = new WebDriverWait(driver, 10);
	    PageFactory.initElements(driver, this);
	}
	

	 @FindBy(xpath = "//*[@id=\"learn-press-payment\"]/ul/li/label")
	 WebElement payWithStripeRadioButton;
	 
	 @FindBy(xpath = "//*[@id=\"learn-press-checkout-place-order\"]")
	 WebElement placeOrderButton; 
	 
	 @FindBy(xpath="//*[@id=\"card-element\"]/div/iframe") WebElement frameelement;
		
     @FindBy(name="cardnumber") WebElement cardnumber;
		
     @FindBy(name="exp-date") WebElement expirydate;
		
	@FindBy(name="cvc") WebElement cvc;
		
	@FindBy(id="payment-button") WebElement payButton;
	
	
	public void paymentOption(String cardnum,String exedate, String cvcnum) {
		payWithStripeRadioButton.click();
		
		//if it is a <input> tap than we needs to give submi() and not click()
		placeOrderButton.submit();
		
		//this will switch to another window
		driver.switchTo().frame(frameelement);
		
		cardnumber.sendKeys(cardnum);
		
		expirydate.sendKeys(exedate);
		
		cvc.sendKeys(cvcnum);
		
		//come bach to main frame
		driver.switchTo().defaultContent();
		payButton.click();
		
		
		
	}
	 
	
}
