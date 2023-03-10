Feature: Verify contact functionality

  Scenario Outline: Verify create contact feature
    Given I create request structure to create contact
      | type      | <type>      |
      | source    | <source>    |
      | tags      | <tags>      |
      | firstName | <firstName> |
      | lastName  | <lastName>  |
      | email     | <email>     |
    When I hit create contact api
    Then I verify the contact is created successfully
      | type      | <type>      |
      | source    | <source>    |
      | tags      | <tags>      |
      | firstName | <firstName> |
      | lastName  | <lastName>  |
      | email     | <email>     |
      | valid     | <valid>     |
    And I verify newly created contact in  get by id api
      | type      | <type>      |
      | source    | <source>    |
      | tags      | <tags>      |
      | firstName | <firstName> |
      | lastName  | <lastName>  |
      | email     | <email>     |
      | valid     | <valid>     |
    Examples:
      | valid | type   | source | tags         | firstName | lastName   | email        |
      | true  | PERSON | manual | sanity,smoke | API       | Automation | api@test.com |
      | false | XYZ    | manual | sanity,smoke | API       | Automation | api@test.com |
      | false | PERSON | manual | sanity,smoke |           | Automation | api@test.com |
      | false | XYZ    | manual | sanity,smoke | API       |            | api@test.com |
      | false | XYZ    | manual | sanity,smoke | API       | Automation | api@test.com |
      | false | XYZ    | manual | sanity,smoke | API       | Automation |              |

  @GetContact
  Scenario Outline: Verify get contact api
    Given I prepare request structure to get the contact
      | username | apitesting@yopmail.com     |
      | password | jabhmj91tibtjpsnijbs63lere |
      | header   | Accept:application/json    |
    When I hit an api
      | endpoint   | contacts    |
      | pathParam  | <pathParam> |
      | httpMethod | GET         |
    Then I verify the contact information using "<pathParam>" and status code should be <statusCode>
      | valid | <valid> |
    Examples:
      | pathParam        | valid | statusCode |
      | 4548918478438400 | true  | 200        |
      | null             | false | 400        |
      |                  | true  | 200        |
      | 313423423        | false | 204        |
      | #^$#^            | false | 400        |
      | sfedgef          | false | 400        |

















