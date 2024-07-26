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

}
