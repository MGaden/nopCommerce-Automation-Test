@regression
Feature: Logged user could select different Categories
  Scenario: Logged user could select different Categories
    Given user login first 3 "MG_demo@was.com" and "123456"
    And user select category
    Then select category successfully
