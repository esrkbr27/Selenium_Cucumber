package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class Login {

    LoginPage page=new LoginPage();
    String expectedUrl;

    @When("User opens url {string}")
    public void user_opens_url(String url) {
        Driver.getDriver().get(url);
        expectedUrl=Driver.getDriver().getCurrentUrl();
    }
    @When("User enters email as {string}")
    public void user_enters_email_as(String validuser) {
        page.username.sendKeys(validuser);
        ReusableMethods.waitFor(2);
    }
    @When("User enters password as {string}")
    public void user_enters_password_as(String validpassword) {
        page.password.sendKeys(validpassword);
        ReusableMethods.waitFor(2);
    }
    @When("Click on login")
    public void click_on_login() {
       page.loginbutton.click();
       ReusableMethods.waitFor(5);
    }


    @And("Close website")
    public void closeWebsite() {
        Driver.closeDriver();
    }

    @Then("Verify that you can't get to loginpage")
    public void verifyThatYouCanTGetToLoginpage() {
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }

    @Then("Verify that you can get the mainpage")
    public void verifyThatYouCanGetTheMainpage() {
       boolean value= Driver.getDriver().getCurrentUrl().contains("anasayfa");
       Assert.assertEquals(value,true);
    }

    @And("User click loginbutton")
    public void userClickLoginbutton() {

    }

    @Given("User enter the following values for login")
    public void userEnterTheFollowingValuesForLogin(DataTable table) {
      String username=  table.row(1).get(0);
      String password= table.row(1).get(1);
      page.username.sendKeys(username);
      page.password.sendKeys(password);
    }
    @Given("User enters {string} and {string}")
    public void user_enters_and(String username, String password) {
      page.username.sendKeys(username);
      page.password.sendKeys(password);
      Driver.closeDriver();
    }



}
