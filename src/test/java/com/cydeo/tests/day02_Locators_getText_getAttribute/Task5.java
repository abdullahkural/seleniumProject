package com.cydeo.tests.day02_Locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task5 {

    public static void main(String[] args) {

        //TC #5: getText() and getAttribute() method practice
        //1- Open a Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        //2- Go to: https://practice.cydeo.com/registration_form
        driver.navigate().to("https://practice.cydeo.com/registration_form");
        //driver.get("https://practice.cydeo.com/registration_form");


        //3- Verify header text is as expected:
        //Expected: Registration form
        WebElement headerText = driver.findElement(By.tagName("h2"));
        String actualHeaderText = headerText.getText();
        String expectedHeaderText = "Registration form";

        if (actualHeaderText.equals(expectedHeaderText)) {
            System.out.println("Verification Passed!");
        } else {
            System.out.println("Verification Failed!");
        }

        //4- Locate “First name” input box
        WebElement firstNameInput = driver.findElement(By.name("firstname"));
        String actualPlaceHolder = firstNameInput.getAttribute("placeholder");
        String expectedPlaceHolder = "first name";


        //5- Verify placeholder attribute’s value is as expected:
        //Expected: first name

        if(actualPlaceHolder.equals(expectedPlaceHolder)) {
            System.out.println("Place Holder Verification Passed!");
        } else {
            System.out.println("Place Holder Verification Failed!");
        }

        driver.close();

    }
}
