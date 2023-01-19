Feature: Verify file upload feature

  @FileUpload
  Scenario:  file upload in postman api
    Given  I prepare request structure to upload the file
    When I hit an api to upload a file
    Then I verify file uploaded successfully

    @DownloadFile
    Scenario:  download the file in RestAssured
      Given I prepare request structure to download the file
      When I hit an api to download the byte array file
      And I hit an api to download the inputStream  file