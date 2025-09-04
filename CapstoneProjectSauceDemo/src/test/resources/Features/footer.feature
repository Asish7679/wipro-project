@FooterLinks @Smoke
Feature: Verify social media links in footer
  As a logged-in user
  I want to check social media links
  So that I can confirm they navigate correctly

  Background:
    Given User is logged in

  @Smoke
  Scenario: Verify social media links are visible
    When User checks the social media links
    Then Clicking each link should navigate to the expected URL
