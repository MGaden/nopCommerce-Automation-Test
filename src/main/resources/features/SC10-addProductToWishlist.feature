@regression
Feature:  Logged user could add different products to Wishlist
  Scenario:  Logged user could add different products to Wishlist
    Given user login first 7 "MG_demo@was.com" and "123456"
    And user select category
    And user add product 1 to wishlist
    Then added to wishlist successfully
    And user add product 2 to wishlist
    Then added to wishlist successfully
