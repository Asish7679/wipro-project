Feature: Login and Logout Functionality

  Background:
    Given I am on the login page

  Scenario: Login with valid credentials
    When I enter valid email and password
    And I click on the login button
    Then I should be logged in successfully

  Scenario: Login with invalid password
    When I enter correct email and wrong password
    And I click on the login button
    Then I should see an error message login "Login was unsuccessful. Please correct the errors and try again."

  Scenario: Login with unregistered email
    When I enter unregistered email and any password
    And I click on the login button
    Then I should see an error message login "No customer account found"

  Scenario: Logout flow
    Given I am logged in
    When I click on the logout button
    Then I should be redirected to the homepage
    And I should see login and register links
