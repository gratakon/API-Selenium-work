package com.ALD_Driver.pageObjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ALD.Base.BaseDriver;
import com.ALD.Commons.CommonUtilities;

public class Driver_BookingPageObjs extends BaseDriver {

	private static final Logger LOG = LogManager.getLogger(Driver_BookingPageObjs.class);

	public CommonUtilities cm = new CommonUtilities();

	By Driver_Leavenowbtn = By.xpath("//button[contains(text(),'Take your car now')]");

	public WebElement getD_Leavenowbtn() {
		return driver.findElement(Driver_Leavenowbtn);
	}

	By Driver_Businesstypebtn = By.xpath("//label[contains(@class,'selectedBusiness')]");

	public WebElement getD_Businesstypebtn() {
		return driver.findElement(Driver_Businesstypebtn);
	}

	By D_Monoparkingtypebtn = By.xpath("//button[contains(text(),'Book a trip')]");

	public WebElement getD_Monoparkingtypebtn() {
		return driver.findElement(D_Monoparkingtypebtn);
	}

	By D_wheregoingfield = By.xpath("//input[@placeholder='search']");

	public WebElement getD_wheregoingfield() {
		return driver.findElement(D_wheregoingfield);
	}

	By D_departuredropdown = By.xpath("//select[contains(@name,'parcheggioIniziale')]");

	public WebElement getD_departuredropdown() {
		return driver.findElement(D_departuredropdown);
	}
	By D_departuredropdown1 = By.xpath("//select[@name='parcheggioIniziale']");

	public WebElement getD_departuredropdown1() {
		return driver.findElement(D_departuredropdown1);
	}
	

	By D_GoingTodropdown = By.xpath("//select[contains(@name,'parcheggioFinale')]");

	public WebElement getD_GoingTodropdown() {
		return driver.findElement(D_GoingTodropdown);
	}

	By D_departureDate = By.xpath("//div[contains(@class,'vdp-datepicker input-date')]");

	public WebElement getD_departureDate() {
		return driver.findElement(D_departureDate);
	}

	By D_Nextbtn = By.xpath("//span[contains(text(),'Next')]");

	public WebElement getD_Nextbtn() {
		return driver.findElement(D_Nextbtn);
	}

	By D_bookingtimefield = By
			.xpath("//div[contains(@class,'row')]//div[1]//div[1]//div[2]//div[1]//span[1]//input[1]");

	public WebElement getD_bookingtimefield() {
		return driver.findElement(D_bookingtimefield);
	}

	By D_bookCarbtn = By.xpath("//button[contains(text(),'Book a car')]");

	public WebElement getD_bookCarbtn() {
		return driver.findElement(D_bookCarbtn);
	}

	By D_citycarbtn = By.xpath("//span[contains(text(),'Citycar')]");

	public WebElement getD_citycarbtn() {
		return driver.findElement(D_citycarbtn);
	}

	By D_Sedancarbtn = By.xpath("//span[contains(text(),'Sedan')]");

	public WebElement getD_Sedancarbtn() {
		return driver.findElement(D_Sedancarbtn);
	}

	By D_ConvertibleSpidercarbtn = By.xpath("//span[contains(text(),'Convertible and spider')]");

	public WebElement getD_ConvertibleSpidercarbtn() {
		return driver.findElement(D_ConvertibleSpidercarbtn);
	}

	By D_forwardbtn = By.xpath("//button[contains(@class,'booking-wizard-nav__item')]");

	public WebElement getD_forwardbtn() {
		return driver.findElement(D_forwardbtn);
	}

	By D_tripreferencefield = By.xpath("//textarea[contains(@placeholder,'Enter trip reference*')]");

	public WebElement getD_tripreferencefield() {
		return driver.findElement(D_tripreferencefield);
	}

	By D_confirmbtn = By.xpath("//button[contains(text(),'Confirm booking')]");

	public WebElement getD_confirmbtn() {
		return driver.findElement(D_confirmbtn);
	}

	By D_GoTo_myTripslink = By.xpath("//button[contains(text(),'Go to my trips')]");

