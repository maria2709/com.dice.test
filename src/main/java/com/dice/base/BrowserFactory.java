package com.dice.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {
    public static WebDriver getDriver(String browser) {
   //     log.info("Starting browser " + browser);
        WebDriver driver;
        switch (browser) {
            case "safari":
                driver = new SafariDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver_107");
                driver = new ChromeDriver();
                break;
        }
        driver.manage().window().maximize();
        return driver;
    }
}
