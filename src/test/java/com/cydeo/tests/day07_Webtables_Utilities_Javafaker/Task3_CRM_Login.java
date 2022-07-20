package com.cydeo.tests.day07_Webtables_Utilities_Javafaker;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.BrowserUtils_Tas2_day7;
import com.cydeo.utilities.CRM_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Task3_CRM_Login extends TestBase {

    //TC #3: Login scenario
    //It was here. I cut this commented part and pasted it in to the testBase class under Base package.
    //And TestBase class is an abstract. And I extended Task3_CRM_Login to TestBase class
    /*
    public WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
 */


    @Test
    public void crmLoginTest(){
        //1. Create new test and make set ups
        //2. Go to : http://login1.nextbasecrm.com/
        driver.navigate().to("http://login1.nextbasecrm.com/");

        //3. Enter valid username
        //helpdesk1@cybertekschool.com
        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys("helpdesk1@cybertekschool.com");

        //4. Enter valid password
        //Helpdesk2@cybertekschool.com
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys("UserUser");

        //5. Click to `Log In` button
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();

        //6. Verify title is as expected:
        //Expected: Portal
        BrowserUtils_Tas2_day7.verifyTitle(driver, "Portal");

    }

    //We created a method to login with helpdesk username
    @Test
    public void crmLoginTest_2(){
        //1. Create new test and make set ups
        //2. Go to : http://login1.nextbasecrm.com/
        driver.navigate().to("http://login1.nextbasecrm.com/");

        //calling my utility method to login helpdesk1
        CRM_Utilities.crm_login(driver);

        //6. Verify title is as expected:
        //Expected: Portal
        BrowserUtils_Tas2_day7.verifyTitle(driver, "Portal");

    }

    @Test
    public void crmLoginTest_3(){
        //1. Create new test and make set ups
        //2. Go to : http://login1.nextbasecrm.com/
        driver.navigate().to("http://login1.nextbasecrm.com/");

        //calling my utility method to login helpdesk1
        CRM_Utilities.crm_login(driver, "helpdesk1@cybertekschool.com", "UserUser");

        //6. Verify title is as expected:
        //Expected: Portal
        BrowserUtils_Tas2_day7.verifyTitle(driver, "Portal");

    }

}


