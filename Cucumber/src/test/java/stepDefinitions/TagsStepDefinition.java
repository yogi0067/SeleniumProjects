package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TagsStepDefinition {

	@Given("We have given smoke tests")
	public void we_have_given_smoke_tests() {
	    System.out.println("we_have_given_smoke_tests");
	}

	@When("we enter user name and password and click on login button")
	public void we_enter_user_name_and_password_and_click_on_login_button() {
	    System.out.println("we_enter_user_name_and_password_and_click_on_login_button");
	}

	@Then("we are successfully navigate to Home Page")
	public void we_are_successfully_navigate_to_home_page() {
		System.out.println("we_are_successfully_navigate_to_home_page");
	}

	@Given("We have Regression smoke tests")
	public void we_have_regression_smoke_tests() {
		System.out.println("we_have_regression_smoke_tests");
	}

	@When("New Code is deployed")
	public void new_code_is_deployed() {
		System.out.println("new_code_is_deployed");
	}

	@Then("check existing features are working fine or not")
	public void check_existing_features_are_working_fine_or_not() {
		System.out.println("check_existing_features_are_working_fine_or_not");
	}

}
