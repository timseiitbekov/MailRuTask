@login
Feature: User should be able to login to the Mail.ru via the login page

  Background:
    Given User navigates to the Mail.ru login page


  Scenario: Positive user login with valid credentials
    When User inputs following credentials
      | username                | password               |
      | timsearstesting@mail.ru | testcasefromthetestlab |
    Then Validate the user has logged in