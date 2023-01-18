package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.io.File;

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
}
