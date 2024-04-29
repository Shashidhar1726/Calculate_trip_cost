Feature: Display hotel details with specific filters
@smoke @functional
  Scenario: Display first three hotel details with specific filters
    Given user open application with provided url
    When user click on hotels button and set the location
    And select the checkin and checkout dates
    And set the traveller count
    And click on search hotels button
    Then list of hotels will be displayed
    When user sort the list with highest user rating
    And select  free wifi and free breakfast filters
    And select laundry  and swimming pool filters under amenities
    Then collect the hotel details that are filtered
    And Store the details in excel sheet
