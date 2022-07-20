package com.cydeo.tests.day11_Driver_Close_Actions_JSexecuter_Practices;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task11 {

    WebDriver driver;

    @Test
    public void test(){

        //TC #: Drag and drop
        //1. Go to https://demos.telerik.com/kendo-ui/dragdrop/index
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/index");

        //Locate acceptCookiesButton and click
        WebElement acceptCookiesButton = driver.findElement(By.id("onetrust-accept-btn-handler"));
        acceptCookiesButton.click();

        //2. Drag and drop the small circle to bigger circle.
        WebElement smallCircle = driver.findElement(By.id("draggable"));
        WebElement bigCircle = driver.findElement(By.id("droptarget"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(smallCircle, bigCircle).perform();

        //2nd way:
        //actions.clickAndHold(smallCircle).moveToElement(bigCircle).release(bigCircle).perform();

        //3. Assert:
        //-Text in big circle changed to: “You did great!”
        String actualBigCircleText = bigCircle.getText();
        String expectedBigCircleText = "You did great!";
        Assert.assertEquals(actualBigCircleText,expectedBigCircleText);
    }
}
