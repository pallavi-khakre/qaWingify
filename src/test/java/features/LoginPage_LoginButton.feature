Feature: check login button functionality 

Scenario: verify user can login by click on login button
Given navigate to login page
When user logged in using username as "UserName" and password as "Password"
Then home page should be displayed