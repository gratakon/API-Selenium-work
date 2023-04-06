package com.apivalidation.stepdefs;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.Before;

public class Hooks {
	
	@Before(order=0)
	public void beforeStartDriver(Scenario scneario)
	{
		Reporter.TScenario.set(scneario);
	}

}
