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

public class Task5_WindowHandle {

    //TC #5: Window Handle practice
    public WebDriver driver;

    //1. Create a new class called: T5_WindowsPractice
    //2. Create new test and make set ups
    //3. Go to : https://practice.cydeo.com/windows
    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/windows");
    }

    @Test
    public void multipleWindowTest(){

        //Storing the main page's window handle as String is a good practice for future re-usable purposes
        String mainHandle = driver.getWindowHandle();
        System.out.println("mainHandle = " + mainHandle);

        //4. Assert: Title is “Windows”
        Assert.assertEquals(driver.getTitle(), "Windows");

        System.out.println("Actual Title Before Click = " + driver.getTitle());

        //5. Click to: “Click Here” link        linkText("CLick Here"
        WebElement clickHereLink = driver.findElement(By.xpath("//a[@target='_blank']"));
        clickHereLink.click();

        System.out.println("Actual Title After Click = " + driver.getTitle());

        //6. Switch to new Window.
        for(String each : driver.getWindowHandles()) {
            driver.switchTo().window(each);
            System.out.println("Current title while switching windows: " + driver.getTitle());
        }


        //7. Assert: Title is “New Window”
        Assert.assertEquals(driver.getTitle(), "New Window");

        System.out.println("Actual Title After Switching Window = " + driver.getTitle());

        //if we want to go back to main page, we can use already stored main handle
        //driver.switchTo().window(mainHandle);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();      //it closes all the pages. Close only closes current window
    }
}
