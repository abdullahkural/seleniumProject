package com.cydeo.tests.day11_Driver_Close_Actions_JSexecuter_Practices;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task7 {

    WebDriver driver;

    @Test
    public void test(){

        //TC #7: Scroll using JavascriptExecutor
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/large
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://practice.cydeo.com/large");

        //Locate the links as web element
        WebElement cydeoLink = driver.findElement(By.linkText("CYDEO"));
        WebElement homeLink = driver.findElement(By.linkText("Home"));

        //To be able to use the JavascriptExecuter for scrolling down, we have to downcast our driver type
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //3- Scroll down to “Cydeo” link
        js.executeScript("arguments[0].scrollIntoView(true)", cydeoLink);
        /*arguments[0].scrollIntoView(true) means get me the argument index number 0 and scrollIntoView
        index number 0 because we can have more than one: "arguments[0].scrollIntoView(true)", cydeoLink, homeLink
        js.executeScript("arguments[0].scrollIntoView(true)", cydeoLink, homeLink, someOtherLink);

            We are trying to use a JavaScript function (method) which selects the web elements by index number, and scrolls until they are in the view.

                js.executeScript("        --> this method accepts and applies the javascript method
                arguments[0]            --> here we are passing the index number of the argument
                .scrollIntoView(true)"    --> scroll until the argument[0] is in visible on the screen
                , cydeoLink);            --> this is where we pass our arguments

                js.executeScript("arguments[1].scrollIntoView(true)", cydeoLink, homeLink, someOtherLink); means get homeLink

         */

        //4- Scroll up to “Home” link
        js.executeScript("arguments[1].scrollIntoView(true)", cydeoLink, homeLink);
        // or also possible as --> js.executeScript("arguments[0].scrollIntoView(true)", homeLink);


        //5- Use below provided JS method only
        //JavaScript method to use : arguments[0].scrollIntoView(true)
        //Note: You need to locate the links as web elements and pass them as arguments into executeScript() method


    }

}
