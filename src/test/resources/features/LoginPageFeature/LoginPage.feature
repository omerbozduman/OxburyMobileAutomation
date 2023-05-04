Feature: Login page

  @login
  Scenario: As a user I should be able to login my BBC News account
    Given I have launched the BBC news app
    When "Sign in to your BBC account" title is displayed
    Then I click the sign in button
    When "Sign in" page appears on the screen
    Then I enter my username
    And I enter my password
    Then I click sign in button



   @smoke
  Scenario: As a user I should be able login my BBC News account without enter my credentials
    Given I have launched the BBC news app
    When "Sign in to your BBC account" title is displayed
    Then I click the sign in button
    And I continue to sign in my account