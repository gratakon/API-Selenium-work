package com.ALD.StepDefs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ALD_CMS_AdminConfig.pageObjects.AdminConfig_HomePageObjs;
import com.ALD_CMS_AdminConfig.pageObjects.AdminConfig_LoginPageObjs;
import com.ALD_CMS_AdminConfig.pageObjects.AdminConfig_PlatformconfigurationObjs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ALD_AdminConfig_StepDef {
	
	public AdminConfig_LoginPageObjs AC_LPO = new AdminConfig_LoginPageObjs();
	public AdminConfig_HomePageObjs AC_HPO = new AdminConfig_HomePageObjs();
	public AdminConfig_PlatformconfigurationObjs AC_PCO = new AdminConfig_PlatformconfigurationObjs();
	
	
	
	private static final Logger LOG = LogManager.getLogger(ALD_AdminConfig_StepDef.class);


	@Given("^Login as a Admin Config with \"([^\"]*)\" and \"([^\"]*)\" credentials$")
    public void login_as_a_admin_config_with_something_and_something_credentials(String AC_LUsername, String AC_LPassword) throws Throwable {
        AC_LPO.browserup();
		AC_LPO.AdminConfig_Login(AC_LUsername, AC_LPassword);	
    }
	 @And("^Logout of as Admin Config$")
	    public void logout_of_as_admin_config() throws Throwable {
	        AC_HPO.Click_logout();
	    }
	@And("^Click on Platform configuration$")
    public void click_on_platform_configuration() throws Throwable {
        AC_HPO.click_PlatformconfigurationLink();
    }
	@Then("^Enter the following parameter \"([^\"]*)\" and click on search$")
    public void enter_the_following_parameter_something_and_click_on_search(String Costcenter_associationType) throws Throwable {
        AC_PCO.Search_configuration(Costcenter_associationType);
    }
	@And("^Click on the desired parameter line$")
    public void click_on_the_desired_parameter_line() throws Throwable {
        AC_PCO.Click_desired_parameter_line();
    }
	@Then("^Select \"([^\"]*)\" from Cost center association type Dropdown and Save the changes$")
    public void select_something_from_cost_center_association_type_dropdown_and_save_the_changes(String CostCenterAssociationTypevalue) throws Throwable {
        AC_PCO.Select_CostCenterAssociationType_Dropdown_Save(CostCenterAssociationTypevalue);
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
