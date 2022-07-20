package com.cydeo.tests.day03_Tasks_cssSelector_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {

    public static void main(String[] args) {

        //TC #1: NextBaseCRM, locators and getText() practice
        //1- Open a Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        //2- Go to: https://login1.nextbasecrm.com/
        driver.navigate().to("https://login1.nextbasecrm.com/");


        //3- Enter incorrect username: “incorrect”
        WebElement loginInput = driver.findElement(By.className("login-inp"));
        loginInput.sendKeys("incorrect");


        //4- Enter incorrect password: “incorrect”
        WebElement passwordInput = driver.findElement(By.name("USER_PASSWORD"));
        passwordInput.sendKeys("incorrect");


        //5- Click to log in button.
        WebElement logInButton = driver.findElement(By.className("login-btn"));
        logInButton.click();


        //6- Verify error message text is as expected:
        //Expected: Incorrect login or password
        WebElement errorMessage = driver.findElement(By.className("errortext"));
        String actualErrorMessage = errorMessage.getText();
        String expectedErrorMessage = "Incorrect login or password";

        if (actualErrorMessage.equals(expectedErrorMessage)) {
            System.out.println("Error message verification Passed!");
        } else {
            System.out.println("Error message verification Failed!");
        }

        driver.close();


        //PS: Inspect and decide which locator you should be using to locate web
        //elements
    }
}
