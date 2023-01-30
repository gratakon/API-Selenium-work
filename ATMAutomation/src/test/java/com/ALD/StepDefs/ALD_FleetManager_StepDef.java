package com.ALD.StepDefs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ALD_FM.pageObjects.FM_AnalyticspageObjs;
import com.ALD_FM.pageObjects.FM_BadgesObjs;
import com.ALD_FM.pageObjects.FM_CostCenterpageObjs;
import com.ALD_FM.pageObjects.FM_CurrentStatusOfParkingAreapageObjs;
import com.ALD_FM.pageObjects.FM_DriverManagementpageObjs;
import com.ALD_FM.pageObjects.FM_FleetOverviewObjs;
import com.ALD_FM.pageObjects.FM_FleetpageObjs;
import com.ALD_FM.pageObjects.FM_GeneralFleetStatusObjs;
import com.ALD_FM.pageObjects.FM_GroupsandSegmentspageObjs;
import com.ALD_FM.pageObjects.FM_HomepageObjs;
import com.ALD_FM.pageObjects.FM_LoginpageObjs;
import com.ALD_FM.pageObjects.FM_ParkingandHourspageObjs;
import com.ALD_FM.pageObjects.FM_SettingspageObjs;
import com.ALD_FM.pageObjects.FM_TravelListpageObjs;
import com.ALD_FM.pageObjects.FM_VehicleConditionObjs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.But;


public class ALD_FleetManager_StepDef {

	public FM_LoginpageObjs FMLO = new FM_LoginpageObjs();
	public FM_HomepageObjs FMHO = new FM_HomepageObjs();
	public FM_SettingspageObjs FMSPO = new FM_SettingspageObjs();
	public FM_FleetpageObjs FMFO = new FM_FleetpageObjs();
	public FM_ParkingandHourspageObjs FMPHO = new FM_ParkingandHourspageObjs();
	public FM_GroupsandSegmentspageObjs FMGSO = new FM_GroupsandSegmentspageObjs();
	public FM_DriverManagementpageObjs FMDMO = new FM_DriverManagementpageObjs();
	public FM_FleetOverviewObjs FMFOO = new FM_FleetOverviewObjs();
	public FM_VehicleConditionObjs FMVCO = new FM_VehicleConditionObjs();
	public FM_BadgesObjs FMBO = new FM_BadgesObjs();
	public FM_CostCenterpageObjs FMCCPO =new FM_CostCenterpageObjs();
	public FM_GeneralFleetStatusObjs FMGFSO = new FM_GeneralFleetStatusObjs();
	public FM_CurrentStatusOfParkingAreapageObjs FMCSOPAO = new FM_CurrentStatusOfParkingAreapageObjs();
	public FM_AnalyticspageObjs FMAPO = new FM_AnalyticspageObjs();
	public FM_TravelListpageObjs FMTLPO = new FM_TravelListpageObjs();

	private static final Logger LOG = LogManager.getLogger(ALD_FleetManager_StepDef.class);

	@Given("^Login as a Fleet Manager with \"([^\"]*)\" and \"([^\"]*)\" credentials$")
	public void login_as_a_Driver(String FMusername, String FMpassword) throws Exception {
		FMLO.browserup();
		FMLO.DLogin(FMusername, FMpassword);
	}

	@And("^Navigate to Configuration and Settings page$")
	public void Navigate_to_Configuration_and_Settings_page() throws Exception {
		FMHO.click_carsharingfleetlink();
		FMHO.click_configurationlink();
		FMHO.click_settingslink();
	}
	@And("^Navigate to Configuration and Cost centers page$")
	public void Navigate_to_Configuration_and_Costcenters_page() throws Exception {
		FMHO.click_carsharingfleetlink();
		FMHO.click_configurationlink();
		FMHO.click_CostcenterLink();
	}
	 

	@Then("^On Generale Tab update the charging to \"([^\"]*)\" and maintaince hours to \"([^\"]*)\" and Save Changes$")
	public void On_Generale_Tab_update_the_charging_to_and_maintaince_hours_to_and_Save_Changes(String chargepercentage,
			String Maintaincehours) throws Exception {
		FMSPO.updateMaintainceChanges(chargepercentage, Maintaincehours);
	}

	@And("^Logout of Fleet Manager Account$")
	public void Logout_of_Fleet_Manager_Account() throws Exception {
		FMHO.FMLogout();
	}

	@And("^Navigate to Configuration and Fleet page$")
	public void Navigate_to_Configuration_and_Fleet_page() throws Exception {
		FMHO.click_carsharingfleetlink();
		FMHO.click_configurationlink();
		FMHO.click_fleetlink();
	}

	@And("^Navigate to Configuration and Parking Hours$")
	public void Navigate_to_Configuration_and_Parking_Hours() throws Exception {
		FMHO.click_carsharingfleetlink();
		FMHO.click_configurationlink();
		FMHO.click_parkingandHoursLink();
	}

	@When("^Navigate to Configuration and Monitoring and Fleet overview page$")
	public void navigate_to_configuration_and_monitoring_and_fleet_overview_page() throws Throwable {
		FMHO.click_MonitoringLink();
		FMHO.click_FleetoverviewLink();
	}
	@When("^Navigate to Configuration and Monitoring and Analytics page$")
	public void navigate_to_configuration_and_monitoring_and_Analytics_page() throws Throwable {
		FMHO.click_MonitoringLink();
		FMHO.click_AnalyticsLink();
	}
	
	
	@When("^Navigate to Configuration and Monitoring and General Fleet status page$")
	public void navigate_to_configuration_and_monitoring_and_General_Fleet_status_page() throws Throwable {
		FMHO.click_MonitoringLink();
		FMHO.click_GeneralFleetStatusLink();
	}
	@When("^Navigate to Configuration and Monitoring and Current status of Parking area page$")
    public void navigate_to_configuration_and_monitoring_and_current_status_of_parking_area_page() throws Throwable {
		FMHO.click_MonitoringLink();
		FMHO.click_FM_CurrentStatusOfParkingAreaLink();
    }

