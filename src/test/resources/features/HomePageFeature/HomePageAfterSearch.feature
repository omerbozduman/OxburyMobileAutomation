Feature: Home page after search


  @search @smoke
  Scenario: As a user I should be able to navigate back to homepage after search any topics
    Given I have logged into my BBC News account
    Then I click the search button
    When "More Topics" is displayed on the search page
    Then I search for "England"
    And "Articles related to" "England" is displayed on the page
    Then I navigate to home page
    And following tab titles are displayed on the home page
    |Top Stories|
    |My News    |
    |Popular    |
    |Video      |