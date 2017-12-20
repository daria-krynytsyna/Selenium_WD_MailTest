package Pages;


//import Driver.MyDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Driver.DriverFactory;
import org.openqa.selenium.support.PageFactory;
import static java.lang.System.setProperty;

import java.io.File;

public abstract class BasePage {

  protected static WebDriver driver = DriverFactory.getDriver();


    public BasePage() {
        PageFactory.initElements(driver,this);
    }
}
