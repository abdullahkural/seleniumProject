package com.cydeo.tests.day06_Alerts_IFrames_Windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task2_Alert {

    //TC #2: Confirmation alert practice
    public WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //1. Open browser
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to website: http://practice.cydeo.com/javascript_alerts
        driver.navigate().to("http://practice.cydeo.com/javascript_alerts");
    }

    @Test
    public void test(){
        //3. Click to “Click for JS Confirm” button


        //4. Click to OK button from the alert


        //5. Verify “You clicked: Ok” text is displayed.
    }

    @AfterMethod
    public void tearDrop(){
        driver.close();
    }

}