	@Then("^View the total conditions with the number of reports and click view full list$")
	public void view_the_total_conditions_with_the_number_of_reports_on_fleet_overview_page() throws Throwable {
		FMFOO.Validate_Vehicleconditions();
	}

	@And("^On vehicle condition page search for plate \"([^\"]*)\" and view the results only specific to that vehicle plate$")
	public void on_vehicle_condition_page_search_for_Plate_and_view_the_results_only_specific_to_that_vehicle_plate(
			String vehicleplate) throws Throwable {
		FMVCO.SearchVehicleplate(vehicleplate);
	}

	@Then("^Verify multiparking option dispayed on Fleet page$")
	public void Verify_multiparking_option_dispayed_on_Fleet_page() throws Exception {
		FMFO.verifyMultiparkinglabelPresent();
	}

	@Then("^Verify multiparking option displayed on Parking and hours page$")
	public void Verify_multiparking_option_displayed_on_Parking_and_hours_page() throws Exception {
		FMPHO.verifyHUBPARKINGtabpresent();
	}

	@Then("^Verify multiparking option is not dispayed on Fleet page$")
	public void Verify_multiparking_option_is_not_dispayed_on_Fleet_page() throws Exception {
		FMFO.verifyMultiparkinglabelNotPresent();
	}

	@Then("^Verify multiparking option is not displayed on Parking and hours page$")
	public void Verify_multiparking_option_is_not_displayed_on_Parking_and_hours_page() throws Exception {
		FMPHO.verifyHUBPARKINGtabNOTpresent();
	}

	@And("^Navigate to Configuration and Groups and Segments page$")
	public void navigate_to_configuration_and_groups_and_segments_page() throws Throwable {
		FMHO.click_carsharingfleetlink();
		FMHO.click_configurationlink();
		FMHO.click_groupsandSegmentsLink();

	}

	@And("^Navigate to DriverManagement page$")
	public void navigate_to_drivermanagement_page() throws Throwable {
		FMHO.click_carsharingfleetlink();
		FMHO.click_DrivermanagementLink();
	}

	@Then("^Create a new group with Name as \"([^\"]*)\" Description as \"([^\"]*)\" and Segment as \"([^\"]*)\" Save changes$")
	public void create_a_new_group_with_name_as_something_description_as_something_and_segment_as_something_save_changes(
			String group_Name, String group_Description, String cartype) throws Throwable {
		FMGSO.AddnewBusinessGroup(group_Name, group_Description, cartype);
	}

	@Then("^Assign the newly created Business Group \"([^\"]*)\" to driver \"([^\"]*)\" and Save changes$")
	public void assign_the_newly_created_business_group_something_to_driver_something_and_save_changes(
			String groupNamesel, String DriverName) throws Throwable {
		FMDMO.updateBusinessGroupforDriver(groupNamesel, DriverName);
	}

	@Then("^Delete the group with Name as \"([^\"]*)\" and assign the driver to group \"([^\"]*)\"$")
	public void delete_the_group_with_name_as_something_and_assign_the_driver_to_group_something(
			String groupname_delete, String newgroup_assign) throws Throwable {
		FMGSO.DeleteBusinessgroup(groupname_delete, newgroup_assign);
	}

	@Then("^Verify Carpooling tab is not displayed for Fleet Manager on settings page$")
	public void verify_carpooling_tab_is_not_displayed_for_fleet_manager_on_settings_page() throws Throwable {
		FMSPO.verify_CarpoolingTab_notDisplayed();
	}

	@Then("^Verify Carpooling tab is displayed for Fleet Manager on settings page$")
	public void verify_carpooling_tab_is_displayed_for_fleet_manager_on_settings_page() throws Throwable {
		FMSPO.verify_CarpoolingTab_Displayed();
	}

	@And("^Navigate to Configuration and Badges page$")
	public void navigate_to_configuration_and_badges_page() throws Throwable {
		FMHO.click_carsharingfleetlink();
		FMHO.click_configurationlink();
		FMHO.click_BadgesLink();
	}

	@Then("^FM downloads the badge upload template by clicking on DOWNLOAD TEMPLATE$")
	public void fm_downloads_the_badge_upload_template_by_clicking_on_download_template() throws Throwable {
		FMBO.Click_DownloadTemplete();
	}

