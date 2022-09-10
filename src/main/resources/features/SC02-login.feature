@regression
Feature: login should be able to login to the system
  Scenario: user login with valid name
    Given user navigate to login page
    When user enter credentials "MG_demo@was.com" and "123456"
    And user press login button
    Then user login successfully
