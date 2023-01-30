package com.ALD_FM.pageObjects;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ALD.Base.BaseDriver;
import com.ALD.Commons.CommonUtilities;

public class FM_BadgesObjs extends BaseDriver {

	private static final Logger LOG = LogManager.getLogger(FM_BadgesObjs.class);

	public CommonUtilities cm = new CommonUtilities();

	By FM_DownloadTemplate = By.xpath("//a[contains(text(),'Download the template')]");

	public WebElement getFM_DownloadTemplate() {
		return driver.findElement(FM_DownloadTemplate);
	}

	By FM_parkingcodes = By.xpath("//a[@class='button white-bordered mb-0']");

	public WebElement getFM_parkingcodes() {
		return driver.findElement(FM_parkingcodes);
	}

	By FM_HUBparkingarea_4 = By
			.xpath("//a[contains(text(),'Viale dei Mille, 4, Florence, Metropolitan City of Florence, Italy')]");

	public WebElement getFM_HUBparkingarea_4() {
		return driver.findElement(FM_HUBparkingarea_4);
	}

	By FM_HUBparkingarea_1 = By
			.xpath("//a[contains(text(),'Via Paolo Sarpi, 1, Milan, Metropolitan City of Milan, Italy')]");

	public WebElement getFM_HUBparkingarea_1() {
		return driver.findElement(FM_HUBparkingarea_1);
	}

	By FM_HUBparkingarea_3 = By
			.xpath("//a[contains(text(),'Via delle Robinie, 3, Rome, Metropolitan City of Rome, Italy')]");

	public WebElement getFM_HUBparkingarea_3() {
		return driver.findElement(FM_HUBparkingarea_3);
	}

	By FM_Choosefilelink = By.xpath("//div[contains(text(),'Choose file')]");

	public WebElement getFM_Choosefilelink() {
		return driver.findElement(FM_Choosefilelink);
	}

	By FM_removefilebtn = By.xpath("//span[@class='badge-upload-widget__ico__action']");

	public WebElement getFM_removefilebtn() {
		return driver.findElement(FM_removefilebtn);
	}

	By FM_uploadfilebtn = By.xpath("//span[contains(text(),'Upload file')]");

	public WebElement getFM_uploadfilebtn() {
		return driver.findElement(FM_uploadfilebtn);
	}

	By FM_uploadsucessFlashMsg = By.xpath("//div[@class='flash__message-content']");

	public WebElement getFM_uploadsucessFlashMsg() {
		return driver.findElement(FM_uploadsucessFlashMsg);
	}

	By FM_cardIDerrorMsg = By.xpath("//span[contains(text(),'cardId cannot be null or empty')]");

	public WebElement getFM_cardIDerrorMsg() {
		return driver.findElement(FM_cardIDerrorMsg);
	}

	By FM_chipIDerrorMsg = By.xpath("//span[contains(text(),'chipId cannot be null or empty')]");

	public WebElement getFM_chipIDerrorMsg() {
		return driver.findElement(FM_chipIDerrorMsg);
	}

	By FM_parkingIDerrorMsg = By.xpath("//span[contains(text(),'parkingId cannot be null or empty')]");

	public WebElement getFM_parkingIDerrorMsg() {
		return driver.findElement(FM_parkingIDerrorMsg);
	}

	By FM_DeleteBadgebtn = By.xpath("//span[contains(text(),'1234')]/following::td[4]/i");

	public WebElement getFM_DeleteBadgebtn() {
		return driver.findElement(FM_DeleteBadgebtn);
	}

	By FM_confirmDeleteBadgebtn = By.xpath("//div[contains(@class,'row')]/following::a[3]");

	public WebElement getFM_confirmDeleteBadgebtn() {
		return driver.findElement(FM_confirmDeleteBadgebtn);
	}
	By FM_BulkDeleteconfirmDeleteBadgebtn = By.xpath("//div[contains(@class,'row')]/following::a[6]");