	@And("^FM click on the View parking codes link$")
	public void fm_click_on_the_view_parking_codes_link() throws Throwable {
		FMBO.click_parkingcodes();
	}
	@Then("^Verify The HUB parking lots are not displayed in the modal$")
    public void verify_the_hub_parking_lots_are_not_displayed_in_the_modal() throws Throwable {
        FMBO.verify_HubParkings_Notdisplayed();
    }
	@Then("^FM is able to Choose a file to upload$")
    public void fm_is_able_to_choose_a_file_to_upload() throws Throwable {
        FMBO.Choose_file_To_Upload();
    }
	@Then("^FM is able to Choose a file to upload and click on Upload button$")
    public void fm_is_able_to_choose_a_file_to_upload_and_click_on_Upload_button() throws Throwable {
        FMBO.Choose_file_To_Upload();
        FMBO.click_uploadfileBtn();
    }
	@And("^FM is able to remove a file before uploading it$")
    public void fm_is_able_to_remove_a_file_before_uploading_it() throws Throwable {
        FMBO.click_removefile();
    }
	@And("^Verify confirmation flash message is displayed$")
    public void verify_confirmation_flash_message_is_displayed() throws Throwable {
        FMBO.verify_uploadSucessFlahMsg_displayed();
    }
	@Then("^Verify badge has been correctly assigned to the driver$")
    public void verify_badge_has_been_correctly_assigned_to_the_driver() throws Throwable {
        FMDMO.verify_BadgeToDriver_assigend();
    }
	@Then("^FM is able to Choose a file with wrong data to upload and click on Upload button$")
    public void fm_is_able_to_choose_a_file_with_wrong_data_to_upload_and_click_on_upload_button() throws Throwable {
        FMBO.Choose_file_To_Upload_wrongData();
        FMBO.click_uploadfileBtn();
    }

    @And("^Verify all the checks are carried out on the data entered$")
    public void verify_all_the_checks_are_carried_out_on_the_data_entered() throws Throwable {
        FMBO.verify_allThedataChecksPerformed();
    }
    @Then("^Click on the trash can icon to delete the wrongly inserted badge \"([^\"]*)\"$")
    public void click_on_the_trash_can_icon_to_delete_the_wrongly_inserted_badge(String Badgenumber) throws Throwable {
        FMBO.click_DeleteBadge(Badgenumber);
    }
    @Then("^FM is able to Choose a file with Driver already assigned and click on Upload button$")
    public void fm_is_able_to_choose_a_file_with_driver_already_assigned_and_click_on_upload_button() throws Throwable {
        FMBO.Choose_file_To_Upload_DriverHasBadge();
        FMBO.click_uploadfileBtn();
    }

    @And("^Verify Driver has Badge assigend message is displayed$")
    public void verify_driver_has_badge_assigend_message_is_displayed() throws Throwable {
        FMBO.Verify_DriverHasBadgeErrormsg_displayed();
    }
    
    @Then("^FM is able to Choose a file with wrong CARDID CHIPID DriverMAILID and PARKINGCODE data to upload and click on Upload button$")
    public void fm_is_able_to_choose_a_file_with_wrong_cardid_chipid_drivermailid_and_parkingcode_data_to_upload_and_click_on_upload_button() throws Throwable {
       FMBO.Choose_file_To_Upload_withAllBadData();
       FMBO.click_uploadfileBtn();
    }
    @And("^Verify all the error messages are displayed under wrong values$")
    public void verify_all_the_error_messages_are_displayed_under_wrong_values() throws Throwable {
        FMBO.Verify_AllErrorMessages_BadDataUploaded();
    }
    @Then("^Edit all the uploaded wrong values and click on upload again$")
    public void edit_all_the_uploaded_wrong_values_and_click_on_upload_again() throws Throwable {
        FMBO.Edit_AllBadDataUploaded();
        FMBO.click_uploadfileBtn();
    }
    @Then("^FM is able to change driver info previously inserted to \"([^\"]*)\"$")
    public void fm_is_able_to_change_driver_info_previously_inserted(String Driver_email) throws Throwable {
        FMBO.Edit_driverinfo(Driver_email);
    }
    @Then("^FM is able to search for a specific driver or association as \"([^\"]*)\" through Search$")
    public void fm_is_able_to_search_for_a_specific_driver_or_association_through_search(String driverTosearch) throws Throwable {
        FMBO.Search_driverAssociation(driverTosearch);
    }
    @Then("^Click on the trash can icon to delete the wrongly inserted badge \"([^\"]*)\" but cancel the deletion$")
    public void click_on_the_trash_can_icon_to_delete_the_wrongly_inserted_badge_something_but_cancel_the_deletion(String Badgenumber1) throws Throwable {
        FMBO.Click_Cancellation_DeleteBadge(Badgenumber1);
    }
    @Then("^FM selects DELETE BADGE option and apply under Massive options section$")
    public void fm_selects_delete_badge_option_and_apply_under_massive_options_section() throws Throwable {
        FMBO.Apply_BadgebulkDeleteOption();
    }
    @Then("^FM selects CHANGE PARKING option and apply under Massive options section$")
    public void fm_selects_change_parking_option_and_apply_under_massive_options_section() throws Throwable {
        FMBO.Apply_BadgebulkChangeParking();
    }
    @Then("^Click on Add new Parking space$")
    public void click_on_add_new_parking_space() throws Throwable {
        FMPHO.Click_Add_newparking();
    }

    @And("^Cancel Add new parking space$")
    public void cancel_add_new_parking_space() throws Throwable {
        FMPHO.click_Cancel_Add_newparking();
    }

    @And("^Enter the required data for new parking space and press Save Changes$")
    public void enter_the_required_data_for_new_parking_space_and_press_save_changes() throws Throwable {
        FMPHO.Enter_newParkingDetails();
    }
    @Then("^FM click on ADD SCHEDULE button for the newly created parking Space$")
    public void fm_click_on_add_schedule_button_for_the_newly_created_parking_space() throws Throwable {
        FMPHO.Click_AddScheduleButton();
    }

