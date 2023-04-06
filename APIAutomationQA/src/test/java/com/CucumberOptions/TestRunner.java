package com.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



//@RunWith(Cucumber.class)
@CucumberOptions(
		
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
                
		//features="Scenarios/Week1.feature",
		features="Scenarios",
		glue= {"com.ALD.StepDefs","com.apivalidation.stepdefs"},
		tags="@E2E_APITests",
		dryRun=false,
		//strict=false,
		monochrome=true
		)

public class TestRunner extends AbstractTestNGCucumberTests{
	
	
	
	
	
		
		
	}
	
	


