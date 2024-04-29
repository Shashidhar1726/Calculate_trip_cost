Feature: cruise line
@smoke
  Scenario: getting inclusion points from the cruise line
    Given user in home page
    When user click on more button
    And click on cruise
    And select first cruise line
    Then cruise line details will be displayed
    And get the inclusion points and display in console
    And store inclusion points in excel sheet
