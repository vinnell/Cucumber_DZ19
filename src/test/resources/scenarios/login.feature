Feature: Login test
  As a common user
  I want to be logged in
  So that I input my credentials

  Background: I set up my env
    Given I open the Login page
@run
  Scenario: Login test positive scenario
  When I enter 'standard_user' my email on the login page
  And I enter 'secret_sauce' my password on the login page
    And I click on submit button on the login page
    Then The main page is displayed