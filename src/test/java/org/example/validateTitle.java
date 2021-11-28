package org.example;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import pageObjects.landingPage;
import pageObjects.loginPage;
import resources.Base;

import java.io.IOException;

public class validateTitle extends Base {

    public WebDriver driver;
    landingPage l;

    @BeforeTest
    public void intialize() throws IOException {
        //Creating object to that class and invoke method from it
        driver = intializeDriver();
        driver.get(prop.getProperty("url"));
    }

    @Test()
    public void validateTitle() throws IOException {

        l = new landingPage(driver);
        //Comparing two test using assertions
        Assert.assertEquals(l.getTitle().getText(),"Featured Courses");
    }

    public void validateHeader(){

        Assert.assertEquals(l.getHeader().getText(),"An Academy to learn Everything about Testing");

    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }


}
