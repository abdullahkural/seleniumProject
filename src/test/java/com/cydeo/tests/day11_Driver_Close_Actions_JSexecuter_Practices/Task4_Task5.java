package com.cydeo.tests.day11_Driver_Close_Actions_JSexecuter_Practices;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task4_Task5 {

    WebDriver driver;

    @Test
    public void test(){

        //TC #4: Scroll practice
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://practice.cydeo.com/");

        //3- Scroll down to “Powered by CYDEO”
        //Create actions object and pass our "driver" instance
        Actions action = new Actions(driver);
        //Locate the “Powered by CYDEO” link
        WebElement poweredByCydeoLinkBottom = driver.findElement(By.xpath("//a[@target='_blank']"));
        //WebElement poweredByCydeoLinkBottom = driver.findElement(By.linkText("CYDEO"));

        //4- Scroll using Actions class “moveTo(element)” method
        action.moveToElement(poweredByCydeoLinkBottom).pause(4000).perform();


        //TC #5: Scroll practice 2
        //1- Continue from where the Task 4 is left in the same test.
        //2- Scroll back up to “Home” link using PageUP button
        WebElement homeLink = driver.findElement(By.xpath("//a[@class='nav-link']"));
        action.sendKeys(Keys.PAGE_UP).perform();
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
