Feature: Implement Mock Server

  @MockServer
  Scenario: Implementation of mock server using wiremock library
    Given I setup mock server
    When I hit an api to get response from mock server
    Then I verify the response