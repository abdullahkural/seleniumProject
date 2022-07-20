package com.cydeo.tests.day05_DynamicWebElements_TestingIntro_DropDowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNG_Selenium {

    WebDriver driver;

    @BeforeMethod
    //BeforeMethod is going to be
    public void setUpMethod(){
        //Do browser driver setup
        //Open browser
        driver = WebDriverFactory.getDriver("Chrome");
        //maximize the page
        driver.manage().window().maximize();

        //Implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void afterMethod(){

    }

    //Selenium is a test automation to test browsers
    //TestNG is unit testing tool
    @Test
    public void selenium_test(){

        //get https://google.com
        driver.navigate().to("https://www.google.com");

        //Assert: title is "Google" (Assert means: "iddia etmek, soylemek, ileri surmek")
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";

        //at the end of parenthesis you can put one more coma and give a message. If the test fails you are going to see this message: , "Title is not matching here");
        Assert.assertEquals(actualTitle, expectedTitle, "Title is not matching here");

    }
}
