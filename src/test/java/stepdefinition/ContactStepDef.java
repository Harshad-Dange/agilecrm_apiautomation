package stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.Map;

public class ContactStepDef extends  BaseClass{
    RequestSpecification requestSpecification;
    Response response;

    @Given("I prepare request structure to get the contact")
    public void iPrepareRequestStructureToGetTheContact(Map<String, String> table) {
        //RequestSpecification --> is a interface
        //RestAssured--> class which is returining the reference of RequestSpecification
        RestAssured.useRelaxedHTTPSValidation();
        //RestAssured.baseURI ="https://webtesting.agilecrm.com";  // base uri setup
        //RestAssured.basePath="/dev/api/";
        String headers = table.get("header");  //Accept:application/json
        String headerKey = headers.split(":")[0];  //Accept
        String headerValue = headers.split(":")[1]; //application/json
        requestSpecification.baseUri("https://webtesting.agilecrm.com")
                .basePath("/dev/api/")
                .header(headerKey, headerValue)
                .auth().basic(table.get("username"), table.get("password")).log().all();
    }

    @Then("I verify the contact information using {string} and status code should be {int}")
    public void iVerifyTheContactInformationUsing(String expectedId, int statusCode, Map<String, String> table) {
        int actualStatusCode = response.statusCode();
        Assert.assertEquals(statusCode, actualStatusCode);
        boolean valid = Boolean.parseBoolean(table.get("valid"));
        if (valid) {
            String actualId = response.jsonPath().getString("id");
            //replacing if-else with junit assertion
//            Assert.assertEquals(expectedId, actualId);
        } else {
            System.out.println("API Response has no content");
        }
    }
}
