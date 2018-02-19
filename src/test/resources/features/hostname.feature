Feature: Hostname

  @android
  Scenario: User enters invalid hostname on android
    Given user opens ANDROID application
    Then hostname view should be visible
    When user enters valid hostname into hostname field
    And user clicks on select button
    Then login view should be visible

  @iOS
  Scenario: User enters valid hostname on iOS
    Given user opens IOS application
    Then hostname view should be visible
    When user enters valid hostname into hostname field
    And user clicks on select button
    Then login view should be visible

  @browser
  Scenario: User opens valid host name on browser
    Given user opens BROWSER application
    When user opens valid hostname url
    Then login view should be visible