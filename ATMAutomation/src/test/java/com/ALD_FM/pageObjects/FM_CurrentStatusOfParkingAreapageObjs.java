package com.ALD_FM.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ALD.Base.BaseDriver;
import com.ALD.Commons.CommonUtilities;

public class FM_CurrentStatusOfParkingAreapageObjs extends BaseDriver {

	private static final Logger LOG = LogManager.getLogger(FM_CurrentStatusOfParkingAreapageObjs.class);

	public CommonUtilities cm = new CommonUtilities();

	By FM_VehiclesTransitTab = By.xpath("//strong[contains(text(),'in transit')]");

	public WebElement getFM_VehiclesTransitTab() {
		return driver.findElement(FM_VehiclesTransitTab);
	}
	By FM_VehiclesInParkingAreaTab = By.xpath("//strong[contains(text(),'in parking areas')]");

	public WebElement getFM_VehiclesInParkingAreaTab() {
		return driver.findElement(FM_VehiclesInParkingAreaTab);
	}
	By FM_VehiclesUnderMaintenanceTab = By.xpath("//strong[contains(text(),'undergoing maintenance')]");

	public WebElement getFM_VehiclesUnderMaintenanceTab() {
		return driver.findElement(FM_VehiclesUnderMaintenanceTab);
	}
	By FM_Filterbutton = By.xpath("//span[@class='icomoon aldicon-ald-monitoring-outline monitoring__filter__launch__icon']");

	public WebElement getFM_Filterbutton() {
		return driver.findElement(FM_Filterbutton);
	}
	By FM_ApplyFilterbutton = By.xpath("//button[contains(text(),'Apply Filters')]");

	public WebElement getFM_ApplyFilterbutton() {
		return driver.findElement(FM_ApplyFilterbutton);
	}
	By FM_ServiceTypeDropdown = By.xpath("(//div[@class='monitoring__filter-content__form']/select)[1]");

	public WebElement getFM_ServiceTypeDropdown() {
		return driver.findElement(FM_ServiceTypeDropdown);
	}
	By FM_SegmentType_Convertible_checkbox = By.xpath("//input[@id='checkboxid-Convertible']");

	public WebElement getFM_SegmentType_Convertible_checkbox() {
		return driver.findElement(FM_SegmentType_Convertible_checkbox);
	}
	By FM_SegmentType_Premium_checkbox = By.xpath("//input[@id='checkboxid-Premium station wagon']");

	public WebElement getFM_SegmentType_Premium_checkbox() {
		return driver.findElement(FM_SegmentType_Premium_checkbox);
	}
	By FM_ParkingAreaDropdown = By.xpath("(//div[@class='monitoring__filter-content__form']/select)[2]");

	public WebElement getFM_ParkingAreaDropdown() {
		return driver.findElement(FM_ParkingAreaDropdown);
	}
	By FM_TripTypeCheckbox = By.xpath("//input[@id='business']");

	public WebElement getFM_TripTypeCheckbox() {
		return driver.findElement(FM_TripTypeCheckbox);
	}
	
	
	
	public void click_FM_VehiclesTransitTab() throws Exception
	{
		cm.FluientWait(FM_VehiclesTransitTab, 10,3);
		cm.HighlightElement(getFM_VehiclesTransitTab());
		cm.jseClick(getFM_VehiclesTransitTab());
		LOG.info("Clicked on VEHICLE TRANSIT tab");
	}
	
	public void click_FM_VehiclesInParkingAreaTab() throws Exception
	{
		cm.FluientWait(FM_VehiclesInParkingAreaTab, 10,3);
		cm.HighlightElement(getFM_VehiclesInParkingAreaTab());
		cm.jseClick(getFM_VehiclesInParkingAreaTab());
		LOG.info("Clicked on VEHICLE IN PARKING AREA tab");
		
	}
	
	public void click_FM_VehiclesUnderMaintenanceTab() throws Exception
	{
		cm.FluientWait(FM_VehiclesUnderMaintenanceTab, 10,3);
		cm.HighlightElement(getFM_VehiclesUnderMaintenanceTab());
		cm.jseClick(getFM_VehiclesUnderMaintenanceTab());
		LOG.info("Clicked on VEHICLE UNDER MAINTENANCE tab");
		
	}
	
	public void click_FM_Filterbutton() throws Exception
	{
		cm.FluientWait(FM_Filterbutton, 10,3);
		cm.HighlightElement(getFM_Filterbutton());
		cm.jseClick(getFM_Filterbutton());
		LOG.info("Clicked on Filter button");
	}
	
	public void click_FM_ApplyFilterbutton() throws Exception
	{
		cm.FluientWait(FM_ApplyFilterbutton, 10,3);
		cm.scrollToview(getFM_ApplyFilterbutton());
		cm.HighlightElement(getFM_ApplyFilterbutton());
		cm.wait(3);
		cm.jseClick(getFM_ApplyFilterbutton());
		LOG.info("Clicked on Apply Filter button");
		cm.movepageup();
		
	}
	public void Select_ServicetypeDropdown() throws Exception
	{
		cm.jseClick(getFM_ServiceTypeDropdown());
		cm.wait(3);
		cm.selectDropDown_text(getFM_ServiceTypeDropdown(), "Multipark");
		cm.wait(3);
		LOG.info("Service Type dropdown selected");
	}
	
	public void Click_VehicleSegment_Checkbox() throws Exception
	{
		cm.FluientWait(FM_SegmentType_Convertible_checkbox, 10,3);
		cm.HighlightElement(getFM_SegmentType_Convertible_checkbox());
		cm.jseClick(getFM_SegmentType_Convertible_checkbox());
		cm.wait(3);
		LOG.info("Clicked on CONVERTIBLE checkbox under VEHICLE SEGMENT");
		cm.HighlightElement(getFM_SegmentType_Premium_checkbox());
		cm.jseClick(getFM_SegmentType_Premium_checkbox());
		LOG.info("Clicked on PREMIUM checkbox under VEHICLE SEGMENT");
	}
	public void Select_ParkingAreaDropdown() throws Exception
	{
		cm.FluientWait(FM_ParkingAreaDropdown, 10,3);
		cm.scrollToview(getFM_ParkingAreaDropdown());
		cm.jseClick(getFM_ParkingAreaDropdown());
		cm.wait(2);
		cm.selectDropDown_text(getFM_ParkingAreaDropdown(), "RM, Roma, Viale Luca Gaurico 187");
		LOG.info("Vehicle Parking Drop down selected");
	}
	
	public void Click_TripTypeCheckbox() throws Exception
	{
		cm.FluientWait(FM_TripTypeCheckbox, 10,3);
		cm.scrollToview(getFM_TripTypeCheckbox());
		cm.jseClick(getFM_TripTypeCheckbox());
		LOG.info("Clicked on Trip Type checkbox for business");
		
	}
	
	

}
