package com.cydeo.tests.day08_WebTablesContinue_Properties_ConfigurationReader;

import com.cydeo.utilities.WebDriverFactory;
import com.cydeo.utilities.WebTableUtils_Task02_Day08;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCase01_WebTablesPractice {

    public WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        //TC #1: Web table practice
        //1. Go to: https://practice.cydeo.com/web-tables
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/web-tables");
    }

    @Test
    public void order_name_verify_test(){
        //Locate the cell that Bob Martin text in it
        WebElement bobMartinCell = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']"));
        System.out.println("bobMartinCell.getText() = " + bobMartinCell.getText());

        //2. Verify Bob’s name is listed as expected.
        //Expected: “Bob Martin”
        String expectedBobName = "Bob Martin";
        String actualBobName = bobMartinCell.getText();
        Assert.assertEquals(actualBobName, expectedBobName);



        //3. Verify Bob Martin’s order date is as expected: 12/31/2021
        WebElement bobMartinDate = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']/following-sibling::td[3]"));
        Assert.assertEquals(bobMartinDate.getText(), "12/31/2021");


    }

    //the method that we created in WebTableUtils_Task02_Day08 class as returnOrderDate for Task02
    @Test
    public void test2(){
        String customerOrderDate1 = WebTableUtils_Task02_Day08.returnOrderDate(driver, "Alexandra Gray");
        System.out.println("customerOrderDate1 = " + customerOrderDate1);
    }

    //the method that we created in WebTableUtils_Task02_Day08 class as returnOrderDate for Task02
    @Test
    public void test3(){
        WebTableUtils_Task02_Day08.orderVerify(driver, "Ned Stark", "05/12/2021");
    }


    @AfterMethod
    public void tearDrop(){
        driver.quit();
    }























}
