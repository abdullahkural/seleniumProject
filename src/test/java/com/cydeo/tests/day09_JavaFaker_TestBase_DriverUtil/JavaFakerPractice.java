package com.cydeo.tests.day09_JavaFaker_TestBase_DriverUtil;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFakerPractice {

    @Test
    public void test1(){

        //creating a Faker object to reach methods
        Faker faker = new Faker();
        //Creating fake names, surnames, fullnames, street names...etc. are needed in test processes
        //print out a fake first name, surname, full name
        System.out.println("faker.name().firstName() = " + faker.name().firstName());   //Philomena
        System.out.println("faker.name().lastName() = " + faker.name().lastName());     //Zieme
        System.out.println("faker.name().fullName() = " + faker.name().fullName());     //Otto Purdy PhD

        //IN ORDER TO GENERATE NUMBERS IN A FORMAT
        String randomNumber = faker.numerify("0###-###-##-##");
        System.out.println("randomNumber1 = " + randomNumber);                          //0215-935-59-98
        // 2nd time System.out.println("randomNumber2 = " + randomNumber);              //0380-127-81-66

        //IN ORDER TO GENERATE WORDS
        System.out.println("faker.letterify(\"???-?????\") = " + faker.letterify("???-?????"));     //fgz-qzksh
        System.out.println("faker.letterify(\"A??? K????\") = " + faker.letterify("A??? K????"));   //Azjn Kddqw
        System.out.println("faker.letterify(\"A???###\") = " + faker.letterify("A???###"));         //Alnz###

        System.out.println("faker.finance().creditCard() = " + faker.finance().creditCard());   //6007-2299-5899-0686

        System.out.println("faker.chuckNorris().fact() = " + faker.chuckNorris().fact());       //The class object inherits from Chuck Norris.

        System.out.println("faker.avatar().image() = " + faker.avatar().image());               //https://s3.amazonaws.com/uifaces/faces/twitter/meln1ks/128.jpg



    }
}
