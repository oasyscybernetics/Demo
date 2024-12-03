package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@AccountCreation", 
features = "C:\\Users\\aishwarya\\eclipse-workspace\\Magento_Luma\\src\\test\\resources\\Features\\Account_creation.feature", 
glue = "com.stepdefinition", 
dryRun = false, 
publish = true, 
stepNotifications = true,
plugin = {"pretty","junit:target/reports/testreport.xml" }, monochrome = true)


public class Test_runner {

}
