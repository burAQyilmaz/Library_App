
Feature:Library app login feature

  User Story: As a user, I should be able to login with correct credentials to different accounts

  Background: Assuming user is on the login page
    Given user is on the login page

  Scenario: Login as librarian
    When user enters username as "librarian12@library"
    And user enters user password as "libraryUser"
    And user clicks sign in button
    Then user should see the dashboard

  Scenario: Login as student
    When user enters username as "student8@library"
    And user enters user password as "libraryUser"
    And user clicks sign in button
    Then user should see the dashboard

  Scenario: Login as librarian in the same line
    When "librarian" enters credentials and clicks sign in button
    Then user should see the dashboard

  Scenario: Login as student in the same line
    When "student" enters credentials and clicks sign in button
    Then user should see the dashboard