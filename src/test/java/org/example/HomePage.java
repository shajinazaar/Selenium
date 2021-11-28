
package org.example;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.forgotPasswordPage;
import pageObjects.landingPage;
import pageObjects.loginPage;
import resources.Base;

import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class HomePage extends Base {
    public WebDriver driver;
   public static Logger  logger = LogManager.getLogManager().getLogger(Base.class.getName());

    @BeforeTest
    public void intialize() throws IOException {
        driver = intializeDriver();
    }

    @Test(dataProvider = "getData")
    public void basePageNavigation(String username,String password,String text) throws IOException {
        driver.get(prop.getProperty("url"));
        landingPage l = new landingPage(driver);
      loginPage lp= l.getLogin();  // GetLogin object will click on the log in button and also will return the object of  "LOGIN PAGE"
        lp.getEmail().sendKeys(username);
        lp.getPassword().sendKeys(password);

        System.out.println(text);
        lp.getLogin().click();

        forgotPasswordPage fp=lp.forgotPassword();

        fp.getEmail().sendKeys(username);
        fp.sendMeInstruction().click();


    }

    @DataProvider
    public Object[][] getData(){
        // rows define how many types of data we want to use in a test
        // columns define how many values passes into a test
        //Array size is 2
        // 0,1

        Object[][] data = new Object[2][3];
        // 0th row
        data[0][0]="nonrestricteduser@qa.com";
        data[0][1]="121133";
        data[0][2]="Non Restricted User";
        // 1st row

        data[1][0]="restricteduser@qa.com";
        data[1][1]="121213";
        data[1][2]="Restricted User";


        return data;
    }
    @AfterTest
    public void tearDown(){
        driver.close();
    }


}
