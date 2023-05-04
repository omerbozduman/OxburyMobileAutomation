Feature: Video Tab


  @videotab @smoke
  Scenario: As a user I should tab video tab and display BBC New Channel title
    Given I have logged into my BBC News account
    Then I navigate to "Video" tab
    And "Watch Live: BBC News" is displayed on the video tab
    And "Copyright © 2018 BBC" is displayed bottom of the screen

