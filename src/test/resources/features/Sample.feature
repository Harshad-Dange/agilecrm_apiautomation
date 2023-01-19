Feature: This is a sample feature
#  Background: precondition
#    Given I launch the "mozila" browser and navigate to website "url"
#    When I login to the application

#  @Sanity @TagHook1 @AfterTagHook1
#  Scenario: Verify create contact feature
#    Given I create contact in the system
#      | first_name | <firstName> |
#    Then I verify the contact is created successfully
#      | first_name | <firstName> |
#
#  @Regression @TagHook1 @TagHook2
#  Scenario: Verify create company feature
#    Given I create contact in the system
#      | first_name | <firstName> |
#    Then I verify the contact is created successfully
#      | first_name | <firstName> |
#
#  @System @DbConnection
#  Scenario: Verify create deals feature
#    Given I create contact in the system
#      | first_name | <firstName> |
#    Then I verify the contact is created successfully
#      | first_name | <firstName> |

  @Download
  Scenario: download
    Given I download the file
    Then I verify the company is created successfully


  @mockserver
  Scenario: download
    Given I setup wiremock server
