
Feature: Library app table headers

  Scenario: Table columns names
    Given user is on the login page
    When "librarian" enters credentials and clicks sign in button
    And user click on "Users" link
    Then table should have following column names:
      | Actions   |
      | User ID   |
      | Full Name |
      | Email     |
      | Group     |
      | Status    |