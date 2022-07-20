package com.cydeo.tests.day05_DynamicWebElements_TestingIntro_DropDowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task4_DropDown {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //TC#4: Verifying “Simple dropdown” and “State selection” dropdown
        //default values
        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to https://practice.cydeo.com/dropdown
        driver.navigate().to("https://practice.cydeo.com/dropdown");
    }


    @Test
    public void simpleDropdownTest(){
        //3. Verify “Simple dropdown” default selected value is correct
        //Expected: “Please select an option”
        Select simpleDropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
        //getFirstSelectedOption() gives selected option as default
        WebElement currentlySelectedOption = simpleDropdown.getFirstSelectedOption();

        String actualSelectedOption = currentlySelectedOption.getText();
        String expectedSelectedOption = "Please select an option";
        System.out.println("actualSelectedOption = " + actualSelectedOption);

        Assert.assertEquals(actualSelectedOption, expectedSelectedOption, "Failed");



        //4. Verify “State selection” default selected value is correct
        //Expected: “Select a State”
        Select stateSelectionDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        String actualStateSelection = stateSelectionDropdown.getFirstSelectedOption().getText();
        String expectedStateSelection = "Select a State";

        Assert.assertEquals(actualStateSelection, expectedStateSelection);

        //OR
        //Assert.assertEquals(stateSelectionDropdown.getFirstSelectedOption().getText(), "Select a State");



    }


}