    @And("^Cancel the Add schedule$")
    public void cancel_the_add_schedule() throws Throwable {
        FMPHO.click_cancelAddscheduleButton();
    }
    @Then("^FM click on ADD SCHEDULE provide the timings and Save changes$")
    public void fm_click_on_add_schedule_provide_the_timings_and_save_changes() throws Throwable {
        FMPHO.Click_AddScheduleButton();
        FMPHO.Select_AddScheduleDetails();   
    }
    @Then("^Click on GET PARKING DATA to download the parking data$")
    public void click_on_get_parking_data_to_download_the_parking_data() throws Throwable {
       FMPHO.Click_GetParkingData();
    }
    @Then("^Search for a specific parking space \"([^\"]*)\"$")
    public void search_for_a_specific_parking_space(String ParkingSpace) throws Throwable {
        FMPHO.Search_ParkingAddress(ParkingSpace);
    }
    @And("^Click on REMOVE Parking space and verify the popup message related to associated vehicle is displayed$")
    public void click_on_remove_parking_space_and_verify_the_popup_message_related_to_associated_vehicle_is_displayed() throws Throwable {
        FMPHO.RemoveParking_AssociatedVehicle();
    }
    @And("^Click on REMOVE Parking space and verify the popup message related to vehicle with ongoing trip booked is displayed$")
    public void click_on_remove_parking_space_and_verify_the_popup_message_related_to_vehicle_with_ongoing_trip_booked_is_displayed() throws Throwable {
    	 FMPHO.RemoveParking_AssociatedVehicle();
    }
    @And("^Click on remove parking space$")
    public void click_on_remove_parking_space() throws Throwable {
        FMPHO.click_removeParkingSpace();
    }
    @Then("^Check the Delete badge check box activates the Confirm Removal button$")
    public void check_the_delete_badge_check_box_activates_the_confirm_removal_button() throws Throwable {
        FMPHO.check_deleteBadge_confirmBtnEnabled();
    }
    @And("^Click on Cancel button$")
    public void click_on_cancel_button() throws Throwable {
        FMPHO.click_Cancelbutton_deleteparking();
    }
    @Then("^Check the checkbox Assign them to another car park and Select parking$")
    public void check_the_checkbox_assign_them_to_another_car_park_and_select_parking() throws Throwable {
        FMPHO.check_AssignAnotherParking();
    }

    @And("^Verify Confirm Reassignment button enabled$")
    public void verify_confirm_reassignment_button_enabled() throws Throwable {
        FMPHO.verify_ReassignmentButton_enabled();
    }
    @Then("^On Enable Tab Select MassiveOptions and Assign the group to all the drivers$")
    public void on_enable_tab_select_massiveoptions_and_assign_the_group_to_all_the_drivers() throws Throwable {
        FMDMO.AssignNewGroupTo_Alldrivers();
    }
    @And("^Click on Cancel$")
    public void click_on_cancel() throws Throwable {
       FMDMO.Click_CancelAssignGroupToAll();
    }
    @And("^Click on Confirm$")
    public void click_on_confirm() throws Throwable {
        FMDMO.Click_ConfirmAssignGroupToAll();
    }
    @Then("^Click on Confirm parking space deletion$")
    public void click_on_confirm_parking_space_deletion() throws Throwable {
        FMPHO.Click_parkingSpaceDeletion_confirmbutton();
    }
    @Then("^Upload the csv file contains driver userID and incorrect lines cdc$")
    public void upload_the_csv_file_contains_driver_userid_and_incorrect_lines_cdc() throws Throwable {
        FMCCPO.click_ChoosefileButton();
        FMCCPO.uploadCSV_UserID_incorrectCDC();
        FMCCPO.click_uploadButton();
    }
    @Then("^Upload the csv file contains driver Taxcode and incorrect lines cdc$")
    public void upload_the_csv_file_contains_driver_Taxcode_and_incorrect_lines_cdc() throws Throwable {
        FMCCPO.click_ChoosefileButton();
        FMCCPO.uploadCSV_Taxcode_incorrectCDC();
        FMCCPO.click_uploadButton();
    }
    @But("^In correspondence with the associations in error click on the trash can icon$")
    public void in_correspondence_with_the_associations_in_error_click_on_the_trash_can_icon() throws Throwable {
        FMCCPO.click_TrashiconButton();
    }
    @Then("^Click on Upload and verify the success message$")
    public void click_on_upload_and_verify_the_success_message() throws Throwable {
        FMCCPO.click_uploadButton();
        FMCCPO.Verify_AlertMessgaeDisplayed();
    }
    @Then("^Upload the csv file contains Pooler userID and correct lines cdc$")
    public void upload_the_csv_file_contains_pooler_userid_and_correct_lines_cdc() throws Throwable {
    	FMCCPO.click_ChoosefileButton();
        FMCCPO.uploadCSV_UserID_correctCDC_pooler();
    }
    @Then("^Upload the csv file contains Pooler Taxcode and correct lines cdc$")
    public void upload_the_csv_file_contains_pooler_Taxcode_and_correct_lines_cdc() throws Throwable {
    	FMCCPO.click_ChoosefileButton();
        FMCCPO.uploadCSV_Taxcode_correctCDC_pooler();
    }
    
