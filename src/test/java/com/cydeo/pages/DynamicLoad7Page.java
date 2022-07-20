package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Day 12 Task4

public class DynamicLoad7Page {

    public DynamicLoad7Page(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//strong[.='Done!']")
    public WebElement doneMessage;

    @FindBy (xpath = "//img[@src='/img/a-few-moments.jpg']")
    public WebElement image;
}