	public WebElement getD_GoTo_myTripslink() {
		return driver.findElement(D_GoTo_myTripslink);
	}
	By D_PriavteBookingoption = By.xpath("//div[@class='switch-booking-type-container']//label[1]");

	public WebElement getD_PriavteBookingoption() {
		return driver.findElement(D_PriavteBookingoption);
	}
	By D_NoVehiclesAvailableMsg = By.xpath("//span[contains(text(),'No vehicles are available for the selected dates')]");

	public WebElement getD_NoVehiclesAvailableMsg() {
		return driver.findElement(D_NoVehiclesAvailableMsg);
	}
	
	public void validateLeaveNowOption_enabled() throws Exception {
		cm.FluientWait(Driver_Leavenowbtn, 30,3);
		cm.validateElementDisplayed(getD_Leavenowbtn());
		cm.HighlightElement(getD_Leavenowbtn());
		LOG.info("LEAVE NOW button is present MultiParking option is Enabled for the driver");
	}

	public void validateLeaveNowOption_disabled() throws Exception {
		cm.validateElementNotDisplayed(Driver_Leavenowbtn);
		LOG.info("Multiparking option is not displayed as expected");
		cm.ExplicitWaitForVisiBility(getD_Businesstypebtn());
		cm.validateElementDisplayed(getD_Businesstypebtn());
		cm.HighlightElement(getD_Businesstypebtn());
		LOG.info("Only MonoParking option is displayed - Multiparking option disabled");
	}
	public void Select_PrivatebookingOption() throws Exception
	{
		cm.FluientWait(D_PriavteBookingoption, 10,3);
		cm.HighlightElement(getD_PriavteBookingoption());
		cm.jseClick(getD_PriavteBookingoption());
		LOG.info("Clicked on Private booking tab");
	}

	public void optforMonoparking() {
		cm.FluientWait(D_Monoparkingtypebtn, 10,3);
		cm.HighlightElement(getD_Monoparkingtypebtn());
		cm.click(getD_Monoparkingtypebtn());
		LOG.info("MonoParking option is selected");
	}

	public void enterGoingtoandDestination(String goingplace, String destinationplace) throws InterruptedException {
		cm.jseTypeText(getD_wheregoingfield(), goingplace);
		LOG.info("The Going to option for the trip is provided");
		cm.click(getD_departuredropdown());
		cm.selectDropDown_text(getD_departuredropdown(), destinationplace);
		LOG.info("The Destionation option for the trip is provided");
	}

	public void BookingStartdateandTime(String startmonth, String date, String hours, String minutes) throws Exception {

		cm.scrollToview(getD_departureDate());
		cm.HighlightElement(getD_departureDate());
		cm.clickElement((getD_departureDate()));
		while (true) {
			String text = driver.findElement(By.xpath(
					"(//div[contains(@class,'vdp-datepicker input-date')]//following::span[contains(@class,'day__month_btn up')])[1]"))
					.getText();
			System.out.println(text);

			if (text.equals(startmonth)) {
				break;
			}

			else {
				driver.findElement(By.xpath(
						"//div[contains(@class,'vdp-datepicker input-date')]//following::span[contains(@class,'day__month_btn up')]//following::span[contains(@class,'next')]"))
						.click();
			}
		}

		driver.findElement(By.xpath(
				"//body//div//div//div//div//div//div//div//div//div[1]//div[1]//div[2]//div[1]//div[1]//span[contains(text(),"
						+ date + ")]"))
				.click();
		cm.jseClick(getD_bookingtimefield());

		driver.findElement(
				By.xpath("//div[contains(@class,'trip-details-box__field')]//div[2]//div[1]//ul[1]//li[contains(text(),"
						+ hours + ")]"))
				.click();
		driver.findElement(
				By.xpath("//div[contains(@class,'trip-details-box__field')]//div[2]//div[1]//ul[2]//li[contains(text(),"
						+ minutes + ")]"))
				.click();

		cm.jseClick(getD_Nextbtn());
	}
		