    @Then("^Upload the csv file contains Driver Taxcode and correct lines cdc$")
    public void upload_the_csv_file_contains_driver_taxcode_and_correct_lines_cdc() throws Throwable {
        FMCCPO.click_ChoosefileButton();
        FMCCPO.uploadCSV_Taxcode_correctCDC();
    }
    @Then("^Upload the file with text format$")
    public void upload_the_file_with_text_format() throws Throwable {
    	FMCCPO.click_ChoosefileButton();
        FMCCPO.uploadFile_invalidformat();
        
    }
    @Then("^Click on Upload and verify the Error message is displayed$")
    public void click_on_upload_and_verify_the_error_message_is_displayed() throws Throwable {
       FMCCPO.click_uploadButton();
       FMCCPO.Verify_ErrorMessage_invalidaFileFormat();
    }
    @Then("^Click on Driver list model on top right$")
    public void click_on_driver_list_model_on_top_right() throws Throwable {
        FMCCPO.Click_DriverlistModel();
    }
    @When("^User enter the driver's first and last name as \"([^\"]*)\" and click on search$")
    public void user_enter_the_drivers_first_and_last_name_as_somethingand_click_on_search(String TextToSearch) throws Throwable {
        FMCCPO.Enter_DriverToSearch(TextToSearch);
    }
    @When("^User enter the driver's Email as \"([^\"]*)\" and click on search$")
    public void user_enter_the_drivers_email_as_something_and_click_on_search(String TextToSearch) throws Throwable {
    	FMCCPO.Enter_DriverToSearch(TextToSearch);
    }
    @When("^User enter the driver's UserID as \"([^\"]*)\" and click on search$")
    public void user_enter_the_drivers_userid_as_something_and_click_on_search(String TextToSearch) throws Throwable {
    	FMCCPO.Enter_DriverToSearch(TextToSearch);
    }

    @When("^User enter the driver's Taxcode as \"([^\"]*)\" and click on search$")
    public void user_enter_the_drivers_taxcode_as_something_and_click_on_search(String TextToSearch) throws Throwable {
        FMCCPO.Enter_DriverToSearch(TextToSearch);
    }
    @When("^User enter the Pooler's first and last name as \"([^\"]*)\" and click on search$")
    public void user_enter_the_poolers_first_and_last_name_as_something_and_click_on_search(String TextToSearch) throws Throwable {
    	FMCCPO.Enter_DriverToSearch(TextToSearch);
    }
    @When("^User enter the Poolers's Email as \"([^\"]*)\" and click on search$")
    public void user_enter_the_poolerss_email_as_something_and_click_on_search(String TextToSearch) throws Throwable {
    	FMCCPO.Enter_DriverToSearch(TextToSearch);
    }
    @When("^User enter the Poolers's UserID as \"([^\"]*)\" and click on search$")
    public void user_enter_the_poolerss_userid_as_something_and_click_on_search(String TextToSearch) throws Throwable {
    	FMCCPO.Enter_DriverToSearch(TextToSearch);
    }
    @When("^User enter the Poolers's Taxcode as \"([^\"]*)\" and click on search$")
    public void user_enter_the_poolerss_taxcode_as_something_and_click_on_search(String TextToSearch) throws Throwable {
    	FMCCPO.Enter_DriverToSearch(TextToSearch);
    }
    @Then("^The system correctly returns the search result$")
    public void  the_system_correctly_returns_the_search_result() throws Throwable {
        FMCCPO.verify_SearchResults();
    }
    @Then("^Close the Driver list model$")
    public void close_the_driver_list_model() throws Throwable {
       FMCCPO.close_DriverlistModel();
    }
    @Then("^Click on Help button on Costcenter page verify the content$")
    public void click_on_help_button_on_costcenter_page_verify_the_content() throws Throwable {
        FMCCPO.click_CostCenterHelpButton();
    }
    @Then("^Select \"([^\"]*)\" option from SEGMENT dropdown and enable Multiparking option$")
    public void select_something_option_from_segment_dropdown_and_enable_multiparking_option(String Segmentname) throws Throwable {
        FMFO.Search_SegmentDropdown_option(Segmentname);
        FMFO.enable_multiparking_as_FM();
    }
    @Then("^Search \"([^\"]*)\" vehicle registration number and enable Multiparking option$")
    public void search_something_vehicle_registration_number_and_enable_multiparking_option(String VehicleRegistrationNumber) throws Throwable {
        FMFO.Search_VehicleRegistrationnumber(VehicleRegistrationNumber);
        FMFO.enable_multiparking_as_FM();
        
    }
    @Then("^Search \"([^\"]*)\" vehicle registration number and disable Multiparking option$")
    public void search_something_vehicle_registration_number_and_disable_multiparking_option(String VehicleRegistrationNumber) throws Throwable {
        FMFO.Search_VehicleRegistrationnumber(VehicleRegistrationNumber);
        FMFO.disable_multiparking_as_FM();
        
    }
    @Then("^Search for vehicle registration number with Reservation made and disable Multiparking option$")
    public void search_for_vehicle_registration_number_with_reservation_made_and_disable_multiparking_option() throws Throwable {
    	FMFO.Search_VehicleRegistrationnumber_From_Mytripspage();
    }
    @Then("^Verify the Multiparking checkbox disabled due to scheduled trip booking$")
    public void verify_the_multiparking_checkbox_disabled_due_to_scheduled_trip_booking() throws Throwable {
        FMFO.Verify_MultiparkingCheckBox_Disabled();
    }
    @Then("^Click on pencil icon and select new CDC value from the dropdown as \"([^\"]*)\"$")
    public void click_on_pencil_icon_and_select_new_cdc_value_from_the_dropdown(String NewCDCvalue) throws Throwable {
        FMCCPO.click_pencilIcon();
    	FMCCPO.select_newCostcenter(NewCDCvalue);
    }
    
