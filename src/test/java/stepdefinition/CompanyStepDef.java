package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class CompanyStepDef extends BaseClass {
//    RequestSpecification requestSpecification;

    @Given("I prepare request structure for get company")
    public void prepareCompReqStructure(Map<String, String> table) {
        RestAssured.useRelaxedHTTPSValidation();
        requestSpecification = RestAssured.given();
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
}
