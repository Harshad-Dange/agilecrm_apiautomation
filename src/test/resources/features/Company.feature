Feature: Verify company module

  @GetCompanyList
  Scenario: verify get company by list api
    Given I prepare request structure for get company
      | username | apitesting@yopmail.com     |
      | password | jabhmj91tibtjpsnijbs63lere |
      | header   | Accept:application/json    |
      | basePath | /dev/api/contacts/          |
    When I hit an api
      | endpoint   | companies/list |
      | httpMethod | POST           |
    Then I verify the company list api response

