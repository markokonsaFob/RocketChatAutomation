Feature: Direct cross-platform messenger

  @LoggedInUsers
  Scenario: User sends direct cross-platform message
    Given sidebar is visible on ANDROID device
    And sidebar is visible on IOS device
    And sidebar is visible on BROWSER device
    When user open "mwc-fobsolutions" channel on IOS device
    And user open "mwc-fobsolutions" channel on ANDROID device
    And user open "mwc-fobsolutions" channel on BROWSER device
    Then direct messenger view should be visible on ANDROID device
    When user send message from BROWSER device
    Then message should be visible on IOS device
    And message should be visible on ANDROID device
    When user send message from IOS device
    Then message should be visible on ANDROID device
    And message should be visible on BROWSER device