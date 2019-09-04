package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


    @RunWith(Cucumber.class)
    @CucumberOptions(
            //if you want to skip undefined tests - default value is false
            //strict=true,
            //tells cucumber where your feature files live
            features = { "testcases/api/src/test/resources/features/" },
            //tells cucumber where your stepdef files live
            glue = { "stepdefs" },
            //for cluecumber
//            plugin = { "json:target/cucumber-report/cucumber.json" },
            //for running with tags
            tags = { "@test" }
    )


    public class RunTest {

    }

