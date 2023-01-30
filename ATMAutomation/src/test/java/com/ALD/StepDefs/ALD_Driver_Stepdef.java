package com.ALD.StepDefs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ALD_Driver.pageObjects.Driver_BookingPageObjs;
import com.ALD_Driver.pageObjects.Driver_CarSharingProfilePageObjs;
import com.ALD_Driver.pageObjects.Driver_HomePageObjs;
import com.ALD_Driver.pageObjects.Driver_LoginPageObjs;
import com.ALD_Driver.pageObjects.Driver_MyTripsPageObjs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ALD_Driver_Stepdef {

	public Driver_HomePageObjs DHPO = new Driver_HomePageObjs();
	public Driver_LoginPageObjs DLPO = new Driver_LoginPageObjs();
	public Driver_CarSharingProfilePageObjs DCSP = new Driver_CarSharingProfilePageObjs();
	public Driver_BookingPageObjs DBP = new Driver_BookingPageObjs();
	public Driver_MyTripsPageObjs DMTPO = new Driver_MyTripsPageObjs();

	private static final Logger LOG = LogManager.getLogger(ALD_Driver_Stepdef.class);

	@Given("^Login as a Driver with \"([^\"]*)\" and \"([^\"]*)\" credentials$")
	public void _login_as_a_Driver(String Dusername, String Dpassword) throws Exception {

		DLPO.browserup();
		DLPO.DLogin(Dusername, Dpassword);
		
	}

	@Then("^Navigate to Car Sharing profile section$")
	public void Navigate_to_Car_Sharing_profile_section() throws Exception {
		try {
			DHPO.click_AcknowledgePopup();
			LOG.info("Acknowledge popup present on HomePage");
		} catch (Exception e) {
			LOG.info("No Acknowledge popup on HomePage");
		} finally {
			DHPO.click_CarSharingLink();
			DHPO.click_CarSharingProfileLink();

		}

	}

	@Then("^Navigate to Booking section$")
	public void Navigate_to_Booking_section() throws Exception {
		try {
			DHPO.click_AcknowledgePopup();
			LOG.info("Acknowledge popup present on HomePage");
		} catch (Exception e) {
			LOG.info("No Acknowledge popup on HomePage");
		} finally {
			DHPO.click_CarSharingLink();
			DHPO.click_BookingLink();

		}

	}

	@Then("^Navigate to My Trips section$")
	public void Navigate_to_MyTrips_section() throws Exception {
		try {
			DHPO.click_AcknowledgePopup();
			LOG.info("Acknowledge popup present on HomePage");
		} catch (Exception e) {
			LOG.info("No Acknowledge popup on HomePage");
		} finally {
			DHPO.click_CarSharingLink();
			DHPO.click_MytripsLink();

		}

	}

	@Then("^Verify new vehicle is assigned to the same trip$")
	public void verify_new_vehicle_is_assigned_to_the_same_trip() throws Throwable {
		DMTPO.verify_newVehicleAssignment();

	}

	@And("^Verify Car Pooling option is enabled$")
	public void Verify_CarPooling_option_is_enabled() throws Exception {
		DCSP.DriverCarPoolingOptiond_enable();
	}

	@Then("^Verify Multiparking option LEAVE NOW button is displayed$")
	public void Verify_Leave_Now_button_is_displayed() throws Exception {
		DBP.validateLeaveNowOption_enabled();
	}

	@Then("^Verify Multiparking option LEAVE NOW is not displayed$")
	public void Verify_Multiparking_option_is_not_displayed() throws Exception {
		DBP.validateLeaveNowOption_disabled();
	}

	@And("^Verify Car Pooling option is Disabled$")
	public void Verify_CarPooling_option_is_Disabled() throws Exception {
		DCSP.DriverCarPoolingOption_Disable();
	}

	@Then("^Select Schedule a return trip option for MonoParking$")
	public void select_schedule_a_return_trip_option_for_monoparking() throws Throwable {
		DBP.optforMonoparking();
	}

	@And("^Provide Departure month as \"([^\"]*)\" day as \"([^\"]*)\" hours as \"([^\"]*)\" minutes as \"([^\"]*)\" and click NEXT button to Book a car$")
	public void provide_departure_month_as_something_day_as_something_hours_as_something_minutes_as_something_and_click_next_button_to_book_a_car(
			String startmonth, String date, String hours, String minutes) throws Throwable {

		DBP.BookingStartdateandTime(startmonth, date, hours, minutes);
		DBP.Click_BookACarbBtn();
	}
	@And("^Provide Departure month as \"([^\"]*)\" day as \"([^\"]*)\" hours as \"([^\"]*)\" minutes as \"([^\"]*)\" and click NEXT button$")
	public void provide_departure_month_as_something_day_as_something_hours_as_something_minutes_as_something_and_click_next_button(
			String startmonth, String date, String hours, String minutes) throws Throwable {

		DBP.BookingStartdateandTime(startmonth, date, hours, minutes);
	}

	@And("^Provide travel going to as \"([^\"]*)\" and Departure from as \"([^\"]*)\"$")
	public void provide_travel_going_to_as_something(String goingplace, String destinationplace) throws Throwable {
		DBP.enterGoingtoandDestination(goingplace, destinationplace);
		
	}

	@Then("^Verify CAR CATEGORY that suits is displayed as expected$")
	public void verify_car_category_that_suits_is_displayed_as_expected() throws Throwable {
		DBP.verifycarcategory();
	}
	@Then("^Verify CAR CATEGORY that suits is displayed as expected and click on forward$")
	public void verify_car_category_that_suits_is_displayed_as_expected_and_click_on_forward() throws Throwable {
		DBP.verifycarcategory();
		DBP.click_forwardButton();
	}
	

	@Then("^Select the Vehicle and Click on forward$")
	public void select_the_vehicle_and_click_on_forward() throws Throwable {
		DBP.clickVehicle_moveforward();
	}

	@And("^Provide the Booking reason and Confirm Booking$")
	public void provide_the_booking_reason_and_confirm_booking() throws Throwable {
		DBP.enterReason_confirmbooking();
	}

	@And("^Logout of Driver Account$")
	public void Logout_of_Driver_Account() throws Exception {
		DHPO.DLogout();
	}

	@And("^Validate Bad credentials error message displayed for wrong username$")
	public void validate_bad_credentials_error_message_displayed_for_wrong_username() throws Throwable {
		DLPO.Dloginfailure();
	}

	@And("^Validate Bad credentials error message displayed for wrong password$")
	public void validate_bad_credentials_error_message_displayed_for_wrong_password() throws Throwable {
		DLPO.Dloginfailure();
	}
	@Then("^Select Leave now option for MultiParking$")
    public void select_leave_now_option_for_multiparking() throws Throwable {
        DBP.OptforMultiparking();
    }
	@And("^Provide travel Departure as \"([^\"]*)\" and Going to as \"([^\"]*)\" and click NEXT button$")
    public void provide_travel_departure_as_something_and_click_next_button(String Departureplace,String GoingToplace) throws Throwable {
        DBP.selectTo_FROM_Multiparking(Departureplace,GoingToplace);
    }
	@And("^Select Private booking$")
	public void select_private_booking() throws Throwable {
	        DBP.Select_PrivatebookingOption();
	    }
	@Then("^Verify no vehicles are available during provided booking period$")
	public void verify_no_vehicles_are_available_during_provided_booking_period() throws Throwable {
	        DBP.verify_VehiclesNotAvailableMsg();
	    }

}
