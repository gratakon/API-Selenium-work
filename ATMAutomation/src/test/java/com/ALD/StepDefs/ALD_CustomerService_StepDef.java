package com.ALD.StepDefs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ALD.Commons.CommonUtilities;
import com.ALD_CS.pageObjects.CS_AssistantOwner_OverviewPageObjs;
import com.ALD_CS.pageObjects.CS_CarSharing_AllVehiclesPageObjs;
import com.ALD_CS.pageObjects.CS_CarSharing_CustomerManagementPageObjs;
import com.ALD_CS.pageObjects.CS_CleaningPageObjs;
import com.ALD_CS.pageObjects.CS_HomePageObjs;
import com.ALD_CS.pageObjects.CS_LoginPageObjs;
import com.ALD_CS.pageObjects.CS_MaintenanceBadgePageObjs;
import com.ALD_CS.pageObjects.CS_MultiparkingPageObjs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ALD_CustomerService_StepDef {

	public CS_HomePageObjs HPO = new CS_HomePageObjs();
	public CS_LoginPageObjs LPO = new CS_LoginPageObjs();
	public CS_CarSharing_CustomerManagementPageObjs CSCM = new CS_CarSharing_CustomerManagementPageObjs();
	public CS_CarSharing_AllVehiclesPageObjs CSAV = new CS_CarSharing_AllVehiclesPageObjs();
	public CS_AssistantOwner_OverviewPageObjs CSAOOPO = new CS_AssistantOwner_OverviewPageObjs();
	public CS_CleaningPageObjs CSCPO = new CS_CleaningPageObjs();
	public CS_MultiparkingPageObjs CSMPO = new CS_MultiparkingPageObjs();
	public CS_MaintenanceBadgePageObjs CSMBPO = new CS_MaintenanceBadgePageObjs();
	public CommonUtilities cm = new CommonUtilities();

	private static final Logger LOG = LogManager.getLogger(ALD_CustomerService_StepDef.class);

	@Given("^Login as a Customer Service with \"([^\"]*)\" and \"([^\"]*)\" credentials$")
	public void _login_as_a_customer_service(String username, String password) throws Exception {
		LPO.browserup();
		LPO.CSLogin(username, password);
	}

	@And("^Navigate to Customer Management section$")
	public void _navigate_to_customer_management_section() throws Throwable {
		HPO.Click_CustomerServiceLink();
		HPO.Click_CarsharingLink();
		HPO.Click_CustomerManagementLink();
		cm.wait(3);
	}
	@And("^Navigate to Multiparking page$")
	public void _navigate_to_multiparking_page() throws Throwable {
		HPO.Click_CustomerServiceLink();
		HPO.Click_CarsharingLink();
		HPO.Click_MultiparkingLink();
		HPO.Click_ManageHubParkingLink();
		cm.wait(3);
	}

	@When("^Navigate to Assistant owner and overview page$")
	public void navigate_to_assistant_owner_and_overview_page() throws Throwable {
		HPO.Click_CustomerServiceLink();
		HPO.Click_CarsharingLink();
		HPO.click_AssistantOwnerLink();
		HPO.click_OverviewLink();
	}
	
	@When("^Navigate to Assistant owner and Maintenance badges page$")
	public void navigate_to_assistant_owner_and_maintenance_badge_page() throws Throwable {
		HPO.Click_CustomerServiceLink();
		HPO.Click_CarsharingLink();
		HPO.click_AssistantOwnerLink();
		HPO.click_maintenanceBadgeLink();
		
	}
	
	

	@Then("^On OVERVIEW ASSISTANCE OWNER page click view complete list under Cleaning section$")
	public void on_overview_assistance_owner_page_click_view_complete_list_under_cleaning_section() throws Throwable {
		CSAOOPO.click_Cleaning_viewcompletelist();
	}

	@And("^On Cleaning page search with the Plate \"([^\"]*)\" and View the list of vehicles for washing for that particular customer$")
	public void on_cleaning_page_search_with_the_plate_and_view_the_list_of_vehicles_for_washing_for_that_particular_customer(
			String vehicleplateno) throws Throwable {
		CSCPO.SearchVehicle_undercleaning(vehicleplateno);
	}

	@Then("^Search for the Customer \"([^\"]*)\" name$")
	public void _search_for_the_customer(String Customername) throws Exception {
		CSCM.searchCustomer(Customername);

	}

	@And("^Customer service enable the Carpooling option and Save changes$")
	public void Customer_service_enable_the_carpooling_option_and_Save_changes() throws Exception {
		CSCM.carpooling_optionEnabled();

	}

	@And("^Customer service disable the Carpooling option and Save changes$")
	public void Customer_service_disable_the_carpooling_option_and_Save_changes() throws Exception {
		CSCM.carpooling_optionDisabled();

	}

	@And("^Customer service enable the Multiparking option and Save changes$")
	public void Customer_service_enable_the_Multiparking_option_and_Save_changes() throws Exception {
		CSCM.MultiParking_optionEnable();

	}

	@And("^Customer service disable the Multiparking option and Save changes$")
	public void Customer_service_disable_the_Multiparking_option_and_Save_changes() throws Exception {
		CSCM.MultiParking_optionDisable();

	}
	@Then("^Verify the Error message to change multi parking due to Departing vehicles is displayed$")
    public void verify_the_error_message_to_change_multi_parking_due_to_departing_vehicles_is_displayed() throws Throwable {
        CSCM.Verify_MultiParking_Departingvehiclesexists_Errormsg_Displayed();
    }

	@Then("^Customer service navigate to All Vehicles page$")
	public void Customer_service_navigate_to_All_Vehicles_page() throws Exception {
		HPO.Click_CarsharingLink();
		HPO.Click_VehiclesLink();
		LOG.info("Navigated to All Vehicles page");
		cm.wait(2);
	}

	@And("^Customer service search for the Vehicle \"([^\"]*)\" and Click on view button$")
	public void Customer_service_search_for_the_Vehicle(String Vehiclenumber) throws Exception {

		CSAV.search_vehicle_ClickViewButton(Vehiclenumber);
	}
	@And("^Customer service search for the Vehicle \"([^\"]*)\"$")
    public void customer_service_search_for_the_vehicle_something(String Vehiclenumber) throws Throwable {
        CSAV.search_vehicle(Vehiclenumber);
    }
	@And("^Filter by multiple criteria Customer as \"([^\"]*)\" Vehicle as \"([^\"]*)\" Status as \"([^\"]*)\"$")
    public void filter_by_multiple_criteria_customer_as_something_vehicle_as_something_status_as_something(String Customer, String Vehiclenumber, String vehiclestatus) throws Throwable {
        CSAV.SearchVehicle_Filter_MultipleCriteria(Customer, Vehiclenumber, vehiclestatus);
    }
	@Then("^Click on the DOWNLOAD button below vehicle results$")
    public void click_on_the_download_button_below_vehicle_results() throws Throwable {
        CSAV.Click_DownloadVehicleresults();
    }

	@Then("^Customer service enter the Maintaince Start Month as \"([^\"]*)\" and Start Day as \"([^\"]*)\" and Start time as \"([^\"]*)\"$")
	public void Customer_service_enter_the_Maintaince_Start_date_as_and_Maintaince_Start_time_as(String startmonth,
			String startday, String starttime) throws Exception {

		CSAV.Select_StartdateTime(startmonth, startday, starttime);

	}

	@And("^Customer service enter the Maintaince End Month as \"([^\"]*)\" and End Day as \"([^\"]*)\" and End time as \"([^\"]*)\"$")
	public void Customer_service_enter_the_Maintaince_End_date_as_and_Maintaince_End_time_as(String endmonth,
			String endday, String endtime) throws Exception {

		CSAV.Select_EnddateTime(endmonth, endday, endtime);

	}

	@Then("^Customer service will select the maintaince Reason as \"([^\"]*)\" and Save the Maintaince Request$")
	public void Customer_service_will_select_the_maintaince_Reason_and_Save_the_Maintaince_Request(String MaintainceReason) throws Exception {
		CSAV.select_MaintainceReason(MaintainceReason);

	}
	@Then("^Customer service will select the maintaince Reason$")
	public void Customer_service_will_select_the_maintaince_Reason() throws Exception {
		CSAV.Verify_VehicleMaintainceReasonOptions();

	}
	

	@Then("^Search for the customer \"([^\"]*)\" and Activate the customer$")
	public void search_for_the_customer_something_and_activate_the_customer(String customeractive) throws Throwable {
		HPO.Activatecustomer(customeractive);
	}

	@And("^List of Fleet Managers corresponding to the chosen customer is shown and download the list$")
	public void list_of_fleet_managers_corresponding_to_the_chosen_customer_is_shown_and_download_the_list()
			throws Throwable {
		HPO.validate_ListofFleetManager();
	}
	
	@Then("^Search for the parking area \"([^\"]*)\"$")
    public void search_for_the_parking_area(String Parkingarea) throws Throwable {
        CSMPO.Search_for_parkingarea(Parkingarea);
    }
	@And("^Click on three dots$")
    public void click_on_three_dots() throws Throwable {
        CSMPO.Click_Threedots();
    }
	
	@Then("^Click on edit button on the popup$")
    public void click_on_edit_button_on_the_popup() throws Throwable {
		CSMPO.Click_editbutton();
  
    }
	@Then("^Click on edit button on the popup and verify edit parking page displayed$")
    public void click_on_edit_button_on_the_popup_and_verify_edit_parking_page_displayed() throws Throwable {
		CSMPO.Click_editbutton();
        CSMPO.Verify_EditHubParkingLable_displayed();
    }
	@Then("^Click on Remove button$")
    public void click_on_delete_button() throws Throwable {
        CSMPO.Click_removebutton();
    }

    @And("^Click on Cancel button on Delete parking pop up$")
    public void click_on_cancel_button_on_delete_parking_pop_up() throws Throwable {
        CSMPO.Click_Cancelbutton();
    }
    @And("^Click on confirm button on Delete parking pop up$")
    public void click_on_confirm_button_on_delete_parking_pop_up() throws Throwable {
        CSMPO.Click_Confirmbutton();
    }
   
    @And("^Click on the pencil Edit$")
    public void click_on_the_pencil_edit() throws Throwable {
        CSMPO.Click_ClickEditpencileButton();
    }
    
    @Then("^Enter the company \"([^\"]*)\" to associate with the car park and Click search button$")
    public void enter_the_company_something_to_associate_with_the_car_park_and_click_search_button(String CompanyToAssociate) throws Throwable {
    	CSMPO.Search_Companyname_To_Associate(CompanyToAssociate);
    }

    @And("^Press Save parking$")
    public void press_save_parking() throws Throwable {
        CSMPO.Click_SaveParkingAreaBtn();
    }
    @Then("^Click on cancel button$")
    public void click_on_cancel_button() throws Throwable {
        CSMPO.Click_CancelBtn_To_AssociateCompany();
    }
    @Then("^Click on Add a new car park$")
    public void click_on_add_a_new_car_park() throws Throwable {
        CSMPO.Click_AddParkingBtn();
    }
    @And("^Fill the address field as \"([^\"]*)\"$")
    public void fill_the_address_field_as_something(String Addressvalue) throws Throwable {
        CSMPO.Fill_AddressDetails(Addressvalue);
    }
    @Then("^Fill Total parking spaces available as \"([^\"]*)\"$")
    public void fill_total_parking_spaces_available_as_something(String ParkingSpacecount) throws Throwable {
       CSMPO.Fill_parkingSpaceDetails(ParkingSpacecount);
    }
    @Then("^On vehicle details page select Allow trips to be closed even if the key is not in the repository box as YES$")
    public void on_vehicle_details_page_select_allow_trips_to_be_closed_even_if_the_key_is_not_in_the_repository_box_as_yes() throws Throwable {
        CSAV.Click_VehicelEndTripRadioBtn();
    }
    @Then("^Select Duration in hours of the maintenance as \"([^\"]*)\" and click on Save$")
    public void select_duration_in_hours_of_the_maintenance_and_click_on_save(String MaintenenceDuration) throws Throwable {
    	CSMBPO.SelectMaintenanceDurationDropdown(MaintenenceDuration);
    }
    @Then("^Enter ChipId BadgeId Assignee and Customer and press save$")
    public void enter_chipid_badgeid_assignee_and_customer_and_press_save() throws Throwable {
        CSMBPO.InsertNewMaintenanceBadge();
    }
    @Then("^Select customer and press Search$")
    public void select_customer_and_press_search() throws Throwable {
        CSMBPO.Search_BadgeID();
    }
    
    
    

	@And("^Logout of Customer Service Account$")
	public void _logout_of_customer_service_account() throws Exception {

		HPO.CSlogout();
	}

}
