package stepdefinition;

import io.cucumber.java.en.When;
import io.restassured.specification.RequestSpecification;

import java.util.Map;
import java.util.Objects;

public class CommonStepDef extends BaseClass {
    public void hitApi(String method, String pathParam) {
        try {
            if (Objects.nonNull(requestSpecification)) {
                switch (method) {
                    case "GET":
                        requestSpecification.get(pathParam);
                        break;
                    case "POST":
                        requestSpecification.post(pathParam);
                        break;
                    case "PUT":
                        requestSpecification.put(pathParam);
                        break;
                    case "DELETE":
                        requestSpecification.delete(pathParam);
                        break;
                    default:
                        System.out.println("Invalid HTTPS Method");
                        throw new Exception("http method did not match");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
