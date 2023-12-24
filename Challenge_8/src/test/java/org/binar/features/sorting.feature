@sorting
Feature: Sorting

  @Sorting
  Scenario Outline: As a user, I should be able to filter the product using valid username and valid password
    Given user is on the login page
    When user input valid username "<username>" and valid password "<password>"
    And user select filter price low to high
    Then compare first product price with second product price
    And user take screenshot "user-sorting-low-to-high-successfully"

    Examples:
      |    username   |   password   |
      | standard_user | secret_sauce |