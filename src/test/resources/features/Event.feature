Feature: Verify event feature

  @CreateEvent
  Scenario: Verify create event feature
    Given I prepare request structure to create event
    When I hit an api to create event
    Then I verify event created successfully