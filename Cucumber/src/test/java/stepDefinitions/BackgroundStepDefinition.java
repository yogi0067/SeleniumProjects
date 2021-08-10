package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BackgroundStepDefinition {

	@Given("We have given user name and password")
	public void we_have_given_user_name_and_password() {
	    System.out.println("we_have_given_user_name_and_password");
	}

	@When("we enter user name and password and clicked on login button")
	public void we_enter_user_name_and_password_and_clicked_on_login_button() {
		 System.out.println("we_enter_user_name_and_password_and_clicked_on_login_button");
	}

	@Then("we have successfully navigate to Home Page")
	public void we_have_successfully_navigate_to_home_page() {
		System.out.println("we_have_successfully_navigate_to_home_page");
	}

	@Then("print the title")
	public void print_the_title() {
		System.out.println("print_the_title");
	}

	@Then("Check Menus are loaded on Home Page")
	public void check_menus_are_loaded_on_home_page() {
		System.out.println("check_menus_are_loaded_on_home_page");
	}

	@Then("Check on My Profile menu")
	public void check_on_my_profile_menu() {
		System.out.println("check_on_my_profile_menu");
	}

}
