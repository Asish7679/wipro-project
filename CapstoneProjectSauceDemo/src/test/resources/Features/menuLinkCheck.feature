@BurgerMenu @Smoke
Feature: Hamburger menu links
  As a logged-in user
  I want to verify all links inside the burger menu
  So that navigation works correctly

  Background:
    Given User is logged in

  @Smoke
  Scenario: Open burger menu
    When User opens the burger menu
    Then Burger menu should be visible

  @Smoke
  Scenario: Verify all links are displayed
    When User opens the burger menu
    Then All menu links should be visible

  @Smoke
  Scenario: Verify all links are clickable
    When User opens the burger menu
    Then All menu links should be clickable
