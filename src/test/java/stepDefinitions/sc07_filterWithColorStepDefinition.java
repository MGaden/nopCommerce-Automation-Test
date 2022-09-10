package stepDefinitions;

import Pages.homePage;
import Pages.loginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.time.Duration;

public class sc07_filterWithColorStepDefinition {

    homePage searchP = null;

    @Given("^user login first 4 \"(.*)\" and \"(.*)\"$")
    public void userLoginFirst4(String userName, String password) throws InterruptedException {
        Hooks.driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");

        Thread.sleep(2000);

        loginPage loginP = new loginPage(Hooks.driver);
        loginP.email.sendKeys(userName);
        loginP.password.sendKeys(password);

        loginP.loginBtn.click();

        Thread.sleep(2000);
    }

    @When("user filter with color")
    public void userFilterWithColor()
    {
        searchP = new homePage(Hooks.driver);
        searchP.getApparelCategory().click();
        searchP.getShoesSubCategory().click();
        Hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        searchP.getShoesRedCheckBox().click();
    }

    @Then("filter successfully")
    public void filterSuccessfully() throws InterruptedException {
        Thread.sleep(2000);
        String actualResult = Hooks.driver.findElement(By.cssSelector("h2[class=\"product-title\"] > [href=\"/adidas-consortium-campus-80s-running-shoes\"]")).getText();
        String expectedResult = "adidas Consortium Campus 80s Running Shoes";
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

}