    @Then("^Click on pencile icon and within the dropdownlist click on cancel corresponding to x$")
    public void click_on_pencile_icon_and_within_the_dropdownlist_click_on_cancel_corresponding_to_x() throws Throwable {
        FMCCPO.click_pencilIcon();
        FMCCPO.click_CDCSelection_cancelBtn();
    }
    @Then("^click on the delete icon next to an association and click on confirm$")
    public void click_on_the_delete_icon_next_to_an_association_and_click_on_confirm() throws Throwable {
        FMCCPO.delete_singleAssociation();
    }
    @Then("^Select from the massive action from the dropdown list and Select CdC to associate from the dropdown list of the CDC$")
    public void select_from_the_massive_action_from_the_dropdown_list_and_select_cdc_to_associate_from_the_dropdown_list_of_the_cdc() throws Throwable {
        FMCCPO.Select_CDCAssociations_Dropdown();
    }
    @And("^Select one or more items in the list of associations displayed on the CDC page$")
    public void select_one_or_more_items_in_the_list_of_associations_displayed_on_the_cdc_page() throws Throwable {
    	FMCCPO.Select_CDC_Items();
    }
    @Then("^Click on Apply$")
    public void click_on_apply() throws Throwable {
        FMCCPO.Click_ApplyBtn();
    }
    @Then("^FM confirms the deletion$")
    public void fm_confirms_the_deletion() throws Throwable {
        FMCCPO.click_MassiveDeleteconfirmButton();
    }
    @Then("^Select Vehicle parking area as \"([^\"]*)\"$")
    public void select_vehicle_parking_area_as_something(String VehicleParkingLocation) throws Throwable {
        FMGFSO.Select_VehicleParkingDropdown(VehicleParkingLocation);
    }

    @Then("^Type in a LISCENCE PLATE number as \"([^\"]*)\" and click on Filter button$")
    public void type_in_a_liscence_plate_number_as_something_and_click_on_filter_button(String VehicleNumber) throws Throwable {
        FMGFSO.Enter_vehicleplateNumber(VehicleNumber);
        FMGFSO.Click_SearchVehicleBtn();
    }
    @And("^Press on the red square in the table and view Pop up with vehicle name$")
    public void press_on_the_red_square_in_the_table_and_view_pop_up_with_vehicle_name() throws Throwable {
        FMGFSO.Click_VehicleMaintainceDayNumber_view_Popup_vehiclename();
    }
    @Then("^Type in a MODEL as \"([^\"]*)\" and click on Filter button$")
    public void type_in_a_model_as_something_and_click_on_filter_button(String VehicleNumber) throws Throwable {
    	FMGFSO.Enter_vehicleplateNumber(VehicleNumber);
        FMGFSO.Click_SearchVehicleBtn();
    }
    @Then("^Scroll down the screen to the bottom of the vehicle list$")
    public void scroll_down_the_screen_to_the_bottom_of_the_vehicle_list() throws Throwable {
    	FMGFSO.Scroll_down_to_pageBottom();  
    }

    @And("^Verify the header of the table containing the days of the week is always visible at the top of the window$")
    public void verify_the_header_of_the_table_containing_the_days_of_the_week_is_always_visible_at_the_top_of_the_window() throws Throwable {
        FMGFSO.Verify_tableHeader_visible();
    }
    @Then("^In the Registration field provide License Plate number as \"([^\"]*)\" and click on filter$")
    public void in_the_registration_field_provide_license_plate_number_and_click_on_filter(String VehicleRegistrationNumber) throws Throwable {
        FMFO.Search_VehicleRegistrationnumber(VehicleRegistrationNumber);
    }
    @Then("^Select the dropdown All car parkings and verify list of car park addresses is displayed in in alphabetical order$")
    public void select_the_dropdown_all_car_parkings_and_verify_list_of_car_park_addresses_is_displayed_in_in_alphabetical_order() throws Throwable {
        FMGFSO.verify_AllParkingDropdown_AlphabeticOrder();
    }
    @Then("^Click on Vehicle in Transit tab$")
    public void click_on_vehicle_in_transit_tab() throws Throwable {
    	FMCSOPAO.click_FM_VehiclesTransitTab();
    }
    @Then("^Click on Vehicle in Parking area tab$")
    public void click_on_vehicle_in_parking_area_tab() throws Throwable {
    	FMCSOPAO.click_FM_VehiclesInParkingAreaTab();
    }
    @Then("^Click on Vehicle Undergoing Maintenance tab$")
    public void click_on_vehicle_undergoing_maintenance_tab() throws Throwable {
    	FMCSOPAO.click_FM_VehiclesUnderMaintenanceTab();
    }
    @Then("^Click on Filters button on CURRENT STATUS OF PARKING AREAS page$")
    public void click_on_filters_button_on_current_status_of_parking_areas_page() throws Throwable {
    	FMCSOPAO.click_FM_Filterbutton();
    }

