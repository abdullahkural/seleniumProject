package com.cydeo.tests.day10_Upload_Actions_JSexecuter;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task6_Scroll {

    WebDriver driver;
    //Driver.getDriver() ile calismadigi icin eski yonteme dondum!

    @Test
    public void test(){

        //TC #6: Scroll using JavascriptExecutor
        //1- Open a chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        assert driver != null;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2- Go to: https://practice.cydeo.com/infinite_scroll
        driver.get("https://practice.cydeo.com/infinite_scroll");


        //3- Use below JavaScript method and scroll
        //also possible as:    ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,750)");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        for (int i = 0; i < 10; i++) {
            js.executeScript("window.scrollBy(0,750)");     //if I write -750 it is going to upside
        }

        for (int i = 0; i < 10; i++) {
            js.executeScript("window.scrollBy(0,-750)");     //now it will go back to beginning position

        }


        //a. 750 pixels down 10 times.
        //b. 750 pixels up 10 times
        //JavaScript method to use : window.scrollBy(0,0)
    }
}
