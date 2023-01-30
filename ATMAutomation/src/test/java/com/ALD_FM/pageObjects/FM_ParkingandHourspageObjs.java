package com.ALD_FM.pageObjects;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ALD.Base.BaseDriver;
import com.ALD.Commons.CommonUtilities;

public class FM_ParkingandHourspageObjs extends BaseDriver {

	private static final Logger LOG = LogManager.getLogger(FM_ParkingandHourspageObjs.class);

	public CommonUtilities cm = new CommonUtilities();

	By FMParkingandHours_multiparkinglabel = By.xpath("//a[contains(text(),'Hub parking areas')]");

	public WebElement getFMParkingandHours_multiparkinglabel() {
		return driver.findElement(FMParkingandHours_multiparkinglabel);
	}

	By FM_AddParkingBtn = By.xpath("//a[@class='button no-margin js-add-group']");

	public WebElement getFM_AddParkingBtn() {
		return driver.findElement(FM_AddParkingBtn);
	}

	By FM_SelectParkingDescriptionfield = By.xpath("//input[@id='parkings_parkings_8_description']");

	public WebElement getFM_SelectParkingDescriptionfield() {
		return driver.findElement(FM_SelectParkingDescriptionfield);
	}

	By FM_SelectParkingRadius = By.xpath("//select[@id='parkings_parkings_8_geoFenceRadius']");

	public WebElement getFM_SelectParkingRadius() {
		return driver.findElement(FM_SelectParkingRadius);
	}

	By FM_SelectParkingOffice = By.xpath("//select[@id='parkings_parkings_8_office']");

	public WebElement getFM_SelectParkingOffice() {
		return driver.findElement(FM_SelectParkingOffice);
	}

	By FM_SavechangesBtn = By.xpath("//span[@class='ico-cs-salva-modifiche']");

	public WebElement getFM_SavechangesBtn() {
		return driver.findElement(FM_SavechangesBtn);
	}

	By FM_AddParkingCancelBtn = By.xpath("//div[@id='parking-group-8']//a[1]");

	public WebElement getFM_AddParkingCancelBtn() {
		return driver.findElement(FM_AddParkingCancelBtn);
	}

	By FM_CancelAddSchedule = By.xpath("//a[contains(@class,'button close white-bordered')]");

	public WebElement getFM_CancelAddSchedule() {
		return driver.findElement(FM_CancelAddSchedule);
	}

	By FM_AddScheduleSaveChangesBtn = By.xpath("//button[contains(@name,'action')]");

	public WebElement getFM_AddScheduleSaveChangesBtn() {
		return driver.findElement(FM_AddScheduleSaveChangesBtn);
	}
	By FM_GetParkingDataTab = By.xpath("//a[@class='button white-bordered mb-0']");

	public WebElement getFM_GetParkingDataTab() {
		return driver.findElement(FM_GetParkingDataTab);
	}
	By FM_SearchParkingAddressfield = By.xpath("//input[@id='parking_filter_address']");

	public WebElement getFM_SearchParkingAddressfield() {
		return driver.findElement(FM_SearchParkingAddressfield);
	}
	By FM_FilterParkingAddressBtn = By.xpath("//button[@id='parking_filter_submitFilter']");

	public WebElement getFM_FilterParkingAddressBtn() {
		return driver.findElement(FM_FilterParkingAddressBtn);
	}
	By FM_SearchResultParkingAddress = By.xpath("//input[@id='parkings_parkings_0_description']");

	public WebElement getFM_SearchResultParkingAddress() {
		return driver.findElement(FM_SearchResultParkingAddress);
	}
	By FM_RemoveparkingBtn = By.xpath("//div[contains(@class,'columns columns--vertical-center medium-1 text-center js-equal-col-parking-1 relative')]//a[1]");

	public WebElement getFM_RemoveparkingBtn() {
		return driver.findElement(FM_RemoveparkingBtn);
	}
	By FM_AssociatedVehiclepopupMSg = By.xpath("//div[contains(@class,'content text-center pb-30')]");

	public WebElement getFM_AssociatedVehiclepopupMSg() {
		return driver.findElement(FM_AssociatedVehiclepopupMSg);
	}
	By FM_DeleteBadgesRadiobtn = By.xpath("//input[@id='badge_associated_action_0']");

	public WebElement getFM_DeleteBadgesRadiobtn() {
		return driver.findElement(FM_DeleteBadgesRadiobtn);
	}
	By FM_AssignAnotherParkingRadiobtn = By.xpath("//input[@id='badge_associated_action_1']");

