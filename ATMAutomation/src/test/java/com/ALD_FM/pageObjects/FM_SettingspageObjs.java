package com.ALD_FM.pageObjects;

import java.util.List;

import javax.swing.text.Highlighter.Highlight;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ALD.Base.BaseDriver;
import com.ALD.Commons.CommonUtilities;

public class FM_SettingspageObjs extends BaseDriver {

	private static final Logger LOG = LogManager.getLogger(FM_SettingspageObjs.class);

	public CommonUtilities cm = new CommonUtilities();

	By FM_GeneralTab = By.xpath("//dd[contains(@class,'active')]//a[contains(text(),'General')]");

	public WebElement getFM_GeneralTab() {
		return driver.findElement(FM_GeneralTab);
	}

	By FM_chargepercentage = By.xpath("//select[@id='settings_bookingRechargePercentageMinLimit']");

	public WebElement getFM_chargepercentage() {
		return driver.findElement(FM_chargepercentage);
	}

	By FM_MaintainceHoursfield = By.xpath("//input[@id='settings_lowBatteryMaintenanceHours']");

	public WebElement getFM_MaintainceHoursfield() {
		return driver.findElement(FM_MaintainceHoursfield);
	}

	By FM_SaveMaintainceChanges = By.xpath("//button[contains(@name,'action')]");

	public WebElement getFM_SaveMaintainceChanges() {
		return driver.findElement(FM_SaveMaintainceChanges);
	}

	By FM_changesSucessmsg = By.xpath("//div[contains(@class,'alert-box info')]");

	public WebElement getFM_changesSucessmsg() {
		return driver.findElement(FM_changesSucessmsg);
	}
	By FM_CarpoolingTab = By.xpath("//a[contains(text(),'Car Pooling')]");

	public WebElement getFM_CarpoolingTab() {
		return driver.findElement(FM_CarpoolingTab);
	}
	By FM_AlertManagementTab = By.xpath("//a[contains(text(),'Alert management')]");

	public WebElement getFM_AlertManagementTab() {
		return driver.findElement(FM_AlertManagementTab);
	}
	By FM_FleetLocationAlert_Checkbox = By.xpath("//input[@id='overfilled_parking_notifications_overfilledParkingNotifications_0_status']");
	
    public WebElement getFM_FleetLocationAlert_Checkbox() {
		return driver.findElement(FM_FleetLocationAlert_Checkbox);
	}
	By FM_FleetLocationAlert_Dropdown = By.xpath("//select[@id='overfilled_parking_notifications_overfilledParkingNotifications_0_value']");
	    
	public WebElement getFM_FleetLocationAlert_Dropdown() {
		return driver.findElement(FM_FleetLocationAlert_Dropdown);
	}
	By FM_FleetLocationAlert_emailfield = By.xpath("//textarea[@id='overfilled_parking_notifications_overfilledParkingNotifications_0_recipient']");
    
	public WebElement getFM_FleetLocationAlert_emailfield() {
		return driver.findElement(FM_FleetLocationAlert_emailfield);
	}
    By FM_FleetLocationAlert_SaveBtn = By.xpath("//button[@id='overfilled_parking_notifications_submit']");
    
	public WebElement getFM_FleetLocationAlert_SaveBtn() {
		return driver.findElement(FM_FleetLocationAlert_SaveBtn);
	}
    By FM_EmptyParkingAlert_Checkbox = By.xpath("//input[@id='underfilled_parking_notifications_underfilledParkingNotifications_0_status']");
	
    public WebElement getFM_EmptyParkingAlert_Checkbox() {
		return driver.findElement(FM_EmptyParkingAlert_Checkbox);
	}
	By FM_EmptyParkingAlert_Dropdown = By.xpath("//select[@id='underfilled_parking_notifications_underfilledParkingNotifications_0_value']");
	    
	public WebElement getFM_EmptyParkingAlert_Dropdown() {
		return driver.findElement(FM_EmptyParkingAlert_Dropdown);
	}
	By FM_EmptyParkingAlert_emailfield = By.xpath("//textarea[@id='underfilled_parking_notifications_underfilledParkingNotifications_0_recipient']");
    
	public WebElement getFM_EmptyParkingAlert_emailfield() {
		return driver.findElement(FM_EmptyParkingAlert_emailfield);
	}
    By FM_EmptyParkingAlert_SaveBtn = By.xpath("//button[@id='underfilled_parking_notifications_submit']");
    
	public WebElement getFM_EmptyParkingAlert_SaveBtn() {
		return driver.findElement(FM_EmptyParkingAlert_SaveBtn);
	}
    By FM_UnusedVehicleAlert_Checkbox = By.xpath("//input[@id='stopped_vehicle_notifications_stoppedVehicleNotifications_0_status']");
	
