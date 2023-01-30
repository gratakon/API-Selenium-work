package com.ALD_CMS_AdminConfig.pageObjects;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ALD.Base.BaseDriver;
import com.ALD.Commons.CommonUtilities;

public class AdminConfig_PlatformconfigurationObjs extends BaseDriver {
	private static final Logger LOG = LogManager.getLogger(AdminConfig_PlatformconfigurationObjs.class);

	public CommonUtilities cm = new CommonUtilities();

	By AC_SearchField = By.xpath("//input[@placeholder='Search']");

	public WebElement getAC_SearchField() {
		return driver.findElement(AC_SearchField);
	}
	By AC_costcenter_ParameterKey = By.xpath("//span[@class='highlight']");

	public WebElement getAC_costcenter_ParameterKey() {
		return driver.findElement(AC_costcenter_ParameterKey);
	}
	By AC_CostCenterAssociationType_Dropdown = By.xpath("//select[@id='configuration_value']");

	public WebElement getAC_CostCenterAssociationType_Dropdown() {
		return driver.findElement(AC_CostCenterAssociationType_Dropdown);
	}
	By AC_SaveBtn = By.xpath("//span[contains(text(),'Save')]");

	public WebElement getAC_SaveBtn() {
		return driver.findElement(AC_SaveBtn);
	}
	
	
	
	public void Search_configuration(String Costcenter_associationType ) throws Exception
	{
		cm.FluientWait(AC_SearchField, 10,3);
		cm.typeTextToTextBox(getAC_SearchField(), "Cost_center_association_type");
		Robot rt = new Robot();
		rt.keyPress(KeyEvent.VK_ENTER);
		rt.keyRelease(KeyEvent.VK_ENTER);
		LOG.info("Searched for Cost_center_association_type in the search box");
	}
	public void Click_desired_parameter_line()
	{
		cm.FluientWait(AC_costcenter_ParameterKey, 10,3);
		cm.clickElement(getAC_costcenter_ParameterKey());
		LOG.info("Clicked on Cost center Parameter Key");
	}
	public void Select_CostCenterAssociationType_Dropdown_Save(String CostCenterAssociationTypevalue) throws Exception
	{
		cm.FluientWait(AC_CostCenterAssociationType_Dropdown, 10,3);
		cm.jseClick(getAC_CostCenterAssociationType_Dropdown());
		cm.wait(3);
		cm.selectDropDown_text(getAC_CostCenterAssociationType_Dropdown(), CostCenterAssociationTypevalue);
		LOG.info(CostCenterAssociationTypevalue +"::: is selected from the Cost center dropdown");
		cm.scrollToview(getAC_SaveBtn());
		cm.HighlightElement(getAC_SaveBtn());
		cm.jseClick(getAC_SaveBtn());
		LOG.info("Clicked on SAVE button :: New cost center changes are SAVED sucessfully");
	}
	
	
	
}
