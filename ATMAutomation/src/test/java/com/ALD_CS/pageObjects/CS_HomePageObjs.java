package com.ALD_CS.pageObjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ALD.Base.BaseDriver;
import com.ALD.Commons.CommonUtilities;

public class CS_HomePageObjs extends BaseDriver {

	private static final Logger LOG = LogManager.getLogger(CS_HomePageObjs.class);

	public CommonUtilities cm = new CommonUtilities();

	By CS_link = By.xpath("//span[contains(@class,'role')]");

	public WebElement getCS_link() {
		return driver.findElement(CS_link);
	}

	By CarSharingLink = By.xpath("//a[contains(@class,'car-sharing')]");

	public WebElement getCarSharingLink() {
		return driver.findElement(CarSharingLink);
	}

	By CustomerManagementLink = By.xpath("//a[contains(text(),'Manage Customers')]");

	public WebElement getCustomerManagementLink() {
		return driver.findElement(CustomerManagementLink);
	}

	By LogoutBtn = By.xpath("//a[@class='logout']");

	public WebElement getLogoutBtn() {
		return driver.findElement(LogoutBtn);
	}

	By VehiclesLink = By.xpath("//a[@class='veicoli']");

	public WebElement getVehiclesLink() {
		return driver.findElement(VehiclesLink);
	}

	By CS_AssistantOwnerlink = By.xpath("//a[contains(text(),'Assistance Owner')]");

	public WebElement getCS_AssistantOwnerlink() {
		return driver.findElement(CS_AssistantOwnerlink);
	}

	By CS_Overviewlink = By.xpath("//a[contains(text(),'Overview')]");

	public WebElement getCS_Overviewlink() {
		return driver.findElement(CS_Overviewlink);
	}

	By CS_SEARCH_CUSTOMERIDENTIFICATIVE = By.xpath("//input[@id='customer_selection_customer']");

	public WebElement getCS_SEARCH_CUSTOMERIDENTIFICATIVE() {
		return driver.findElement(CS_SEARCH_CUSTOMERIDENTIFICATIVE);
	}

	By CS_CustomerSearchbtn = By.xpath("//button[@class='button search-button']//i[@class='fa fa-search']");

	public WebElement getCS_CustomerSearchbtn() {
		return driver.findElement(CS_CustomerSearchbtn);
	}

	By CS_ActivateUserbtn = By.xpath("//button[@id='customer_selection_submit']");

	public WebElement getCS_ActivateUserbtn() {
		return driver.findElement(CS_ActivateUserbtn);
	}
	By CS_DownloadLink = By.xpath("//a[contains(@class,'download-link')]");

	public WebElement getCS_DownloadLink() {
		return driver.findElement(CS_DownloadLink);
	}
	By CS_fleetmanagerList = By.xpath("//a[contains(@class,'cambia mb-10')]");

	public WebElement getCS_fleetmanagerList() {
		return driver.findElement(CS_fleetmanagerList);
	}
	By CS_Fleetmanagerresult = By.xpath("//a[contains(text(),'[1] Test automation')]");

	public WebElement getCS_Fleetmanagerresult() {
		return driver.findElement(CS_Fleetmanagerresult);
	}
	By CS_MultiparkingLink = By.xpath("//a[contains(text(),'Multiparking')]");

	public WebElement getCS_MultiparkingLink() {
		return driver.findElement(CS_MultiparkingLink);
	}
	By CS_ManageHubParkingLink = By.xpath("//a[contains(text(),'Manage Hub Parking Areas')]");

	public WebElement getCS_ManageHubParkingLink() {
		return driver.findElement(CS_ManageHubParkingLink);
	}
	By CS_MaintenanceBadgeLink = By.xpath("//a[contains(text(),'Maintenance badges')]");

	public WebElement getCS_MaintenanceBadgeLink() {
		return driver.findElement(CS_MaintenanceBadgeLink);
	}
	
	
	
	
	public void Click_CustomerServiceLink() throws Exception {
		cm.jseClick(getCS_link());
		LOG.info("Clicked on CS_link");
	}

	public void Click_CarsharingLink() throws Exception {
		cm.jseClick(getCarSharingLink());
		LOG.info("Car Sharing link clicked");
	}

	public void Click_CustomerManagementLink() throws Exception {
		cm.jseClick(getCustomerManagementLink());
		LOG.info("Customer management Link Clicked");
	}
	
	public void Click_MultiparkingLink() throws Exception {
		cm.jseClick(getCS_MultiparkingLink());
		LOG.info("Clicked on MULTIPARKING link");
	}
	
	public void Click_ManageHubParkingLink() throws Exception
	{
		cm.jseClick(getCS_ManageHubParkingLink());
		LOG.info("Clicked on ManageHubParking Link");
	}
	
	public void Click_VehiclesLink() throws Exception {
		cm.jseClick(getVehiclesLink());
		LOG.info("Vehicles Link Clicked");
	}

	public void click_AssistantOwnerLink() throws Exception {
		cm.jseClick(getCS_AssistantOwnerlink());
		LOG.info("Assistant owner link clicked");
	}
	public void click_maintenanceBadgeLink() throws Exception
	{
		cm.jseClick(getCS_MaintenanceBadgeLink());
		LOG.info("Maintenance Badge Link clicked");
		
	}

	public void click_OverviewLink() throws Exception {
		cm.jseClick(getCS_Overviewlink());
		LOG.info("Overview link clicked");
	}

	public void CSlogout() throws Exception {
		cm.ExplicitWaitelementclickable(getCS_link());
		cm.clickElement(getCS_link());
		cm.ExplicitWaitelementclickable(getLogoutBtn());
		cm.HighlightElement(getLogoutBtn());
		cm.jseClick(getLogoutBtn());
		LOG.info("Logout Sucessfull");
		driver.quit();

	}

	
	public void Activatecustomer(String customeractive) throws Exception {
		cm.jseClick(getCS_link());
		cm.jseClick(getCarSharingLink());
		cm.HighlightElement(getCS_fleetmanagerList());
		cm.jseClick(getCS_fleetmanagerList());
		LOG.info("Clicked on Fleet Manager List link");
		cm.FluientWait(CS_SEARCH_CUSTOMERIDENTIFICATIVE, 20,3);
		cm.typeTextToTextBox(getCS_SEARCH_CUSTOMERIDENTIFICATIVE(), customeractive);
		LOG.info("Customer name to searched is entered to the field ");
		cm.wait(3);
		cm.FluientWait(CS_Fleetmanagerresult, 20,3);
		cm.jseClick(getCS_Fleetmanagerresult());
		LOG.info("Customer search result is selected on partial search");
		//cm.jseClick(getCS_CustomerSearchbtn());
		//LOG.info("Clicked on search for customer button");
		cm.jseClick(getCS_ActivateUserbtn());
		LOG.info("Clicked on Activate user button");
		cm.wait(5);
	}

	public void validate_ListofFleetManager() throws Exception {
		List<WebElement> list_fleetmanager = driver.findElements(By.xpath("//tbody/tr"));

		for (int i = 0; i < list_fleetmanager.size(); i++) {
			WebElement fleetmanager = list_fleetmanager.get(i);
			cm.scrollToview(fleetmanager);
			cm.HighlightElement(fleetmanager);
			LOG.info("All the List fo fleet managers are Highlighted");	
		}
		cm.scrollToview(getCS_DownloadLink());
		cm.HighlightElement(getCS_DownloadLink());
		cm.jseClick(getCS_DownloadLink());
		cm.wait(5);
	}

}
