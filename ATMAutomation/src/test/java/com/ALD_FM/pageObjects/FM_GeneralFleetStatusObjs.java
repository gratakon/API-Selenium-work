package com.ALD_FM.pageObjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ALD.Base.BaseDriver;
import com.ALD.Commons.CommonUtilities;

public class FM_GeneralFleetStatusObjs extends BaseDriver {

	private static final Logger LOG = LogManager.getLogger(FM_GeneralFleetStatusObjs.class);

	public CommonUtilities cm = new CommonUtilities();

	By FM_VehicleplateField = By.xpath("//input[@id='vehicles_filter_plateOrBrand']");

	public WebElement getFM_VehicleplateField() {
		return driver.findElement(FM_VehicleplateField);
	}
	By FM_VehicleParkingDropdown = By.xpath("//select[@id='vehicles_filter_homeParking']");

	public WebElement getFM_VehicleParkingDropdown() {
		return driver.findElement(FM_VehicleParkingDropdown);
	}
	By FM_VehicleFilterBtn = By.xpath("//button[@id='vehicles_filter_submit']");

	public WebElement getFM_VehicleFilterBtn() {
		return driver.findElement(FM_VehicleFilterBtn);
	}
	By FM_VehicleMaintainceDayNumber= By.xpath("//span[@class='day-number']");

	public WebElement getFM_VehicleMaintainceDayNumber() {
		return driver.findElement(FM_VehicleMaintainceDayNumber);
	}
	By FM_DaysTableHeader= By.xpath("(//table[@class='days-container']/tbody/tr)[1]");

	public WebElement getFM_DaysTableHeader() {
		return driver.findElement(FM_DaysTableHeader);
	}
	
	
	
	public void Select_VehicleParkingDropdown(String VehicleParkingLocation) throws Exception
	{
		cm.jseClick(getFM_VehicleParkingDropdown());
		cm.wait(2);
		cm.selectDropDown_text(getFM_VehicleParkingDropdown(), VehicleParkingLocation);
		LOG.info("Vehicle Parking Dropdown Selected");
	}
	public void Enter_vehicleplateNumber(String VehicleNumber) throws Exception {
		cm.typeTextToTextBox(getFM_VehicleplateField(), VehicleNumber);
		LOG.info("Vehicel numner entered for search");
	}
	public void Click_SearchVehicleBtn() throws Exception
	{
		cm.HighlightElement(getFM_VehicleFilterBtn());
		cm.jseClick(getFM_VehicleFilterBtn());
		LOG.info("Clicked on Filter button to search for Vehicles");
		search_vehicle();
	}
	public void search_vehicle() throws Exception {
		
		cm.wait(3);
		List<WebElement> Searchresultscount = driver.findElements(By.xpath("//tbody/tr[@class='car-row']"));
		LOG.info("No. of search results displayed is : "+ Searchresultscount.size());
		
		List<WebElement> Searchresults = driver.findElements(By.xpath("//tbody/tr[@class='car-row']/td"));
		for(WebElement results : Searchresults)
			LOG.info(results.getText());	
	}
	public void Click_VehicleMaintainceDayNumber_view_Popup_vehiclename() throws Exception
	{
		cm.FluientWait(FM_VehicleMaintainceDayNumber, 20,3);
		cm.HighlightElement(getFM_VehicleMaintainceDayNumber());
		cm.jseClick(getFM_VehicleMaintainceDayNumber());
		LOG.info("Clicked on Vehicle Maintaince Day Number RED button");
		cm.wait(3);
		List<WebElement> Searchresults = driver.findElements(By.xpath("//table[@class='features']/tbody/tr/td"));
		for(WebElement results : Searchresults)
			LOG.info(results.getText());
		List<WebElement> Referenceperiod = driver.findElements(By.xpath("//td[@class='content-right maintenance']/div"));
		for(WebElement Referencetexts : Referenceperiod)
			LOG.info(Referencetexts.getText());
	}
	public void Scroll_down_to_pageBottom() {
		cm.Scroll_PageEnd();
		LOG.info("Scroll till page end ");
	}
	public void Verify_tableHeader_visible() throws InterruptedException
	{
		cm.FluientWait(FM_DaysTableHeader, 5,1);
		cm.HighlightElement(getFM_DaysTableHeader());
		LOG.info("The header of the table containing the days of the week is always visible at the top of the window");
	}
	public void verify_AllParkingDropdown_AlphabeticOrder() throws Exception {
		cm.jseClick(getFM_VehicleParkingDropdown());
		LOG.info("Clicked on All Vehicle parking Dropdown");
		cm.Print_AllDropdownValues(FM_VehicleParkingDropdown);
		cm.verify_DropdownValues_alphabeticorder(FM_VehicleParkingDropdown);
	}
	
}
