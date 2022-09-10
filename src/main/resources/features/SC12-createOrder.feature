@regression
Feature:  Create successful Order
  Scenario:  Create successful Order
    Given user login first 9 "MG_demo@was.com" and "123456"
    And user select category
    And user add product 1 to cart
    Then added to cart successfully
    And user add product 2 to cart
    Then added to cart successfully

    And user press on shopping cart in header.
    And user press on agree with the terms of service checkbox.
    And user press on checkout button.

    Then user is redirected to checkout webpage.
    And user selects Country
    And user enters Cairo as City.
    And user enters his or her address.
    And user enters zip or postal code.
    And user enters his or her phone number.
    And user press on shipping address continue button.

    And user press on shipping method continue button.

    And user press on payment method continue button.

    And user press on payment information continue button.

    And user press on confirm button to confirm the order.

    Then user is redirected to checkout completed webpage.
    And order proceeded successfully message appears.
