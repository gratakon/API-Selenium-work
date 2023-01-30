package com.ALD_CS.pageObjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ALD.Base.BaseDriver;
import com.ALD.Commons.CommonUtilities;

public class CS_CarSharing_AllVehiclesPageObjs extends BaseDriver {

	private static final Logger LOG = LogManager.getLogger(CS_CarSharing_AllVehiclesPageObjs.class);

	public CommonUtilities cm = new CommonUtilities();

	By Vehicles_Searchfield = By
			.xpath("//input[@id='customer_service_vehicles_filter_plateOrBrandOrModelOrPublicNumber']");

	public WebElement getVehicles_Searchfield() {
		return driver.findElement(Vehicles_Searchfield);
	}

	By Vehicles_Searchbtn = By.xpath("//button[@id='customer_service_vehicles_filter_submit']");

	public WebElement getVehicles_Searchbtn() {
		return driver.findElement(Vehicles_Searchbtn);
	}

	By Maintaince_reasonfield = By.xpath("//select[@id='vehicle_maintenance_reasonChoices']");

	public WebElement getMaintaince_reasonfield() {
		return driver.findElement(Maintaince_reasonfield);
	}

	By Maintaince_startdate = By.xpath("//input[@id='vehicle_maintenance_startDate']");

	public WebElement getMaintaince_startdate() {
		return driver.findElement(Maintaince_startdate);
	}

	By Maintaince_starttime = By.xpath("//select[@id='vehicle_maintenance_startTime']");

	public WebElement getMaintaince_starttime() {
		return driver.findElement(Maintaince_starttime);
	}

	By Maintaince_save = By.xpath("//button[@id='vehicle_maintenance_submit']");

	public WebElement getMaintaince_save() {
		return driver.findElement(Maintaince_save);
	}

	By Maintaince_Selectstartdate = By.xpath("//td[@class='today active day']");

	public WebElement getMaintaince_Selectstartdate() {
		return driver.findElement(Maintaince_Selectstartdate);
	}

	By Maintaince_enddate = By.xpath("//input[@id='vehicle_maintenance_endDate']");

	public WebElement getMaintaince_enddate() {
		return driver.findElement(Maintaince_enddate);
	}

	By Maintaince_Selectenddate = By.xpath("//td[@class='today active day']");

	public WebElement getMaintaince_Selectenddate() {
		return driver.findElement(Maintaince_Selectenddate);
	}

	By Maintaince_endtime = By.xpath("//select[@id='vehicle_maintenance_endTime']");

	public WebElement getMaintaince_endtime() {
		return driver.findElement(Maintaince_endtime);
	}

	By Maintaince_sucessmsg = By.xpath("//div[@class='alert-box info']");

	public WebElement getMaintaince_sucessmsg() {
		return driver.findElement(Maintaince_sucessmsg);
	}

	By Maintaince_Failuremsg = By.xpath("//div[@class='alert-box alert']");

	public WebElement getMaintaince_Failuremsg() {
		return driver.findElement(Maintaince_Failuremsg);
	}
	By CS_CustomerselectDropdown = By.xpath("//select[@id='customer_service_vehicles_filter_customerId']");

	public WebElement getCS_CustomerselectDropdown() {
		return driver.findElement(CS_CustomerselectDropdown);
	}
	By CS_VehicleStatusselectDropdown = By.xpath("//select[@id='customer_service_vehicles_filter_vehicleStatus']");

	public WebElement getCS_VehicleStatusselectDropdown() {
		return driver.findElement(CS_VehicleStatusselectDropdown);
	}
	By CS_DownloadVehicleresults = By.xpath("//i[@class='fa fa-file-excel-o']");

	public WebElement getCS_DownloadVehicleresults() {
		return driver.findElement(CS_DownloadVehicleresults);
	}
	By CS_VehiclemaintainceReasonOthers = By.xpath("//input[@id='vehicle_maintenance_reason']");

	public WebElement getCS_VehiclemaintainceReasonOthers() {
		return driver.findElement(CS_VehiclemaintainceReasonOthers);
	}
	By CS_VehicleEndTripRadioBtn = By.xpath("//input[@id='vehicle_end_trip_check_endTripWithoutKeyCheck_0']");

	public WebElement getCS_VehicleEndTripRadioBtn() {
		return driver.findElement(CS_VehicleEndTripRadioBtn);
	}
	
	
	
	

