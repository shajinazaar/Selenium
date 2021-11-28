package org.example;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.landingPage;
import resources.Base;

import java.io.IOException;

public class validateNavBar extends Base {
    public WebDriver driver;
    @BeforeTest
    public void intialize() throws IOException {
        //Creating object to that class and invoke method from it
        driver = intializeDriver();
        driver.get(prop.getProperty("url"));
    }

    @Test()
    public void basePageNavigation() throws IOException {

        landingPage l = new landingPage(driver);
        //Comparing two test using assertions
        Assert.assertTrue(l.validateNavBar().isDisplayed());

    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }



}
