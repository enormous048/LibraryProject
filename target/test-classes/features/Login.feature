

Feature: Library app login feature
  User Story:
  As a user, I should be able to login with correct
  credentials to different accounts

  Background: Assuming user is on the login page
    Given user is on the login page
  @librarian @employee
  Scenario: Login as librarian
    When user enters librarian username "librarian12@library"
    And user enters librarian password "wHhJQDSK"
    Then user should see the dashboard

  @student
  Scenario: Login as student
    When user enters student username "student12@library"
    And user enters student password "8ENtWqOe"
    Then user should see the dashboard