Feature: Browsing and Navigation

  Background:
    Given I am on the homepage

  Scenario: Navigate via main categories
    When I click on "Electronics" category
    And I select "Cell phones"
    Then I should see the list of cell phones displayed

  Scenario: Navigate via sitemap footer
    When I click on the sitemap link in the footer
    Then I should see the full site map displayed

  Scenario: Access Shipping & Returns informational page
    When I click on "Shipping & returns" link
    Then I should see the Shipping & Returns page content

  Scenario: Access Privacy Notice informational page
    When I click on "Privacy notice" link
    Then I should see the Privacy Notice page content
    
  Scenario: Access Conditions of Use page
    When I click on "Conditions of Use" link
    Then I should see the Conditions of Use page content
    
  Scenario: Access About us page
    When I click on "About us" link
    Then I should see the About us page content
    
  Scenario: Access Contact us page
    When I click on "Contact us" link
    Then I should see the Contact us page content
    
  Scenario: Access News page
    When I click on "News" link
    Then I should see the News content
    
  Scenario: Access New products page
    When I click on "New products" link
    Then I should see the New products content

  Scenario: Access Blog page
    When I click on "Blog" link
    Then I should see the Blog content