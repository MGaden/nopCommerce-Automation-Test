@regression
Feature: User can reset password in the system
  Scenario: User could reset his/her password successfully
    Given user navigate to recovery page
    When user enter email "MG_demo@was.com"
    And user press recovery button
    Then user receive instructions successfully
