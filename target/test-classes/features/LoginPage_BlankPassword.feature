Feature: check login functionality with valid username and password  

Scenario: verify user can login with a valid username and valid password
Given navigate to login page
When user logged in using username as "UserName" and password as ""
Then verify error message if Password is blank
