package com.cydeo.tests.day13_Review_InterviewPractice;

import com.cydeo.pages.DoubleClickPage;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task1 {

    @Test
    public void test(){

        //TC #1: Double Click Test
        //1. Go to https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");


        Actions actions = new Actions(Driver.getDriver());
        DoubleClickPage doubleClickPage = new DoubleClickPage();

        actions.click(doubleClickPage.acceptButton).perform();

        //2. Switch to iframe.
        Driver.getDriver().switchTo().frame("iframeResult");


        //3. Double-click on the text “Double-click me to change my text color.”

        actions.doubleClick(doubleClickPage.doubleClickText).perform();

        //4. Assert: Text’s “style” attribute value contains “red”.
        //NOTE: FOLLOW POM
        String actualStyleValue = doubleClickPage.doubleClickText.getAttribute("style");
        Assert.assertEquals(actualStyleValue, "color: red;");

        Driver.closeDriver();

    }
}
