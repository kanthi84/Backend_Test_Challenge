package env;

import cucumber.api.Scenario;
import cucumber.api.java.Before;

public class Hooks {

    public Hooks(){

    }

    @Before
    public void beforeScenario(Scenario scenario){
        String scenarioName = scenario.getName();
        scenario.write("Scenario: " + scenarioName);
    }
}
