package com.cydeo.tests.day05_DynamicWebElements_TestingIntro_DropDowns;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_Intro {                             //if I click this run button all the tests are going to be run

    @Test   (priority = 1)
    public void test1(){                                //if I click this run button Test1 is going to be run
        System.out.println("Test 1 is running");

        //ASSERT EQUALS: compare 2 of the same things

        //Assert true
        String actual = "apple";
        String expected = "apple";

        Assert.assertEquals(actual, expected);
    }

    /*
        if there is no main method, there is no green run button
        in order to activate run button
        I write "@Test"
        */
    @Test   (priority = 2)
    public void test2(){                                //if I click this run button Test2 is going to be run
        System.out.println("Test 2 is running");

        //Assert true
        String actual = "apple";
        String expected = "apple";

        Assert.assertTrue(actual.equals(expected));
    }

    /*
        Method with this annotation will always run once before all the other methods in this class.
       Usually used for setups
        */
    @BeforeClass
    public void beforeClass(){
        System.out.println("---> Before Class is running!");
    }

    /*
    Runs ONCE after all the methods are DONE.
    Usually used for tearDowns, closing browser, killing instances etc…
     */
    @AfterClass
    public void afterClass(){
        System.out.println("---> After Class is running!");
    }



    /*
    Method with this annotation will always run once before EVERY @Test method
    Usually used for setting up for EVERY test
    */
    @BeforeMethod
    public void setUpMethod(){
        System.out.println("---> Before Method is running!");
    }

    /*
    Basically runs once after every @Test
    Usually used for closing down setups for every test
    */
    @AfterMethod
    public void tearDownMethod(){
        System.out.println("---> After Method is running!");
    }

    //RESULT: (when printed)
    //---> Before Class is running!
    //---> Before Method is running!
    //Test 1 is running
    //---> After Method is running!
    //---> Before Method is running!
    //Test 2 is running
    //---> After Method is running!
    //---> After Class is running!
}
