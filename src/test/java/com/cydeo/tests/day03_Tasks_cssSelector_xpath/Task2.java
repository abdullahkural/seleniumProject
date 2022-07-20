package com.cydeo.tests.day03_Tasks_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task2 {

    public static void main(String[] args) {

        //TC #2: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();


        //2- Go to: https://login1.nextbasecrm.com/
        driver.navigate().to("https://login1.nextbasecrm.com/");


        //3- Verify “remember me” label text is as expected:
        //Expected: Remember me on this computer
        WebElement rememberMeLabel = driver.findElement(By.className("login-item-checkbox-label"));
        String actualRememberMeLabel = rememberMeLabel.getText();
        String expectedRememberMeLabel = "Remember me on this computer";
        if(actualRememberMeLabel.equals(expectedRememberMeLabel)) {
            System.out.println("Remember me on this computer verification is PASSED!");
        } else {
            System.out.println("Remember me on this computer verification is FAILED!");
        }


        //4- Verify “forgot password” link text is as expected:
        //Expected: Forgot your password?
        WebElement forgotPasswordLink = driver.findElement(By.className("login-link-forgot-pass"));
        String actualForgotPasswordLinkText = forgotPasswordLink.getText();
        String expectedForgotPasswordLinkText = "Forgot your password?";
        if(actualForgotPasswordLinkText.equals(expectedForgotPasswordLinkText)) {
            System.out.println("Forgot password link text verification is PASSED!");
        } else {
            System.out.println("Forgot password link text verification is FAILED!");
        }


        //5- Verify “forgot password” href attribute’s value contains expected:
        //Expected: forgot_password=yes
        String hrefAttributeValue = forgotPasswordLink.getAttribute("href");
        if(hrefAttributeValue.contains("forgot_password=yes")) {
            System.out.println("forgot password href attribute’s value verification is PASSED!");
        } else {
            System.out.println("forgot password href attribute’s value verification is FAILED!");
        }
        //PS: Inspect and decide which locator you should be using to locate web
        //elements

        driver.close();

    }
}
