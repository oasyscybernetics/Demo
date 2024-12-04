@AccountCreation
Feature: Account Creation for a customer

  Scenario Outline: To create a account for a new customer
    Given Open the browser and go the store URL
    And Select the Create An Account option
    When Enter the "<firstname>" and "<lastname>" under personal information
    And Enter the "<email>" and "<password>" under sign-in information
    And Again re-enter the same password in "<confirm_password>"
    Then Click on Create An Accounts
    And Check for the "Thank you for registering with Main Website Store."

    Examples: 
      | firstname | lastname | email                     | password    | confirm_password |
      | Spring    | Potato   | lumatestingdemo@gmail.com | Hello@12345 | Hello@12345      |
