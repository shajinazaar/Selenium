package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class landingPage {

    public WebDriver driver;

    private By signin = By.xpath("//span[contains(text(),'Login')]");

    private By title = By.xpath("//h2[contains(text(),'Featured Courses')]");

   private By navBar = By.xpath("//ul[@class='nav navbar-nav navbar-right']");

   private By header = By.cssSelector("div[class*='video-banner'] h3");

    public landingPage(WebDriver driver) {
    }


    public loginPage getLogin(){

         driver.findElement(signin).click();
        loginPage lp = new loginPage(driver);
        return lp;
    }

    public WebElement getTitle(){
        return driver.findElement(title);
    }

    public WebElement validateNavBar(){
        return driver.findElement(navBar);
    }

    public WebElement getHeader(){
        return driver.findElement(header);
    }

}
