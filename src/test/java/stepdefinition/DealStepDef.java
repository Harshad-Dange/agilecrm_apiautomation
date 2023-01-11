package stepdefinition;

import Util.Utility;
import com.agilecrm.types.DealDto;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.*;

public class DealStepDef {
    RequestSpecification requestSpecification;
    Response response;
    Map<String, Object> dealBody;
    DealDto dealDto;

    public void createDealStructure(DataTable table) {
        Map<String, String> data = table.asMaps().get(0);
        // get comma saperated contact ids and split them then convert into integers and then add into array
        List<Integer> contactIdList = new ArrayList<>();
        if (Objects.nonNull(data.get("contactIds"))) {
            String[] contactIds = data.get("contactIds").split(",");
            for (String id : contactIds) {
                int contactId = Integer.parseInt(id);
                contactIdList.add(contactId);
            }
        }
        //prepare custom data object
        List<Map<String, String>> customData = new ArrayList<>();
        Map<String, String> customDataObj = new HashMap<>();
        if (Objects.nonNull(data.get("customData"))) {
            String[] dataObject = data.get("customData").split(",");
            customDataObj.put("name", dataObject[0]);
            customDataObj.put("value", dataObject[1]);
            customData.add(customDataObj);
        }
        //get the name from feature file,
        // if value is not null then get the value as it is else consider it as null
        Object name = Objects.nonNull(data.get("name")) ? data.get("name") : null;

        //get the expectedValue from dataTable/feature file
        // if the value is not null then convert into float
        // else take the value as it is
        Object expectedValue = null;
        if (Objects.nonNull(data.get("expectedValue"))) {
            try {
                expectedValue = Float.valueOf(data.get("expectedValue"));
            } catch (Exception e) {
                expectedValue = data.get("expectedValue");
            }
        }
        // get the probability value from datatable/ feature file
        // if value is not null or valid  string
        // then convert into integer else take it as it is
        Object probability = null;
        if (Objects.nonNull(data.get("probability"))) {
            try {
                probability = Integer.parseInt(data.get("probability"));
            } catch (Exception e) {
                probability = data.get("probability");
            }
        }
        //if  milestone values is not null then get it as it is
        // else use it as null value in deal body
        Object mileStone = Objects.nonNull(data.get("milestone")) ? data.get("milestone") : null;

//         Utility utility= new Utility();
        dealBody = new HashMap<>();
        dealBody.put("name", name);
        dealBody.put("expected_value", expectedValue);
        dealBody.put("probability", probability);
        dealBody.put("milestone", mileStone);
        dealBody.put("contact_ids", contactIdList);
//        dealBody.put("contact_ids", utility.setContactListForDeal(data));
        dealBody.put("custom_data", customData);
    }

    @Given("I prepare request structure to create deal")
    public void prepareDealStructure(DataTable dataTable) {

        createDealStructure(dataTable);
/*
        Map<String, String> data=dataTable.asMaps().get(0);
        List<Map<String, String>> customData= new ArrayList<>();
        Map<String, String> customDataValues= new HashMap<>();
        customDataValues.put("name", "Group Size");
        customDataValues.put("value", "10");
        customData.add(customDataValues);
        List<Long> contactIds= new ArrayList<>();*/

//        RestAssured.useRelaxedHTTPSValidation();
//        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://webtesting.agilecrm.com")
                .basePath("/dev/api")
                .header("Accept", ContentType.JSON)
                .header("Content-Type", ContentType.JSON)
                .auth().basic("apitesting@yopmail.com", "jabhmj91tibtjpsnijbs63lere")
                .body(dealBody)
                .log().all();
    }

    @When("I hit an api to create deal")
    public void iHitAnApiToCreateDeal() {
        response = requestSpecification.post("/opportunity");

    }

    @Then("I verify deal created successfully using {string}")
    public void iVerifyDealCreatedSuccessfully(String statusCode, DataTable table) {
//        Assert.assertEquals(Integer.parseInt(statusCode), response.statusCode());
        response.prettyPrint();
        if (response.statusCode() == 200) {
            Assert.assertEquals(dealDto.getName(), response.jsonPath().get("name"));
            Assert.assertEquals(dealDto.getExpected_value(), response.jsonPath().get("expected_value"));
            Assert.assertEquals(dealDto.getProbability(), response.jsonPath().get("probability"));
            Assert.assertEquals(dealDto.getMilestone(), response.jsonPath().get("milestone"));
            Assert.assertEquals(dealDto.getContact_ids(), response.jsonPath().getList("contacts"));
            Assert.assertEquals(dealDto.getCustom_data(), response.jsonPath().getList("custom_data"));

           /* Assert.assertEquals(dealBody.get("name"), response.jsonPath().get("name"));
            Assert.assertEquals(dealBody.get("expected_value"), response.jsonPath().get("expected_value"));
            Assert.assertEquals(dealBody.get("probability"), response.jsonPath().get("probability"));
            Assert.assertEquals(dealBody.get("milestone"), response.jsonPath().get("milestone"));
            Assert.assertEquals(dealBody.get("contact_ids"), response.jsonPath().getList("contacts"));
            Assert.assertEquals(dealBody.get("custom_data"), response.jsonPath().getList("custom_data"));*/
        }
    }

    @Given("I prepare request structure to create deal using serialization concept")
    public void iPrepareRequestStructureToCreateDealUsingSerializationConcept(DataTable table) {
        Utility utility = new Utility();
        dealDto = new DealDto();
        Map<String, String> dataTable = table.asMaps().get(0);
        dealDto.setName(dataTable.get("name"));
        dealDto.setExpected_value(dataTable.get("expectedValue"));
        dealDto.setProbability(dataTable.get("probability"));
        dealDto.setMilestone(dataTable.get("milestone"));
        dealDto.setClose_date(1455042600);
        List<Long> contactIds = utility.setContactListForDeal(dataTable);

        dealDto.setContact_ids(contactIds);

        List<Map<String, String>> custom_data = utility.setCustomDataForDeal(dataTable);

        dealDto.setCustom_data(custom_data);

        RestAssured.useRelaxedHTTPSValidation();
        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://webtesting.agilecrm.com")
                .basePath("/dev/api")
                .header("Accept", ContentType.JSON)
                .header("Content-Type", ContentType.JSON)
                .auth().basic("apitesting@yopmail.com", "jabhmj91tibtjpsnijbs63lere")
                .body(dealDto)
                .log().all();
        response= requestSpecification.post("/opportunity");
    }


}
