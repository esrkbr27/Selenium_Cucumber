package stepdefinitions;

import io.cucumber.java.en.*;
import pages.SearchPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Search {

    SearchPage page=new SearchPage();

    @Then("User goes to beksitealpha")
    public void user_goes_to_beksitealpha() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));

    }
    @Given("User types {string} into searchbar")
    public void user_types_into_searchbar(String string) {
      page.search.sendKeys();
    }
    @Then("Verify that searched products in the results")
    public void verify_that_searched_products_in_the_results() {

    }

}
