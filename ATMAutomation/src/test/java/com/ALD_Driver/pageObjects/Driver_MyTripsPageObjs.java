package com.ALD_Driver.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ALD.Base.BaseDriver;
import com.ALD.Commons.CommonUtilities;

public class Driver_MyTripsPageObjs extends BaseDriver {

	private static final Logger LOG = LogManager.getLogger(Driver_MyTripsPageObjs.class);

	public CommonUtilities cm = new CommonUtilities();
	
	public static String newvehicleplatenumber;

	By Driver_Viewtripbtn = By.xpath("//button[contains(text(),'View')]");

	public WebElement getDriver_Viewtripbtn() {
		return driver.findElement(Driver_Viewtripbtn);
	}
	By Driver_newvehicleplate = By.xpath("//div[@class='box-sharing__model__title']//span[@class='uppercase']");

	public WebElement getDriver_newvehicleplate() {
		return driver.findElement(Driver_newvehicleplate);
	}
	
	public void verify_newVehicleAssignment() throws Exception
	{
		cm.FluientWait(Driver_Viewtripbtn, 20,3);
		cm.scrollToview(getDriver_Viewtripbtn());
		cm.HighlightElement(getDriver_Viewtripbtn());
		cm.jseClick(getDriver_Viewtripbtn());
		LOG.info("Clicked on VIEW button of the trip");
		cm.FluientWait(Driver_newvehicleplate, 20,3);
		cm.validateElementDisplayed(getDriver_newvehicleplate());
		cm.HighlightElement(getDriver_newvehicleplate());
		cm.wait(3);
		
		 newvehicleplatenumber = driver.findElement(Driver_newvehicleplate).getText();
		LOG.info("The new vehicle plate number Assigned to the existing trip is: "+ newvehicleplatenumber);
		
	}
}
