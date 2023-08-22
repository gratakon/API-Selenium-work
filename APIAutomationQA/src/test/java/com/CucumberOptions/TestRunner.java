package com.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



//@RunWith(Cucumber.class)
@CucumberOptions(
		
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
                
		//features="Scenarios/API_validations.feature",
		features="Scenarios",
		glue= {"com.ALD.StepDefs","com.apivalidation.stepdefs"},
		tags="@dummyapiscenario_1",
		dryRun=false,
		//strict=false,
		monochrome=true
		)

public class TestRunner extends AbstractTestNGCucumberTests{
	
	
	
	
	
		
		
	}
	
	


