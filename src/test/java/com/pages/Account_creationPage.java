package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class Account_creationPage extends BaseClass {

	public Account_creationPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//a[text()='Create an Account'])[1]")
	private WebElement createAccount;

	@FindBy(id = "firstname")
	private WebElement firstName;

	@FindBy(id = "lastname")
	private WebElement lastName;

	@FindBy(id = "email_address")
	private WebElement emailAddress;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(id = "password-confirmation")
	private WebElement pswdConfirm;

	@FindBy(xpath = "(//span[text()='Create an Account'])[1]")
	private WebElement btnCreate;

	@FindBy(xpath = "(//li[@class='greet welcome']/child::span[@class='logged-in'])[1]")
	private WebElement verifyUser;

	public WebElement getCreateAccount() {
		return createAccount;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getEmailAddress() {
		return emailAddress;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getPswdConfirm() {
		return pswdConfirm;
	}

	public WebElement getBtnCreate() {
		return btnCreate;
	}

	public WebElement getVerifyUser() {
		return verifyUser;
	}

	public void accountCreation() {
		elementClick(getCreateAccount());

	}

	public void personalDetails(String frist, String last) {
		sendingKeys(getFirstName(), frist);
		sendingKeys(getLastName(), last);

	}

	public void signIn(String mail, String pswd) {
		sendingKeys(getEmailAddress(), mail);
		sendingKeys(getPassword(), pswd);

	}

	public void confirmation(String confirm) {
		sendingKeys(getPswdConfirm(), confirm);

	}

	public void create() {
		elementClick(getBtnCreate());

	}

	public String verifyTxt(String text) {
		gettingText(getVerifyUser());
		return text;

	}
}
