@azrlogin
Feature: Login

  Scenario: Happy path
    Given User goes to azrlotereya website
    When User click Dahil Ol button
    And User enters valid email
    And User enters valid password
    And User click Dahil Ol button in the modal
    Then User verify that user on the mainpage