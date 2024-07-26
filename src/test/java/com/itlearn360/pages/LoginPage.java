package com.itlearn360.pages;






import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;





public class LoginPage  {

	private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"loginlabel\"]")
    private WebElement loginButton;

    @FindBy(name = "log")
    private WebElement usernameField;

    @FindBy(name = "pwd")
    private WebElement passwordField;

    @FindBy(name = "wp-submit")
    private WebElement submitButton;

    public void loginToPortal(String username, String password) {
        // Clicking on login button
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();

        // Entering username
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("log")));
        usernameField.sendKeys(username);
        System.out.println("Username entered: " + usernameField.getAttribute("value"));

        // Entering password
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("pwd")));
        passwordField.sendKeys(password);
        System.out.println("Password entered: " + passwordField.getAttribute("value"));

        // Clicking on submit button
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submitButton.click();
    }
}

