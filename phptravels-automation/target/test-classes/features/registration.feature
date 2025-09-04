@dregistration
Feature: Customer Registration

  Background:
    Given the following application config
      | baseUrl   | https://www.phptravels.net |
      | browser   | chrome                     |
      | firstname | Ashish                      |
      | lastname  | Kumar                      |
      | country   | +91                        |
      | phone     | 9876543311                 |
      | email     | asish.auto112@test.com      |
      | password  | Test@1785                   |

  Scenario: Valid Registration
    Given user is on registration page
    When user enters registration details
    Then account should be created successfully

  @negative
  Scenario: Missing mandatory fields
    Given user is on registration page
    When user tries to register with missing fields
    Then system should show error message "Please fill out this field." for "firstname"

  @negative
  Scenario: Invalid email address
    Given user is on registration page
    When user enters invalid email "invalidEmail.com"
    Then system should show error message "Please include an '@' in the email address." for "email"

  @negative @expectedFailure
  Scenario: Weak password
    Given user is on registration page
    When user enters weak password "12345"
    Then account should NOT be created successfully

  @negative @expectedFailure
  Scenario: Phone number longer than 10 digits
    Given user is on registration page
    When user enters phone number "9876543211234"
    Then account should NOT be created successfully
