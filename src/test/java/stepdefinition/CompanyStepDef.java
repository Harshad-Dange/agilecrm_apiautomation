package stepdefinition;

import com.agilecrm.types.CompanyDto;
import com.agilecrm.types.PropertyDto;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.*;

import static io.restassured.RestAssured.given;

public class CompanyStepDef extends BaseClass {
//    RequestSpecification requestSpecification;
//    Response response;
    @Given("I prepare request structure for get company")
    public void prepareCompReqStructure(Map<String, String> table) {
        RestAssured.useRelaxedHTTPSValidation();
        requestSpecification = given();
        requestSpecification.baseUri("https://webtesting.agilecrm.com")
                .basePath(table.get("basePath"))
                .header("Accept", ContentType.JSON)
                .auth().basic(table.get("username"), table.get("password")).log().all();
    }

    @Then("I verify the company list api response")
    public void iVerifyTheCompanyListApiResponse() {
        Assert.assertEquals(200, response.statusCode());
        //List<List<Map<String,String>>
        List<List<Map<String, String>>> propDetails = response.jsonPath().getList("properties");
        List<Long> compIds = response.jsonPath().get("id");
        //comparing the size of id and propDetails list
        Assert.assertEquals(compIds.size(), propDetails.size());
        //iterate each property object
        for (int i = 0; i < compIds.size(); i++) {
            Long id = compIds.get(i); // get company id in list format
            List<Map<String, String>> propObject = propDetails.get(i); // get property object list
            //iterate each property object of company
            String companyName = null;
            String website = null;
            //iterate property object to get company name and website
            for (Map<String, String> prop : propObject) {
                if (prop.get("name").equals("name")) {
                    companyName = prop.get("value");
                } else if (prop.get("name") != null && prop.get("name").equals("url")) {
                    website = prop.get("value");
                }
            }
            System.out.println("Id: " + id + ", Company Name: " + companyName + ", Website: " + website);
        }
    }

    @Given("I prepare request structure to create company")
    public void iPrepareRequestStructureForCompany() {
        List<PropertyDto> propertyDto = new ArrayList<>();

        PropertyDto propertyDto1= new PropertyDto();
        propertyDto1.setName("Company Type");
        propertyDto1.setType("CUSTOM");
        propertyDto1.setValue("MNC Inc");

        propertyDto.add(propertyDto1); // adding first property dto object in the list

        PropertyDto propertyDto2= new PropertyDto();
        propertyDto2.setName("name");
        propertyDto2.setValue("Google");
        propertyDto2.setType(";");

        propertyDto.add(propertyDto2); // adding second property dto object in the list


        PropertyDto propertyDto3= new PropertyDto();
        propertyDto3.setName("url");
        propertyDto3.setValue("www.Google.com");
        propertyDto3.setType("SYSTEM");

        propertyDto.add(propertyDto3);// adding third property dto object in the list

        PropertyDto propertyDto4= new PropertyDto();
        propertyDto4.setName("email");
        propertyDto4.setValue("www.Google.com");
        propertyDto4.setType("SYSTEM");

        propertyDto.add(propertyDto4);// adding third property dto object in the list

        CompanyDto companyDto= new CompanyDto();
        companyDto.setProperties(propertyDto);
        companyDto.setType("COMPANY");
        companyDto.setTags(Collections.EMPTY_LIST);

        System.out.println(companyDto);

        RestAssured.useRelaxedHTTPSValidation();
        requestSpecification = given();
        requestSpecification.baseUri("https://webtesting.agilecrm.com")
                .basePath("/dev/api")
                .header("Accept", ContentType.JSON)
                .header("Content-Type", ContentType.JSON)
                .auth().basic("apitesting@yopmail.com", "jabhmj91tibtjpsnijbs63lere")
                .body(companyDto)
                .log().all();

        //Hit the api in gherkin language
       given()
                .baseUri("")
                .basePath("")
                .header("", "")
                .body("")
                .auth().basic("", "")
                .log().all()
        .when()
                .post()
        .then().statusCode(200);


        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBasePath("");
        requestSpecBuilder.setBaseUri("");
        requestSpecBuilder.addHeader("","");
        requestSpecBuilder.addParam("contactId","2485782347823784");
        requestSpecBuilder.addQueryParam("q","Cyber");

        requestSpecification= new RequestSpecBuilder()
                .setBaseUri("")
                .setBasePath("")
                .setBody("")
//                .setAuth("", "")
                .addParam("", "")
                .addQueryParam("", "")
                .build();


        requestSpecification=requestSpecBuilder.build();

//        requestSpecification.spec(requestSpecification).post();


        requestSpecification.post();
    }

    @When("I hit an api to get a company")
    public void iHitAnApiToGetACompany() {
        response= requestSpecification.post("/contacts");
        response.prettyPrint();
    }

    @Then("I verify the company information retriving successfully in the response")
    public void iVerifyTheCompanyInformationRetrivingSuccessfullyInTheResponse() {
    }
}
