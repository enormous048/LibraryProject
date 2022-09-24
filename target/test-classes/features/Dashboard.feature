

Feature: As a user I should be able to login as librarian and see 660 users on dashboard


Scenario: Login as librarian same line
    Given I am on the login page
    When I login using "librarian12@library" and "wHhJQDSK"
    Then dashboard should be displayed
    And there should be 665 users


    # Нічо собі, я можу написати в новому фічур файлі такий самий текскт як і в минулих фічур файлах
    # наприклад логін аз лайбреріан, і вони не конфліктять