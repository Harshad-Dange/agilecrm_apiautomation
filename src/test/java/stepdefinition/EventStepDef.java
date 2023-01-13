package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class EventStepDef {
    RequestSpecification requestSpecification;
    Response response;
    RequestSpecBuilder requestSpecBuilder;

    @Given("I prepare request structure to create event")
    public void createEvent() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", ContentType.JSON.toString());
        String rootPath = System.getProperty("user.dir"); // path of the project
        File file = new File(rootPath + "/src/test/resources/reqFiles/event_request.json");
        if (file.exists()) {
            System.out.println("file is present to defined location.....");
        }

//        requestSpecBuilder = new RequestSpecBuilder()
//                .setBaseUri("https://webtesting.agilecrm.com")
//                .setBasePath("/dev/api")
//                .addHeaders(headers)
//                .setContentType(ContentType.JSON)
//                .setBody(file)
//                .log(LogDetail.ALL);
        RestAssured.useRelaxedHTTPSValidation();
        requestSpecification = given();
        requestSpecification.baseUri("https://webtesting.agilecrm.com")
                .basePath("/dev/api")
                .header("Accept", ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(file)
                .auth()
                .basic("apitesting@yopmail.com", "jabhmj91tibtjpsnijbs63lere")
                .log().all();
    }

    @When("I hit an api to create event")
    public void iHitAnApiToCreateEvent() {

        response=requestSpecification.post("/events");
//
//        requestSpecification = requestSpecBuilder.build();
//        response = RestAssured.given(requestSpecification)
//                .relaxedHTTPSValidation().auth()
//                .basic("apitesting@yopmail.com", "jabhmj91tibtjpsnijbs63lere")
//                .post("/events");

    }

    @Then("I verify event created successfully")
    public void iVerifyEventCreatedSuccessfully() {

        response.prettyPrint();
        Assert.assertEquals(200, response.statusCode());
    }
}
