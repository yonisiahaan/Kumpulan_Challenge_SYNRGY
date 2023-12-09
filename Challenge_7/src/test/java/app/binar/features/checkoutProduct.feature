@checkout
Feature: Checkout

  @checkout
  Scenario: As a user, I should be able to log in using correct registered data
    Given user navigate to url "https://www.saucedemo.com/"
    When user login using "standard user"
    And user click Add To Cart button on product
    And user do checkout
    Then verify checkout successfully
    And user take screenshot "user-checkout-successfully"