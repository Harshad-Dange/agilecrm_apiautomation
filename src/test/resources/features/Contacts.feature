Feature: Verify contact functionality

  @GetAllContacts
  Scenario Outline: Verify create contact feature
    Given I create request structure to create contact
      | type      | <type>      |
      | source    | <source>    |
      | tags      | <tags>      |
      | firstName | <firstName> |
      | lastName  | <lastName>  |
      | email     | <email>     |
    When I hit create contact api
    Then I verify the create contact api response using <statusCode>
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
      | valid | type   | source | tags         | firstName   | lastName   | email   | statusCode |
      | true  | PERSON | manual | sanity,smoke | RestAssured | Automation | valid   | 200        |
      | false | PERSON | manual | sanity,smoke |             | Automation | valid   | 500        |
      | false | PERSON | manual | sanity,smoke | API         |            | valid   | 500        |
      | false | XYZ    | manual | sanity,smoke |             |            | valid   | 500        |
      | false | XYZ    | manual | sanity,smoke |             | Automation | invalid | 500        |
      | false | XYZ    | manual | sanity,smoke |             |            | invalid | 500        |

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


  Scenario: Verify missing email ids in contacts
    Given I prepare request structure to get the contact
      | username | apitesting@yopmail.com     |
      | password | jabhmj91tibtjpsnijbs63lere |
      | header   | Accept:application/json    |
    When I hit an api
      | endpoint   | contacts |
      | pathParam  |          |
      | httpMethod | GET      |
    Then I verify missing email ids in contact


  Scenario: Get contact information who is not associated with company
    Given I prepare request structure to get the contact
      | username | apitesting@yopmail.com     |
      | password | jabhmj91tibtjpsnijbs63lere |
      | header   | Accept:application/json    |
    When I hit an api
      | endpoint   | contacts |
      | pathParam  |          |
      | httpMethod | GET      |
    Then I print all contact info who is not associated to company


  @SearchContact
  Scenario: Search contact information
    Given I prepare request structure to search contact
    When I hit an api
      | endpoint   | search              |
      | queryParam | q:cyber,type:PERSON |
      | httpMethod | GET                 |
    Then I verify the contact should be listed in the response



      # Create Contact
      #Verify create contact response
      #get contact by id
      #verify get contact by id api response with request body of create contact


  @GetAllContact
  Scenario: Verify get all contact info in xml format
    Given I prepare request structure to search contact
    When I hit an api
      | endpoint   | contacts |
      | httpMethod | GET      |
    Then I verify the get all contact response














