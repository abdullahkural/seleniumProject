package com.cydeo.tests.day08_WebTablesContinue_Properties_ConfigurationReader;

import org.testng.annotations.Test;

public class LearningProperties {

    @Test
    public void java_properties_reading_test(){
        //os.name: operating system name
        System.out.println("System.getProperty(\"os.name\") = " + System.getProperty("os.name"));      //System.getProperty("os.name") = Windows 10
        System.out.println("System.getProperty(\"user.name\") = " + System.getProperty("user.name"));  //System.getProperty("user.name") = Gebruiker



    }

}
