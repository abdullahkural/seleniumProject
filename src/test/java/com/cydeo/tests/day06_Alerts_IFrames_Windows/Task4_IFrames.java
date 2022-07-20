package com.cydeo.tests.day06_Alerts_IFrames_Windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task4_IFrames {

    //TC #4: Iframe practice
    public WebDriver driver;

    //1. Create a new class called: T4_Iframes
    //2. Create new test and make set ups
    //3. Go to: https://practice.cydeo.com/iframe
    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/iframe");
    }

    //@Ignore
    @Test
    public void test(){
        //4. Assert: “Your content goes here.” Text is displayed.
        //we need to switch the driver's focus to iframe

        //option #1- switching to iframe by using id attribute of iframe
        //driver.switchTo().frame("mce_0_ifr");

        //option #2- switching to iframe by using index number of iframe
        //driver.switchTo().frame(1); //there is only 1 iframe. If there were more we can write 2,3,4...

        //option #2- switching to iframe by using webElement and pass in frame() method
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']")));

        //p[.='Your content goes here.']
        WebElement yourContentGoesHereText = driver.findElement(By.xpath("//p"));
        //NoSuchElementException is given. Because we did not switch the driver to IFrame

        Assert.assertTrue(yourContentGoesHereText.isDisplayed(), "Text is NOT displayed!");

        //5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor” header is displayed
        //to be able to verify the header, we must switch back to "main HTML"
        driver.switchTo().parentFrame();
        WebElement headerText = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(headerText.isDisplayed());

    }

    @AfterMethod
    public void tearDrop(){
        driver.close();
    }

}
