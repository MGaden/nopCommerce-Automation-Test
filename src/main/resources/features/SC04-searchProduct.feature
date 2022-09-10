@regression
Feature: Logged User could search for any product
  Scenario: Logged User could search for any product
    Given user login first 1 "MG_demo@was.com" and "123456"
    When user enter search keyword "computer"
    And user click search button
    Then list of products will show
