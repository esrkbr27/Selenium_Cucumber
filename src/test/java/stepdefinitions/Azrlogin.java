package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import pages.AzrlLoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Azrlogin {

    AzrlLoginPage loginPage=new AzrlLoginPage();

    @When("User azrlsitesine gider")
    public void user_azrlsitesine_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("azrurl"));
    }

    @Then("User dahil ol butonunu clickler")
    public void user_dahil_ol_butonunu_clickler() {
      loginPage.loginbutton.click();
    }
}