    public WebElement getFM_UnusedVehicleAlert_Checkbox() {
		return driver.findElement(FM_UnusedVehicleAlert_Checkbox);
	}
	By FM_UnusedVehicleAlert_Dropdown = By.xpath("//select[@id='stopped_vehicle_notifications_stoppedVehicleNotifications_0_value']");
	    
	public WebElement getFM_UnusedVehicleAlert_Dropdown() {
		return driver.findElement(FM_UnusedVehicleAlert_Dropdown);
	}
	By FM_UnusedVehicleAlert_emailfield = By.xpath("//textarea[@id='stopped_vehicle_notifications_stoppedVehicleNotifications_0_recipient']");
    
	public WebElement getFM_UnusedVehicleAlert_emailfield() {
		return driver.findElement(FM_UnusedVehicleAlert_emailfield);
	}
    By FM_UnusedVehicleAlert_SaveBtn = By.xpath("//button[@id='stopped_vehicle_notifications_submit']");
    
	public WebElement getFM_UnusedVehicleAlert_SaveBtn() {
		return driver.findElement(FM_UnusedVehicleAlert_SaveBtn);
	}
    By FM_EmailMandatory_ErrorMsg = By.xpath("//li[contains(text(),'This value should not be blank.')]");
    
	public WebElement getFM_EmailMandatory_ErrorMsg() {
		return driver.findElement(FM_EmailMandatory_ErrorMsg);
	}
    By FM_Alertchanges_SuccessMsg = By.xpath("//div[contains(text(),'The changes are saved')]");
    
	public WebElement getFM_Alertchanges_SuccessMsg() {
		return driver.findElement(FM_Alertchanges_SuccessMsg);
	}
    By FM_AnalyticsTab = By.xpath("//dd/a[contains(text(),'Analytics')]");
    
	public WebElement getFM_AnalyticsTab() {
		return driver.findElement(FM_AnalyticsTab);
	}
    By FM_Analytics_parking_productivityField = By.xpath("//input[@id='analytics_settings_parking_productivity']");
    
	public WebElement getFM_Analytics_parking_productivityField() {
		return driver.findElement(FM_Analytics_parking_productivityField);
	}
	By FM_Analytics_parking_unavailabilityField = By.xpath("//input[@id='analytics_settings_parking_unavailability']");
	    
	public WebElement getFM_Analytics_parking_unavailabilityField() {
		return driver.findElement(FM_Analytics_parking_unavailabilityField);
	}
	By FM_Analytics_parking_AverageTraveltimeLimitfield = By.xpath("//input[@id='analytics_settings_parking_trips']");
    
	public WebElement getFM_Analytics_parking_AverageTraveltimeLimitfield() {
		return driver.findElement(FM_Analytics_parking_AverageTraveltimeLimitfield);
	}
    By FM_Analytics_parking_Performancefield = By.xpath("//input[@id='analytics_settings_parking_performance']");
    
	public WebElement getFM_Analytics_parking_Performancefield() {
		return driver.findElement(FM_Analytics_parking_Performancefield);
	}
    By FM_AllowEndTrip = By.xpath("//input[@id='settings_endTripWithoutKeyCheck']");
    
	public WebElement getFM_AllowEndTrip() {
		return driver.findElement(FM_AllowEndTrip);
	}
	
	
    
	
	
	
		
	public void updateMaintainceChanges(String chargepercentage, String Maintaincehours) throws Exception {
		cm.HighlightElement(getFM_GeneralTab());
		cm.FluientWait(FM_chargepercentage, 20,3);
		cm.jseClick(getFM_chargepercentage());
		cm.selectDropdown(getFM_chargepercentage(), chargepercentage);
		LOG.info("The charge percentage is select for the vehicel");
		cm.scrollToview(getFM_MaintainceHoursfield());
		cm.typeTextToTextBox(getFM_MaintainceHoursfield(), Maintaincehours);
		LOG.info("Duration, in hours, of the maintenance for vehicles provided");
		cm.jseClick(getFM_SaveMaintainceChanges());
		LOG.info("Electric Vehicle charging details updated and Changes saved");
		cm.FluientWait(FM_changesSucessmsg, 20,3);
		cm.HighlightElement(getFM_changesSucessmsg());
		LOG.info("Electric Vehicle maintaince changes saved Message displayed sucesfully");

	}
	
