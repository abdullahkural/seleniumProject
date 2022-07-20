package com.cydeo.tests.day02_Locators_getText_getAttribute.homeWorks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork1 {

    public static void main(String[] args) throws InterruptedException {

        //TC #1: Etsy Title Verification
        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        //2. Go to https://www.etsy.com
        driver.get("https://www.etsy.com");

        WebElement acceptButton = driver.findElement(By.cssSelector("button[class='wt-btn wt-btn--filled wt-mb-xs-0']"));
        acceptButton.click();


        //3. Search for “wooden spoon”
        WebElement searchQuery = driver.findElement(By.name("search_query"));
        searchQuery.sendKeys("wooden spoon" + Keys.ENTER);


        //4. Verify title:
        //Expected: “Wooden spoon | Etsy
        String actualTitle = driver.getTitle();
        String expectedTitle = "Wooden spoon | Etsy";

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title verification PASSED!");
        } else {
            System.out.println("Title verification FAILED!");
        }

        driver.close();
    }
}
