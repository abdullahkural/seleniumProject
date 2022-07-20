package com.cydeo.tests.day06_Alerts_IFrames_Windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task1_Alert {

    //TC #1: Information alert practice
    public WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //1. Open browser
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();

        //2. Go to website: http://practice.cydeo.com/javascript_alerts
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cydeo.com/javascript_alerts");
    }

    @Test
    public void alertsTest1(){
        //3. Click to “Click for JS Alert” button                       for the text I use "."
        WebElement clickForJSAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        clickForJSAlertButton.click();

        //4. Click to OK button from the alert
        //to be able to click "Alert OK button" we need to switch driver's focus to Alert itself
        Alert alert = driver.switchTo().alert();
        alert.accept();

        //5. Verify “You successfully clicked an alert” text is displayed.
        WebElement alertText = driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertTrue(alertText.isDisplayed(), "Result text is NOT displayed!");
    }

    @AfterMethod
    public void tearDrop(){
        driver.close();
    }

}

