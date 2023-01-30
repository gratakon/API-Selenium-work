package com.ALD_FM.pageObjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ALD.Base.BaseDriver;
import com.ALD.Commons.CommonUtilities;
import com.ALD_Driver.pageObjects.Driver_MyTripsPageObjs;

public class FM_FleetpageObjs extends BaseDriver {

	private static final Logger LOG = LogManager.getLogger(FM_FleetpageObjs.class);

	public CommonUtilities cm = new CommonUtilities(); 

	By FMFleet_multiparkinglabel = By.xpath("//th[contains(text(),'Multiparking')]");

	public WebElement getFMFleet_multiparkinglabel() {
		return driver.findElement(FMFleet_multiparkinglabel);
	}
	By FMSegment_dropdown = By.xpath("//select[@id='vehicle_filter_categoryId']");

	public WebElement getFMSegment_dropdown() {
		return driver.findElement(FMSegment_dropdown);
	}
	By FMMultiparking_checkbox = By.xpath("//input[@id='vehicle_driving_range_and_mileage_target_vehiclesData_0_multiParking']");

	public WebElement getFMMultiparking_checkbox() {
		return driver.findElement(FMMultiparking_checkbox);
	}
	By FMVehicle_filterBtn = By.xpath("//button[@id='vehicle_filter_submit']");

	public WebElement getFMVehicle_filterBtn() {
		return driver.findElement(FMVehicle_filterBtn);
	}
	By FMSaveButton = By.xpath("//button[@id='saveButton']");

	public WebElement getFMSaveButton() {
		return driver.findElement(FMSaveButton);
	}
	By FM_Confirm_multiparkingenableBtn = By.xpath("//a[@class='button']");

	public WebElement getFM_Confirm_multiparkingenableBtn() {
		return driver.findElement(FM_Confirm_multiparkingenableBtn);
	}
	By FM_RegistrationField = By.xpath("//input[@placeholder='Registration']");

	public WebElement getFM_RegistrationField() {
		return driver.findElement(FM_RegistrationField);
	}
	
	
	
	
	
	
	public void verifyMultiparkinglabelPresent() throws Exception
	{
		cm.verifyElementDisplayed(getFMFleet_multiparkinglabel());
		cm.HighlightElement(getFMFleet_multiparkinglabel());
		LOG.info("Multiparking Option is displayed on Fleet page");
	}
	public void verifyMultiparkinglabelNotPresent() throws Exception
	{
        cm.validateElementNotDisplayed(FMFleet_multiparkinglabel);
        LOG.info("Multiparking Option is not displayed on Fleet Page");

	}
	public void Search_SegmentDropdown_option(String Segmentname) throws Exception
	{
		cm.FluientWait(FMSegment_dropdown, 10,3);
		cm.jseClick(getFMSegment_dropdown());
		cm.wait(3);
		cm.selectDropdown(getFMSegment_dropdown(), Segmentname);
		LOG.info(Segmentname+" :: is selected from the Dropdown");
		cm.jseClick(getFMVehicle_filterBtn());
		cm.wait(3);
	}
	
	public void enable_multiparking_as_FM() throws Exception
	{
		cm.FluientWait(FMMultiparking_checkbox, 10,3);
		cm.scrollToview(getFMMultiparking_checkbox());
		String multiparkingcheck = getFMMultiparking_checkbox().getAttribute("checked");

		if (multiparkingcheck != null) {
			LOG.info("Fleet Multiparking option ENABLED ALREADY");
		} else {
			cm.jseClick(getFMMultiparking_checkbox());
			LOG.info("Fleet Multiparking option ENABLED NOW");
		}

		LOG.info("Fleet Multiparking option Changes are SAVED");
		cm.wait(2);
		cm.jseClick(getFMSaveButton());
		try {
			
			cm.FluientWait(FM_Confirm_multiparkingenableBtn, 10,3);
			cm.click(getFM_Confirm_multiparkingenableBtn());
			LOG.info("Clicked on Confirm button and Multiparking changes saved");	
		} catch (final Exception e) {
			
			e.printStackTrace();
			LOG.info("CONFIRM button is not needed to click and Multiparking changes saved");
		}
		
		LOG.info("Multiparking Enabled changes saved");	
		
	}
	public void disable_multiparking_as_FM() throws Exception
	{
		cm.FluientWait(FMMultiparking_checkbox, 10,3);
		cm.scrollToview(getFMMultiparking_checkbox());
		String multiparkingcheck = getFMMultiparking_checkbox().getAttribute("checked");

		if (multiparkingcheck == null) {
			LOG.info("Fleet Multiparking option DISABLED ALREADY");
		} else {
			cm.jseClick(getFMMultiparking_checkbox());
			LOG.info("Fleet Multiparking option DISABLED NOW");
		}

		LOG.info("Fleet Multiparking option Changes are SAVED");
		cm.wait(2);
		cm.jseClick(getFMSaveButton());
		try {
			
			cm.FluientWait(FM_Confirm_multiparkingenableBtn, 10,3);
			cm.jseClick(getFM_Confirm_multiparkingenableBtn());
			LOG.info("Clicked on Confirm button and Multiparking changes saved");	
		} catch (final Exception e) {
			
			e.printStackTrace();
			LOG.info("CONFIRM button is not needed to click and Multiparking changes saved");
		}
		
		LOG.info("Multiparking Disabled changes saved");	
		
	}
	public void Search_VehicleRegistrationnumber(String VehicleRegistrationNumber) throws Exception {
		cm.FluientWait(FM_RegistrationField, 10,3);
		cm.typeTextToTextBox(getFM_RegistrationField(), VehicleRegistrationNumber);
		cm.jseClick(getFMVehicle_filterBtn());
		LOG.info("Click on Filter button");
		List<WebElement> Searchresultscount = driver.findElements(By.xpath("//tbody/tr[@class='js-fleet-row']"));
		LOG.info("No. of search results displayed is : "+ Searchresultscount.size());
		
		List<WebElement> Searchresults = driver.findElements(By.xpath("//tbody/tr[@class='js-fleet-row']/td"));
		for(WebElement results : Searchresults)
			LOG.info(results.getText());
		cm.Scroll_PageEnd();
		
	}
	public void Search_VehicleRegistrationnumber_From_Mytripspage() throws Exception {
		
		cm.FluientWait(FM_RegistrationField, 10,3);
		cm.typeTextToTextBox(getFM_RegistrationField(), Driver_MyTripsPageObjs.newvehicleplatenumber);
		cm.jseClick(getFMVehicle_filterBtn());
		LOG.info("Click on Filter button");
		List<WebElement> Searchresultscount = driver.findElements(By.xpath("//tbody/tr[@class='js-fleet-row']"));
		LOG.info("No. of search results displayed is : "+ Searchresultscount.size());
		
		List<WebElement> Searchresults = driver.findElements(By.xpath("//tbody/tr[@class='js-fleet-row']/td"));
		for(WebElement results : Searchresults)
			LOG.info(results.getText());
		cm.Scroll_PageEnd();
		
	}
	public void Verify_MultiparkingCheckBox_Disabled()
	{
		cm.FluientWait(FMMultiparking_checkbox, 10,3);
		cm.scrollToview(getFMMultiparking_checkbox());
		String multiparkingcheck = getFMMultiparking_checkbox().getAttribute("disabled");
		System.out.println(multiparkingcheck);

		if (multiparkingcheck != null) {
			LOG.info("Fleet Multiparking option DISABLED because of the Scheduled trip booking");
		} else {
			
			LOG.info("Fleet Multiparking option should be disabled but is not DISABLED");
		}
	}
	
	
}