	public void verify_CarpoolingTab_notDisplayed() throws Exception
	{
		cm.validateElementNotDisplayed(FM_CarpoolingTab);
		LOG.info("Car pooling tab is NOT DISPLAYED for FM on Seetings page");
	}
	public void verify_CarpoolingTab_Displayed() throws Exception
	{
		cm.validateElementDisplayed(getFM_CarpoolingTab());
		cm.HighlightElement(getFM_CarpoolingTab());
		LOG.info("Car pooling tab is DISPLAYED for FM on Seetings page");
	}
	public void click_AlertManagementTab() throws Exception
	{
		cm.FluientWait(FM_AlertManagementTab, 10,3);
		cm.HighlightElement(getFM_AlertManagementTab());
		cm.jseClick(getFM_AlertManagementTab());
		LOG.info("Clicked on ALERT MANAGEMENT Tab");
	}
	public void click_FleetlocationAlert_checkbox_enable() throws Exception
	{
		String Fleetlocationalertvalue =driver.findElement(FM_FleetLocationAlert_Checkbox).getAttribute("checked");
		
		if(Fleetlocationalertvalue != null)
		{
			LOG.info("Fleet Location Alert checkbox is Enabled ALREADY");
			
		}
		else 
		{
			cm.jseClick(getFM_FleetLocationAlert_Checkbox());
			LOG.info("Fleet Location Alert checkbox is checked and Enabled");
		}
	}
	public void click_EmptyParkingAlert_checkbox_enable() throws Exception
	{
		String EmptyParkingAlertvalue =driver.findElement(FM_EmptyParkingAlert_Checkbox).getAttribute("checked");
		
		if(EmptyParkingAlertvalue != null)
		{
			LOG.info("Empty Parking Alert checkbox is Enabled ALREADY");
			
		}
		else 
		{
			cm.jseClick(getFM_FleetLocationAlert_Checkbox());
			LOG.info("Empty Parking Alert checkbox is checked and Enabled");
		}
	}
	public void click_UnusedVehicleAlert_checkbox_enable() throws Exception
	{
		String UnusedVehicleAlertvalue =driver.findElement(FM_UnusedVehicleAlert_Checkbox).getAttribute("checked");
		
		if(UnusedVehicleAlertvalue != null)
		{
			LOG.info("Unused Vehicle Alert checkbox is Enabled ALREADY");
			
		}
		else 
		{
			cm.jseClick(getFM_FleetLocationAlert_Checkbox());
			LOG.info("Unused Vehicle Alert checkbox is checked and Enabled");
		}
	}
	public void Select_FleetlocationAlert_Dropdown() throws Exception
	{
		cm.scrollToview(getFM_FleetLocationAlert_Dropdown());
		cm.jseClick(getFM_FleetLocationAlert_Dropdown());
		cm.selectDropDown_text(getFM_FleetLocationAlert_Dropdown(), "1");
		LOG.info("Fleet Location Alert dropdown selected");
	}
	public void Select_EmptyParkingAlert_Dropdown() throws Exception
	{
		cm.scrollToview(getFM_EmptyParkingAlert_Dropdown());
		cm.jseClick(getFM_EmptyParkingAlert_Dropdown());
		cm.selectDropDown_text(getFM_EmptyParkingAlert_Dropdown(), "1");
		LOG.info("Empty Parking Alert dropdown selected");
	}
	public void Select_UnusedVehicleAlert_Dropdown() throws Exception
	{
		cm.scrollToview(getFM_UnusedVehicleAlert_Dropdown());
		cm.jseClick(getFM_EmptyParkingAlert_Dropdown());
		cm.selectDropDown_text(getFM_EmptyParkingAlert_Dropdown(), "1");
		LOG.info("Unused Vehicle Alert dropdown selected");
	}
	
	public void Clear_FleetlocationAlert_Emailfield() throws Exception 
	{
		cm.clearText(getFM_FleetLocationAlert_emailfield());
	}
	public void Clear_EmptyParkingAlert_Emailfield() throws Exception
	{
		cm.clearText(getFM_EmptyParkingAlert_emailfield());
	}
	public void Clear_UnusedVehicleAlert_Emailfield() throws Exception
	{
		cm.clearText(getFM_UnusedVehicleAlert_emailfield());
	}
	public void Enter_FleetlocationAlert_Emailfield() throws Exception 
	{
		cm.clearText(getFM_FleetLocationAlert_emailfield());
		cm.typeTextToTextBox(getFM_FleetLocationAlert_emailfield(), "guru.ratakonda@socgen.com");
		LOG.info("Email entered in the Fleet location Alert Email field");
	}
	public void Enter_EmptyParkingAlert_Emailfield() throws Exception
	{
		cm.clearText(getFM_EmptyParkingAlert_emailfield());
		cm.typeTextToTextBox(getFM_EmptyParkingAlert_emailfield(), "guru.ratakonda@socgen.com");
		LOG.info("Email entered in the Empty location Alert Email field");
	}
	public void Enter_UnusedVehicleAlert_Emailfield() throws Exception
	{
		cm.clearText(getFM_UnusedVehicleAlert_emailfield());
		cm.typeTextToTextBox(getFM_UnusedVehicleAlert_emailfield(), "guru.ratakonda@socgen.com");
		LOG.info("Email entered in the Unused Vehicle Alert Email field");
	}
	public void Click_FleetlocationAlert_SaveBtn() throws Exception
	{
		cm.FluientWait(FM_FleetLocationAlert_SaveBtn, 10,3);
		cm.jseClick(getFM_FleetLocationAlert_SaveBtn());
		LOG.info("Clicked on SAVE button for Fleet Location Alert");
	}
	
