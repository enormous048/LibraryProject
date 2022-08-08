
Feature: As a user I should be able to successfully login and logout from VyTrack page.

  Scenario: User login with excel
    Given User is on VyTrack login page
    Then User logins with different data, sees expected name and surname, logouts