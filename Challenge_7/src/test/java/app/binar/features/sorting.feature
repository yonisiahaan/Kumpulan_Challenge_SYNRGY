@sorting
Feature: Sorting

  @sorting
  Scenario: As a user, I should be able to log in using correct registered data
    Given user navigate to url "https://www.saucedemo.com/"
    When user login using "standard user"
    And user select filter price high to low
    Then compare first product price with second product price
    And user take screenshot "user-sorting-high-to-low-successfully"