    @And("^Click on Apply Filters button CURRENT STATUS OF PARKING AREAS page$")
    public void click_on_apply_filters_button_current_status_of_parking_areas_page() throws Throwable {
    	FMCSOPAO.click_FM_ApplyFilterbutton();
    }
    @And("^Select the Service Type dropdown$")
    public void select_the_service_type_dropdown() throws Throwable {
    	FMCSOPAO.Select_ServicetypeDropdown();
    }
    @And("^Select the Vehicle Segment checkbox option for CONVERTIBLE and PREMIUM$")
    public void select_the_vehicle_segment_checkbox_option_for_convertible_and_premium() throws Throwable {
        FMCSOPAO.Click_VehicleSegment_Checkbox();
    }
    @And("^Select the Vehicle Parking area dropdown$")
    public void select_the_vehicle_parking_area_dropdown() throws Throwable {
    	FMCSOPAO.Select_ParkingAreaDropdown();
    }
    @And("^Select the Trip type checkbox as Business$")
    public void select_the_trip_type_checkbox_as_business() throws Throwable {
    	FMCSOPAO.Click_TripTypeCheckbox();
    }
    @Then("^Click on Alert Management tab$")
    public void click_on_alert_management_tab() throws Throwable {
    	FMSPO.click_AlertManagementTab();
        
    }
    @Then("^Under FLEET LOCATION SECTION Set ON when notification is received$")
    public void under_fleet_location_section_set_on_when_notification_is_received() throws Throwable {
        FMSPO.click_FleetlocationAlert_checkbox_enable();
    }
    @And("^Under FLEET LOCATION SECTION Choose a number of vehicles present$")
    public void under_fleet_location_section_choose_a_number_of_vehicles_present() throws Throwable {
        FMSPO.Select_FleetlocationAlert_Dropdown();
    }
    @But("^Under FLEET LOCATION SECTION Do not insert mail Click on SAVE button$")
    public void under_fleet_location_section_do_not_insert_mail_click_on_save_button() throws Throwable {
        FMSPO.Clear_FleetlocationAlert_Emailfield();
        FMSPO.Click_FleetlocationAlert_SaveBtn();
    }
    @Then("^Under FLEET LOCATION SECTION Validate mail Mandatory message will display$")
    public void under_fleet_location_section_validate_mail_mandatory_message_will_display() throws Throwable {
        FMSPO.Verify_EmailMandatory_ErrorMsg_displayed();
    }
    @But("^Under FLEET LOCATION SECTION Insert mail Click on SAVE button$")
    public void under_fleet_location_section_insert_mail_click_on_save_button() throws Throwable {
        FMSPO.Enter_FleetlocationAlert_Emailfield();
        FMSPO.Click_FleetlocationAlert_SaveBtn();
    }
    @Then("^Under FLEET LOCATION SECTION Validate Success message displayed as expected$")
    public void under_fleet_location_section_validate_success_message_displayed_as_expected() throws Throwable {
        FMSPO.Verify_AlertChanges_SuccessMsg_displayed();
    }
    @Then("^Under EMPTY PARKING SECTION Set ON when notification is received$")
    public void under_empty_parking_section_set_on_when_notification_is_received() throws Throwable {
        FMSPO.click_EmptyParkingAlert_checkbox_enable();
    }

    @And("^Under EMPTY PARKING SECTION Choose a number of vehicles present$")
    public void under_empty_parking_section_choose_a_number_of_vehicles_present() throws Throwable {
        FMSPO.Select_EmptyParkingAlert_Dropdown();
    }
    @But("^Under EMPTY PARKING SECTION Do not insert mail Click on SAVE button$")
    public void under_empty_parking_section_do_not_insert_mail_click_on_save_button() throws Throwable {
        FMSPO.Clear_EmptyParkingAlert_Emailfield();
        FMSPO.Click_EmptyParkingAlert_SaveBtn();
    }
    @Then("^Under EMPTY PARKING SECTION Validate mail Mandatory message will display$")
    public void under_empty_parking_section_validate_mail_mandatory_message_will_display() throws Throwable {
        FMSPO.Verify_EmailMandatory_ErrorMsg_displayed();
    }
    @But("^Under EMPTY PARKING SECTION Insert mail Click on SAVE button$")
    public void under_empty_parking_section_insert_mail_click_on_save_button() throws Throwable {
        FMSPO.Clear_EmptyParkingAlert_Emailfield();
        FMSPO.Enter_EmptyParkingAlert_Emailfield();
        FMSPO.Click_EmptyParkingAlert_SaveBtn();
    }
    @Then("^Under EMPTY PARKING SECTION Validate Success message displayed as expected$")
    public void under_empty_parking_section_validate_success_message_displayed_as_expected() throws Throwable {
       FMSPO.Verify_AlertChanges_SuccessMsg_displayed();
    }
    @Then("^Under UNUSED VEHICLE SECTION Set ON when notification is received$")
    public void under_unused_vehicle_section_set_on_when_notification_is_received() throws Throwable {
        FMSPO.click_UnusedVehicleAlert_checkbox_enable();
    }

