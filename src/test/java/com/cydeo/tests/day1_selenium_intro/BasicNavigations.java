package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {

    public static void main(String[] args) throws InterruptedException {

        //1- Set-up the "Browser Driver"
        WebDriverManager.chromedriver().setup();

        //2- We create the instance and the object of the Selenium WebDriver
        //This is the line opening an empty browser
        WebDriver driver = new ChromeDriver();

        //This line will maximize the browser size
        driver.manage().window().maximize();

        //Makes the screen fullscreen, but
        //We do not use this one really so much
        //driver.manage().window().fullscreen();

        //3- Go to "https://www.tesla.com"
        driver.get("https://www.tesla.com");

        //Stop the code execution for 3 seconds
        Thread.sleep(3000);

        //use selenium to navigate back
        driver.navigate().back();

        //Stop the code execution for 3 seconds
        Thread.sleep(3000);

        //use selenium to navigate forward
        driver.navigate().forward();

        //Stop the code execution for 3 seconds
        Thread.sleep(3000);

        //use selenium to navigate refresh
        driver.navigate().refresh();

        //use navigate().to; method
        //driver.navigate().to("https://www.google.com");
        driver.navigate().to("https://www.tesla.com/models");

        //get the title of the page
        //System.out.println("driver.getTitle() = " + driver.getTitle()); OR
        String currentTitle  = driver.getTitle();
        System.out.println("currentTitle " + currentTitle);

        //get the current URL
        String currentURL = driver.getCurrentUrl();
        System.out.println("currentURL = " + currentURL);

        //this will close the currently opened window
        driver.close();

        //this will close all the opened windows
        driver.quit();




    }
}
