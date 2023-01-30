package com.ALD_FM.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ALD.Base.BaseDriver;
import com.ALD.Commons.CommonUtilities;

public class FM_HomepageObjs extends BaseDriver {

	private static final Logger LOG = LogManager.getLogger(FM_HomepageObjs.class);

	public CommonUtilities cm = new CommonUtilities();

	By FMmenu = By.xpath("//span[@class='label-menu']");

	public WebElement getFMmenu() {
		return driver.findElement(FMmenu);
	}

	By FMcarsharingfleetlink = By.xpath("//a[@class='carsharing a-level-1']");

	public WebElement getFMcarsharingfleetlink() {
		return driver.findElement(FMcarsharingfleetlink);
	}

	By FM_configurationlink = By.xpath("//a[contains(text(),'Configuration')]");

	public WebElement getFM_configurationlink() {
		return driver.findElement(FM_configurationlink);
	}

	By FM_settingslink = By.xpath("//a[@class='js-direct-link a-level-3']");

	public WebElement getFM_settingslink() {
		return driver.findElement(FM_settingslink);
	}

	By FM_profilelink = By.xpath("//span[contains(@class,'role')]");

	public WebElement getFM_profilelink() {
		return driver.findElement(FM_profilelink);
	}

	By FM_logoutbtn = By.xpath("//a[contains(text(),'Logout')]");

	public WebElement getFM_logoutbtn() {
		return driver.findElement(FM_logoutbtn);
	}

	By FM_fleetlink = By
			.xpath("//a[@class='js-mobile-alert car-sharing-configuration a-level-3'][contains(text(),'Fleet')]");

	public WebElement getFM_fleetlink() {
		return driver.findElement(FM_fleetlink);
	}

	By FM_parkingandHourslink = By.xpath("//a[contains(text(),'Parkings and hours')]");

	public WebElement getFM_parkingandHourslink() {
		return driver.findElement(FM_parkingandHourslink);
	}

	By FM_Groupsandsegmentslink = By.xpath("//a[contains(text(),'Groups and segments')]");

	public WebElement getFM_Groupsandsegmentslink() {
		return driver.findElement(FM_Groupsandsegmentslink);
	}

	By FM_Drivermanagementlink = By.xpath("//a[contains(text(),'Driver management')]");

	public WebElement getFM_Drivermanagementlink() {
		return driver.findElement(FM_Drivermanagementlink);
	}

	By FM_Monitoringlink = By.xpath("//a[contains(text(),'Monitoring')]");

	public WebElement getFM_Monitoringlink() {
		return driver.findElement(FM_Monitoringlink);
	}

	By FM_Fleetoverviewlink = By.xpath("//a[contains(text(),'Fleet overview')]");

	public WebElement getFM_Fleetoverviewlink() {
		return driver.findElement(FM_Fleetoverviewlink);
	}

	By FM_Badgeslink = By.xpath("//a[contains(text(),'Badge')]");

	public WebElement getFM_Badgeslink() {
		return driver.findElement(FM_Badgeslink);
	}
	By FM_CostCenterlink = By.xpath("//a[contains(text(),'Cost centers')]");

	public WebElement getFM_CostCenterlink() {
		return driver.findElement(FM_CostCenterlink);
	}
	By FM_GeneralFleetStatusLink = By.xpath("//a[contains(text(),'General fleet status')]");

	public WebElement getFM_GeneralFleetStatusLink() {
		return driver.findElement(FM_GeneralFleetStatusLink);
	}
	By FM_CurrentStatusOfParkingAreaLink = By.xpath("//a[contains(text(),'Current status of Parking Areas')]");

	public WebElement getFM_CurrentStatusOfParkingAreaLink() {
		return driver.findElement(FM_CurrentStatusOfParkingAreaLink);
	}
	By FM_AnalyticsLink = By.xpath("//a[contains(text(),'Analytics')]");

	public WebElement getFM_AnalyticsLink() {
		return driver.findElement(FM_AnalyticsLink);
	}
	By FM_TravelManagementLink = By.xpath("//a[contains(text(),'Travel management')]");

	public WebElement getFM_TravelManagementLink() {
		return driver.findElement(FM_TravelManagementLink);
	}
	By FM_TravelListLink = By.xpath("//a[contains(text(),'Travel list')]");

