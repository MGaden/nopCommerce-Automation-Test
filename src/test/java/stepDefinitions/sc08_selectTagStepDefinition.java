package stepDefinitions;

import Pages.homePage;
import Pages.loginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class sc08_selectTagStepDefinition {

    homePage homeP = null;
    String tagName = "";

    @Given("^user login first 5 \"(.*)\" and \"(.*)\"$")
    public void userLoginFirst5(String userName, String password) throws InterruptedException {
        Hooks.driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");

        Thread.sleep(2000);

        loginPage loginP = new loginPage(Hooks.driver);
        loginP.email.sendKeys(userName);
        loginP.password.sendKeys(password);

        loginP.loginBtn.click();

        Thread.sleep(2000);
    }

    @When("^user select tag \"(.*)\"$")
    public void userSelectTag(String tagName)
    {
        this.tagName = tagName;
        homeP = new homePage(Hooks.driver);
       homeP.getTag(tagName).click();
    }

    @Then("select tag successfully")
    public void selectTagSuccessfully() throws InterruptedException {
        Thread.sleep(2000);
        String actualRedirectedURL = Hooks.driver.getCurrentUrl();
        String expectedRedirectedURL = "https://demo.nopcommerce.com/" + this.tagName;
        Assert.assertTrue(actualRedirectedURL.contains(expectedRedirectedURL));
    }

}
