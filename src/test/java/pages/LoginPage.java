package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {

    public LoginPage (){

        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy (id="username")
    public WebElement username;

    @FindBy (css="[type='password']")
    public WebElement password;

    @FindBy (css="[class='ant-btn ant-btn-primary ant-blueBtn']")
    public WebElement loginbutton;

}