	public WebElement getFM_BulkDeleteconfirmDeleteBadgebtn() {
		return driver.findElement(FM_BulkDeleteconfirmDeleteBadgebtn);
	}
	
	
	By FM_CancelDeleteBadgebtn = By.xpath("//div[contains(@class,'row')]/following::a[2]");

	public WebElement getFM_CancelDeleteBadgebtn() {
		return driver.findElement(FM_CancelDeleteBadgebtn);
	}
	
	By FM_DriverHasBadgeErrorMsg = By.xpath("//span[contains(text(),'Driver has badge associated')]");

	public WebElement getFM_DriverHasBadgeErrorMsg() {
		return driver.findElement(FM_DriverHasBadgeErrorMsg);
	}

	By FM_BADCardIDErrorMsg = By.xpath("//span[contains(text(),'cardId already exists')]");

	public WebElement getFM_BADCardIDErrorMsg() {
		return driver.findElement(FM_BADCardIDErrorMsg);
	}

	By FM_BADChipIDErrorMsg = By.xpath("//span[contains(text(),'chipId already exists')]");

	public WebElement getFM_BADChipIDErrorMsg() {
		return driver.findElement(FM_BADChipIDErrorMsg);
	}

	By FM_BADDriverEmailIDErrorMsg = By.xpath("//span[contains(text(),'Driver not found')]");

	public WebElement getFM_BADDriverEmailIDErrorMsg() {
		return driver.findElement(FM_BADDriverEmailIDErrorMsg);
	}

	By FM_BADParkingCodeErrorMsg = By.xpath("//span[contains(text(),'parking not found')]");

	public WebElement getFM_BADParkingCodeErrorMsg() {
		return driver.findElement(FM_BADParkingCodeErrorMsg);
	}
	By FM_CardIDfield = By.xpath("//div[contains(@class,'row')]//td[1]//div[1]//input[1]");

	public WebElement getFM_CardIDfield() {
		return driver.findElement(FM_CardIDfield);
	}
	By FM_ChipIDfield = By.xpath("//div[contains(@class,'row')]//td[2]//div[1]//input[1]");

	public WebElement getFM_ChipIDfield() {
		return driver.findElement(FM_ChipIDfield);
	}
	By FM_DriverMailIDfield = By.xpath("//div[contains(@class,'row')]//td[3]//div[1]//input[1]");

	public WebElement getFM_DriverMailIDfield() {
		return driver.findElement(FM_DriverMailIDfield);
	}
	By FM_ParkingCodefield = By.xpath("//div[contains(@class,'row')]//td[4]//div[1]//input[1]");

	public WebElement getFM_ParkingCodefield() {
		return driver.findElement(FM_ParkingCodefield);
	}
	By FM_EditDriverBtn = By.xpath("//tr[1]//td[4]//div[1]//i[1]");

	public WebElement getFM_EditDriverBtn() {
		return driver.findElement(FM_EditDriverBtn);
	}
	By FM_InsertDriverEmailfield = By.xpath("//input[@id='autosuggest__input'][1]");

	public WebElement getFM_InsertDriverEmailfield() {
		return driver.findElement(FM_InsertDriverEmailfield);
	}
	By FM_SearchDriverfield = By.xpath("//input[@placeholder='Search Id card, driver name']");

	public WebElement getFM_SearchDriverfield() {
		return driver.findElement(FM_SearchDriverfield);
	}
	By FM_Driversearchresults = By.xpath("(//tbody)[2]//tr");

	public WebElement getFM_Driversearchresults() {
		return driver.findElement(FM_Driversearchresults);
	}
	By FM_SelectMassiveOptionsDropDown = By.xpath("//div[contains(@class,'badge-list-container')]//div[1]//select[1]");

	public WebElement getFM_SelectMassiveOptionsDropDown() {
		return driver.findElement(FM_SelectMassiveOptionsDropDown);
	}
	By FM_BadgeselectCheckbox = By.xpath("//tr[1]//td[1]//input[1]");

	public WebElement getFM_BadgeselectCheckbox() {
		return driver.findElement(FM_BadgeselectCheckbox);
	}
	By FM_ApplyButton = By.xpath("//button[contains(@class,'full-width')]");

