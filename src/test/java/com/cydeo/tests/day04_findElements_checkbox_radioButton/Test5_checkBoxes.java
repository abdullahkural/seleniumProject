package com.cydeo.tests.day04_findElements_checkbox_radioButton;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Test5_checkBoxes {

    public static void main(String[] args) throws InterruptedException {

        //Practice: Checkboxes
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();

        //1. Go to http://practice.cydeo.com/checkboxes
        driver.navigate().to("http://practice.cydeo.com/checkboxes");

        //2. Confirm checkbox #1 is NOT selected by default
        WebElement checkBox1 = driver.findElement(By.xpath("//input[@name='checkbox1']"));
        boolean isCheckBox1Checked = checkBox1.isSelected();
        System.out.println("isCheckBox1Checked = " + isCheckBox1Checked);

        //3. Confirm checkbox #2 is SELECTED by default.
        WebElement checkBox2 = driver.findElement(By.xpath("//input[@name='checkbox2']"));
        boolean isCheckBox2Checked = checkBox2.isSelected();
        System.out.println("isCheckBox2Checked = " + isCheckBox2Checked);

        //4. Click checkbox #1 to select it.
        Thread.sleep(2000);
        checkBox1.click();

        //5. Click checkbox #2 to deselect it.
        Thread.sleep(2000);
         checkBox2.click();

        //6. Confirm checkbox #1 is SELECTED.
        boolean isCheckBox1Selected = checkBox1.isSelected();
        System.out.println("isCheckBox1Selected = " + isCheckBox1Selected);

        //7. Confirm checkbox #2 is NOT selected.
        boolean isCheckBox2Selected = checkBox2.isSelected();
        System.out.println("isCheckBox2Selected = " + isCheckBox2Selected);

        driver.close();
    }
}
