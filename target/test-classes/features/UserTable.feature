

Feature: As a user, I should be able to login as librarian. When I go to Users
  page, table should have expected columns

  Scenario: Table columns names
    Given I am on the login page
    When I login using "librarian12@library" and "wHhJQDSK"
    And I click on Users link
    Then table should have following column names:
      | Actions   |
      | User ID   |
      | Full Name |
      | Email     |
      | Group     |
      | Status    |