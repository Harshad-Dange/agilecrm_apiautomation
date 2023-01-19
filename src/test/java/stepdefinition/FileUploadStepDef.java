package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.io.*;

public class FileUploadStepDef {
    RequestSpecification requestSpecification;
    Response response;
    File file;
    @Given("I prepare request structure to upload the file")
    public void prepareFileUploadRequest(){
        String filePath ="src/test/resources/reqFiles/event_request.json";

       String [] fileObjects= filePath.split("/");

       String fileName = fileObjects[fileObjects.length-1];

        System.out.println( "******** Name of File Is : " + fileName + "*************");

        file= new File(filePath);

        RestAssured.useRelaxedHTTPSValidation();
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://postman-echo.com")
                .header("Accept", ContentType.JSON)
                .multiPart("file", file, ContentType.JSON.toString())
                .log().all();
    }

    @When("I hit an api to upload a file")
    public void iHitAnApiToUploadAFile() {
        response = requestSpecification.post("/post");
        Assert.assertEquals(200, response.statusCode());
        response.prettyPrint();
    }

    @Then("I verify file uploaded successfully")
    public void iVerifyFileUploadedSuccessfully() {
        String fileDetails = response.jsonPath().get("files."+ file.getName());
        System.out.println(fileDetails);
    }

    @Given("I prepare request structure to download the file")
    public void iPrepareRequestStructureToDownloadTheFile() {

        RestAssured.useRelaxedHTTPSValidation();
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://github.com/")
                .basePath("DataTalksClub/data-engineering-zoomcamp/raw/main/images/architecture/")
                .log().all();
    }

    @When("I hit an api to download the byte array file")
    public void iHitAnApiToDownloadTheFile() {
        byte [] inputByteArray = requestSpecification.get("arch_1.jpg")
                .asByteArray();

        try {
            FileOutputStream  fileOutputStream = new FileOutputStream("src/test/resources/test.png");
            fileOutputStream.write(inputByteArray);
            fileOutputStream.flush();
            fileOutputStream.close();

        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("I hit an api to download the inputStream  file")
    public void iVerifyFileDownloadedSuccessfully() {

            InputStream inputStream =requestSpecification.get("arch_1.jpg").asInputStream();

            try{
                byte []  inputArray = new byte[inputStream.read()];
                FileOutputStream  fileOutputStream = new FileOutputStream("src/test/resources/test1.jpg");
                fileOutputStream.write(inputArray);
                fileOutputStream.flush();
                fileOutputStream.close();
            }catch (IOException e){

            }


    }
}