	public WebElement getFM_AssignAnotherParkingRadiobtn() {
		return driver.findElement(FM_AssignAnotherParkingRadiobtn);
	}
	By FM_CancelDeleteParkingbtn = By.xpath("//span[@class='button js-overlayer-embed-close white-bordered']");

	public WebElement getFM_CancelDeleteParkingbtn() {
		return driver.findElement(FM_CancelDeleteParkingbtn);
	}
	By FM_SelectReassignParkingdropdown = By.xpath("//select[@id='badge_associated_parking']");

	public WebElement getFM_SelectReassignParkingdropdown() {
		return driver.findElement(FM_SelectReassignParkingdropdown);
	}
	By FM_ConfirmReassignmentBtn = By.xpath("//a[@class='button js-cta-badge-reassign']");

	public WebElement getFM_ConfirmReassignmentBtn() {
		return driver.findElement(FM_ConfirmReassignmentBtn);
	}
	By FM_ConfirmParkingSpaceDeleteBtn = By.xpath("//a[@class='button mb-0 mr-10']");

	public WebElement getFM_ConfirmParkingSpaceDeleteBtn() {
		return driver.findElement(FM_ConfirmParkingSpaceDeleteBtn);
	}
	
	
	
	
	public void verifyHUBPARKINGtabpresent() throws Exception {
		cm.FluientWait(FMParkingandHours_multiparkinglabel, 20,3);
		cm.verifyElementDisplayed(getFMParkingandHours_multiparkinglabel());
		cm.jseClick(getFMParkingandHours_multiparkinglabel());
		cm.HighlightElement(getFMParkingandHours_multiparkinglabel());
		LOG.info("HUB-Multi PARKING link is displayed on PARKING and HOURS page ");
	}

	public void verifyHUBPARKINGtabNOTpresent() throws Exception {
		cm.validateElementNotDisplayed(FMParkingandHours_multiparkinglabel);
		LOG.info("HUB-Multi PARKING link is NOT displayed on PARKING and HOURS page");
	}

	public void Click_Add_newparking() throws Exception {
		cm.jseClick(getFM_AddParkingBtn());
		LOG.info("Clicked on New Parking Button");
	}

	public void click_Cancel_Add_newparking() throws Exception {
		cm.jseClick(getFM_AddParkingCancelBtn());
		LOG.info("Clicked on Cancel button for adding a new parking");
	}

