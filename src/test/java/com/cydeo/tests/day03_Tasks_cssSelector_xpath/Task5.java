package com.cydeo.tests.day03_Tasks_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task5 {

    public static void main(String[] args) {

        //TC #5: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();


        //2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
        driver.navigate().to("https://login1.nextbasecrm.com/?forgot_password=yes");

        //3- Enter incorrect username into login box:
        //                                                    tagName[attribute = 'attributeValue']
        WebElement userNameInput = driver.findElement(By.cssSelector("input[class='login-inp']"));
        userNameInput.sendKeys("incorrect");


        //4- Click to `Reset password` button
        WebElement resetPasswordButton = driver.findElement(By.cssSelector("button[class='login-btn']"));
        resetPasswordButton.click();

        //5- Verify “error” label is as expected: Login or E-mail not found
        //PS1: Inspect and decide which locator you should be using to locate web elements.
        //PS2: Pay attention to where to get the text of this button from
        WebElement errorLabel = driver.findElement(By.cssSelector("div[class='errortext']"));
        String actualErrorLabelText = errorLabel.getText();
        String expectedErrorLabelText = "Login or E-mail not found";
        if(actualErrorLabelText.equals(expectedErrorLabelText)){
            System.out.println("Error Label Text Verification is PASSED!");
        } else {
            System.out.println("Error Label Text Verification is FAILED!");
        }
        driver.close();

    }
}
