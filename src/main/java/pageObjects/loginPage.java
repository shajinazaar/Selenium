package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {

    public WebDriver driver;

    By email = By.cssSelector("input[id='user_email']");

    By password =By.cssSelector("input[id='user_password']");

    By login = By.cssSelector("[value='Log In']");

    By forgotPwd = By.cssSelector("[href*='password/new']");

    public loginPage(WebDriver driver) {

    }


    public forgotPasswordPage forgotPassword(){
        driver.findElement(forgotPwd).click();
        forgotPasswordPage fp= new forgotPasswordPage(driver);
         return fp;
    }

    public WebElement getEmail(){

        return driver.findElement(email);
    }

    public  WebElement getPassword(){

        return driver.findElement(password);
    }

    public WebElement getLogin(){

        return driver.findElement(login);
    }
}
