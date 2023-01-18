Feature: Verify file upload feature

  @FileUpload
  Scenario:  file upload in postman api
    Given  I prepare request structure to upload the file
    When I hit an api to upload a file
    Then I verify file uploaded successfully