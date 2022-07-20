package com.cydeo.tests.day12_PageObjectModel_Synchronization;

import com.cydeo.pages.LibraryLoginPage;
import com.cydeo.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class POMPractices {

    //Day12 Task1, Task2, Task3

    LibraryLoginPage libraryLoginPage;

    @BeforeMethod
    public void setUpMethod(){
        Driver.getDriver().get("https://library1.cydeo.com");
        libraryLoginPage = new LibraryLoginPage();
    }

    @Test
    //Task1 of Day12
    public void test1(){

        //TC #1: Required field error message test
        //1- Open a chrome browser
        //2- Go to: https://library1.cydeo.com

        //3- Do not enter any information
        //4- Click to “Sign in” button

        libraryLoginPage.signInButton.click();

        //5- Verify expected error is displayed:
        //Expected: This field is required.
        //NOTE: FOLLOW POM DESIGN PATTERN
        Assert.assertTrue(libraryLoginPage.fieldRequiredErrorMessage.isDisplayed());

        Driver.closeDriver();
    }

    @Test
    //Task2 of Day12
    public void test2(){

        //TC #2: Invalid email format error message test
        //1- Open a chrome browser
        //2- Go to: https://library1.cydeo.com

        //3- Enter invalid email format

        libraryLoginPage.inputUsername.sendKeys("alkdsjlkas");
        libraryLoginPage.signInButton.click();


        //4- Verify expected error is displayed:
        //Expected: Please enter a valid email address.
        //NOTE: FOLLOW POM DESIGN PATTERN
        Assert.assertTrue(libraryLoginPage.enterValidEmailErrorMessage.isDisplayed());

        Driver.closeDriver();
    }

    @Test
    //Task3 of Day12
    public void test3(){

        //TC #3: Library negative login
        //1- Open a chrome browser
        //2- Go to: https://library1.cydeo.com

        //3- Enter incorrect username or incorrect password

        libraryLoginPage.inputUsername.sendKeys("dd@g.com");
        libraryLoginPage.inputPassword.sendKeys("askjdh");
        libraryLoginPage.signInButton.click();

        //4- Verify title expected error is displayed:
        //Expected: Sorry, Wrong Email or Password
        //NOTE: FOLLOW POM DESIGN PATTERN
        Assert.assertTrue(libraryLoginPage.wrongEmailOrPasswordMessage.isDisplayed());

        Driver.closeDriver();
    }

}