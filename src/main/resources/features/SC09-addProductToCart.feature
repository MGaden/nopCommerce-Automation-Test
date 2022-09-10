@regression
Feature:  Logged user could add different products to Shopping cart
  Scenario:  Logged user could add different products to Shopping cart
    Given user login first 6 "MG_demo@was.com" and "123456"
    And user select category
    And user add product 1 to cart
    Then added to cart successfully
    And user add product 2 to cart
    Then added to cart successfully
