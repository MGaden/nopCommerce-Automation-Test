@regression
Feature: Logged user could filter with color
  Scenario: Logged user could filter with color
    Given user login first 4 "MG_demo@was.com" and "123456"
    And user filter with color
    Then filter successfully
