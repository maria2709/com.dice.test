package com.dice.base;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePageObject<T> {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected BasePageObject(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofMillis(500L));
    }

    protected T getPage(String url){
        driver.get(url);
        return (T) this;
    }

    protected void type(String text, By element){
        findElement(element).sendKeys(text);
    }

    private WebElement findElement(By element) {
        return driver.findElement(element);
    }

    protected void click(By submitButton) {
        findElement(submitButton).click();
    }

    protected void waitOfVisibilityOf(By locator, Duration timeoutInSeconds){
        int attempts = 0;
        while (attempts < 2) {
            try {
                waitForCondition(ExpectedConditions.visibilityOfElementLocated(locator), timeoutInSeconds);
                break;
            } catch (StaleElementReferenceException e){
            }
            attempts++;
        }
    }

    private void waitForCondition(ExpectedCondition<WebElement> condition, Duration timeOutInSeconds){
        timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : Duration.ofSeconds(30);
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(condition);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getText(By element) {
        return findElement(element).getText();
    }
}
