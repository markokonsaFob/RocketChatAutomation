Feature: Direct cross-platform messenger

  @LoggedInUsers
  Scenario: User sends direct cross-platform message
    Given user opens sidebar on ANDROID device
    And sidebar is visible on IOS device
    When user open "mwc-fobsolutions" channel on IOS device
    And user open "mwc-fobsolutions" channel on ANDROID device
    And user open "mwc-fobsolutions" channel on BROWSER device
    Then BROWSER and IOS are having a conversation with each other