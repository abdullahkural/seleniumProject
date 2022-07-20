package com.cydeo.tests.day12_PageObjectModel_Synchronization;

import com.cydeo.pages.DynamicLoad7Page;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task4 {

    //Day 12 Task4

    @Test
    public void test(){

        //TC#4 : Dynamically Loaded Page Elements 7
        //1. Go to https://practice.cydeo.com/dynamic_loading/7
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/7");


        //2. Wait until title is “Dynamic title”
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.titleIs("Dynamic title"));

        //3. Assert: Message “Done” is displayed.
        DynamicLoad7Page dynamicLoad7Page = new DynamicLoad7Page();
        Assert.assertTrue(dynamicLoad7Page.doneMessage.isDisplayed());

        //4. Assert: Image is displayed.
        //Note: Follow POM
        Assert.assertTrue(dynamicLoad7Page.image.isDisplayed());
    }
}
