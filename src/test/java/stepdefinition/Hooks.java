package stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    //Scenario hook
    @Before(value = "@DbConnection", order = 2)
    public void hook1(){
        System.out.println("This is tag hook 1");
    }

    @Before(value = "@TagHook2", order = 1)
    public void hook2(){
        System.out.println("This is tag hook 2");

    }

    @After(value = "@AfterTagHook1", order = 1)
    public void after1(){
        System.out.println("This is after tag hook 1...");
    }

}
