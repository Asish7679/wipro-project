@fbooking
Feature: Flight Booking

  Background:
    Given the following application config
      | baseUrl   | https://www.phptravels.net |
      | browser   | chrome                     |

  # ✅ Positive flow
  Scenario: Book a flight with PayPal
    Given user is on flight results page
    And user selects the first available flight
    When user enters passenger details
    And user chooses PayPal as payment method
    Then booking invoice page should be displayed
    And user clicks proceed on invoice page

  # ❌ Negative flow - mandatory fields blank
  @negative
  Scenario: Leave mandatory booking fields blank
    Given user is on flight results page
    And user selects the first available flight
    When user leaves mandatory booking fields blank
    And user chooses PayPal as payment method
    Then booking should NOT be created

  # ❌ Negative flow - invalid passport
  @negative
  Scenario: Enter invalid passport number
    Given user is on flight results page
    And user selects the first available flight
    When user enters invalid passport number "123"
    And user chooses PayPal as payment method
    Then booking should NOT be created