	public void search_vehicle_ClickViewButton(String Vehiclenumber) throws Exception {
		cm.jseTypeText(getVehicles_Searchfield(), Vehiclenumber);
		cm.jseClick(getVehicles_Searchbtn());
		cm.wait(3);

		driver.findElement(By.xpath("//td[contains(text()," + Vehiclenumber
				+ ")]/following::a[contains(@class,'list-command details f-n')]")).click();

		LOG.info("Vehicle Search sucessfull");
		cm.wait(5);

	}
	public void search_vehicle(String Vehiclenumber) throws Exception {
		cm.jseTypeText(getVehicles_Searchfield(), Vehiclenumber);
		cm.jseClick(getVehicles_Searchbtn());
		cm.wait(3);
		List<WebElement> Searchresultscount = driver.findElements(By.xpath("//table[@class='table-cs-index']/tbody/tr"));
		LOG.info("No. of search results displayed is : "+ Searchresultscount.size());
		
		List<WebElement> Searchresults = driver.findElements(By.xpath("//table[@class='table-cs-index']/tbody/tr/td"));
		for(WebElement results : Searchresults)
			LOG.info(results.getText());	
	}
	public void SearchVehicle_Filter_MultipleCriteria(String Customer,String Vehiclenumber,String vehiclestatus) throws Exception
	{
		cm.jseClick(getCS_CustomerselectDropdown());
		cm.selectDropDown_text(getCS_CustomerselectDropdown(), Customer);
		LOG.info(Customer+" Selected from Customer Dropdown");
		cm.jseClick(getCS_VehicleStatusselectDropdown());
		cm.selectDropDown_text(getCS_VehicleStatusselectDropdown(), vehiclestatus);
		LOG.info(vehiclestatus+" Selected from Customer Dropdown");
		search_vehicle(Vehiclenumber);

	}
	public void Click_DownloadVehicleresults() throws Exception
	{
		cm.scrollToview(getCS_DownloadVehicleresults());
		cm.HighlightElement(getCS_DownloadVehicleresults());
		cm.jseClick(getCS_DownloadVehicleresults());
		LOG.info("Clicked on Download button for Vehicle results");
	}

	public void Select_StartdateTime(String startmonth, String startday, String starttime) throws Exception {

		cm.moveToObject(getMaintaince_save());
		cm.HighlightElement(getMaintaince_startdate());
		cm.clickElement(getMaintaince_startdate());

		while (true) {
			String text = driver.findElement(By.xpath("/html[1]/body[1]/div[7]/div[1]/table[1]/thead[1]/tr[1]/th[2]"))
					.getText();
			System.out.println(text);

			if (text.equals(startmonth)) {
				break;
			}

			else {
				driver.findElement(By.xpath("/html[1]/body[1]/div[7]/div[1]/table[1]/thead[1]/tr[1]/th[3]")).click();
			}
		}

		driver.findElement(By.xpath(
				"//div[contains(@class,'datepickerBootstrap date-dropdown datepickerBootstrap-orient-left datepickerBootstrap-orient-top')]//tr//td[contains(text(),"
						+ startday + ")]"))

				.click();

		cm.selectDropdown(getMaintaince_starttime(), starttime);

		LOG.info("Vehicle Maintaince Start date and time provided");

	}

	public void Select_EnddateTime(String endmonth, String endday, String endtime) {

		cm.HighlightElement(getMaintaince_enddate());
		cm.clickElement(getMaintaince_enddate());

		while (true) {
			String text = driver.findElement(By.xpath("/html[1]/body[1]/div[7]/div[1]/table[1]/thead[1]/tr[1]/th[2]"))
					.getText();
			System.out.println(text);

			if (text.equals(endmonth)) {
				break;
			}

			else {
				driver.findElement(By.xpath("/html[1]/body[1]/div[7]/div[1]/table[1]/thead[1]/tr[1]/th[3]")).click();
			}
		}

		driver.findElement(By.xpath(
				"//div[contains(@class,'datepickerBootstrap date-dropdown datepickerBootstrap-orient-left datepickerBootstrap-orient-top')]//tr//td[contains(text(),"
						+ endday + ")]"))

				.click();
		cm.selectDropdown(getMaintaince_endtime(), endtime);
		LOG.info("Vehicle Maintaince End date and time provided");

	}

	public void select_MaintainceReason(String MaintainceReason) throws Exception {
		cm.jseClick(getMaintaince_reasonfield());
		cm.selectDropdown(getMaintaince_reasonfield(), MaintainceReason);
		if(MaintainceReason.equals("Other                "))
		{
			cm.FluientWait(CS_VehiclemaintainceReasonOthers, 10,3);
			cm.typeTextToTextBox(getCS_VehiclemaintainceReasonOthers(), "This is a other reason");
			LOG.info("Vehicle maintaince reason provided by choosing others as option");
		}
		else
		{
			LOG.info("Vehicle maintaince reason provided");
		}
		LOG.info("Vehicle maintaince reason provided");
		cm.wait(10);
		cm.clickElement(getMaintaince_save());
		LOG.info("Clicked on Submit Maintaince");
		cm.wait(3);
		cm.validateElementDisplayed(getMaintaince_sucessmsg());
		cm.HighlightElement(getMaintaince_sucessmsg());
		LOG.info("Vehicle Maintaince request sucessfull Message displayed");
		System.out.println(cm.getText(getMaintaince_sucessmsg()));
		
		//LOG.info("Vehicle Maintaince request is not sucessfull see below message for Error");
		//System.out.println(cm.getText(getMaintaince_Failuremsg()));
		}
	public void Verify_VehicleMaintainceReasonOptions() throws Exception
	{
		cm.FluientWait(Maintaince_reasonfield, 10,3);
		cm.jseClick(getMaintaince_reasonfield());
		cm.Print_AllDropdownValues(Maintaince_reasonfield);
		cm.scrollToview(getMaintaince_reasonfield());
		LOG.info("Vehicle maintaince reason provided");
	}
	
	public void Click_VehicelEndTripRadioBtn() throws Exception
	{
		cm.FluientWait(CS_VehicleEndTripRadioBtn, 10,3);
		cm.scrollToview(getCS_VehicleEndTripRadioBtn());
		cm.HighlightElement(getCS_VehicleEndTripRadioBtn());
		cm.jseClick(getCS_VehicleEndTripRadioBtn());
		
	}

	}

