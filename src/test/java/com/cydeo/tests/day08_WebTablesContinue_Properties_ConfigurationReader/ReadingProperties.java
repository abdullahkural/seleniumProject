package com.cydeo.tests.day08_WebTablesContinue_Properties_ConfigurationReader;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingProperties {

    @Test
    public void reading_from_properties() throws IOException {
        //1- Create the object of the Properties class
        Properties properties = new Properties();

        //2- We need to open the file in java memory
        FileInputStream file = new FileInputStream("configuration.properties");

        //3- Load the properties object using FileInputStream object
        properties.load(file);

        //4- Use properties object to read value
        System.out.println("properties.getProperty(\"browser\") = " + properties.getProperty("browser"));   //chrome
        System.out.println("properties.getProperty(\"env\") = " + properties.getProperty("env"));           //https://login1.nextbasecrm.com
        System.out.println("properties.getProperty(\"username\") = " + properties.getProperty("username")); //helpdesk1@cydeo.com

    }

}
