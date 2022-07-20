package com.cydeo.tests.day02_Locators_getText_getAttribute.homeWorks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork4 {

    public static void main(String[] args) {

        //TC #4: Practice Cydeo – Class locator practice
        //1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://practice.cydeo.com/inputs
        driver.navigate().to("https://practice.cydeo.com/inputs");

        //3- Click to “Home” link
        WebElement homeButton = driver.findElement(By.className("navbar-nav"));
        homeButton.click();


        //4- Verify title is as expected:
        //Expected: Practice
        //PS: Locate “Home” link using “className” locator
        String actualTitle = driver.getTitle();
        if (actualTitle.equals("Practice")) {
            System.out.println("Title verification PASSED!");
        } else {
            System.out.println("Title verification FAILED!");
        }

        driver.close();
    }
}
