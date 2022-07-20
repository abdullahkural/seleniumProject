package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicallyLoadedPageElements1 {

    public DynamicallyLoadedPageElements1(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//button[.='Start']")
    public WebElement startButton;

    @FindBy (css = "div#loading")
    ////img[@src='/img/ajax-loader.gif']
    public WebElement loadingBars;

    @FindBy (css = "#username")
    //@FindBy (id = "username")
    public WebElement inputUsername;

    @FindBy (css = "#pwd")
    public WebElement inputPassWord;

    @FindBy (xpath = "//button[.='Submit']")
    public WebElement submitButton;

    @FindBy (id = "flash")
    public WebElement errorMessage;


}
