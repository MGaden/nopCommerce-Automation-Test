@regression
Feature:  Logged user could add different products to compare list
  Scenario:  Logged user could add different products to compare list
    Given user login first 8 "MG_demo@was.com" and "123456"
    And user add product 1 to compare list
    Then added to compare list successfully
    And user add product 2 to compare list
    Then added to compare list successfully
    And user redirect to compare page
    Then redirect successfully
