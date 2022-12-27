package com.dice;

import com.dice.base.BaseTest;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;

public class FirstTest extends BaseTest {

    @Test
    public void firstTestMethodChrome() {
        String URL = "http://dice.com";
        driver.get(URL);
        System.out.println(URL);
    }

    @Test
    public void secondTestMethodChrome() {
/*        String URL = "http://linkedin.com";
        driver.get(URL);
        System.out.println(URL);*/
        int x = 1;
        x *= 2;
        int x1 = 2;
        x1 *= 2;
        System.out.println(x);
        System.out.println(x1);
    }

}
