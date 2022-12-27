package com.dice.pages;

import com.dice.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePageObject<LoginPage> {

    private static final String URL = "https://www.dice.com/dashboard/login";
 //   private By emailField = By.id("email");
    private By emailField = By.xpath("//input[@id='email']");
 //   private By passwordField = By.id("password");
    private By passwordField = By.xpath("//input[@id='password']");

    private By submitButton = By.xpath("//button[@type='submit']");

    private By errorMessage = By. xpath("//*[@data-automation-id='login-failure-help-message']");
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openLoginPage(){
        getPage(URL);
    }

    public void fillUpCredentials(String email, String password){
        type(email, emailField);
        type(password, passwordField);
    }

    public ProfilePage pushSigninButton(){
        click(submitButton);
        return new ProfilePage(driver);
    }

    public String getLoginErrorMessage(){
        return getText(errorMessage);
    }
}
