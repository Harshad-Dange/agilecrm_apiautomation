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

    @CreateCompany
    Scenario: verify get by id api
      Given I prepare request structure to create company
      When I hit an api to get a company
      Then I verify the company information retriving successfully in the response

