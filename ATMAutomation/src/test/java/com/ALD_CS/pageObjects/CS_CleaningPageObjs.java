package com.ALD_CS.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ALD.Base.BaseDriver;
import com.ALD.Commons.CommonUtilities;

public class CS_CleaningPageObjs  extends BaseDriver {

	private static final Logger LOG = LogManager.getLogger(CS_CleaningPageObjs.class);

	public CommonUtilities cm = new CommonUtilities();

	By CS_Searchvehiclefield = By.xpath("//input[@id='assistance_owner_issue_list_filter_multiSearchValue']");

	public WebElement getCS_Searchvehiclefield() {
		return driver.findElement(CS_Searchvehiclefield);
	}
	By CS_Searchvehiclebtn = By.xpath("//button[@id='assistance_owner_issue_list_filter_submit']");

	public WebElement getCS_Searchvehiclebtn() {
		return driver.findElement(CS_Searchvehiclebtn);
	}
	
	public void SearchVehicle_undercleaning(String vehicleplateno) throws Exception
	{
		cm.jseTypeText(getCS_Searchvehiclefield(), vehicleplateno);
		cm.jseClick(getCS_Searchvehiclefield());
	}

	
}
