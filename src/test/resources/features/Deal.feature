Feature: Verify deal feature


  Scenario Outline: verify create deal api
    Given I prepare request structure to create deal
      | name   | expectedValue   | probability   | milestone   | contactIds   | customData   |
      | <name> | <expectedValue> | <probability> | <milestone> | <contactIds> | <customData> |
    When I hit an api to create deal
    Then I verify deal created successfully using "<statusCode>"
      | name   | expectedValue   | probability   | milestone   | contactIds   | customData   |
      | <name> | <expectedValue> | <probability> | <milestone> | <contactIds> | <customData> |
    Examples:
      | name  | expectedValue | probability | milestone | contactIds     | customData     | statusCode |
      | Deal2 | 500.0f        | 100         | Won       |                | Group Size, 10 | 200        |
      |       | 500.0f        | 100         | Won       |                | Group Size, 10 | 200        |
      | Deal2 | 68767         | 100         | Won       |                | Group Size, 10 | 200        |
      | Deal2 | 500.0f        | 100         | test      |                | Group Size, 10 | 200        |
      | Deal2 | 500.0f        | 100         | Won       | 58758,78585    | Group Size, 10 | 200        |
      | Deal2 | 500.0f        | 100         | Won       |                |                | 200        |
      | Deal2 | 500.0f        | 1000        | Won       |                |                | 200        |
      | Deal2 | 500.0f        | -10         | Won       |                |                | 200        |
      | Deal2 | 500.0f        | -10         |           |                |                | 400        |
      | Deal2 | 500.0f        | true        | Won       |                | Group Size, 10 | 400        |
      | Deal2 | 500.0f        | 100         | Won       | dysdt,sajdfjsa | Group Size, 10 | 400        |
      | Deal2 | test          | 100         | Won       |                | Group Size, 10 | 400        |
      |       |               |             |           |                |                | 400        |
      | Deal2 | 500.0f        | 100         | 13243     |                | Group Size, 10 | 200        |
      | Deal2 | 500.0f        | 100f        | Won       |                | Group Size, 10 | 400        |

  @CreateDeal
  Scenario: Serialization/Deserialization of create deal api
    Given I prepare request structure to create deal using serialization concept
      | name  | expectedValue | probability | milestone | contactIds | customData     | statusCode |
      | Deal2 | 500           | 100         | Proposal  |            | Group Size, 10 | 200        |
#    When I hit an api to create deal
    Then Verify api response using deserialization
#    Then I verify deal created successfully using "200"
#      | name  | expectedValue | probability | milestone | contactIds | customData     |
#      | Deal2 | 500.0f        | 100         | Proposal  |            | Group Size, 10 |


  @GetAllDeal
  Scenario: Deserialization of get deal api
    Given I prepare request structure to get all deals
    Then Verify get all deals api response using deserialization















