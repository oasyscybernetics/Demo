package com.pages;

public class PageObjectManager {

	private Account_creationPage accountcreation;

	public Account_creationPage getAccount_creation() {
		return (accountcreation == null) ? accountcreation = new Account_creationPage() : accountcreation;

	}

}
