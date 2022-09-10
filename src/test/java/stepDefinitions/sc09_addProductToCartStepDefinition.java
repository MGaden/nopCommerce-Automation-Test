package stepDefinitions;

import Pages.homePage;
import Pages.loginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class sc09_addProductToCartStepDefinition {

    homePage homeP = null;

    @Given("^user login first 6 \"(.*)\" and \"(.*)\"$")
    public void userLoginFirst6(String userName, String password) throws InterruptedException {
        Hooks.driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");

        Thread.sleep(2000);

        loginPage loginP = new loginPage(Hooks.driver);
        loginP.email.sendKeys(userName);
        loginP.password.sendKeys(password);

        loginP.loginBtn.click();

        Thread.sleep(2000);
    }

    @When("user add product 1 to cart")
    public void userAddProduct1ToCart()
    {
        homeP = new homePage(Hooks.driver);
       homeP.product1_addToCartButton().click();
    }

    @When("user add product 2 to cart")
    public void userAddProduct2ToCart()
    {
        homeP = new homePage(Hooks.driver);
        homeP.product2_addToCartButton().click();
    }

    @Then("added to cart successfully")
    public void addedToCartSuccessfully() throws InterruptedException {
        Thread.sleep(1000);

        String actualMessageDisplayed = homeP.notificationBar.getText();
        String expectedMessageDisplayed = "The product has been added to your shopping cart";
        Assert.assertTrue(actualMessageDisplayed.contains(expectedMessageDisplayed));

        homeP.notificationBar.click();
        Thread.sleep(1000);

    }

}
