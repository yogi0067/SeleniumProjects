package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/rosources/featuresFiles"},
		glue = {"stepDefinitions"}
		)
public class SampleRunnerTest {

	


}
