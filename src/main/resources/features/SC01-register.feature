@regression
Feature: User could register in system
  Scenario: User could register with valid data
    Given user navigate to register page
    When user enter registration data "M" and "G" and "MG_demo@was.com" and "123456"
    And user press register button
    Then user register successfully
