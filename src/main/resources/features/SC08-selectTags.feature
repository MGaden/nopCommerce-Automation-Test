@regression
Feature:  Logged user could select different tags
  Scenario:  Logged user could select different tags
    Given user login first 5 "MG_demo@was.com" and "123456"
    And user select category
    And user select tag "awesome"
    Then select tag successfully
    And user select tag "cool"
    Then select tag successfully
