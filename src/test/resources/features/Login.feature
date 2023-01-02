Feature: Verify login feature of agile crm application
#
#  Scenario: verify login feature with valid credentials
#    Given I launch the "chrome" browser and navigate to website "https://webtesting.agilecrm.com/"
#    When I enter valid username "apitesting@yopmail.com"
#    And I enter valid password "FOW13TXF"
#    And Click on login button
#    Then I should login to application successfully

#  Scenario Outline: Verify login with valid and invalid cred
#    Given I launch the "<browser>" browser and navigate to website "<url>"
#    When I enter valid username "<username>"
#    And I enter valid password "<password>"
#    And Click on login button
#    Then Verify user login to application with "<valid>" details
#    Examples:
#      | browser | url                              | username               | password   | valid |
#      | edge    | https://webtesting.agilecrm.com/ | apitesting@yopmail.com | FOW13TXF   | true  |
#      | chrome  | https://webtesting.agilecrm.com/ | api@yopmail.com        | fjdfjasdjg | false |

  #Scenario with data table in map<key,val> format
#  Scenario Outline: Verify create contact functionality
#    Given I login to the application
#    When I create contact in the system
#      | first_name   | <firstName> |
#      | last_name    | <lastName>  |
#      | title        | <title>     |
#      | email_id     | <email>     |
#      | phone_number | <phoneNum>  |
#    Then I verify the contact is created successfully
#      | first_name   | <firstName> |
#      | last_name    | <lastName>  |
#      | title        | <title>     |
#      | email_id     | <email>     |
#      | phone_number | <phoneNum>  |
#      | valid        | <valid>     |
#    Examples:
#      | firstName | lastName | title       | email            | phoneNum      | valid |
#      | api1      | testing1 | QA Engineer | api1@yopmail.com | 7676434396989 | true  |
#      | api2      | testing2 | QA Engineer | api2@yopmail.com |               | false |
#
#
#  Scenario Outline: verify create company functionality
#    Given I login to the application
#    When  I create company in the system
#      | Company_Name  | website_url | email   | phoneNum   | valid   |
#      | <companyName> | <url>       | <email> | <phoneNum> | <valid> |
#    Then I verify the company is created successfully
#    Examples:
#      | companyName | url         | email            | phoneNum      | valid |
#      | api1        | QA Engineer | api1@yopmail.com | 7676434396989 | true  |
#      | api2        | QA Engineer | api2@yopmail.com |               | false |

# get data in list format
  Scenario Outline: verify create company functionality
#    Given I login to the application
    Given  I create company in the system
      | <companyName> |
      | <url>         |
      | <email>       |
      | <phoneNum>    |
      | <valid>       |
    Then I verify the company is created successfully
    Examples:
      | companyName | url         | email            | phoneNum      | valid |
      | api1        | QA Engineer | api1@yopmail.com | 7676434396989 | true  |
      | api2        | QA Engineer | api2@yopmail.com |               | false |




#  Scenario: verify login feature with invalid credentials
#    Given I launch the browser and navigate to website
#    When I enter invalid username
#    And I enter invalid password
#    And Click on login button
#    Then I verify error message on the screen
#
#  Scenario: Sample scenario
#    Given I have 2 numbers
#    When I do the addition of "10,20,30,40,50,60" and 20
#    Then I should get the "output" as 30

