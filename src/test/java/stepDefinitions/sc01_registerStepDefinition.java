package stepDefinitions;

import Pages.registerPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class sc01_registerStepDefinition {

    registerPage registerP = null;

    @Given("user navigate to register page")
    public void userNavigateRegister() throws InterruptedException {
       Hooks.driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");

        Thread.sleep(2000);
    }

    @When("^user enter registration data \"(.*)\" and \"(.*)\" and \"(.*)\" and \"(.*)\"$")
    public void userEnterRegistrationData(String firstName, String lastName, String email, String password)
    {
        registerP = new registerPage(Hooks.driver);
        registerP.firstName.sendKeys(firstName);
        registerP.lastName.sendKeys(lastName);
        registerP.email.sendKeys(email);
        registerP.password.sendKeys(password);
        registerP.confirmPassword.sendKeys(password);
    }

    @And("user press register button")
    public void userPressRegister()
    {
        registerP.registerBtn.click();
    }

    @Then("user register successfully")
    public void userRegister() throws InterruptedException {
        Thread.sleep(2000);
        String currentUrl=Hooks.driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.equals("https://demo.nopcommerce.com/registerresult/1?returnUrl=/"));
    }

}
