package stepDefinitions;

import Pages.homePage;
import Pages.loginPage;
import Pages.shoppingCartPage;
import Pages.checkoutPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class sc12_createOrderStepDefinition {

    homePage searchP = null;

    shoppingCartPage shoppingCart = new shoppingCartPage();
    checkoutPage checkout = new checkoutPage();

    @Given("^user login first 9 \"(.*)\" and \"(.*)\"$")
    public void userLoginFirst9(String userName, String password) throws InterruptedException {
        Hooks.driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");

        Thread.sleep(2000);

        loginPage loginP = new loginPage(Hooks.driver);
        loginP.email.sendKeys(userName);
        loginP.password.sendKeys(password);

        loginP.loginBtn.click();

        Thread.sleep(2000);
    }

    @And("user press on shopping cart in header.")
    public void user_press_on_shopping_cart_in_header() throws InterruptedException {
        Hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        homePage home = new homePage(Hooks.driver);
        home.closeNotification();
        home.shoppingCart_header().click();
        Thread.sleep(1000);
    }

    @And("user press on agree with the terms of service checkbox.")
    public void user_press_on_agree_with_the_terms_of_service_checkbox() {
        Hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        shoppingCart.termsOfService_checkbox().click();
    }

    @And("user press on checkout button.")
    public void user_press_on_checkout_button() throws InterruptedException {
        shoppingCart.checkout_Button().click();
        Thread.sleep(2000);
    }

    @Then("user is redirected to checkout webpage.")
    public void user_is_redirected_to_checkout_webpage()  {
        String actualRedirectedURL = Hooks.driver.getCurrentUrl();
        String expectedRedirectedURL = checkout.checkoutPageURL();
        Assert.assertTrue(actualRedirectedURL.contains(expectedRedirectedURL));
    }

    @And("user selects Country")
    public void user_selects_Country() {
        Hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        checkout.countryList().click();
        Hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        checkout.country_Egypt().click();
    }


    @And("user enters Cairo as City.")
    public void user_enters_Cairo_as_City() {
        checkout.city_textBox().sendKeys("Cairo");
    }

    @And("user enters his or her address.")
    public void user_enters_his_her_address() {
        checkout.address1_textBox().sendKeys("Any Address");
    }

    @And("user enters zip or postal code.")
    public void user_enters_zip_or_postal_code() {
        checkout.zipOrPostal_textBox().sendKeys("12345");
    }


    @And("user enters his or her phone number.")
    public void user_enters_his_or_her_phone_number() {
        checkout.phoneNumber_textBox().sendKeys("01000000000");
    }

    @And("user press on shipping address continue button.")
    public void user_press_on_shipping_address_continue_button() {
        Hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        checkout.shippingAddress_continueButton().click();

    }


    @And("user press on shipping method continue button.")
    public void user_press_on_shipping_method_continue_button() {
        Hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        checkout.shippingMethod_continueButton().click();
    }

    @And("user press on payment method continue button.")
    public void user_press_on_payment_method_continue_button() {
        Hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        checkout.paymentMethod_continueButton().click();
    }

    @And("user press on payment information continue button.")
    public void user_press_on_payment_information_continue_button() {
        Hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        checkout.paymentInfo_continueButton().click();
    }


    @And("user press on confirm button to confirm the order.")
    public void user_press_on_confirm_button_to_confirm_the_order() throws InterruptedException {
        Hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        checkout.confirmOrder_Button().click();
        Thread.sleep(2000);
    }

    @Then("user is redirected to checkout completed webpage.")
    public void user_is_redirected_to_checkout_completed_webpage() {
        String actualRedirectedURL = Hooks.driver.getCurrentUrl();
        String expectedRedirectedURL = checkout.checkoutCompletedURL();
        Assert.assertTrue(actualRedirectedURL.contains(expectedRedirectedURL));
    }


    @And("order proceeded successfully message appears.")
    public void order_proceeded_successfully_message_appears() {
        String actualResult= checkout.orderProceededSuccess_title().getText();
        String expectedResult = "Your order has been successfully processed!";
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

}
