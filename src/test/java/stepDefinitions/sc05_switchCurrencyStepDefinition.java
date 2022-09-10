package stepDefinitions;

import Pages.homePage;
import Pages.loginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class sc05_switchCurrencyStepDefinition {

    homePage searchP = null;

    @Given("^user login first 2 \"(.*)\" and \"(.*)\"$")
    public void userLoginFirst2(String userName, String password) throws InterruptedException {
        Hooks.driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");

        Thread.sleep(2000);

        loginPage loginP = new loginPage(Hooks.driver);
        loginP.email.sendKeys(userName);
        loginP.password.sendKeys(password);

        loginP.loginBtn.click();

        Thread.sleep(2000);
    }

    @When("user switch currency")
    public void userSwitchCurrency()
    {
        searchP = new homePage(Hooks.driver);
       String currentCurrency = searchP.getSelectedCurrencyValue();
       switch (currentCurrency)
       {
           case "US Dollar":
               searchP.setSelectedCurrency("Euro");
           default:
               searchP.setSelectedCurrency("US Dollar");
       }

    }

    @Then("action successfully")
    public void checkCurrentCurrency() throws InterruptedException {
        Thread.sleep(2000);

        List<WebElement> elements = Hooks.driver.findElements(By.className("actual-price"));
        if(elements != null && elements.size() > 0)
        {
            String innerText = elements.get(0).getText();
            String currentCurrency = searchP.getSelectedCurrencyValue();
            switch (currentCurrency)
            {
                case "US Dollar":
                    Assert.assertTrue(innerText.contains("$"));
                    break;
                default:
                    Assert.assertTrue(innerText.contains("€"));
                    break;
            }
        }

    }

}
