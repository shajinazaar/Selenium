package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class forgotPasswordPage {

    public WebDriver driver;

    By email = By.cssSelector("input[id='user_email']");

    By sendMeInstruction =By.cssSelector("[type='submit']");

    public forgotPasswordPage(WebDriver driver) {
    }


    public WebElement getEmail(){

        return driver.findElement(email);
    }

    public WebElement sendMeInstruction(){
        return driver.findElement(sendMeInstruction);
    }


}
