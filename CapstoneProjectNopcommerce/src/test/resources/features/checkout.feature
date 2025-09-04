Feature: Checkout Functionality
  As a user
  I want to proceed to checkout after adding a product to my shopping cart
  So that I can complete my purchase

  Background: I am logged in
    Given I am on the login page
    When I enter valid email and password
    And I click on the login button
    Then I should be logged in successfully

  Scenario: Complete checkout
    Given I am on the homepage
    When I add a product to the cart
    And I proceed to checkout
    And I complete the checkout form
    Then I should complete the checkout successfully
