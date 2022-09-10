package stepDefinitions;

import Pages.homePage;
import Pages.loginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

import static stepDefinitions.Hooks.driver;

public class sc11_addProductToComparelistStepDefinition {

    homePage homeP = null;

    @Given("^user login first 8 \"(.*)\" and \"(.*)\"$")
    public void userLoginFirst8(String userName, String password) throws InterruptedException {
        driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");

        Thread.sleep(2000);

        loginPage loginP = new loginPage(driver);
        loginP.email.sendKeys(userName);
        loginP.password.sendKeys(password);

        loginP.loginBtn.click();

        Thread.sleep(2000);
    }

    @When("user add product 1 to compare list")
    public void userAddProduct1ToCompareList()
    {
        homeP = new homePage(driver);
        homeP.product1_compareListButton().click();

    }

    @When("user add product 2 to compare list")
    public void userAddProduct2ToCompareList()
    {
        homeP = new homePage(driver);
        homeP.product2_compareListButton().click();

    }

    @Then("added to compare list successfully")
    public void addedToCompareListSuccessfully() throws InterruptedException {
        Thread.sleep(1000);

        String actualMessageDisplayed = homeP.notificationBar.getText();
        String expectedMessageDisplayed = "The product has been added to your product comparison";
        Assert.assertTrue(actualMessageDisplayed.contains(expectedMessageDisplayed));

        homeP.notificationBar.click();
        Thread.sleep(1000);
    }

    @And("user redirect to compare page")
    public void userRedirectToComparePage() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        homeP.productComparison_link().click();
        Thread.sleep(1000);
    }

    @Then("redirect successfully")
    public void redirectedSuccessfully() {
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://demo.nopcommerce.com/compareproducts";
        Assert.assertTrue(actualURL.contains(expectedURL));

    }


}
