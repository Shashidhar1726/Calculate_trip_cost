Feature: getting error messages by providing invalid details
@smoke @regression
  Scenario: capturing error message by providing invalid details
    Given user in gift voucher page
    When user fill corparate quieries form with invalid phone number
    Then get the error message and store it in excel sheet
    When user fill corparate quieries form with invalid email id
    Then get the error message and store it in excel sheet
