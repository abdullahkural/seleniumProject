package com.cydeo.tests.day03_Tasks_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task3 {

    public static void main(String[] args) {

        //TC #3: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/
        driver.navigate().to("https://login1.nextbasecrm.com/");

        //3- Verify “Log in” button text is as expected:
        //Expected: Log In
        //PS: Inspect and decide which locator you should be using to locate web
        //elements.
        //PS2: Pay attention to where to get the text of this button from
        WebElement logInButton = driver.findElement(By.cssSelector("input[class='login-inp']"));
        String actualLogInButtonText = logInButton.getText();
        if(actualLogInButtonText.equals("Log In")) {
            System.out.println("Passed!");
        } else {
            System.out.println("Failed!");
        }
        driver.close();

    }
}
