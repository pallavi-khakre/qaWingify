Feature: check login functionality with valid blank username and password  

Scenario: verify user can login with blank username and blank password
Given navigate to login page
When user logged in using username as "" and password as ""
Then verify error message