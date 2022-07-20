package com.cydeo.tests.day07_Webtables_Utilities_Javafaker;

import com.cydeo.utilities.BrowserUtils_Tas2_day7;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task01_WindowHandlingTest {

    //TC #1: Window Handle practice

    public WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //1. Create new test and make set ups
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to : https://www.amazon.com
        driver.get("https://www.amazon.com");
    }



    @Test
    public void windowHandlingTest(){
        //3. Copy-paste the lines from below into your class
        ((JavascriptExecutor) driver).executeScript("window.open('https://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://facebook.com','_blank');");

        //4. Create a logic to switch to the tab where Etsy.com is open
        /*in order to print out all window handles
        for (String each : driver.getWindowHandles()){
            System.out.println(each);
        } Will print:
        CDwindow-62E0D7AA0A817D3B3C3DBA89C9D54402
        CDwindow-FA379F7F13F2F51FF7D939B38BA944CB
        CDwindow-E30CDDDDCAEF6E5B9A0953D49BB31AFB
        CDwindow-612DBD061A3A5A26005747E9DDCD63ED*/

        BrowserUtils_Tas2_day7.switchWindowAndVerify(driver,"etsy", "Etsy");



        //Lines to be pasted:
        //((JavascriptExecutor) driver).executeScript("window.open('https://google.com','_blank');");
        //((JavascriptExecutor) driver).executeScript("window.open('https://etsy.com','_blank');");
        //((JavascriptExecutor) driver).executeScript("window.open('https://facebook.com','_blank');");
        //These lines will simply open new tabs using something called JavascriptExecutor
        //and get those pages. We will learn JavascriptExecutor later as well.
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
