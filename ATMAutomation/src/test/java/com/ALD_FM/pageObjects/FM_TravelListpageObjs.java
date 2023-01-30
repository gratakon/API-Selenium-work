package com.ALD_FM.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ALD.Base.BaseDriver;
import com.ALD.Commons.CommonUtilities;

public class FM_TravelListpageObjs extends BaseDriver {

	private static final Logger LOG = LogManager.getLogger(FM_TravelListpageObjs.class);

	public CommonUtilities cm = new CommonUtilities();

	By NextTripsTab = By.xpath("//a[contains(text(),'Next trips')]");

	public WebElement getNextTripsTab() {
		return driver.findElement(NextTripsTab);
	}
	By PastTripsTab = By.xpath("//a[contains(text(),'Past trips')]");

	public WebElement getPastTripsTab() {
		return driver.findElement(PastTripsTab);
	}
	
	By TravelSearchBtn = By.xpath("//button[@id='bookings_filter_submit']");

	public WebElement getTravelSearchBtn() {
		return driver.findElement(TravelSearchBtn);
	}
	By LicensePlateField = By.xpath("//input[@id='bookings_filter_plateOrDriver']");

	public WebElement getLicensePlateField() {
		return driver.findElement(LicensePlateField);
	}
	By TypeofUseDropdown = By.xpath("//select[@id='bookings_filter_useType']");

	public WebElement getTypeofUseDropdown() {
		return driver.findElement(TypeofUseDropdown);
	}
	
	
	public void Click_NextTripTab() throws Exception
	{
		cm.FluientWait(NextTripsTab, 10,3);
		cm.HighlightElement(getNextTripsTab());
		cm.jseClick(getNextTripsTab());
		LOG.info("Clicked on Next Trips Tab");
	}
	public void Click_PastTripsTab() throws Exception
	{
		cm.FluientWait(PastTripsTab, 10,3);
		cm.HighlightElement(getPastTripsTab());
		cm.jseClick(getPastTripsTab());
		LOG.info("Clicked on Past Trips Tab");
	}
	
	public void Click_TravelsearchBtn() throws Exception
	{
		cm.FluientWait(TravelSearchBtn, 10,3);
		cm.HighlightElement(getTravelSearchBtn());
		cm.jseClick(getTravelSearchBtn());
		LOG.info("Clicked on Search Button");
	}
	
	public void Enter_LicensePlatenumber(String LicensePlate) throws Exception
	{
		cm.FluientWait(LicensePlateField, 10,3);
		cm.typeTextToTextBox(getLicensePlateField(), LicensePlate);
	}
	
	public void Select_TypeofUseDropdown(String Usetype) throws InterruptedException
	{
		cm.FluientWait(TypeofUseDropdown, 10,3);
		cm.HighlightElement(getTypeofUseDropdown());
		cm.click(getTypeofUseDropdown());
		cm.selectDropDown_text(getTypeofUseDropdown(), Usetype);
	}
	
	
	
	
}
