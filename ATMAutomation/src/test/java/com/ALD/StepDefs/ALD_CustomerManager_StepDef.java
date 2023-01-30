package com.ALD.StepDefs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ALD_CSM.pageObjects.CSM_CustomerManagerUsersPageObjs;
import com.ALD_CSM.pageObjects.CSM_HomePageObjs;
import com.ALD_CSM.pageObjects.CSM_LoginPageObjs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class ALD_CustomerManager_StepDef {

	public CSM_LoginPageObjs CSM_LPO = new CSM_LoginPageObjs();
	public CSM_HomePageObjs CSM_HPO = new CSM_HomePageObjs();
	public CSM_CustomerManagerUsersPageObjs CSM_CMUP = new CSM_CustomerManagerUsersPageObjs();

	private static final Logger LOG = LogManager.getLogger(ALD_CustomerManager_StepDef.class);

	@Given("^Login as a Customer Service Manager with \"([^\"]*)\" and \"([^\"]*)\" credentials$")
	public void login_as_a_customer_service_manager_with_something_and_something_credentials(String username,
			String password) throws Exception {
		CSM_LPO.browserup();
		CSM_LPO.CSMLogin(username, password);

	}

	@Then("^Navigate to Customer service Users page$")
	public void navigate_to_customer_service_users_page() throws Exception {

		CSM_HPO.click_CSM_userslink();
	}

	@And("^Customer service manager click on add the Customer operator$")
	public void customer_service_manager_click_on_add_the_customer_operator() throws Exception {
		CSM_CMUP.add_Customeroperator();

	}

	@Then("^Customer service manager cancel to add the Cusomter operator$")
	public void customer_service_manager_cancel_to_add_the_cusomter_operator() throws Exception {
		CSM_CMUP.cancel_Customeroperator();

	}

	@When("^Again add customer operator with Name as \"([^\"]*)\" Surname as \"([^\"]*)\" and EmailID as \"([^\"]*)\"$")
	public void customer_service_manager_again_try_to_add_the_customer_operator(String name, String surname,
			String emailID) throws Exception {
		CSM_CMUP.add_NewcustomerOperator(name, surname, emailID);
	}

	@Then("^Customer service manager search for the cusomer operator \"([^\"]*)\"$")
	public void customer_service_manager_search_for_the_cusomer_operator_something(String Customeroperator)
			throws Exception {
		CSM_CMUP.search_CustomerOperator(Customeroperator);

	}

	@And("^Logout of Customer service manager Account$")
	public void logout_of_customer_service_manager_account() throws Exception {
		CSM_HPO.Logout();
	}

	@Then("^Customer service manager delete the Customer operator$")
	public void customer_service_manager_delete_the_customer_operator() throws Exception {
		CSM_CMUP.delete_CustomerOperator();
	}

}
