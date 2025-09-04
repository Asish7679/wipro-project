Feature: User Registration on nopCommerce
  As a user
  I want to register on nopCommerce
  So that I can create an account and log in

  Scenario: Register with valid data
    Given I am on the registration page
    When I enter a unique email, strong password and matching confirm password
    And I submit the registration form
    Then I should see a success message "Your registration completed"

  Scenario: Register with existing email
    Given I am on the registration page
    When I enter an existing email, strong password and matching confirm password
    And I submit the registration form
    Then I should see an error message "The specified email already exists"

  Scenario: Register with invalid email
    Given I am on the registration page
    When I enter an invalid email format
    And I submit the registration form
    Then I should see an error message for invalid email "Wrong email"

  Scenario: Register with weak password
    Given I am on the registration page
    When I enter a unique email and weak password

    Then I should see a password policy error message

  Scenario: Register with mismatched passwords
    Given I am on the registration page
    When I enter a unique email, strong password and mismatched confirm password
    And I submit the registration form
    Then I should see an mismatched password error message "The password and confirmation password do not match"
