package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ValidateFormPage extends BasePage {

    @FindBy(xpath = ".//*[@class='content clear']")
    private WebElement invalidError;

    public String getTextInvalidErr (){
        return invalidError.getText();
    }
}
