package com.eldorado.authservice.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AuthSteps {
	
	@Given("user have valid credentials")
	public void usere_have_valid_credentials() {
		System.out.println("Inside- user have valid credentials");
	}

	@When("user open website")
	public void user_open_website() {
		System.out.println("Inside- user open website");
	}

	@And("entered username and password")
	public void entered_username_and_password() {
		System.out.println("Inside- entered username and password");
	}

	@Then("user should be authenticated to see the product list page")
	public void user_should_be_authenticated_to_see_the_product_list_page() {
		System.out.println("Inside- user should be authenticated to see the product list page");
	}

	@And("should not have the access for Admin Features")
	public void should_not_have_the_access_for_admin_features() {
		System.out.println("Inside- should not have the access for Admin Features");
	}

	@Given("admin have valid credentials")
	public void admin_have_valid_credentials() {
		System.out.println("Inside- admin have valid credentials");
	}

	@When("admin open website")
	public void admin_open_website() {
		System.out.println("Inside- admin open website");
	}

	@Then("admin should be authenticated to see the product list page")
	public void admin_should_be_authenticated_to_see_the_product_list_page() {
		System.out.println("Inside- admin should be authenticated to see the product list page");
	}

	@And("should have ability to perform other admin activities as well")
	public void should_have_ability_to_perform_other_admin_activities_as_well() {
		System.out.println("Inside- should have ability to perform other admin activities as well");
	}
	
	@Given("user have invalid credentials")
	public void usere_have_invalid_credentials() {
		System.out.println("Inside- user have valid credentials");
	}
	@And("entered invalid username and password")
	public void entered_invalid_username_and_password() {
		System.out.println("Inside- entered invalid username and password");
	}

	@Then("user should not be authenticated")
	public void user_should_not_be_authenticated() {
		System.out.println("Inside- user should not be authenticated");
	}


}
