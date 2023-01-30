package com.ALD_Driver.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ALD.Base.BaseDriver;
import com.ALD.Commons.CommonUtilities;

public class Driver_CarSharingProfilePageObjs extends BaseDriver{
	
	private static final Logger LOG = LogManager.getLogger(Driver_CarSharingProfilePageObjs.class);

	public CommonUtilities cm = new CommonUtilities();
	
	By D_CarPoolingOption = By.xpath("//a[contains(text(),'To use the Car Pooling')]");

	public WebElement getD_CarPoolingOption() {
		return driver.findElement(D_CarPoolingOption);
	}
	
	public void DriverCarPoolingOptiond_enable() throws Exception
	{
		//cm.ExplicitWaitForVisiBility(getD_CarPoolingOption());
		
		cm.verifyTextPresent("To use the Car Pooling");
		cm.HighlightElement(getD_CarPoolingOption());
		LOG.info("Car pooling Option Enabled for the driver");
		
	}
	
	public void DriverCarPoolingOption_Disable() throws Exception {
		cm.verifyTextNOTPresent("To use the Car Pooling");
		LOG.info("Car pooling Option Disabled for the driver");
		
	}
	
	

}
