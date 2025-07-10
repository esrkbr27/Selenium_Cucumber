package stepdefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AzrlLoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class azrlogin {

    AzrlLoginPage loginPage=new AzrlLoginPage();
    @Given("User goes to azrlotereya website")
    public void user_goes_to_azrlotereya_website() {
        Driver.getDriver().get(ConfigReader.getProperty("azrurl"));
    }
    @When("User click Dahil Ol button")
    public void user_click_dahil_ol_button() {
       loginPage.loginbutton.click();
    }
    @When("User enters valid email")
    public void user_enters_valid_email() {
       loginPage.mobilenumber.sendKeys(ConfigReader.getProperty("validphonenumber"));
    }
    @When("User enters valid password")
    public void user_enters_valid_password() {
       loginPage.password.sendKeys(ConfigReader.getProperty("validpassword"));
    }
    @And("User click Dahil Ol button in the modal")
    public void userClickDahilOlButtonInTheModal() {
        loginPage.dahilolbutton.click();
    }
    @Then("User verify that user on the mainpage")
    public void user_verify_that_user_on_the_mainpage() {
        Assert.assertTrue(loginPage.azrlicon.isDisplayed());
    }


}
