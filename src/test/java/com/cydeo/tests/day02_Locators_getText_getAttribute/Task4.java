package com.cydeo.tests.day02_Locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task4 {

    public static void main(String[] args) {

        //TC #4: Library verifications
        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        //2. Go to http://library2.cybertekschool.com/login.html
        driver.navigate().to("http://library2.cybertekschool.com/login.html");


        //3. Enter username: “incorrect@email.com”
        //PS: Locate username input box using “className” locator
        WebElement userNameInput = driver.findElement(By.className("form-control"));
        userNameInput.sendKeys("incorrect@email.com");


        //4. Enter password: “incorrect password”
        //Locate password input box using “id” locator
        //Locate Sign in button using “tagName” locator
        WebElement passwordInput = driver.findElement(By.id("inputPassword"));
        passwordInput.sendKeys("incorrect password");

        WebElement signInButton = driver.findElement(By.tagName("button"));
        signInButton.click();



        //5. Verify: visually “Sorry, Wrong Email or Password” displayed
        WebElement alertMessage = driver.findElement(By.className("alert"));
        String message = alertMessage.getText();

        if (message.equalsIgnoreCase("Sorry, Wrong Email or Password")){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }




    }
}
