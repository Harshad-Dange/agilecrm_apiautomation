package stepdefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class SampleStepDef {
    int sum;  //30
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

    @Then("I verify the contact is created successfully")
    public void verifyContact(Map<String, String> contactData) {
        System.out.println("verify contact method");
        contactData.forEach((key, val) -> {
            System.out.println(key + " : " + val);
        });
    }

    @And("I create company in the system")
    public void iCreateCompanyInTheSystem(List<String> testData) {
        System.out.println("create the company");
        System.out.println("List Data : " + testData);
        testData.forEach(System.out::println);

//        String companyName=data.get(0);
//        String website=data.get(1);
        //driver.findElement(By.id()).sendKeys(companyName);
        //driver.findElement(By.id()).sendKeys(website);

    }


    @Then("I verify the company is created successfully")
    public void verifyCompany() {
        System.out.println("verify the company created successfully");
    }
}
