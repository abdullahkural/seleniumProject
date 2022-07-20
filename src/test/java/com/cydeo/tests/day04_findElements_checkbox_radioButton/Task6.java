package com.cydeo.tests.day04_findElements_checkbox_radioButton;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task6 {

    public static void main(String[] args) {

        //TC #6: StaleElementReferenceException Task
        //1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();

        //2- Go to: https://practice.cydeo.com/abtest
        driver.navigate().to("https://practice.cydeo.com/abtest");

        //3- Locate “CYDEO” link, verify it is displayed.
        WebElement cydeoLink = driver.findElement(By.xpath("//a[contains(@target,'bla')]"));
        System.out.println("cydeoLink.isDisplayed() = " + cydeoLink.isDisplayed());

        //4- Refresh the page.
        driver.navigate().refresh();

        //When we execute "driver.navigate().refresh();" it gives "StaleElementReferenceException"
        //In order to solve:
        //We are refreshing the web element reference by re-assigning (re-locating) the web element
        cydeoLink = driver.findElement(By.xpath("//a[contains(@target,'bla')]"));

        //5- Verify it is displayed, again.
        //This is a simple StaleElementReferenceException to understand what is this exception and how to handle it.
        System.out.println("cydeoLink.isDisplayed() = " + cydeoLink.isDisplayed());

        driver.close();






    }
}
