package com.ALD_CS.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ALD.Base.BaseDriver;
import com.ALD.Commons.CommonUtilities;

public class CS_CarSharing_CustomerManagementPageObjs extends BaseDriver {

	private static final Logger LOG = LogManager.getLogger(CS_CarSharing_CustomerManagementPageObjs.class);

	public CommonUtilities cm = new CommonUtilities();

	By Searchcustomerfield = By.xpath("//input[@id='customerSwitchMonoMultiParkingFilter_IdOrNameCustomer']");

	public WebElement getSearchcustomerfield() {
		return driver.findElement(Searchcustomerfield);
	}

	By Searchcustomerbtn = By.xpath("//button[@id='customerSwitchMonoMultiParkingFilter_submit']");

	public WebElement getSearchcustomerbtn() {
		return driver.findElement(Searchcustomerbtn);
	}

	By Carpooling_option = By.xpath("//input[@id='customers_customers_0_carPooling']");

	public WebElement getCarpooling_option() {
		return driver.findElement(Carpooling_option);
	}

	By CustomerManagement_Savebtn = By.xpath("//button[@id='customers_submit']");

	public WebElement getCustomerManagement_Savebtn() {
		return driver.findElement(CustomerManagement_Savebtn);
	}

	By MultiParking_option = By.xpath("//input[@id='customers_customers_0_multiParking']");

	public WebElement getMultiParking_option() {
		return driver.findElement(MultiParking_option);
	}

	By MultiParking_Departingvehiclesexists_Errormsg = By.xpath("//div[@class='alert-box alert']");

	public WebElement getMultiParking_Departingvehiclesexists_Errormsg() {
		return driver.findElement(MultiParking_Departingvehiclesexists_Errormsg);
	}

	public void searchCustomer(String Customername) throws Exception {
		cm.typeTextToTextBox(getSearchcustomerfield(), Customername);
		cm.clickElement(getSearchcustomerbtn());
		LOG.info("Customer searched");

	}

	public void carpooling_optionEnabled() throws Exception {
		String carpoolingopto = getCarpooling_option().getAttribute("checked");

		if (carpoolingopto != null) {
			LOG.info("CarPooling option ENABLED ALREADY for the customer");

		} else {
			cm.jseClick(getCarpooling_option());
			LOG.info("Carpooling option ENABLED NOW for the customer");

		}

		cm.jseClick(getCustomerManagement_Savebtn());
		cm.wait(3);
		LOG.info("Car pooling Changes made and SAVED");
	}

	public void carpooling_optionDisabled() throws Exception {
		String carpoolingopto = getCarpooling_option().getAttribute("checked");

		if (carpoolingopto == null) {
			LOG.info("CarPooling option DISABLED ALREADY for the customer");

		} else {
			cm.jseClick(getCarpooling_option());
			LOG.info("Carpooling option DIABLED NOW for the customer");

		}

		cm.jseClick(getCustomerManagement_Savebtn());
		cm.wait(3);
		LOG.info("Car pooling Changes made and SAVED");
	}

	public void MultiParking_optionEnable() throws Exception {

		String multiparkingopto = getMultiParking_option().getAttribute("checked");

		// System.out.println(multiparkingopto);

		if (multiparkingopto != null) {
			LOG.info("Multiparking option ENABLED ALREADY for the customer");
		} else {
			System.out.println("I came here");
			cm.jseClick(getMultiParking_option());
			LOG.info("MultiParking option ENABLED NOW for the customer");
		}

		cm.jseClick(getCustomerManagement_Savebtn());
		LOG.info("Multi Parking Option Changes made and SAVED");
		cm.wait(5);
	}

	public void MultiParking_optionDisable() throws Exception {

		String multiparkingopto = getMultiParking_option().getAttribute("checked");

		if (multiparkingopto == null) {
			LOG.info("Multiparking option DISABLED ALREADY for the customer");
		} else {
			cm.jseClick(getMultiParking_option());
			LOG.info("MultiParking option DISABLED NOW for the customer");
		}

		cm.jseClick(getCustomerManagement_Savebtn());
		LOG.info("Multi Parking Option Changes made and SAVED");
		cm.wait(5);
	}

	public void Verify_MultiParking_Departingvehiclesexists_Errormsg_Displayed() throws Exception {
		cm.WaitForTheVisibilityOfElement(getMultiParking_Departingvehiclesexists_Errormsg(), 10);
		cm.HighlightElement(getMultiParking_Departingvehiclesexists_Errormsg());
		String ErrorMsg_Departingvehicles = cm.getText(getMultiParking_Departingvehiclesexists_Errormsg());
		LOG.info(ErrorMsg_Departingvehicles + ": ERROR MESSAGE is displayed");
	}

}
