package stepDefinitions;

import Pages.loginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class sc02_loginStepDefinition {
    loginPage loginP = null;

    @Given("user navigate to login page")
    public void userNavigateLogin() throws InterruptedException {
        Hooks.driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");

        Thread.sleep(2000);
    }

    @When("^user enter credentials \"(.*)\" and \"(.*)\"$")
    public void userEnterCredentials(String userName, String password)
    {
        loginP = new loginPage(Hooks.driver);
        loginP.email.sendKeys(userName);
        loginP.password.sendKeys(password);
    }

    @And("user press login button")
    public void userPressLogin()
    {
        loginP.loginBtn.click();
    }

    @Then("user login successfully")
    public void userlogin() throws InterruptedException {
        Thread.sleep(2000);
        String currentUrl=Hooks.driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.equals("https://demo.nopcommerce.com/"));
    }

}
