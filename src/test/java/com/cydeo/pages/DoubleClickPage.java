package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoubleClickPage {

    //Day13 Task1

    public DoubleClickPage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (id = "demo")
    public WebElement doubleClickText;

    @FindBy (xpath = "//div[@class='sn-b-def sn-blue']")
    public WebElement acceptButton;
}
