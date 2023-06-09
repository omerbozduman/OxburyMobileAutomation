Feature: Search From More Topics


  @search @smoke
  Scenario: As a user I should be able to search topics from search button and see them after search
    Given I have logged into my BBC News account
    Then I click the search button
    When "More Topics" is displayed on the search page
    Then I select "England" from more topics
    And I should see all related topics on the navigation bar