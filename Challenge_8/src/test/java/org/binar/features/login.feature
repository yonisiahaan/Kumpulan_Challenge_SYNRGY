@login
Feature: Login

  @login
  Scenario Outline: As a user, I should be able to login using valid username and valid password
    Given user is on the login page
    And user input valid username "<username>" and valid password "<password>"
    When user click on the login button
    Then user direct to home page

    Examples:
      |    username   |   password   |
      | standard_user | secret_sauce |

  @login
  Scenario Outline: As a user, I should not be able to login using valid username and invalid password
    Given user is on the login page
    And user input valid username "<username>" and invalid password "<password>"
    When user click on the login button
    Then error alert exist with value "<message>"

    Examples:
      |    username   |  password  |                      message                                 |
      | standard_user | fake_sauce | Username and password do not match any user in this service. |
