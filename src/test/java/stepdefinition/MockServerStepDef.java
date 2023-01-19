package stepdefinition;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.http.Body;
import com.github.tomakehurst.wiremock.matching.ContentPattern;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class MockServerStepDef {

    RequestSpecification requestSpecification;
    Response response;

    @Given("I setup mock server")
    public void setupMockServer() {

        WireMockServer wireMockServer = new WireMockServer();

        System.out.println("Start Mock Server on 8080 port");
//        wireMockServer.start();   // http://localhost:8080

        System.out.println("setup the sub in mock server");


        //get api
        stubFor(get("/contacts")
                .willReturn(aResponse()
                        .withResponseBody(new Body("{\n" +
                                "    \"request\": {\n" +
                                "        \"method\": \"GET\",\n" +
                                "        \"url\": \"/some/thing\"\n" +
                                "    },\n" +
                                "    \"response\": {\n" +
                                "        \"status\": 200,\n" +
                                "        \"body\": \"Hello world!\",\n" +
                                "        \"headers\": {\n" +
                                "            \"Content-Type\": \"text/plain\"\n" +
                                "        }\n" +
                                "    }\n" +
                                "}"))
                        .withStatus(200)));

        //for post api
        stubFor(get("/company")
                .willReturn(aResponse()
                        .withBody("{\n" +
                                "    \"request\": {\n" +
                                "        \"method\": \"GET\",\n" +
                                "        \"url\": \"/some/thing\"\n" +
                                "    },\n" +
                                "    \"response\": {\n" +
                                "        \"status\": 200,\n" +
                                "        \"body\": \"Hello world!\",\n" +
                                "        \"headers\": {\n" +
                                "            \"Content-Type\": \"text/plain\"\n" +
                                "        }\n" +
                                "    }\n" +
                                "}")
                        .withStatus(200)));

    }

    @When("I hit an api to get response from mock server")
    public void iHitAnApiToGetResponseFromMockServer() {
        RestAssured.useRelaxedHTTPSValidation();
        requestSpecification= RestAssured.given();
        response =requestSpecification.baseUri("http://localhost:8080")
                .log().all()
                .get("/contacts");

        response.prettyPrint();
    }

    @Then("I verify the response")
    public void iVerifyTheResponse() {
    }
}
