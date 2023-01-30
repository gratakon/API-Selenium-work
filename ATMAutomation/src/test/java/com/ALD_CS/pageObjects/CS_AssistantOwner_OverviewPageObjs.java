package com.ALD_CS.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ALD.Base.BaseDriver;
import com.ALD.Commons.CommonUtilities;

public class CS_AssistantOwner_OverviewPageObjs extends BaseDriver {

	private static final Logger LOG = LogManager.getLogger(CS_AssistantOwner_OverviewPageObjs.class);

	public CommonUtilities cm = new CommonUtilities();

	By CS_WashingLabel = By.xpath("//div[contains(text(),'Cleaning')]");

	public WebElement getCS_WashingLabel() {
		return driver.findElement(CS_WashingLabel);
	}
	By CS_viewcleaningListlink = By.xpath("//div[@class='box-container feedback-int']//a[contains(text(),'View complete list')]");

	public WebElement getCS_viewcleaningListlink() {
		return driver.findElement(CS_viewcleaningListlink);
	}
	
	public void click_Cleaning_viewcompletelist() throws Exception
	{
		cm.scrollToview(getCS_WashingLabel());
		cm.HighlightElement(getCS_viewcleaningListlink());
		cm.jseClick(getCS_viewcleaningListlink());
		LOG.info("Clicked on View complete list link under CLEANING section");
	}
	
	
}
