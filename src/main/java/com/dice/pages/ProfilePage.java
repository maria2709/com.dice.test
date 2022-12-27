package com.dice.pages;

import com.dice.base.BasePageObject;
import com.dice.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class ProfilePage extends BasePageObject {

    private By photoModal = By.xpath("//*[@id='contact-first-name']");
    private By profileName = By.xpath("//span[@id='contact-last-name']");

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public void waitForProfilePageOpened(){
        waitOfVisibilityOf(photoModal, Duration.ofSeconds(100));
    }

    public boolean isCorrectProfileLoaded(String correctProfile) {
        if (getText(profileName).equalsIgnoreCase(correctProfile))
            return true;
        else {
            return false;
        }

    }

}
