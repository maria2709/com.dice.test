package com.dice.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    protected void beforeClassSetupClass(ITestContext ctx){

        String testName = ctx.getCurrentXmlTest().getName();
 //       log.info("Test name" + testName);
    }

    @AfterClass
    protected void afterClass(){
 //       log.info("After class...");
    }

    @Parameters ({ "browser" })
    @BeforeMethod
    protected void setUp(String browser) {
        driver = BrowserFactory.getDriver(browser);
    }

    @AfterMethod
    protected void tearDown() {
        driver.quit();

   //     log.info("Test finished.");
    }

}
