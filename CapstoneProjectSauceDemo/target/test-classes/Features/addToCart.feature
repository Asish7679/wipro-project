@Cart @Regression
Feature: Cart functionality
  As a user
  I want to manage items in the cart
  So that I can verify cart operations

  Background:
    Given User is logged in

  @Smoke
  Scenario: Add item to cart and verify
    When User adds single item to the cart
    And User opens the cart page
    Then User should see the item in the cart

  @Smoke
  Scenario: Add multiple items to cart and verify
    When User adds multiple items to the cart
    And User opens the cart page
    Then User should see multiple items in the cart

  @Regression
  Scenario: Remove an item from the cart
    When User adds multiple items to the cart
    And User opens the cart page
    And User removes one item from the cart
    Then The removed item should no longer be in the cart

  @Regression
  Scenario: Verify cart badge count after adding items
    When User adds multiple items to the cart
    Then Cart badge count should match number of items added

  @Regression
  Scenario: Verify cart badge disappears after removing all items
    When User adds multiple items to the cart
    And User opens the cart page
    And User removes all items from the cart
    Then Cart badge should not be visible

  @Smoke
  Scenario: Navigate to cart from homepage
    When User clicks on cart icon
    Then User should be navigated to the cart page

  @Regression
  Scenario: Verify cart is empty when no items added
    When User opens the cart page
    Then Cart should be empty
