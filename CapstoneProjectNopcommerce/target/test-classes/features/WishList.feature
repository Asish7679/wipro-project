Feature: Wishlist Functionality

  Background:
    Given I am on the homepage

  Scenario: Add Apple MacBook Pro to wishlist
    When I add Apple MacBook Pro to the wishlist
    Then Apple MacBook Pro should appear in my wishlist
