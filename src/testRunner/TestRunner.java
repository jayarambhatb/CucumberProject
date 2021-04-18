package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions

(
		features="src/features/Login.feature" ,  //the path of the feature files
		glue={"steps"}, //the path of the step definition files
		dryRun= false,  //to check the mapping is proper between feature file and step def file
		monochrome=true,  // display the console output in a proper readable format
		plugin={"pretty",
		"html:test-output" }  //to generate reports

		)

public class TestRunner {

}
