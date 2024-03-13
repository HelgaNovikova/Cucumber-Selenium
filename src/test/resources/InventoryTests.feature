Feature: Inventory Tests

  Background:
    Given User navigates to Inventory page

  Scenario: Verify years filter
    When User chooses value in year filter
    Then Result page contains only cars of the chosen year

  Scenario: Verify transmission filter
    When User chooses values in transmission filter
    Then Result page contains only cars of the chosen transmission

  Scenario: Verify make filter
    When User chooses values in make filter
    Then Result page contains only cars of the chosen maker

  Scenario Outline: Verify sorting by "<sortBy>"
    When User chooses sort by "<sortBy>"
    Then Result page contains cars sorted by "<sortBy>"
    Examples:
      | sortBy                 |
      | Price (Low to High)    |
      | Price (High to Low)    |
      | Odometer (Low to High) |
      | Odometer (High to Low) |
      | Year (Low to High)     |
      | Year (High to Low)     |
      | Make (A - Z)           |
      | Make (Z - A)           |
      | Model (A - Z)          |
      | Model (Z - A)          |