	public WebElement getFM_ApplyButton() {
		return driver.findElement(FM_ApplyButton);
	}
	By FM_SelectParkingDropdown = By.xpath("//body[contains(@class,'')]//div[contains(@class,'row')]//div[contains(@class,'row')]//div[2]//select[1]");

	public WebElement getFM_SelectParkingDropdown() {
		return driver.findElement(FM_SelectParkingDropdown);
	}
	
	
	
	public void Click_DownloadTemplete() throws Exception {
		cm.FluientWait(FM_DownloadTemplate, 20,3);
		cm.HighlightElement(getFM_DownloadTemplate());
		cm.jseClick(getFM_DownloadTemplate());
		LOG.info("Clicked on DOWNLOAD TEMPLATE link");
	}

	public void click_parkingcodes() throws Exception {
		cm.FluientWait(FM_parkingcodes, 20,3);
		cm.HighlightElement(getFM_parkingcodes());
		cm.jseClick(getFM_parkingcodes());
		LOG.info("Parking code are displayed");
	}

	public void verify_HubParkings_Notdisplayed() throws Exception {
		cm.validateElementNotDisplayed(FM_HUBparkingarea_1);
		cm.validateElementNotDisplayed(FM_HUBparkingarea_3);
		cm.validateElementNotDisplayed(FM_HUBparkingarea_4);
		LOG.info("HUB Parkings are not displayed under the Parking codes on Badges page");
	}

	public void Choose_file_To_Upload() throws Exception {
		cm.FluientWait(FM_Choosefilelink, 10,3);
		cm.HighlightElement(getFM_Choosefilelink());
		cm.clickElement(getFM_Choosefilelink());
		LOG.info("CHOOSE FILE button is clicked");
		cm.uploadfile_to_app(
				"C:\\Users\\IT-SERVICE-OFFSH2\\Documents\\Badges files\\template_importazione_badge_en.xlsx");
	}

	public void Choose_file_To_Upload_wrongData() throws Exception {
		cm.FluientWait(FM_Choosefilelink, 10,3);
		cm.HighlightElement(getFM_Choosefilelink());
		cm.clickElement(getFM_Choosefilelink());
		LOG.info("CHOOSE FILE button is clicked");
		cm.uploadfile_to_app(
				"C:\\Users\\IT-SERVICE-OFFSH2\\Documents\\Badges files\\template_importazione_badge_en - wrongdata.xlsx");
	}

	public void click_removefile() throws InterruptedException {
		cm.clickElement(getFM_removefilebtn());
		cm.wait(5);
	}

	public void click_uploadfileBtn() throws Exception {
		cm.FluientWait(FM_uploadfilebtn, 20,3);
		cm.HighlightElement(getFM_uploadfilebtn());
		cm.jseClick(getFM_uploadfilebtn());
		LOG.info("Clicked on UPLOAD file button");
	}

	public void verify_uploadSucessFlahMsg_displayed() throws Exception {
		cm.FluientWait(FM_uploadsucessFlashMsg, 20,3);
		cm.verifyElementDisplayed(getFM_uploadsucessFlashMsg());
		cm.scrollToview(getFM_uploadsucessFlashMsg());
		cm.HighlightElement(getFM_uploadsucessFlashMsg());
		LOG.info("The Badge file upload sucess messgae is displayed sucessfully");
	}

	public void verify_allThedataChecksPerformed() throws Exception {
		cm.FluientWait(FM_cardIDerrorMsg, 20,3);
		cm.validateElementDisplayed(getFM_cardIDerrorMsg());
		cm.HighlightElement(getFM_cardIDerrorMsg());
		LOG.info("Data check for CARD ID is performed error message displayed");
		cm.validateElementDisplayed(getFM_chipIDerrorMsg());
		cm.HighlightElement(getFM_chipIDerrorMsg());
		LOG.info("Data check for CHIP ID is performed error message displayed");
		cm.validateElementDisplayed(getFM_parkingIDerrorMsg());
		cm.HighlightElement(getFM_parkingIDerrorMsg());
		LOG.info("Data check for PARKING ID is performed error message displayed");

	}

