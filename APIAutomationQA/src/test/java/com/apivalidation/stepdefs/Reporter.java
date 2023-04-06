package com.apivalidation.stepdefs;

import io.cucumber.core.api.Scenario;

public class Reporter {

	public static ThreadLocal<Scenario> TScenario = new ThreadLocal<Scenario>();
	
	public synchronized static void addStepLog(String message) {
		
		
		//will not work for cucumber more than 4
		TScenario.get().write(message);
	}

}
