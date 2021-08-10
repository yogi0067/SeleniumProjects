package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SampleStepDefinitionClass {

	@Given("User open the Login Page")
	public void user_open_the_login_page() {
		System.out.println("User open the Login Page");
	}

	@When("User enter {string} and {string}")
	public void user_enter_and(String string, String string2) {
		System.out.println("user_enter_and");
	}
	@Then("Check user is able to login or not")
	public void check_user_is_able_to_login_or_not() {
		System.out.println("check_user_is_able_to_login_or_not");
	}


	@Then("check further login page things")
	public void check_further_login_page_things() {
		System.out.println("check_further_login_page_things");
	}
}
