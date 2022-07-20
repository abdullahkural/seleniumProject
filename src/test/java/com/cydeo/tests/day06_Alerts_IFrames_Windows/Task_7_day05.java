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

public class Task_7_day05 {

    //TC #7: Selecting value from non-select dropdown

    public WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/dropdown
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://practice.cydeo.com/dropdown");
    }

    @Test
    public void test(){

        //3. Click to non-select dropdown
        WebElement nonSelectDropdown = driver.findElement(By.xpath("//a[@id='dropdownMenuLink']"));

        //4. Select Facebook from dropdown
        nonSelectDropdown.click();
        driver.findElement(By.xpath("//a[text()='Facebook']")).click();

        //5. Verify title is “Facebook - Log In or Sign Up”
        String actualTitle = driver.getTitle();
        String expectedTitle = "Facebook - Log In or Sign Up";
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }

}
