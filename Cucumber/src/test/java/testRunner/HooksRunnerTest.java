package testRunner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/rosources/featuresFiles"},
		glue = {"stepDefinitions","hooksPackage"},
		tags = "@Smoke or @Regration"
		 /* We can user below alternates also
							tags = "@smoke or @Regration" - it will execute both
							tags = "@smoke and @Regration" - it will execute both if scenario have both tags
							tags = "@all" - it will execute all the scenarios
							tags = "not @smoe" - it will execute all the scenarios except @smoke
		 				*/
		)
public class HooksRunnerTest {

}
