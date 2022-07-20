package com.cydeo.tests.day02_Locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task3 {

    public static void main(String[] args) {

        //TC#3: Google search:
        //1- Open a Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        //2- Go to: https://google.com
        driver.navigate().to("https://google.com");


        //3- Write “apple” in search box
        //go to https://google.com and inspect the search box. As I find element by name find the name of the attribute and write it
        //4- Please Enter by using Keys.ENTER
        WebElement googleSearchBox = driver.findElement(By.name("q"));
        googleSearchBox.sendKeys("apple" + Keys.ENTER);


        //5- Verify title:
        //Expected: Title should start with “apple” word
        String actualTitle = driver.getTitle();
        String expectedTitle = "apple";
        if (actualTitle.startsWith(expectedTitle)) {
            System.out.println("Title verification Passed!");
        } else {
            System.out.println("Title verification Failed!");
        }
        driver.close();
    }
}
