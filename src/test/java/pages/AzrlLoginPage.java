package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AzrlLoginPage {

   public AzrlLoginPage(){
       PageFactory.initElements(Driver.getDriver(),this);
   }
   @FindBy (xpath= "//a[@data-testid=\"DaxilButton\"]")
   public WebElement loginbutton;

    @FindBy (xpath= "//input[@id='phoneNumber']")
    public WebElement mobilenumber;

    @FindBy (xpath = "//input[@id='loginPassword']")
    public WebElement password;

    @FindBy (xpath = "//button[@type='submit']")
    public WebElement dahilolbutton;

    @FindBy (xpath = "//img[@class='mr-4 w-30 h-6 xmd:w-40 xmd:h-8']")
    public WebElement azrlicon;





}
