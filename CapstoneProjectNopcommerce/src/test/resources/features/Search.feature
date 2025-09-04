Feature: Search

  Background:
    Given I am on the homepage

  Scenario: Search for an existing product
    When I search for "MacBook"
    Then I should see products related to "MacBook"

  Scenario: Search for a non-existent product
    When I search for "FlyingCar"
    Then I should see a message saying "No products were found that matched your criteria."

  Scenario: Search with blank input
    When I search for ""
    Then I should see a message saying "Please enter some search keyword"
