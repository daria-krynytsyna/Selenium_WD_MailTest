package Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static Common.Constants.BASE_URL;

public class DriverFactory {
   public static WebDriver driver = null;
    public static WebDriver getDriver(){

           System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
           driver = new ChromeDriver();

           driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
           driver.get(BASE_URL);

       return driver;
   }

    public static void quitDriver(WebDriver driver){

        driver.quit();
    }
}
