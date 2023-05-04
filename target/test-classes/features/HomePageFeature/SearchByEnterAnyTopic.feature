Feature: Search By Enter Any Topic


  @search @smoke
  Scenario: As a user I should be able search topics from search button and see them after search
    Given I have logged into my BBC News account
    Then I click the search button
    When "More Topics" is displayed on the search page
    Then I search for "England"
    And "Articles related to" "England" is displayed on the page
    Then all topics on the navigation bar should contain "England"