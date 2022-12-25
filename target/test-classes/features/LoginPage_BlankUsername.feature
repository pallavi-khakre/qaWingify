Feature: check login functionality with valid username and password  

Scenario: verify user can login with a valid username and valid password
Given navigate to login page
When user logged in using username as "" and password as "Password"
Then verify error message if UserName is blank
