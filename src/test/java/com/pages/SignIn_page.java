package com.pages;

import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class SignIn_page extends BaseClass {

	public SignIn_page() {
		PageFactory.initElements(driver, this);

	}

}
