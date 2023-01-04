package stepdefinition;

import Util.Utility;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ContactStepDef extends BaseClass {

    RequestSpecification requestSpecification;
    Response response;
    Long id;

    @Given("I prepare request structure to get the contact")
    public void iPrepareRequestStructureToGetTheContact(Map<String, String> table) {
        //RequestSpecification --> is a interface
        //RestAssured--> class which is returining the reference of RequestSpecification
        RestAssured.useRelaxedHTTPSValidation();
        requestSpecification = RestAssured.given();
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

    @When("I hit an api")
    public void iHitAnApi(Map<String, String> table) {
        try {
            ContactStepDef contactStepDef = new ContactStepDef();
            String endpoint;
            if (table.get("pathParam") != null) {
                endpoint = table.get("endpoint") + "/" + table.get("pathParam");  //  contacts/{id}
            } else {
                endpoint = table.get("endpoint"); //contacts/
            }
            //get the http method from feature file
            String httpMethod = table.get("httpMethod");
            //based on https method and endpoint, execute method will hit the api
            execute(httpMethod, endpoint);
        } catch (Exception e) {
            e.printStackTrace();
        }

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

    @Then("I verify missing email ids in contact")
    public void iVerifyMissingEmailIdsInContact() {
        List<List<Map<String, String>>> propDetails = response.jsonPath().getList("properties");
        for (List<Map<String, String>> prop : propDetails) {
            String contactName = null;
            String email = null;
            for (Map<String, String> propObject : prop) {
                if (Objects.nonNull(propObject.get("name")) && propObject.get("name").equals("first_name")) {
                    contactName = propObject.get("value"); // get the contact first name from property object
                } else if (Objects.nonNull(propObject.get("name")) && propObject.get("name").equals("email")) {
                    email = propObject.get("value");
                }
            }
            Utility utility = new Utility();
            utility.verifyEmail(email);
        }
    }

    @Then("I print all contact info who is not associated to company")
    public void iPrintAllContactInfoWhoIsNotAssociatedToCompany() {
        List<Map<String, Object>> contacts = response.jsonPath().get();
        System.out.println(contacts);
        for (Map<String, Object> contact : contacts) {
            if (Objects.isNull(contact.get("contact_company_id"))) {
                List<Map<String, String>> properties = (List<Map<String, String>>) contact.get("properties");
                for (Map<String, String> prop : properties) {
                    if (Objects.nonNull(prop.get("name")) && prop.get("name").equals("first_name")) {
                        System.out.println("Missing company information for contact : " + prop.get("value") + " and Id is : " + contact.get("id"));
                    }
                }
//                System.out.println(properties);
            }
        }
    }

    public void execute(String method, String pathParam) {
        try {
            switch (method) {
                case "GET":
                    response = requestSpecification.get(pathParam);
                    break;
                case "POST":
                    response = requestSpecification.post(pathParam);
                    break;
                case "PUT":
                    response = requestSpecification.put(pathParam);
                    break;
                case "DELETE":
                    response = requestSpecification.delete(pathParam);
                    break;
                default:
                    System.out.println("Invalid HTTPS Method");
                    throw new Exception("http method did not match");
            }
            response.prettyPrint();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Given("I create request structure to create contact")
    public void iCreateRequestStructureToCreateContact(Map<String, String> table) {

        String body =" firstName ="+ table.get("firstName") + " lastName" + table.get("lastName");
        String requestBody = "{\n" +
                "    \"star_value\": \"4\",\n" +
                "    \"lead_score\": \"92\",\n" +
                "    \"tags\": [\n" +
                "        \"API_Tag\"\n" +
                "    ],\n" +
                "    \"properties\": [\n" +
                "        {\n" +
                "            \"type\": \"SYSTEM\",\n" +
                "            \"name\": \"first_name\",\n" +
                "            \"value\": \"API\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"type\": \"SYSTEM\",\n" +
                "            \"name\": \"last_name\",\n" +
                "            \"value\": \"Automation\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"type\": \"SYSTEM\",\n" +
                "            \"name\": \"email\",\n" +
                "            \"subtype\": \"work\",\n" +
                "            \"value\": \"apiautomation55@yopmail.com\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        RestAssured.useRelaxedHTTPSValidation();
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://webtesting.agilecrm.com")
                .basePath("/dev/api")
                .header("Accept", ContentType.JSON)
                .header("Content-Type", ContentType.JSON)
                .auth().basic("apitesting@yopmail.com", "jabhmj91tibtjpsnijbs63lere")
                .body(requestBody)
                .log().all();


    }

    @Then("I verify the contact is created successfully")
    public void verifyContact(Map<String, String> contactData) {
        Assert.assertEquals(200, response.statusCode());
        response.prettyPrint();
        id = response.jsonPath().get("id");
        Assert.assertTrue(Objects.nonNull(id));

    }

    @When("I hit create contact api")
    public void iHitCreateContactApi() {
        response = requestSpecification.post("/contacts");
    }

    @And("I verify newly created contact in  get by id api")
    public void iVerifyNewlyCreatedContactInGetByIdApi(DataTable table) {
        requestSpecification=RestAssured.given();
        requestSpecification.baseUri("https://webtesting.agilecrm.com")
                .basePath("/dev/api")
                .header("Accept", ContentType.JSON)
                .auth().basic("apitesting@yopmail.com", "jabhmj91tibtjpsnijbs63lere")
                .log()
                .all();
        response=requestSpecification.get("/contacts/"+ id);
        Assert.assertEquals(200, response.statusCode());
        response.prettyPrint();
        Assert.assertEquals(id, response.jsonPath().get("id"));
    }
}
