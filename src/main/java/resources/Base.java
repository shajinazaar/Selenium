package resources;

import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public WebDriver driver;


    public Properties prop;

    public WebDriver intializeDriver() throws IOException {

        prop = new Properties();

        FileInputStream io = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
        prop.load(io);

        String browserName = System.getProperty("browser"); //To execute paramaterized build in jenkins from maven commands
         // mvn test -Dbrowser=chrome
      //  String browserName = prop.getProperty("browser");


        if(browserName.contains("chrome")){
            ChromeOptions options = new ChromeOptions();
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"resources\\chromedriver.exe");
            if(browserName.contains("headless"))
                options.addArguments("headless");
             driver = new ChromeDriver(options);

        }

        else if(browserName.equals("firefox")){
            driver = new FirefoxDriver();
        }
        else if(browserName.equals("IE")) {
            driver = new EdgeDriver();
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;

    }

    public void takeScreenShot(String testCaseName, WebDriver driver) throws IOException {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            String destinationFile = System.getProperty("user.dir") + "\\reports\\"+testCaseName+".png";
            FileUtils.copyFile(source,new File(destinationFile));
    }
}