	public void Enter_newParkingDetails() throws Exception {
		cm.typeTextToTextBox(getFM_SelectParkingDescriptionfield(),
				"Rome Metropolitan Guesthouse, Via Milazzo, Rome, Metropolitan City of Rome, Italy");
		cm.wait(4);
		Robot robo = new Robot();
		robo.keyPress(KeyEvent.VK_DOWN);
		robo.keyRelease(KeyEvent.VK_DOWN);
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);
		cm.clickElement(getFM_SelectParkingRadius());
		cm.wait(2);
		cm.selectDropDown_text(getFM_SelectParkingRadius(), "600 M");
		cm.clickElement(getFM_SelectParkingOffice());
		cm.wait(2);
		cm.selectDropDown_text(getFM_SelectParkingOffice(), "Rome");
		cm.wait(2);
		cm.scrollToview(getFM_SavechangesBtn());
		cm.jseClick(getFM_SavechangesBtn());
	}

	public void Click_AddScheduleButton() throws Exception {
		WebElement AddSchduleBtn = driver.findElement(By.xpath(
				"//input[@value='Rome Metropolitan Guesthouse, Via Milazzo, Rome, Rome, Metropolitan City of Rome, Italy']/following::a[contains(text(),'Add schedules')]"));
		cm.wait(3);
		cm.scrollToview(AddSchduleBtn);
		cm.wait(2);
		cm.HighlightElement(AddSchduleBtn);
		cm.jseClick(AddSchduleBtn);
		cm.wait(3);
		LOG.info("Clicked on Add Schedule button");
	}

	public void click_cancelAddscheduleButton() throws Exception {
		cm.FluientWait(FM_CancelAddSchedule, 10,3);
		cm.jseClick(getFM_CancelAddSchedule());
		LOG.info("Clicked on CANCEL button for Add Schedule");
	}

	public void Select_AddScheduleDetails() throws Exception {
		List<WebElement> FM_Open247_checkbox = driver.findElements(By.xpath(
				"//div[contains(@class,'content modal-parking-hours__content')]//div[@class='small-3 columns text-right']//input[1]"));
		int opencheckboxsize = FM_Open247_checkbox.size();
		cm.wait(5);
		System.out.println(opencheckboxsize);
		for (int i = 0; i < opencheckboxsize; i++) {
			WebElement FM_Open247_checkboxeach = FM_Open247_checkbox.get(i);
			cm.HighlightElement(FM_Open247_checkboxeach);
			cm.jseClick(FM_Open247_checkboxeach);
		}
		LOG.info("All the parking hours are selected on the PARKING AREA OPERATING popup");
		cm.HighlightElement(getFM_AddScheduleSaveChangesBtn());
		cm.jseClick(getFM_AddScheduleSaveChangesBtn());
		LOG.info("Clicked on SAVE CHANGES button after providing PARKING AREA OPERATING details ");

	}
	public void Click_GetParkingData() throws Exception
	{
		cm.FluientWait(FM_GetParkingDataTab, 10,3);
		cm.scrollToview(getFM_GetParkingDataTab());
		cm.HighlightElement(getFM_GetParkingDataTab());
		cm.jseClick(getFM_GetParkingDataTab());
		cm.wait(3);
		LOG.info("Clicked on GET PARKING DATA tab to downalod the Parking data");	
	}
	public void Search_ParkingAddress(String ParkingSpace) throws Exception
	{
		cm.FluientWait(FM_SearchParkingAddressfield, 10,3);
		cm.typeTextToTextBox(getFM_SearchParkingAddressfield(), ParkingSpace);
		cm.HighlightElement(getFM_FilterParkingAddressBtn());
		cm.jseClick(getFM_FilterParkingAddressBtn());
	    LOG.info("Searched for the specific address and clicked on filter button");
	    cm.scrollToview(getFM_SearchResultParkingAddress());
	    cm.HighlightElement(getFM_SearchResultParkingAddress());
	    cm.wait(3);    
	}
	public void RemoveParking_AssociatedVehicle() throws Exception
	{
		cm.FluientWait(FM_RemoveparkingBtn, 10,3);
		cm.HighlightElement(getFM_RemoveparkingBtn());
		cm.jseClick(getFM_RemoveparkingBtn());
		LOG.info("Clicked on remove parking button");
		cm.FluientWait(FM_AssociatedVehiclepopupMSg, 10,3);
		cm.HighlightElement(getFM_AssociatedVehiclepopupMSg());
		LOG.info(getFM_AssociatedVehiclepopupMSg().getText());
		
	}
	
	public void click_removeParkingSpace() throws Exception
	{
		cm.FluientWait(FM_RemoveparkingBtn, 10,3);
		cm.HighlightElement(getFM_RemoveparkingBtn());
		cm.jseClick(getFM_RemoveparkingBtn());
		LOG.info("Clicked on remove parking space button");
	}
	public void check_deleteBadge_confirmBtnEnabled() throws Exception
	{
		cm.FluientWait(FM_DeleteBadgesRadiobtn, 10,3);
		cm.click(getFM_DeleteBadgesRadiobtn());
		cm.wait(2);
		cm.HighlightElement(getFM_DeleteBadgesRadiobtn());
	}
	public void click_Cancelbutton_deleteparking() throws Exception
	{
		cm.HighlightElement(getFM_CancelDeleteParkingbtn());
		cm.wait(2);
		cm.jseClick(getFM_CancelDeleteParkingbtn());
		LOG.info("Clicked on cancel button for delete parking ");
	}
	public void check_AssignAnotherParking() throws Exception
	{
		cm.FluientWait(FM_AssignAnotherParkingRadiobtn, 10,3);
		cm.jseClick(getFM_AssignAnotherParkingRadiobtn());
		LOG.info("Reassignement radio button is selected");
		cm.click(getFM_SelectReassignParkingdropdown());
		cm.wait(2);
		cm.selectDropDown_text(getFM_SelectReassignParkingdropdown(), "FI, Firenze, Piazzale Michelangelo");
		cm.wait(3);
		LOG.info("Another parking is selected from select another parking dropdown");
		
	}
	public void verify_ReassignmentButton_enabled() throws Exception
	{
		cm.validateElementEnabled(getFM_ConfirmReassignmentBtn());
		LOG.info("Confirm Reassignemnt button is ENABLED");
		LOG.info("Badge to be deleted - Reassignment of parking is sucessful");
	}
	public void Click_parkingSpaceDeletion_confirmbutton() throws Exception
	{
		cm.FluientWait(FM_ConfirmParkingSpaceDeleteBtn, 10,3);
		cm.HighlightElement(getFM_ConfirmParkingSpaceDeleteBtn());
		cm.jseClick(getFM_ConfirmParkingSpaceDeleteBtn());
		LOG.info("The Parking space is deleted sucessfully");
		cm.wait(3);
	}
}
