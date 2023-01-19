package stepdefinition;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.io.IOUtils;
import org.hamcrest.xml.HasXPath;
import org.junit.Assert;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasXPath;

public class SampleStepDef {
    int sum;  //30
    Response response;
    RequestSpecification requestSpecification;

    @Given("I have 2 numbers")
    public void totalNum() {
        System.out.println("Doing the addition");
    }

    @When("I do the addition of {string} and {int}")
    public void add(String a, int b) {
        String[] array = a.split(",");
        int addition = 0;
        for (String val : array) {
            int value = Integer.parseInt(val);
            addition = addition + value;
        }
        sum = addition + b;
    }

    @Then("I should get the {string} as {int}")
    public void sum(String output, int c) {
        System.out.println(output);
        if (sum == c) {
            System.out.println("test case pass and output is :" + sum);
        } else {
            System.out.println("fail the test case" + sum);
        }
    }

    @When("I login to the application")
    public void iLoginToTheApplication() {
        System.out.println("This method is from background");
        System.out.println("login method");
    }

    @And("I create contact in the system")
    public void createContact(Map<String, String> contactData) {
        System.out.println("create contact method");
        contactData.forEach((key, value) -> {
            System.out.println(key + " : " + value);
        });

    }


    @And("I create company in the system")
    public void iCreateCompanyInTheSystem() {

        Map<String, Object> formData = new LinkedHashMap<>();
        formData.put("key", "panel/uploaded-logo/webtesting/1673892575678/sample.png");
        formData.put("acl", "public-read");
        formData.put("content-type", "image/*");
        formData.put("AWSAccessKeyId", "AKIA6MFDOFPIT23OXQOE");
        formData.put("policy", "ewogICAgImV4cGlyYXRpb24iOiAiMjA0MC0wMS0wMVQxMjowMDowMC4wMDBaIiwKICAgICJjb25kaXRpb25zIjogWwogICAgICAgIHsgImJ1Y2tldCI6ICJhZ2lsZWNybSIgfSwKICAgICAgICB7ICJhY2wiOiAicHVibGljLXJlYWQiIH0sCiAgICAgICAgWyJlcSIsICIkc3VjY2Vzc19hY3Rpb25fcmVkaXJlY3QiLCAiIl0sCiAgICAgICAgWyJzdGFydHMtd2l0aCIsICIka2V5IiwgInBhbmVsL3VwbG9hZGVkLWxvZ28vIl0sCiAgICAgICAgWyJzdGFydHMtd2l0aCIsICIkQ29udGVudC1UeXBlIiwgImltYWdlLyJdLAogICAgXQp9");
        formData.put("signature", "6zxNNI5zzDRuqp9QPdx6xgjx+ns=");

        Response response = given().relaxedHTTPSValidation().baseUri("https://agilecrm.s3.amazonaws.com/").contentType(ContentType.MULTIPART).multiPart("file", new File("/Users/harshad_dange/Desktop/sample.png"), "image/*").header("Accept", "*/*").accept(ContentType.XML).formParams(formData).log().all().post();


        System.out.println(response.then().assertThat().body("Message", equalTo("")));

//        String companyName=data.get(0);
//        String website=data.get(1);
        //driver.findElement(By.id()).sendKeys(companyName);
        //driver.findElement(By.id()).sendKeys(website);

    }


    @Then("I verify the company is created successfully")
    public void verifyCompany() {
        System.out.println("verify the company created successfully");
    }

    @Given("I download the file")
    public void iUploadTheFile() throws IOException {
        byte [] byteArray = given().relaxedHTTPSValidation()
                .baseUri("https://github.com/DataTalksClub/data-engineering-zoomcamp/raw/main/images/aws/iam.png")
                .log().all()
                .when()
                .get().asByteArray();

        FileOutputStream fileOutputStream = new FileOutputStream("src/test/resources/iam.png");
        fileOutputStream.write(byteArray);
        fileOutputStream.close();
//        IOUtils.closeQuietly(inputStream);

        InputStream inputStream = given().relaxedHTTPSValidation()
                .baseUri("https://github.com/DataTalksClub/data-engineering-zoomcamp/raw/main/images/aws/iam.png")
                .log().all()
                .when()
                .get().asInputStream();
        byte [] inoutArray = new  byte[inputStream.available()];
        FileOutputStream  outputStream = new FileOutputStream("src/test/resources/iam1.png");
        inputStream.read(inoutArray);
        outputStream.write(inoutArray);

        outputStream.close();

    }

    @Given("I setup wiremock server")
    public void iSeupWiremockServer() {
        WireMockServer wireMockServer = new WireMockServer(WireMockConfiguration.wireMockConfig().port(8080) );
        wireMockServer.start();
        stubFor(post("/maps")
                .willReturn(jsonResponse("{\n" +
                        "    \"request\": {\n" +
                        "        \"method\": \"GET\",\n" +
                        "        \"url\": \"/some/thing\"\n" +
                        "    },\n" +
                        "    \"response\": {\n" +
                        "        \"status\": 200,\n" +
                        "        \"statusMessage\": \"Everything was just fine!\"\n" +
                        "    }\n" +
                        "}", 200))

        );
        RestAssured.useRelaxedHTTPSValidation();
        requestSpecification= RestAssured.given();
        response=requestSpecification.baseUri("http://localhost:8080/")
                .log().all()
                .post("/maps");
        response.prettyPrint();
    }
}
