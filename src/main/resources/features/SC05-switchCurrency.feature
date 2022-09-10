@regression
Feature: Logged User could switch between currencies US-Euro
  Scenario: Logged User could switch between currencies US-Euro
    Given user login first 2 "MG_demo@was.com" and "123456"
    And user switch currency
    Then action successfully
