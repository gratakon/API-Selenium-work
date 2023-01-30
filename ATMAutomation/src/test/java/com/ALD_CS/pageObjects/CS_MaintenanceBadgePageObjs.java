package com.ALD_CS.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ALD.Base.BaseDriver;
import com.ALD.Commons.CommonUtilities;

public class CS_MaintenanceBadgePageObjs extends BaseDriver {

	private static final Logger LOG = LogManager.getLogger(CS_MaintenanceBadgePageObjs.class);

	public CommonUtilities cm = new CommonUtilities();

	By CS_MaintenanceDurationDropdown = By.xpath("//select[@id='global_settings_defaultMaintenanceHoursDuration']");

	public WebElement getCS_MaintenanceDurationDropdown() {
		return driver.findElement(CS_MaintenanceDurationDropdown);
	}
	By CS_MaintenanceDurationSave = By.xpath("//button[@id='global_settings_update']");

	public WebElement getCS_MaintenanceDurationSave() {
		return driver.findElement(CS_MaintenanceDurationSave);
	}
	By CS_ChipIDField = By.xpath("//input[@id='form_chipId']");

	public WebElement getCS_ChipIDField() {
		return driver.findElement(CS_ChipIDField);
	}
	By CS_BadgeIDField = By.xpath("//input[@id='form_badgeId']");

	public WebElement getCS_BadgeIDField() {
		return driver.findElement(CS_BadgeIDField);
	}
	By CS_AssigneeField = By.xpath("//input[@id='form_description']");

	public WebElement getCS_AssigneeField() {
		return driver.findElement(CS_AssigneeField);
	}
	By CS_SaveNewBadgeBtn = By.xpath("//button[@id='form_save']");

	public WebElement getCS_SaveNewBadgeBtn() {
		return driver.findElement(CS_SaveNewBadgeBtn);
	}
	By CS_SearchBadgeIDBtn = By.xpath("//button[@id='form_search']");

	public WebElement getCS_SearchBadgeIDBtn() {
		return driver.findElement(CS_SearchBadgeIDBtn);
	}
	
	
	
	
	
	
	
	
	
	
	
	public void SelectMaintenanceDurationDropdown(String MaintenenceDuration) throws Exception
	{
		cm.click(getCS_MaintenanceDurationDropdown());
		cm.selectDropDown_text(getCS_MaintenanceDurationDropdown(), MaintenenceDuration);
		cm.HighlightElement(getCS_MaintenanceDurationSave());
		cm.jseClick(getCS_MaintenanceDurationSave());
	}
	
	public void InsertNewMaintenanceBadge() throws Exception
	{
		cm.FluientWait(CS_ChipIDField, 10,3);
		cm.typeTextToTextBox(getCS_ChipIDField(), "1222");
		cm.typeTextToTextBox(getCS_BadgeIDField(), "7889");
		cm.typeTextToTextBox(getCS_AssigneeField(), "ABCDEFs");
		cm.HighlightElement(getCS_SaveNewBadgeBtn());
		cm.jseClick(getCS_SaveNewBadgeBtn());
	}
	
	public void Search_BadgeID() throws Exception
	{
		cm.FluientWait(CS_SearchBadgeIDBtn, 10,3);
		cm.HighlightElement(getCS_SearchBadgeIDBtn());
		cm.jseClick(getCS_SearchBadgeIDBtn());
		cm.scrollToview(getCS_SearchBadgeIDBtn());
	}
}
