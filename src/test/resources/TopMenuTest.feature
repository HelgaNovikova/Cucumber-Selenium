Feature: Top menu tests

  Background:
    Given User navigates to 'https://www.rightwayautosale.com/' page

  Scenario: Navigate to the About Us page and verify it is displayed correctly
    When User clicks About Us
    Then Page with correct title is opened

  Scenario: Navigate to the Contact Us page and verify it is displayed correctly
    When User clicks Contact Us
    Then It's possible to send a message
