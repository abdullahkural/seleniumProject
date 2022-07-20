package com.cydeo.tests.day02_Locators_getText_getAttribute.homeWorks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork3 {

    public static void main(String[] args) {

        //TC #3: Back and forth navigation
        //1- Open a Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        //2- Go to: https://google.com
        driver.navigate().to("https://google.com");

        WebElement ikGaAkkoordLink = driver.findElement(By.cssSelector("button[id='L2AGLb']"));
        ikGaAkkoordLink.click();

        //3- Click to Gmail from top right.
        WebElement gmailLink = driver.findElement(By.linkText("Gmail"));
        gmailLink.click();

        //4- Verify title contains:
        //Expected: Gmail
        String actualTitle1 = driver.getTitle();
        if (actualTitle1.contains("Gmail")) {
            System.out.println("Title verification 1 PASSED!");
        } else {
            System.out.println("Title verification 1 FAILED!");
        }

        driver.navigate().back();

        //5- Go back to Google by using the .back();
        //6- Verify title equals:
        //Expected: Google
        String actualTitle2 = driver.getTitle();
        if (actualTitle2.equals("Google")) {
            System.out.println("Title verification 2 PASSED!");
        } else {
            System.out.println("Title verification 2 FAILED!");
        }

        driver.close();
    }
}
