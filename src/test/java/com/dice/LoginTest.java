package com.dice;

import com.dice.base.BaseTest;
import com.dice.base.CsvDataProvider;
import com.dice.pages.LoginPage;
import com.dice.pages.ProfilePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Map;


public class LoginTest extends BaseTest {
    static Logger log = LogManager.getLogger();

    public String expectedPageTitle = "Dashboard Home Feed | Dice.com";
    public String correctProfileLastname = "Gaidayenko";
    public String expectedErrorMessage = "Email and/or password incorrect.";

    @Test
    public void openLoginPageAndLogin(){
        LoginPage loginPage = new LoginPage(driver);
        //Open login page
        log.info("Open login page");
        loginPage.openLoginPage();

        //Fill up credentials
        loginPage.fillUpCredentials("maryiagaydayenko@gmail.com", "Testtest2020");

        //Submit with the button
        ProfilePage profilePage = loginPage.pushSigninButton();

        //Verification
        log.info("Verifications: ");
        profilePage.waitForProfilePageOpened();
        Assert.assertEquals(profilePage.getPageTitle(), expectedPageTitle, "Page title is not expected");
        Assert.assertTrue(profilePage.isCorrectProfileLoaded(correctProfileLastname),"The lastname is incorrect" );
    }

    @Test (dataProvider = "CsvDataProvider", dataProviderClass = CsvDataProvider.class)
    public void negativeLoginPageAndLogin(Map<String, String> testData){
        log.info("Login page is opening: ");
        LoginPage loginPage = new LoginPage(driver);
        String testNumber = testData.get("no");
        String email = testData.get("email");
        String password = testData.get("password");
        String description = testData.get("description");

        log.info("Test N = " + testNumber +"/n");
        //Open login page
        loginPage.openLoginPage();

        //Fill up credentials
        loginPage.fillUpCredentials(email, password);

        //Submit with the button
        loginPage.pushSigninButton();

        //Verification of the error
        log.info("Verifications: ");
        Assert.assertTrue(loginPage.getLoginErrorMessage().contains(expectedErrorMessage));
    }

}