	public WebElement getFM_TravelListLink() {
		return driver.findElement(FM_TravelListLink);
	}
	
	
	
	
	
	
	public void click_carsharingfleetlink() throws Exception {
		cm.FluientWait(FMcarsharingfleetlink, 20,3);
		cm.jseClick(getFMcarsharingfleetlink());
		LOG.info("Clicked on Car Sharing fleet Link on FleetManager Menu");
	}

	public void click_configurationlink() throws Exception {
		cm.FluientWait(FM_configurationlink, 20,3);
		cm.jseClick(getFM_configurationlink());
		cm.wait(3);
		LOG.info("Clicked on configuration Link on FleetManager Menu");
	}
	

	public void click_settingslink() throws Exception {
		cm.FluientWait(FM_settingslink, 20,3);
		cm.jseClick(getFM_settingslink());
		cm.wait(3);
		LOG.info("Clicked on settings Link on FleetManager Menu");
	}

	public void click_fleetlink() throws Exception {
		cm.FluientWait(FM_fleetlink, 20,3);
		cm.jseClick(getFM_fleetlink());
		LOG.info("Clicked on Fleet link under configuration");
	}

	public void click_parkingandHoursLink() throws Exception {
		cm.FluientWait(FM_parkingandHourslink, 20,3);
		cm.jseClick(getFM_parkingandHourslink());
		LOG.info("Clicked on Parking and Hours link");
	}

	public void click_groupsandSegmentsLink() throws Exception {
		cm.FluientWait(FM_Groupsandsegmentslink, 20,3);
		cm.jseClick(getFM_Groupsandsegmentslink());
		LOG.info("Clicked on Groups and Segments link");
	}

	public void click_BadgesLink() throws Exception {
		cm.FluientWait(FM_Badgeslink, 20,3);
		cm.jseClick(getFM_Badgeslink());
		LOG.info("Clicked on Badges link");

	}
	public void click_CostcenterLink() throws Exception
	{
		cm.FluientWait(FM_CostCenterlink, 10,3);
		cm.jseClick(getFM_CostCenterlink());
		LOG.info("Clicked on Cost Center link");
	}

	public void click_DrivermanagementLink() throws Exception {
		cm.FluientWait(FM_Drivermanagementlink, 20,3);
		cm.jseClick(getFM_Drivermanagementlink());
		LOG.info("Clicked on DriverManagement Link");

	}

	public void click_FleetoverviewLink() throws Exception {
		
		cm.FluientWait(FM_Fleetoverviewlink, 20,3);
		cm.jseClick(getFM_Fleetoverviewlink());
		LOG.info("Clicked on Fleet overview Link");

	}
	
	public void click_AnalyticsLink() throws Exception
	{
		cm.FluientWait(FM_AnalyticsLink, 20,3);
		cm.jseClick(getFM_AnalyticsLink());
		LOG.info("Clicked on Analytics link");
	}
	
	public void click_MonitoringLink() throws Exception
	{
		cm.FluientWait(FM_Monitoringlink, 20,3);
		cm.jseClick(getFM_Monitoringlink());
		LOG.info("Clicks on MonitoringLink");
	}
	
	public void click_GeneralFleetStatusLink() throws Exception
	{	
		cm.FluientWait(FM_GeneralFleetStatusLink, 10,3);
		cm.jseClick(getFM_GeneralFleetStatusLink());
		LOG.info("Clicked on General Fleet status Link");
	}
	public void click_FM_CurrentStatusOfParkingAreaLink() throws Exception {
		cm.FluientWait(FM_CurrentStatusOfParkingAreaLink, 10,3);
		cm.jseClick(getFM_CurrentStatusOfParkingAreaLink());
		LOG.info("Clicked on Current Status Of Parking Area Link");
	}
	
	public void click_FM_TravelManagementLink() throws Exception
	{
		cm.FluientWait(FM_TravelManagementLink, 20,3);
		cm.jseClick(getFM_TravelManagementLink());
		LOG.info("Clicked on TravelManagement Link");
	}
	
	public void click_FM_TravelListLink() throws Exception
	{
		cm.FluientWait(FM_TravelListLink, 20,3);
		cm.jseClick(getFM_TravelListLink());
		LOG.info("Clicked on TravelList Link");
	}

	public void FMLogout() throws Exception {
		cm.jseClick(getFM_profilelink());
		cm.ExplicitWaitelementclickable(getFM_logoutbtn());
		cm.HighlightElement(getFM_logoutbtn());
		cm.jseClick(getFM_logoutbtn());
		LOG.info("Logout Successful as FleetManager");
		driver.quit();
	}

}
