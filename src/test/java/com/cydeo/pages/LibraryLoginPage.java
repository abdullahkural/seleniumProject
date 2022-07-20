package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Day 12 Task1, Task2 and Task3

public class LibraryLoginPage {

    //#1- Initialize the driver instance and object of the class
    public LibraryLoginPage(){
        //initElements method will crate connection in btw the current driver session(instance) and the object of the current class
        PageFactory.initElements(Driver.getDriver(), this);}

    /*
    When I call my constructor from other classes as: "LibraryLoginPage libraryLoginPage = new LibraryLoginPage();"
    My constructor is "public LibraryLoginPage(){...}"
    And constructor will execute --> PageFactory.initElements(Driver.getDriver(), this);}
    And this code will initiate driver instance (Driver.getDriver()), and object of this class (this)
     */

    //#2- Use @findBy annotation to locate web elements
    @FindBy(xpath = "//input[@id='inputEmail']")
    public WebElement inputUsername;

    @FindBy(id = "inputPassword")
    public WebElement inputPassword;

    @FindBy(xpath = "//button[.='Sign in']")
    public WebElement signInButton;

    @FindBy(xpath = "//div[.='This field is required.']")
    public WebElement fieldRequiredErrorMessage;

    @FindBy(xpath = "//div[.='Please enter a valid email address.']/div")
    public WebElement enterValidEmailErrorMessage;

    @FindBy(xpath = "//div[.='Sorry, Wrong Email or Password']")
    public WebElement wrongEmailOrPasswordMessage;

}
