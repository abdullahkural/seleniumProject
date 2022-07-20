package com.cydeo.tests.day13_Review_InterviewPractice;

import com.cydeo.pages.ExplicitWaitPage;
import com.cydeo.utilities.BrowserUtils_Tas2_day7;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task2_Task3 {

    ExplicitWaitPage explicitWaitPage;

    @BeforeMethod
    public void setUpMethod(){
        //TC #2: Explicit wait practice
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/dynamic_controls
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_controls");
        explicitWaitPage = new ExplicitWaitPage();
    }

    //Task2
    @Test
    public void test2(){

        //3- Click to “Remove” button
        explicitWaitPage.removeButton.click();

        //4- Wait until “loading bar disappears”
        /*
        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);//in order to issue of explicitly wait in this task we can also use implicitly wait
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf(explicitWaitPage.loadingBar));
        */
        //Instead of the commented lines above, we created a method in BrowserUtils
        BrowserUtils_Tas2_day7.waitForInvisibilityOf(explicitWaitPage.loadingBar);

        //5- Verify:
        //a. Checkbox is not displayed
        //Normally we have to check that Checkbox is not displayed. But it disappears/completely deleted from the page
        //So we use try catch block
        try {
            Assert.assertTrue(!explicitWaitPage.checkBox.isDisplayed());
            //OR: AssertFalse method will pass the test if the boolean value returned as false
            Assert.assertFalse(explicitWaitPage.checkBox.isDisplayed());
        } catch (NoSuchElementException n){
            Assert.assertTrue(true);
        }

        //b. “It’s gone!” message is displayed.
        //NOTE: FOLLOW POM
        Assert.assertTrue(explicitWaitPage.message.isDisplayed());
        //Assert.assertTrue(explicitWaitPage.message.getText().equals("It’s gone!")); is also possible

        Driver.closeDriver();
    }

    //Task3
    @Test
    public void test3(){

        //TC #3: Explicit wait practice
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/dynamic_controls

        //3- Click to “Enable” button
        explicitWaitPage.enableButton.click();

        //4- Wait until “loading bar disappears”
        //Calling our ExplicitWait utility method to wait loadingBar to disappear
        BrowserUtils_Tas2_day7.waitForInvisibilityOf(explicitWaitPage.loadingBar2);
        Assert.assertTrue(!explicitWaitPage.loadingBar2.isDisplayed());

        //5- Verify:
        //a. Input box is enabled.
        Assert.assertTrue(explicitWaitPage.enableButton.isDisplayed());

        //b. “It’s enabled!” message is displayed.
        //NOTE: FOLLOW POM
        Assert.assertTrue(explicitWaitPage.message.isDisplayed());
        Assert.assertTrue(explicitWaitPage.message.getText().equals("It’s enabled!"));

    }


}
