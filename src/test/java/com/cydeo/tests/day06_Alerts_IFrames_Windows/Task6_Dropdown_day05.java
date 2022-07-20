package com.cydeo.tests.day06_Alerts_IFrames_Windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task6_Dropdown_day05 {

    //TC #6: Selecting date on dropdown and verifying

    public WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");
    }


    @Test
    public void dropdowns_Task6(){

        //3. Select “December 1st, 1923” and verify it is selected.
        Select yearDropdown = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        Select dayDropdown = new Select(driver.findElement(By.xpath("//select[@id='day']")));

        //Select year using : visible text
        yearDropdown.selectByVisibleText("1923");

        //Select month using : value attribute
        monthDropdown.selectByValue("11");

        //Select day using : index number
        dayDropdown.selectByIndex(0);

        Assert.assertEquals(yearDropdown.getFirstSelectedOption().getText(), "1923");
        Assert.assertEquals(monthDropdown.getFirstSelectedOption().getText(), "December");
        Assert.assertEquals(dayDropdown.getFirstSelectedOption().getText(), "1");

    }

    @AfterMethod
    public void teardownMethod(){
        driver.close();
    }
}
