package com.cydeo.tests.day10_Upload_Actions_JSexecuter;

import com.cydeo.utilities.BrowserUtils_Tas2_day7;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task3_Actions_Hover {


    @Test
    public void hoveringTest(){
        //TC #3: Hover Test
        //1. Go to https://practice.cydeo.com/hovers
        Driver.getDriver().get("https://practice.cydeo.com/hovers");


        //Locate all images under here
        WebElement img1 = Driver.getDriver().findElement(By.xpath("//img[1]"));
        WebElement img2 = Driver.getDriver().findElement(By.xpath("//img[2]"));
        WebElement img3 = Driver.getDriver().findElement(By.xpath("//img[3]"));

        //Locate all the user texts
        WebElement textImg1 = Driver.getDriver().findElement(By.xpath("//h5[text()='name: user1']"));
        WebElement textImg2 = Driver.getDriver().findElement(By.xpath("//h5[text()='name: user2']"));
        WebElement textImg3 = Driver.getDriver().findElement(By.xpath("//h5[text()='name: user3']"));

        //Locate all the view profile links of the images
        WebElement viewProfileLink1 = Driver.getDriver().findElement(By.xpath("//a[@href='/users/1']"));
        WebElement viewProfileLink2 = Driver.getDriver().findElement(By.xpath("//a[@href='/users/2']"));
        WebElement viewProfileLink3 = Driver.getDriver().findElement(By.xpath("//a[@href='/users/3']"));

        //2. Hover over to first image (Hover means bring your mouse and wait)
        BrowserUtils_Tas2_day7.sleep(2);
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(img1).perform();


        //3. Assert:
        //a. “name: user1” is displayed
        //b. “view profile” is displayed
        Assert.assertTrue(textImg1.isDisplayed());


        //4. Hover over to second image
        action.moveToElement(img2);

        //5. Assert:
        //a. “name: user2” is displayed
        //b. “view profile” is displayed
        Assert.assertTrue(textImg2.isDisplayed());
        Assert.assertTrue(viewProfileLink2.isDisplayed());


        //6. Hover over to third image
        action.moveToElement(img3);
        //7. Confirm:
        //a. “name: user3” is displayed
        //b. “view profile” is displayed
        Assert.assertTrue(textImg3.isDisplayed());
        Assert.assertTrue(viewProfileLink3.isDisplayed());
    }

}
