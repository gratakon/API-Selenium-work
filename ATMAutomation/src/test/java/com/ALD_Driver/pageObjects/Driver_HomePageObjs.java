package com.ALD_Driver.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ALD.Base.BaseDriver;
import com.ALD.Commons.CommonUtilities;

public class Driver_HomePageObjs extends BaseDriver {

	private static final Logger LOG = LogManager.getLogger(Driver_HomePageObjs.class);

	public CommonUtilities cm = new CommonUtilities();

	By AcknowledgePopup = By.xpath("//a[contains(@class,'button close')]");

	public WebElement getAcknowledgePopup() {
		return driver.findElement(AcknowledgePopup);
	}

	By Driver_Menu = By.xpath("//span[contains(@class,'label-menu')]");

	public WebElement getDriver_Menu() {
		return driver.findElement(Driver_Menu);
	}

	By Driver_CarSharingLink = By.xpath("//a[@class='carsharing a-level-1']");

	public WebElement getDriver_CarSharingLink() {
		return driver.findElement(Driver_CarSharingLink);
	}

	By Driver_CarSharingProfileLink = By.xpath("//a[contains(text(),'Carsharing profile')]");

	public WebElement getDriver_CarSharingProfileLink() {
		return driver.findElement(Driver_CarSharingProfileLink);
	}

	By Driver_BookingLink = By.xpath("//a[contains(text(),'Booking')]");

	public WebElement getDriver_BookingLink() {
		return driver.findElement(Driver_BookingLink);
	}

	By Driver_ProfileLink = By.xpath("//span[contains(@class,'role')]");

	public WebElement getDriver_ProfileLink() {
		return driver.findElement(Driver_ProfileLink);
	}
	By Driver_MytripsLink = By.xpath("//a[contains(text(),'My trips')]");

	public WebElement getDriver_MytripsLink() {
		return driver.findElement(Driver_MytripsLink);
	}

	
	
	By DLogoutbtn = By.xpath("//a[contains(text(),'Logout')]");

	public WebElement getDLogoutbtn() {
		return driver.findElement(DLogoutbtn);
	}

	public void click_AcknowledgePopup() {
		cm.HighlightElement(getAcknowledgePopup());
		cm.clickElement(getAcknowledgePopup());
		LOG.info("AcknowledgePopup clicked on HomePage of Driver");
	}

	public void click_DriverMenu() throws Exception {
		cm.HighlightElement(getDriver_Menu());
		cm.jseClick(getDriver_Menu());
		LOG.info("Clicked on MENU option on Driver Home page");
	}

	public void click_CarSharingLink() throws Exception {
		cm.HighlightElement(getDriver_CarSharingLink());
		cm.jseClick(getDriver_CarSharingLink());
		cm.wait(3);
		LOG.info("Clicked on Car Sharing Link on Driver Menu");
	}

	public void click_BookingLink() throws Exception {
		cm.HighlightElement(getDriver_BookingLink());
		cm.jseClick(getDriver_BookingLink());
		cm.wait(3);
		LOG.info("Clicked on Car Booking Link");
	}

	public void click_CarSharingProfileLink() throws Exception {
		cm.HighlightElement(getDriver_CarSharingProfileLink());
		cm.jseClick(getDriver_CarSharingProfileLink());
		cm.wait(3);
		LOG.info("Clicked on Car Sharing Profile Link");
	}

	public void click_MytripsLink() throws Exception
	{
		cm.HighlightElement(getDriver_MytripsLink());
		cm.jseClick(getDriver_MytripsLink());
		LOG.info("Clicked on My Trips link");
	}
	
	
	public void DLogout() throws Exception {
		cm.jseClick(getDriver_ProfileLink());
		cm.ExplicitWaitelementclickable(getDLogoutbtn());
		cm.HighlightElement(getDLogoutbtn());
		cm.jseClick(getDLogoutbtn());
		LOG.info("Logout Sucessfull as Driver");
		driver.quit();
		
	}

}
