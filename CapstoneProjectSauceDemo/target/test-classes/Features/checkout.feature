@Checkout
Feature: Checkout functionality
  As a user
  I want to checkout items from the cart
  So that I can complete my purchase

  Background:
    Given User is logged in
    And User adds multiple items to the cart
    And User opens the cart page

  @Smoke
  Scenario: Proceed to checkout
    When User clicks on Checkout button
    Then User should be on the Checkout Information page

  @Regression
  Scenario: Fill valid checkout information and continue
    When User clicks on Checkout button
    And User fills checkout information
    And User clicks on Continue button
    Then User should be on the Checkout Overview page

  @Regression
  Scenario: Try to continue without filling required fields
    When User clicks on Checkout button
    And User clicks on Continue button
    Then Error message should be displayed

  @Smoke
  Scenario: Complete checkout process successfully
    When User clicks on Checkout button
    And User fills checkout information
    And User clicks on Continue button
    And User clicks on Finish button
    Then User should see order confirmation message

  @Regression
  Scenario: Cancel checkout from information page
    When User clicks on Checkout button
    And User clicks on Cancel button
    Then User should be navigated back to the cart page

  @Regression
  Scenario: Cancel checkout from overview page
    When User clicks on Checkout button
    And User fills checkout information
    And User clicks on Continue button
    And User clicks on Cancel button
    Then User should be navigated back to the products page

  @Regression
  Scenario: Verify order summary in overview page
    When User clicks on Checkout button
    And User fills checkout information
    And User clicks on Continue button
    Then User should see selected items in the summary
    And Total price should be displayed

  @Smoke
  Scenario: Verify Finish button completes order
    When User clicks on Checkout button
    And User fills checkout information
    And User clicks on Continue button
    And User clicks on Finish button
    Then User should see order completion page
