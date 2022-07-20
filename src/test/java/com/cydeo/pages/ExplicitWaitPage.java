package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExplicitWaitPage {

    //Day13 Task2

    public ExplicitWaitPage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//button[@onclick='swapCheckbox()']")
    //button[.='Remove']
    //(css = form#checkox-example > button)
    public WebElement removeButton;

    @FindBy (id = "checkbox")
    //div[@id='checkbox']
    // (css = "input[label='blah']")
    // (css = "input[type='checkbox']")
    public WebElement checkBox;

    @FindBy (xpath = "//img[@src='/img/ajax-loader.gif']")
    // (css = "div#loading")
    public WebElement loadingBar;

    @FindBy (css = "p[id='message']")
    //@FindBy (xpath = "p[@id='message']")
    public WebElement message;

    @FindBy (xpath = "//button[.='Enable']")
    public WebElement enableButton;

    @FindBy (xpath = "//input[@style='width: 30%;']")
    //@FindBy (css = "input[type='text']")
    public WebElement inputBox;

    @FindBy (xpath = "//img[@src='/img/ajax-loader.gif']")
    public WebElement loadingBar2;



}