	public void click_DeleteBadge(String Badgenumber) throws Exception {
		cm.wait(4);
		
WebElement BadgeToDelete = driver.findElement(By.xpath("//span[contains(text(),'"+Badgenumber+"')]/following::td[4]/i"));
		
		cm.wait(4);
		cm.scrollToview(BadgeToDelete);
		cm.jseClick(BadgeToDelete); 
		cm.wait(3);
		cm.FluientWait(FM_confirmDeleteBadgebtn, 10,3);
		cm.HighlightElement(getFM_confirmDeleteBadgebtn());
		cm.jseClick(getFM_confirmDeleteBadgebtn());
		LOG.info("Newly created Badge deleted sucessfully");
	}

	public void Click_Cancellation_DeleteBadge(String Badgenumber1) throws Exception
	{
		cm.wait(4);
		
		WebElement BadgeToDelete = driver.findElement(By.xpath("//span[contains(text(),'"+Badgenumber1+"')]/following::td[4]/i"));
				
				cm.wait(4);
				cm.scrollToview(BadgeToDelete);
				cm.jseClick(BadgeToDelete); 
				cm.wait(3);
				cm.FluientWait(FM_CancelDeleteBadgebtn, 10,3);
				cm.HighlightElement(getFM_CancelDeleteBadgebtn());
				cm.jseClick(getFM_CancelDeleteBadgebtn());
				LOG.info("Clicked on Cancel Button for the Badge deletion, BADGE Deletion is cancelled sucessfully");
			}

	public void Choose_file_To_Upload_DriverHasBadge() throws Exception {
		cm.FluientWait(FM_Choosefilelink, 10,3);
		cm.HighlightElement(getFM_Choosefilelink());
		cm.clickElement(getFM_Choosefilelink());
		LOG.info("CHOOSE FILE button is clicked");
		cm.uploadfile_to_app(
				"C:\\Users\\IT-SERVICE-OFFSH2\\Documents\\Badges files\\template_importazione_badge_en - DriverBadge Already.xlsx");
	}

	public void Verify_DriverHasBadgeErrormsg_displayed() throws Exception {
		cm.FluientWait(FM_DriverHasBadgeErrorMsg, 10,3);
		cm.validateElementDisplayed(getFM_DriverHasBadgeErrorMsg());
		cm.HighlightElement(getFM_DriverHasBadgeErrorMsg());
		LOG.info("Error message with Driver has Badge assigned is displayed");
	}

	public void Choose_file_To_Upload_withAllBadData() throws Exception {
		cm.FluientWait(FM_Choosefilelink, 10,3);
		cm.HighlightElement(getFM_Choosefilelink());
		cm.clickElement(getFM_Choosefilelink());
		LOG.info("CHOOSE FILE button is clicked");
		cm.uploadfile_to_app(
				"C:\\Users\\IT-SERVICE-OFFSH2\\Documents\\Badges files\\template_importazione_badge_en - AllBadData.xlsx");
	}

	public void Verify_AllErrorMessages_BadDataUploaded() throws Exception {
		cm.FluientWait(FM_BADCardIDErrorMsg, 20,3);
		cm.validateElementDisplayed(getFM_BADCardIDErrorMsg());
		cm.HighlightElement(getFM_BADCardIDErrorMsg());
		LOG.info("Error Message for Bad CARDID is displayed as expected");
		cm.validateElementDisplayed(getFM_BADChipIDErrorMsg());
		cm.HighlightElement(getFM_BADChipIDErrorMsg());
		LOG.info("Error Message for Bad CHIPID is displayed as expected");
		cm.validateElementDisplayed(getFM_BADDriverEmailIDErrorMsg());
		cm.HighlightElement(getFM_BADDriverEmailIDErrorMsg());
		LOG.info("Error Message for Bad Driver mail ID is displayed as expected");
		cm.validateElementDisplayed(getFM_BADParkingCodeErrorMsg());
		cm.HighlightElement(getFM_BADParkingCodeErrorMsg());
		LOG.info("Error Message for Bad PARKINGCODE is displayed as expected");

	}

