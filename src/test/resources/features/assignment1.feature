@android
Scenario: User opens side menu with swipe
Given user opens ANDROID application and is logged in
Then home screen should be visible
When user swipes from left to right
Then side menu should open

@android
Scenario: Changing user status
Given user opens ANDROID application and is logged in
Then home screen should be visible
When user opens side menu and clicks top right button
And user clicks on away
Then status should change to away

@android
Scenario: Logging out
Given user is logged in
Then Home screen should be visible
When user opens side menu and clicks top right button
And user clicks logout
Then user should log out and login screen should be visible