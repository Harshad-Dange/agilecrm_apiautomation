
 Feature: Verify user api

   @CreateUser
   Scenario: verify create user api
     Given I prepare request structure to create user
     Then I verify the user is created successfully