		public void Click_BookACarbBtn() throws Exception
		{
			cm.FluientWait(D_bookCarbtn, 20,3);
			cm.HighlightElement(getD_bookCarbtn());
			cm.jseClick(getD_bookCarbtn());
			cm.wait(5);
		}
		

	public void verifycarcategory() throws Exception {

		List<WebElement> vehicleslist = driver.findElements(By.xpath("//ul[@class='segment-list']//li"));

		for (int i = 0; i < vehicleslist.size(); i++) {

			String vehicleslistenabled = vehicleslist.get(i).getAttribute("class");
			if (vehicleslistenabled.contains("disabled")) {
				LOG.info(vehicleslist.get(i).getText() + " --------------> is DISABLED");
			} else {
				LOG.info(vehicleslist.get(i).getText() + " --------------> is ENABLED");
			}
		}
		cm.FluientWait(D_ConvertibleSpidercarbtn, 20,3);
		cm.scrollToview(getD_ConvertibleSpidercarbtn());
		cm.HighlightElement(getD_ConvertibleSpidercarbtn());
		cm.jseClick(getD_ConvertibleSpidercarbtn());
		cm.movepageup();

	}
	
	public void click_forwardButton() throws Exception
	{
		cm.scrollToview(getD_forwardbtn());
		LOG.info("Moved to element FORWARD button");
		cm.jseClick(getD_forwardbtn());
		LOG.info("Clicked on Forward button");
	}

	public void clickVehicle_moveforward() throws Exception {
		cm.scrollToview(getD_Sedancarbtn());
		LOG.info("Moved to City car type vehicle");
		cm.HighlightElement(getD_Sedancarbtn());
		LOG.info("City car option Highlighted");
		cm.jseClick(getD_Sedancarbtn());
		LOG.info("Clicked on City car type option");
		cm.scrollToview(getD_forwardbtn());
		LOG.info("Moved to element FORWARD button");
		cm.jseClick(getD_forwardbtn());
		LOG.info("Clicked on Forward button");
	}

	public void enterReason_confirmbooking() throws Exception {
		cm.pageUp();
		cm.scrollToview(getD_tripreferencefield());
		cm.jseClick(getD_tripreferencefield());
		cm.jseTypeText(getD_tripreferencefield(), "This is the trip reason");
		cm.scrollToview(getD_confirmbtn());
		cm.jseClick(getD_confirmbtn());
		cm.movepageup();

		try {
			cm.FluientWait(D_GoTo_myTripslink, 30,3);
			cm.scrollToview(getD_GoTo_myTripslink());
			cm.HighlightElement(getD_GoTo_myTripslink());
			LOG.info("Trip Booking is sucessfull");
		} catch (Exception e) {
			// TODO: handle exception
			LOG.error("Trip Booking is failed due to some reason");
		}
	}

	public void OptforMultiparking() throws Exception {
		cm.HighlightElement(getD_Leavenowbtn());
		cm.jseClick(getD_Leavenowbtn());
		LOG.info("Multiparking option selected");
	}

	public void selectTo_FROM_Multiparking(String Departureplace, String GoingToplace) throws Exception {
		cm.FluientWait(D_departuredropdown, 20,3);
		cm.jseClick(getD_departuredropdown());
		cm.wait(5);
		cm.selectDropDown_text(getD_departuredropdown(), Departureplace);
		LOG.info("Departure from place is selected");
		cm.jseClick(getD_GoingTodropdown());
		cm.selectDropDown_text(getD_GoingTodropdown(), GoingToplace);
		LOG.info("Going to place is selected");
		cm.jseClick(getD_Nextbtn());
		LOG.info("Clicked on NEXT button");
	}
	public void verify_VehiclesNotAvailableMsg() throws Exception
	{
		cm.FluientWait(D_NoVehiclesAvailableMsg, 10,3);
		cm.verifyElementDisplayed(getD_NoVehiclesAvailableMsg());
		cm.scrollToview(getD_NoVehiclesAvailableMsg());
		cm.HighlightElement(getD_NoVehiclesAvailableMsg());
		LOG.info("NO Vehicles are available for the provided period of time slot message displayed sucessfully");
		
	}

}
