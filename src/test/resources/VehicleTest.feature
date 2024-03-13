Feature: Vehicle Details Screen Tests

  Background:
    Given User navigates to Inventory page

    Scenario: Verify vehicle details are displayed correctly
      When User clicks View Details for any car on the inventory page
      Then Vehicle details page contains the same vehicle data

