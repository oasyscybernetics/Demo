package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.base.BaseClass;
import com.pages.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC_01_Account_creation extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	@Given("Open the browser and go the store URL")
	public void open_the_browser_and_go_the_store_url() throws FileNotFoundException, IOException {
		getDriver(getPropertyFileValue("browserType"));
		getURL(getPropertyFileValue("url"));
	}

	@Given("Select the Create An Account option")
	public void select_the_create_an_account_option() {
		pom.getAccount_creation().accountCreation();
	}

	@When("Enter the {string} and {string} under personal information")
	public void enter_the_and_under_personal_information(String first, String last) {
		pom.getAccount_creation().personalDetails(first, last);
	}

	@When("Enter the {string} and {string} under sign-in information")
	public void enter_the_and_under_sign_in_information(String mail, String pswd) {
		pom.getAccount_creation().signIn(mail, pswd);
	}

	@When("Again re-enter the same password in {string}")
	public void again_re_enter_the_same_password_in(String confirm) {
		pom.getAccount_creation().confirmation(confirm);
	}

	@Then("Click on Create An Accounts")
	public void click_on_create_an_accounts() throws InterruptedException {
		Thread.sleep(20);
		pom.getAccount_creation().create();
		Thread.sleep(50);
	}

	@Then("Check for the {string}")
	public void check_for_the(String text) throws InterruptedException {
		pom.getAccount_creation().getVerifyUser();
		System.out.println(text);
		Thread.sleep(30);

	}

}