package stepdefinition;

import com.reqres.types.UserDto;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class UserStepDef {
    UserDto userDto;
    RequestSpecification requestSpecification;
    Response response;
    @Given("I prepare request structure to create user")
    public void prepareStructure(){
        userDto= new UserDto();
        userDto.setName("Cyber");
        userDto.setJob("QA");

        RestAssured.useRelaxedHTTPSValidation();
        requestSpecification= RestAssured.given();
        response=requestSpecification.baseUri("https://reqres.in/")
                .basePath("api/")
                .body(userDto)
                .log().all()
                .post("/users");



    }
    @Then("I verify the user is created successfully")
    public void iVerifyTheUserIsCreatedSuccessfully() {
        Assert.assertEquals(201, response.statusCode());
        response.prettyPrint();

    }
}
