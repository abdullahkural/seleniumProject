package com.cydeo.utilities;

//TASK: NEW METHOD CREATION
//Method name: getDriver
//Static Method
//Accepts String arg: browser type
//  - This arg will determine what type of browser is opened
//  - if "chrome" passed --> it will open chrome browser
//  - if "firefox" passed --> it will open firefox browser
// Return type: "WebDriver"

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {

    public static WebDriver getDriver(String browserType){

        if (browserType.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else if (browserType.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            return new ChromeDriver();
        } else {
            System.out.println("Given browser type does not exist!");
            System.out.println("Driver= null");
            return null;
        }

    }



}
