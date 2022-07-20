package com.cydeo.tests.day04_findElements_checkbox_radioButton;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task1and2_xPath_cssSelectorPractice {

    public static void main(String[] args) {

        //XPATH and CSS Selector PRACTICES
        //DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
        //TC #1: XPATH and cssSelector Practices
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();

        //2. Go to https://practice.cydeo.com/forgot_password
        driver.navigate().to("https://practice.cydeo.com/forgot_password");

        //3. Locate all the WebElements on the page using XPATH and/or CSS
        //locator only (total of 6)
            //a. “Home” link
            WebElement homeLink = driver.findElement(By.cssSelector("a[class='nav-link']"));
            //Locate homeLink using cssSelector syntax #2
            WebElement homeLink2 = driver.findElement(By.cssSelector("a.nav-link"));
            //Locate homeLink using cssSelector by using href
            WebElement homeLink3 = driver.findElement(By.cssSelector("a[href='/']"));

            //b. “Forgot password” header
            WebElement forgotPasswordHeader = driver.findElement(By.cssSelector("div.example > h2"));
            //Locate header using (relative) xPath and using web element text
            WebElement header_ex2 = driver.findElement(By.xpath("//h2[text()='Forgot Password']"));

            //c. “E-mail” text
            WebElement emailLabel = driver.findElement(By.xpath("//label[@for='email']"));

            //d. E-mail input box
            WebElement emailInputBoxExample1 = driver.findElement(By.xpath("//input[@name='email']"));
            //Locate input box using xpath contains method
            //tagName[contains(@attribute,'value')]
            WebElement emailInputBoxExample2 = driver.findElement(By.xpath("//input[contains(@pattern,'a-z')]"));

            //e. “Retrieve password” button with //tagName[contains(@attribute, 'value')]
            WebElement retrievePasswordButton = driver.findElement(By.xpath("//i[contains(@class, 'icon')]"));
                                                                             //button[@id='form_submit']

            //f. “Powered by Cydeo text
            WebElement poweredByCydeoText = driver.findElement(By.xpath("//div[contains(@style,'text-')]"));


        //4. Verify all web elements are displayed.
        System.out.println("homeLink.isDisplayed() = " + homeLink.isDisplayed());
        System.out.println("forgotPasswordHeader.isDisplayed() = " + forgotPasswordHeader.isDisplayed());
        System.out.println("emailInputBoxExample1.isDisplayed() = " + emailInputBoxExample1.isDisplayed());
        System.out.println("retrievePasswordButton.isDisplayed() = " + retrievePasswordButton.isDisplayed());
        System.out.println("poweredByCydeoText.isDisplayed() = " + poweredByCydeoText.isDisplayed());

        //First solve the task with using cssSelector only. Try to create 2 different cssSelector if possible
        //Then solve the task using XPATH only. Try to create 2 different XPATH locator if possible

        driver.close();
    }
}
