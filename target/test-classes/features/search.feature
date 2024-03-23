@Search
Feature: Search

  Scenario: Product Search

    Given User goes to beksitealpha
    And   User types "product" into searchbar
    Then  Verify that searched products in the results