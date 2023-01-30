package com.ALD_FM.pageObjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ALD.Base.BaseDriver;
import com.ALD.Commons.CommonUtilities;

public class FM_VehicleConditionObjs extends BaseDriver {

	private static final Logger LOG = LogManager.getLogger(FM_VehicleConditionObjs.class);

	public CommonUtilities cm = new CommonUtilities();

	By FM_Vehiclesearchfield = By.xpath("//input[@id='assistance_owner_issue_list_filter_multiSearchValue']");

	public WebElement getFM_Vehiclesearchfield() {
		return driver.findElement(FM_Vehiclesearchfield);
	}

	By FM_Vehiclesearchbtn = By.xpath("//button[@id='assistance_owner_issue_list_filter_submit']");

	public WebElement getFM_Vehiclesearchbtn() {
		return driver.findElement(FM_Vehiclesearchbtn);
	}

	public void SearchVehicleplate(String vehicleplate) throws Exception {
		cm.typeTextToTextBox(getFM_Vehiclesearchfield(), vehicleplate);
		cm.jseClick(getFM_Vehiclesearchbtn());
		LOG.info("Vehicle plate number search is sucessful");

		List<WebElement> vehiclesearchresults = driver
				.findElements(By.xpath("//tbody/tr/td/strong[contains(text(),'EW768ME')]"));
		if(vehiclesearchresults.size()==0)
		{
			LOG.info("No search results found for the vehicle palte:" +vehicleplate);
		}
		for (int i = 0; i < vehiclesearchresults.size(); i++) {
			WebElement specificvehicleresults = vehiclesearchresults.get(i);
			cm.HighlightElement(specificvehicleresults);
			cm.scrollToview(specificvehicleresults);
			if (specificvehicleresults.getText().equals(vehicleplate)) {
				LOG.info("All the Vehicle results displayed are of same vehicle");
			} else {
				LOG.error(
						"Vehicle results are displayed of different vehicles, Specific vehicle search failed revisit vehicle condtion page again");
			}
		}
	}

}
