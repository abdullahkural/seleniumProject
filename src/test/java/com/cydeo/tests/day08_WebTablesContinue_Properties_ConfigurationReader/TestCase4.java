package com.cydeo.tests.day08_WebTablesContinue_Properties_ConfigurationReader;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCase4 {

    public WebDriver driver;

    @BeforeMethod
    public void setUp(){
        //TC #4: Google search
        //  1- Open a chrome browser
        //  2- Go to: https://google.com

        //it is going to accept the browser name as browser:
        //I am calling ConfigurationReader-getProperty method
        //browser is defined as "Chrome" in ConfigurationReader class in utilities
        String browserType = ConfigurationReader.getProperty("browser");

        driver = WebDriverFactory.getDriver(browserType);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://google.com");

        WebElement ikGaAkkordButton = driver.findElement(By.xpath("//button[@id='L2AGLb']"));
        ikGaAkkordButton.click();

    }

    @Test
    public void google_search_test(){

        //  3- Write “apple” in search box
        WebElement searchBox = driver.findElement(By.xpath("//input[@name='q']"));
        searchBox.sendKeys(ConfigurationReader.getProperty("searchValue") + Keys.ENTER);

        //  4- Verify title:
        //  Expected: apple - Google Search
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, ConfigurationReader.getProperty("searchValue") + " - Google Zoeken", "FAILED!");

    }

    @AfterMethod
    public void tearDown() {
       driver.close();
    }

    //TC #4: Google search
    //  1- Open a Chrome browser
    //  2- Go to: https://google.com
    //  3- Write “apple” in search box
    //  4- Verify title:
    //  Expected: apple - Google Search

    //Use `configuration.properties` for the following:
    //  1. The browser type
    //  2. The URL
    //  3. The search keyword
    //  4. Make title verification dynamic. If search value changes, title
    //assertion should not fail.
}
