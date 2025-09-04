Feature: Shopping Cart Functionality
  As a user
  I want to add a product to my shopping cart
  So that I can purchase it later

  Scenario: Add product to cart
    Given I am on the homepage
    When I add a product to the cart
    Then product should appear in my shopping cart
