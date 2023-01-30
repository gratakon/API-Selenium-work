package com.ALD_FM.pageObjects;

import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.codecs.ByteArrayCodec;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ALD.Base.BaseDriver;
import com.ALD.Commons.CommonUtilities;

public class FM_FleetOverviewObjs extends BaseDriver {

	private static final Logger LOG = LogManager.getLogger(FM_FleetOverviewObjs.class);

	public CommonUtilities cm = new CommonUtilities();

	By FM_VehicleconditionLabel = By.xpath("//div[contains(text(),'Vehicle condition')]");

	public WebElement getFM_VehicleconditionLabel() {
		return driver.findElement(FM_VehicleconditionLabel);
	}

	public void Validate_Vehicleconditions() {
		cm.scrollToview(getFM_VehicleconditionLabel());
		cm.HighlightElement(getFM_VehicleconditionLabel());

		List<WebElement> typecondtions = driver
				.findElements(By.xpath("//div[contains(@class,'box-container feedback-ext')]//a"));

		for (int i = 0; i < typecondtions.size(); i++) {
			WebElement typecondtionselements = typecondtions.get(i);
			cm.HighlightElement(typecondtionselements);
			LOG.info("All the condition elements are present and Highlighted");
			if (typecondtionselements.getText().equals("View complete list")) {
				cm.click(typecondtionselements);
				LOG.info("View Complete list link is clicked under vehicle condition section");
			}
		}

	}

}
