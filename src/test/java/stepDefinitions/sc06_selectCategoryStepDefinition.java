package stepDefinitions;

import Pages.homePage;
import Pages.loginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class sc06_selectCategoryStepDefinition {

    homePage searchP = null;

    WebElement selectedSubCategory=null;

    @Given("^user login first 3 \"(.*)\" and \"(.*)\"$")
    public void userLoginFirst3(String userName, String password) throws InterruptedException {
        Hooks.driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");

        Thread.sleep(2000);

        loginPage loginP = new loginPage(Hooks.driver);
        loginP.email.sendKeys(userName);
        loginP.password.sendKeys(password);

        loginP.loginBtn.click();

        Thread.sleep(2000);
    }

    @When("user select category")
    public void userSelectCategory()
    {
        searchP = new homePage(Hooks.driver);

        WebElement computer = searchP.mainCategory("computers");

        Actions action = new Actions(Hooks.driver);

        action.moveToElement(computer).perform();

        selectedSubCategory = searchP.subCategory("desktops");

        selectedSubCategory.click();

    }

    @Then("select category successfully")
    public void selectCategorySuccessfully() throws InterruptedException {
        Thread.sleep(2000);

        //Assert.assertTrue(searchP.getPageTitle().equalsIgnoreCase("desktops"));

        Assert.assertTrue(Hooks.driver.getCurrentUrl().contains("desktops"));
    }

}
