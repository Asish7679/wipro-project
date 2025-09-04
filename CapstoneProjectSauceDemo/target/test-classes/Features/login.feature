@Login @Smoke
Feature: Login functionality

@Smoke
Scenario: Successful login with valid credentials
    Given User is on Login Page
    When User enters valid username
    And User enters valid password
    And User clicks on Login button
    Then User should be navigated to the homepage

@Regression
Scenario: Login with invalid credentials
    Given User is on Login Page
    When User enters invalid username
    And User enters invalid password
    And User clicks on Login button
    Then Login error message should be displayed

@Regression
Scenario: Login with blank username and password
    Given User is on Login Page
    When User leaves username blank
    And User leaves password blank
    And User clicks on Login button
    Then Mandatory login field error messages should appear

@Regression
Scenario: Logout functionality
    Given User is logged in
    When User clicks on Logout
    Then User should be redirected to Login Page
