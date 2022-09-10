package stepDefinitions;

import Pages.loginPage;
import Pages.homePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class sc04_searchStepDefinition {

    homePage searchP = null;

    @Given("^user login first 1 \"(.*)\" and \"(.*)\"$")
    public void userLoginFirst1(String userName, String password) throws InterruptedException {
        Hooks.driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");

        Thread.sleep(2000);

        loginPage loginP = new loginPage(Hooks.driver);
        loginP.email.sendKeys(userName);
        loginP.password.sendKeys(password);

        loginP.loginBtn.click();

        Thread.sleep(2000);
    }

    @When("^user enter search keyword \"(.*)\"$")
    public void userEnterSearch(String keyWord)
    {
        searchP = new homePage(Hooks.driver);
        searchP.searchElement.sendKeys(keyWord);
    }

    @And("user click search button")
    public void userPressSearch()
    {
        searchP.searchBtn.click();
    }

    @Then("list of products will show")
    public void productsShown() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(searchP.productItems.isDisplayed());
    }

}
