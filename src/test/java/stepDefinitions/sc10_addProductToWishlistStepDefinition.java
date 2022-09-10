package stepDefinitions;

import Pages.homePage;
import Pages.loginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class sc10_addProductToWishlistStepDefinition {

    homePage homeP = null;

    @Given("^user login first 7 \"(.*)\" and \"(.*)\"$")
    public void userLoginFirst7(String userName, String password) throws InterruptedException {
        Hooks.driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");

        Thread.sleep(2000);

        loginPage loginP = new loginPage(Hooks.driver);
        loginP.email.sendKeys(userName);
        loginP.password.sendKeys(password);

        loginP.loginBtn.click();

        Thread.sleep(2000);
    }

    @When("user add product 1 to wishlist")
    public void userAddProduct1ToWishlist()
    {
        homeP = new homePage(Hooks.driver);
        homeP.product1_wishListButton().click();
    }

    @When("user add product 2 to wishlist")
    public void userAddProduct2ToWishlist()
    {
        homeP = new homePage(Hooks.driver);
        homeP.product2_wishListButton().click();
    }

    @Then("added to wishlist successfully")
    public void addedToWishlistSuccessfully() throws InterruptedException {
        Thread.sleep(1000);

        String actualMessageDisplayed = homeP.notificationBar.getText();
        String expectedMessageDisplayed = "The product has been added to your wishlist";
        Assert.assertTrue(actualMessageDisplayed.contains(expectedMessageDisplayed));

        homeP.notificationBar.click();
        Thread.sleep(1000);

    }

}
