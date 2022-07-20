package com.cydeo.utilities;

//In this class only general utility methods that are not related to some specific page.

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BrowserUtils_Tas2_day7 {

    //This method will accept int (in seconds) and executes Thread.sleep for given duration
    public static void sleep(int second){
        second *= 1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {

        }
    }

    /*TC #2: Create utility method (Day7)
    1. Create a new class called BrowserUtils
    2. Create a method to make Task1 logic re-usable
    3. When method is called, it should switch window and verify title.
    Method info:
    • Name: switchWindowAndVerify
    • Return type: void
    • Arg1: WebDriver
    • Arg2: String expectedInUrl
    • Arg3: String expectedTitle*/

    /*I do not want to create the objects of this class. So it is static
    This method accepts 3 arguments
        Arg1- webDriver
        Arg2- expectedInURL: to verify if the URL contains given String
                If condition matches, will break loop.
        Arg3- expectedInTitle: to compared against actualTitle
     */
    public static void switchWindowAndVerify(WebDriver driver, String expectedInURL, String expectedInTitle){

        Set<String> allWindowsHandles = driver.getWindowHandles();

        for (String each : allWindowsHandles) {

            driver.switchTo().window(each);
            System.out.println("Current URL: " + driver.getCurrentUrl());

            if (driver.getCurrentUrl().contains(expectedInURL)){
                break;
            }
        }

        //5. Assert: Title contains “Etsy”
        //driver.switchTo().window("Etsy");
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedInTitle));

    }


    //This method accepts a String expectedTitle and asserts if it is true
    public static void verifyTitle(WebDriver driver, String expectedTitle){
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }

    //Creating a utility method for ExplicitWait, so we d npt have to repeat the lines
    public static void waitForInvisibilityOf(WebElement webElement){

        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf(webElement));

    }
}