	public void Edit_AllBadDataUploaded() throws Exception {
		
		cm.typeTextToTextBox(getFM_CardIDfield(), "7890");
		cm.typeTextToTextBox(getFM_ChipIDfield(), "0987");
		cm.clearText(getFM_DriverMailIDfield());
		cm.wait(2);
		cm.typeTextToTextBox(getFM_DriverMailIDfield(), "testautomationccs+driver1@gmail.com");
		cm.clearText(getFM_ParkingCodefield());
		cm.wait(2);
		cm.typeTextToTextBox(getFM_ParkingCodefield(), "ff57fdce-2ccc-4d4f-a3d7-8a175a846760");
		cm.click(getFM_CardIDfield());
		LOG.info("All the wrongly inserted data is edited and corrected");	
		cm.wait(5);
	}
	
	public void Edit_driverinfo(String Driver_email) throws Exception
	{
		cm.FluientWait(FM_EditDriverBtn, 10,3);
		cm.scrollToview(getFM_EditDriverBtn());
		cm.HighlightElement(getFM_EditDriverBtn());
		cm.click(getFM_EditDriverBtn());
		cm.wait(3);
		WebElement insertdriverinfo = driver.findElement(By.xpath("//span[contains(text(),'1111')]/following::input[@id='autosuggest__input']"));
		cm.clearText(insertdriverinfo);
		cm.typeTextToTextBox(insertdriverinfo, Driver_email);
		cm.wait(3);
		LOG.info("FM is able to edit the driver information for the wrongly inserted details");
	}
	
	public void Search_driverAssociation(String driverTosearch) throws Exception
	{
		cm.FluientWait(FM_SearchDriverfield, 10,3);
		cm.scrollToview(getFM_SearchDriverfield());
		cm.HighlightElement(getFM_SearchDriverfield());
		cm.typeTextToTextBox(getFM_SearchDriverfield(), driverTosearch);
		cm.HighlightElement(getFM_Driversearchresults());
		cm.wait(3);	
	}
	
	public void Apply_BadgebulkDeleteOption() throws Exception
	{
		cm.FluientWait(FM_SelectMassiveOptionsDropDown, 10,3);
		cm.scrollToview(getFM_SelectMassiveOptionsDropDown());
		cm.jseClick(getFM_SelectMassiveOptionsDropDown());
		cm.wait(3);
		cm.selectDropDown_text(getFM_SelectMassiveOptionsDropDown(), "Delete badge");
		cm.click(getFM_BadgeselectCheckbox());
		cm.HighlightElement(getFM_ApplyButton());
		cm.click(getFM_ApplyButton());
		cm.FluientWait(FM_BulkDeleteconfirmDeleteBadgebtn, 10,3);
		cm.HighlightElement(getFM_BulkDeleteconfirmDeleteBadgebtn());
		cm.click(getFM_BulkDeleteconfirmDeleteBadgebtn());
		cm.wait(10);
	}
	public void Apply_BadgebulkChangeParking() throws Exception
	{
		cm.FluientWait(FM_SelectMassiveOptionsDropDown, 10,3);
		cm.scrollToview(getFM_SelectMassiveOptionsDropDown());
		cm.jseClick(getFM_SelectMassiveOptionsDropDown());
		cm.wait(3);
		cm.selectDropDown_text(getFM_SelectMassiveOptionsDropDown(), "Change parking");
		cm.FluientWait(FM_SelectParkingDropdown, 10,3);
		cm.jseClick(getFM_SelectParkingDropdown());
		cm.wait(3);
		cm.selectDropDown_text(getFM_SelectParkingDropdown(), "MI, Milano, Viale delle Rimembranze di Greco 3");
		cm.click(getFM_BadgeselectCheckbox());
		cm.HighlightElement(getFM_ApplyButton());
		cm.click(getFM_ApplyButton());
		cm.wait(10);
		
	}
	

}
