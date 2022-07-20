package com.cydeo.tests.day05_DynamicWebElements_TestingIntro_DropDowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Task1_StaleElementRefException {

    public static void main(String[] args) throws InterruptedException {

        //XPATH PRACTICES
        //DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
        //TC #1: StaleElementReferenceException handling
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to https://practice.cydeo.com/add_remove_elements/
        driver.get("https://practice.cydeo.com/add_remove_elements/");

        //3. Click to “Add Element” button
        WebElement addElementButton = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
                                                                    ////button[.='Add Element']
        Thread.sleep(2000);
        addElementButton.click();


        //4. Verify “Delete” button is displayed after clicking.
        WebElement deleteButton = driver.findElement(By.xpath("//button[.='Delete']"));
        System.out.println("deleteButton.isDisplayed() = " + deleteButton.isDisplayed());

        //5. Click to “Delete” button.
        //When I click delete button again it gives "StaleElementReferenceException"
        //Because when I re-click the web element is deleted
        //So that I am going to use try-catch
        Thread.sleep(1000);
        deleteButton.click();

        //6. Verify “Delete” button is NOT displayed after clicking.
        try{
            System.out.println("deleteButton.isDisplayed() = " + deleteButton.isDisplayed());
        } catch (StaleElementReferenceException e){
            System.out.println("-->StaleElementReferenceException is thrown");
            System.out.println("-->his means the web element is completely deleted from the page");
            System.out.println("deleteButton.isDisplayed() = false");
        }


        //USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS

        driver.close();
    }
}
