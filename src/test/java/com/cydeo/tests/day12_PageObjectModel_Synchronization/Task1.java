package com.cydeo.tests.day12_PageObjectModel_Synchronization;

import com.cydeo.utilities.Driver;
import org.testng.annotations.Test;

public class Task1 {

    @Test
    public void test(){

        //TC #1: Required field error message test
        //1- Open a chrome browser
        //2- Go to: https://library1.cydeo.com
        Driver.getDriver().get("https://library1.cydeo.com");

        //3- Do not enter any information


        //4- Click to “Sign in” button  (//button[@class='btn btn-lg btn-primary btn-block'])
        //5- Verify expected error is displayed:
        //Expected: This field is required.
        //NOTE: FOLLOW POM DESIGN PATTERN
    }
}
