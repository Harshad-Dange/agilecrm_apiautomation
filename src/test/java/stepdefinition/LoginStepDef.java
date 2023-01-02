package stepdefinition;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginStepDef {

    WebDriver driver;
    @Given("I launch the {string} browser and navigate to website {string}")
    public void initialization(String browser,String url){

        System.out.println("*********This is initialization method *******");
        System.out.println("browser name is :"+ browser);
        System.out.println("url is :"+ url);
        System.out.println("*********************");
    }
    @When("I enter valid username {string}")
    public void enterUsername(String username){
        System.out.println("*******username method starts************");
        System.out.println("enter the user name: "+ username);
        System.out.println("******username method ends***********");

    }
    @And("I enter valid password {string}")
    public void enterPassword(String password){
        System.out.println("*****enter the password starts*******");
        System.out.println("password is: "+ password);
        System.out.println("*******enter password  method ends******");
    }
    @And("Click on login button")
    public void submit(){
        System.out.println("*********signin method starts***********");
        System.out.println("*********signin method ends*************");
    }
    @Then("Verify user login to application with {string} details")
    public void verifyLogin(String var) {
        System.out.println("****** this is verify login method*********");
        boolean flag= Boolean.parseBoolean(var);
        if(flag){
            System.out.println("valid credentials");
        }else{
            System.out.println("invalid credentials");
        }
        System.out.println("******verify login method ends here****");

    }







}
