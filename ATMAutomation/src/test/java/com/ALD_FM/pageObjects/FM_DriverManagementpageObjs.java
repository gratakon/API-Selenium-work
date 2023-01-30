package com.ALD_FM.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ALD.Base.BaseDriver;
import com.ALD.Commons.CommonUtilities;

public class FM_DriverManagementpageObjs extends BaseDriver {

	private static final Logger LOG = LogManager.getLogger(FM_DriverManagementpageObjs.class);

	public CommonUtilities cm = new CommonUtilities();

	By FM_Driversearch = By.xpath("//input[@id='driver_request_filter_name']");

	public WebElement getFM_Driversearch() {
		return driver.findElement(FM_Driversearch);
	}

	By FM_Driversearchbtn = By.xpath("//button[@id='driver_request_filter_submit']");

	public WebElement getFM_Driversearchbtn() {
		return driver.findElement(FM_Driversearchbtn);
	}

	By FM_EnabledTab = By.xpath("//a[contains(text(),'Enabled')]");

	public WebElement getFM_EnabledTab() {
		return driver.findElement(FM_EnabledTab);
	}

	By FM_selectGroupdropdown = By.xpath("//select[@id='drivers_enabled_driversEnabled_0_driverGroup']");

	public WebElement getFM_selectGroupdropdown() {
		return driver.findElement(FM_selectGroupdropdown);
	}

	By FM_savemodificationbtn = By.xpath("//button[@id='cs-salva-modifiche']");

	public WebElement getFM_savemodificationbtn() {
		return driver.findElement(FM_savemodificationbtn);
	}

	By FM_BadgeTodriverlabel = By
			.xpath("//td[contains(text(),'testautomationccs+driver@gmail.com')]/following::td[5]//a");

	public WebElement getFM_BadgeTodriverlabel() {
		return driver.findElement(FM_BadgeTodriverlabel);
	}
	By FM_MassiveActionsBtn = By.xpath("//button[@id='cs-azioni-massive']");

	public WebElement getFM_MassiveActionsBtn() {
		return driver.findElement(FM_MassiveActionsBtn);
	}
	By FM_AssignSameGroupToEveryonelink = By.xpath("//a[@class='strip-link assign-all js-modal-assegna-gruppo']//h2[contains(text(),'Assign the same group to everyone')]");

	public WebElement getFM_AssignSameGroupToEveryonelink() {
		return driver.findElement(FM_AssignSameGroupToEveryonelink);
	}
	By FM_GroupSelectBox = By.xpath("//select[contains(@class,'js-modal-group-select')]");

	public WebElement getFM_GroupSelectBox() {
		return driver.findElement(FM_GroupSelectBox);
	}
	By FM_AssignGroupCancelBtn = By.xpath("//a[contains(@class,'button back2index')]");

	public WebElement getFM_AssignGroupCancelBtn() {
		return driver.findElement(FM_AssignGroupCancelBtn);
	}
	By FM_AssignGroupConfirmBtn = By.xpath("//a[contains(@class,'button confirm-change')]");

	public WebElement getFM_AssignGroupConfirmBtn() {
		return driver.findElement(FM_AssignGroupConfirmBtn);
	}
	By FM_BackToDriversListLink = By.xpath("//a[contains(@class,'close mb-20 mt-20 underline')]");

	public WebElement getFM_BackToDriversListLink() {
		return driver.findElement(FM_BackToDriversListLink);
	}
	
	
	
	
	

	public void updateBusinessGroupforDriver(String groupNamesel, String DriverName) throws Exception {
		cm.jseTypeText(getFM_Driversearch(), DriverName);
		cm.jseClick(getFM_Driversearchbtn());
		cm.moveToObject(getFM_EnabledTab());
		cm.jseClick(getFM_EnabledTab());
		cm.moveToObject(getFM_selectGroupdropdown());
		cm.jseClick(getFM_selectGroupdropdown());
		cm.selectDropdown(getFM_selectGroupdropdown(), groupNamesel);
		cm.jseClick(getFM_savemodificationbtn());
	}

	public void verify_BadgeToDriver_assigend() throws Exception {
		cm.jseClick(getFM_EnabledTab());
		cm.FluientWait(FM_BadgeTodriverlabel, 20,3);
		cm.scrollToview(getFM_BadgeTodriverlabel());
		cm.HighlightElement(getFM_BadgeTodriverlabel());
		String badgename = cm.getText(getFM_BadgeTodriverlabel());
		if (badgename.equalsIgnoreCase("1234")) {
			LOG.info("The newly created Badge: " +badgename+ " is assigned to the Specific Driver sucessfully");
		} else {
			LOG.info("The newly created Badge is assignment is not sucessfull");
		}
		cm.wait(5);

	}
	
	public void AssignNewGroupTo_Alldrivers() throws Exception
	{
		cm.jseClick(getFM_EnabledTab());
		LOG.info("Clicked on Enable Tab");
		cm.HighlightElement(getFM_MassiveActionsBtn());
		cm.jseClick(getFM_MassiveActionsBtn());
		LOG.info("Clicked on massive Actions Tab");
		cm.FluientWait(FM_AssignSameGroupToEveryonelink, 10,3);
		cm.HighlightElement(getFM_AssignSameGroupToEveryonelink());
		cm.jseClick(getFM_AssignSameGroupToEveryonelink());
		LOG.info("Clicked on ASSIGN SAME GROUP TO EVERYONE link");
		cm.FluientWait(FM_GroupSelectBox, 10,3);
		cm.jseClick(getFM_GroupSelectBox());
		cm.wait(3);
		cm.selectDropDown_text(getFM_GroupSelectBox(), "Default");
		LOG.info("A value is selected from the Group Select box");
			
	}
	
	public void Click_CancelAssignGroupToAll() throws Exception
	{
		cm.scrollToview(getFM_AssignGroupCancelBtn());
		cm.HighlightElement(getFM_AssignGroupCancelBtn());
		cm.jseClick(getFM_AssignGroupCancelBtn());
		LOG.info("Clicked on CANCEL button for the Assign Group popup ");
	}
	
	public void Click_ConfirmAssignGroupToAll() throws Exception
	{
		cm.scrollToview(getFM_AssignGroupConfirmBtn());
		cm.HighlightElement(getFM_AssignGroupConfirmBtn());
		cm.jseClick(getFM_AssignGroupConfirmBtn());
		LOG.info("Clicked on Confirm button for the Assign Group popup ");
		cm.FluientWait(FM_BackToDriversListLink, 10,3);
		cm.HighlightElement(getFM_BackToDriversListLink());
		cm.jseClick(getFM_BackToDriversListLink());
		LOG.info("Clicked on Back to Driver list button");
		cm.wait(3);
		cm.movepagedown();
		cm.movepagedown();
		cm.movepagedown();
		cm.wait(3);
	}
	
	public void SearchDriverField(String drivername) throws Exception
	{
		cm.FluientWait(FM_Driversearch, 10,3);
		cm.typeTextToTextBox(getFM_Driversearch(),drivername );
		cm.jseClick(getFM_Driversearchbtn());
		cm.jseClick(getFM_EnabledTab());
		LOG.info("Clicked on Enable Tab");
		cm.Scroll_PageEnd();
		
	}
	

}
