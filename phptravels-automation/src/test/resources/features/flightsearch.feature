@eflightsearch
Feature: Flight Search

  Background:
    Given the following application config
      | baseUrl   | https://www.phptravels.net |
      | browser   | chrome                     |
      | departure | New York                   |
      | arrival   | London                     |

  Scenario: Valid Flight Search
    Given user is on homepage
    When user searches for a flight
    Then flight results should be displayed

  @negative
  Scenario: Search flight with blank departure
    Given user is on homepage
    When user searches for a flight with departure "" and arrival "London"
    Then system should not navigate to results page

  @negative
  Scenario: Search flight with blank arrival
    Given user is on homepage
    When user searches for a flight with departure "New York" and arrival ""
    Then system should not navigate to results page

  @negative
  Scenario: Search flight with more than 10 adults
    Given user is on homepage
    When user searches for a flight with 11 adults
    Then system should not navigate to results page
