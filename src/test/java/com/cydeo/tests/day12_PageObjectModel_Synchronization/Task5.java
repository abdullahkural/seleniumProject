package com.cydeo.tests.day12_PageObjectModel_Synchronization;

import com.cydeo.pages.DynamicallyLoadedPageElements1;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task5 {

    @Test
    public void test(){

        //TC#5 : Dynamically Loaded Page Elements 1
        //1. Go to https://practice.cydeo.com/dynamic_loading/1
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/1");

        //2. Click to start
        DynamicallyLoadedPageElements1 dynamicallyLoadedPageElements1 = new DynamicallyLoadedPageElements1();
        dynamicallyLoadedPageElements1.startButton.click();

        //3. Wait until loading bar disappears
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf(dynamicallyLoadedPageElements1.loadingBars));

        //4. Assert username inputbox is displayed
        Assert.assertTrue(dynamicallyLoadedPageElements1.inputUsername.isDisplayed());

        //5. Enter username: tomsmith
        dynamicallyLoadedPageElements1.inputUsername.sendKeys("tomsmith");

        //6. Enter password: incorrectpassword
        dynamicallyLoadedPageElements1.inputPassWord.sendKeys("incorrectpassword");

        //7. Click to Submit button
        dynamicallyLoadedPageElements1.submitButton.click();

        //8. Assert “Your password is invalid!” text is displayed.
        //Note: Follow POM Design Pattern
        Assert.assertTrue(dynamicallyLoadedPageElements1.errorMessage.isDisplayed());
    }
}