    @And("^Under UNUSED VEHICLE SECTION Choose a number of vehicles present$")
    public void under_unused_vehicle_section_choose_a_number_of_vehicles_present() throws Throwable {
        FMSPO.Select_UnusedVehicleAlert_Dropdown();
    }
    @But("^Under UNUSED VEHICLE SECTION Do not insert mail Click on SAVE button$")
    public void under_unused_vehicle_section_do_not_insert_mail_click_on_save_button() throws Throwable {
        FMSPO.Clear_UnusedVehicleAlert_Emailfield();
        FMSPO.Click_UnusedVehicleAlert_SaveBtn();
        
    }
    @Then("^Under UNUSED VEHICLE SECTION Validate mail Mandatory message will display$")
    public void under_unused_vehicle_section_validate_mail_mandatory_message_will_display() throws Throwable {
        FMSPO.Verify_EmailMandatory_ErrorMsg_displayed();
    }
    @But("^Under UNUSED VEHICLE SECTION Insert mail Click on SAVE button$")
    public void under_unused_vehicle_section_insert_mail_click_on_save_button() throws Throwable {
        FMSPO.Clear_UnusedVehicleAlert_Emailfield();
    	FMSPO.Enter_UnusedVehicleAlert_Emailfield();
    	FMSPO.Click_UnusedVehicleAlert_SaveBtn();
    }
    @Then("^Under UNUSED VEHICLE SECTION Validate Success message displayed as expected$")
    public void under_unused_vehicle_section_validate_success_message_displayed_as_expected() throws Throwable {
        FMSPO.Verify_AlertChanges_SuccessMsg_displayed();
    }
    @Then("^Verify Use of parking lots tab and MAINTENANCE tab on Analytics page$")
    public void verify_use_of_parking_lots_tab_and_maintenance_tab_on_analytics_page() throws Throwable {
        
    	FMAPO.click_UseOfParkingLotsTab();
    	FMAPO.click_MaintenanceTab();
    }
    @Then("^On the Analytics page select Maintenance$")
    public void on_the_analytics_page_select_maintenance() throws Throwable {
    	FMAPO.click_MaintenanceTab();
    }
    @Then("^Verify hub parking options are not present in Parking dropdown list$")
    public void verify_hub_parking_options_are_not_present_in_parking_dropdown_list() throws Throwable {
        FMAPO.verify_hubparkingoptionsNOTpresent_ParkingDropdown();
    }
    @Then("^Verify search button disabled when one of the three search parameters is not selected$")
    public void verify_search_button_disabled_when_one_of_the_three_search_parameters_is_not_selected() throws Throwable {
        FMAPO.Veirfy_Searchbutton_disabled();
    }
    @Then("^Select the Parking option$")
    public void select_the_parking_option() throws Throwable {
        FMAPO.Select_ParkingDropdown();
    }
    @Then("^Provide month as \"([^\"]*)\" day as \"([^\"]*)\" in the FROM field$")
    public void and_provide_month_as_something_day_as_something_in_the_FROM_field(String startmonth, String date) throws Throwable {
        FMAPO.Input_fromdate(startmonth, date);
    }
    @Then("^Provide month as \"([^\"]*)\" day as \"([^\"]*)\" in the TO field$")
    public void provide_month_as_something_day_as_something_in_the_to_field(String startmonth, String date) throws Throwable {
        FMAPO.Input_Todate(startmonth, date);
    }
    @Then("^Verify search button is enabled and Click if enabled$")
    public void verify_search_button_is_enabled_and_click_if_enabled() throws Throwable {
        FMAPO.Verify_Searchbutton_enabled();
    }
    @Then("^Verify Button to download the table on XLS click on EXPORT XLS button$")
    public void verify_button_to_download_the_table_on_xls_click_on_export_xls_button() throws Throwable {
        FMAPO.Verify_Click_ExportXLSBtn();
    }
    @Then("^Click on Analytics Tab$")
    public void click_on_analytics_tab() throws Throwable {
        FMSPO.Click_AnalyticsTab();
    }
    @Then("^Provie all the data on Analytics page$")
    public void provie_all_the_data_on_analytics_page() throws Throwable {
        FMSPO.Provide_values_Analyticsfield();
    }
    @Then("^Enter a string for each numeric value$")
    public void enter_a_string_for_each_numeric_value() throws Throwable {
        FMSPO.Provide_Stringvalues_Analyticsfield();
    }
    @Then("^Verify that an error message appears$")
    public void verify_that_an_error_message_appears() throws Throwable {
        FMSPO.Verify_AnalyticsStringvalue_ErrorMessages_Displayed();
    }
    @And("^Navigate to TravelList section$")
    public void navigate_to_travellist_section() throws Throwable {
    	
    	FMHO.click_FM_TravelManagementLink();
    	FMHO.click_FM_TravelListLink();
        
    }
    @Then("^On Next trips Tab and click on search$")
    public void on_next_trips_tab_click_on_search() throws Throwable {
        FMTLPO.Click_NextTripTab();
        FMTLPO.Click_TravelsearchBtn();
    }
    @Then("^Click on Past trips Tab and click on search$")
    public void click_on_past_trips_tab_and_click_on_search() throws Throwable {
       FMTLPO.Click_PastTripsTab();
       FMTLPO.Click_TravelsearchBtn();
    }
    @Then("^Enter the correct license plate code as \"([^\"]*)\" and press Search$")
    public void enter_the_correct_license_plate_code_as_something_and_press_search(String LicensePlate) throws Throwable {
        FMTLPO.Enter_LicensePlatenumber(LicensePlate);
        FMTLPO.Click_TravelsearchBtn();   
    }
    @Then("^Select the Type of use as \"([^\"]*)\" and press Search$")
    public void select_the_type_of_use_as_something_and_press_search(String Usetype) throws Throwable {
        FMTLPO.Select_TypeofUseDropdown(Usetype);
        FMTLPO.Click_TravelsearchBtn();
    }
    @Then("^Verify Allow the closure of trips even if the key is not in the repository is disabled$")
    public void verify_allow_the_closure_of_trips_even_if_the_key_is_not_in_the_repository_is_disabled() throws Throwable {
        FMSPO.Verify_AllowEndTripOption_Disabled();
    }
    @Then("^Search with Drivers LastName as \"([^\"]*)\"$")
    public void search_with_drivers_lastname_as_something(String drivername) throws Throwable {
        FMDMO.SearchDriverField(drivername);
    }
    @Then("^Search with Drivers SurName as \"([^\"]*)\"$")
    public void search_with_drivers_Surname_as_something(String drivername) throws Throwable {
        FMDMO.SearchDriverField(drivername);
    }
    @Then("^Search with Drivers EmailID as \"([^\"]*)\"$")
    public void search_with_drivers_EmailID_as_something(String drivername) throws Throwable {
        FMDMO.SearchDriverField(drivername);
    }



    }



