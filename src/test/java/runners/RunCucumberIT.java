package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**************************
 *  (C) L Somni            *
 ***************************/

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = { "pretty",
				"html:target/cucumber-html-report",
				"json:target/cucumber.json",
				"rerun:target/rerun.txt"},
		features = "src/test/resources/features",
		glue= {"stepDefinitions"},
		tags={"@api_test"}
)
public class RunCucumberIT {
}