	public void Click_EmptyParkingAlert_SaveBtn() throws Exception
	{
		cm.FluientWait(FM_EmptyParkingAlert_SaveBtn, 10,3);
		cm.jseClick(getFM_EmptyParkingAlert_SaveBtn());
		LOG.info("Clicked on SAVE button for Empty Parking Alert");
		
	}
	public void Click_UnusedVehicleAlert_SaveBtn() throws Exception
	{
		cm.FluientWait(FM_UnusedVehicleAlert_SaveBtn, 10,3);
		cm.jseClick(getFM_UnusedVehicleAlert_SaveBtn());
		LOG.info("Clicked on SAVE button for Unsed Vehicle Alert");
		
	}
	public void Verify_EmailMandatory_ErrorMsg_displayed() throws Exception
	{
		cm.FluientWait(FM_EmailMandatory_ErrorMsg, 10,3);
		cm.validateElementDisplayed(getFM_EmailMandatory_ErrorMsg());
		cm.scrollToview(getFM_EmailMandatory_ErrorMsg());
		cm.HighlightElement(getFM_EmailMandatory_ErrorMsg());
		LOG.info(getFM_EmailMandatory_ErrorMsg().getText()+" ERROR MESSAGE DISPLAYED");
	}
	public void Verify_AlertChanges_SuccessMsg_displayed() throws Exception
	{
		cm.FluientWait(FM_Alertchanges_SuccessMsg, 10,3);
		cm.validateElementDisplayed(getFM_Alertchanges_SuccessMsg());
		cm.HighlightElement(getFM_Alertchanges_SuccessMsg());
		LOG.info(getFM_Alertchanges_SuccessMsg().getText()+" SUCCESS MESSAGE DISPLAYED");
	}
	public void Click_AnalyticsTab() throws Exception
	{
		cm.FluientWait(FM_AnalyticsTab, 10,3);
		cm.HighlightElement(getFM_AnalyticsTab());
		cm.jseClick(getFM_AnalyticsTab());
		LOG.info("Clicke on Analytics Tab");
	}
	public void Provide_values_Analyticsfield() throws Exception
	{
		cm.jseTypeText(getFM_Analytics_parking_productivityField(), "100");
		cm.typeTextToTextBox(getFM_Analytics_parking_unavailabilityField(), "100");
		cm.typeTextToTextBox(getFM_Analytics_parking_AverageTraveltimeLimitfield(), "100");
		cm.typeTextToTextBox(getFM_Analytics_parking_Performancefield(), "100");
		cm.HighlightElement(getFM_SaveMaintainceChanges());
		cm.click(getFM_SaveMaintainceChanges());
	}
	public void Provide_Stringvalues_Analyticsfield() throws Exception
	{
		cm.jseTypeText(getFM_Analytics_parking_productivityField(), "abc");
		cm.typeTextToTextBox(getFM_Analytics_parking_unavailabilityField(), "def");
		cm.typeTextToTextBox(getFM_Analytics_parking_AverageTraveltimeLimitfield(), "ghi");
		cm.typeTextToTextBox(getFM_Analytics_parking_Performancefield(), "jkl");
		cm.HighlightElement(getFM_SaveMaintainceChanges());
		cm.click(getFM_SaveMaintainceChanges());
	}
	public void Verify_AnalyticsStringvalue_ErrorMessages_Displayed()
	{
		List<WebElement> Errormsgslist = driver.findElements(By.xpath("//li[contains(text(),'This value is not valid.')]"));
		int Errormsgscount = Errormsgslist.size();
		System.out.println(Errormsgscount);
		for(int i=0;i<Errormsgscount;i++)
		{
			cm.HighlightElement(Errormsgslist.get(i));
			
		}
		
	}
	public void Verify_AllowEndTripOption_Disabled() throws Exception
	{
		cm.scrollToview(getFM_AllowEndTrip());
		cm.validateElementisDisable(getFM_AllowEndTrip());
	}
	
	

	
	
}
