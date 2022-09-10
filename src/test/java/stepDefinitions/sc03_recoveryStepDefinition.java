package stepDefinitions;

import Pages.recoveryPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class sc03_recoveryStepDefinition {

    recoveryPage recoveryP = null;

    @Given("user navigate to recovery page")
    public void userNavigateRecoveryPage() throws InterruptedException {
        Hooks.driver.get("https://demo.nopcommerce.com/passwordrecovery");

        Thread.sleep(2000);
    }

    @When("^user enter email \"(.*)\"$")
    public void userEnterEmail(String email)
    {
        recoveryP = new recoveryPage(Hooks.driver);
        recoveryP.email.sendKeys(email);
    }

    @And("user press recovery button")
    public void userPressRecovery()
    {
        recoveryP.recoveryBtn.click();
    }

    @Then("user receive instructions successfully")
    public void userRecovery() throws InterruptedException {
        Thread.sleep(2000);
        String notificationText = recoveryP.notificationBar.getText();
        Assert.assertTrue(notificationText.equals("Email with instructions has been sent to you."));
    }


}
