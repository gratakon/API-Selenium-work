package com.ALD_CSM.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ALD.Base.BaseDriver;
import com.ALD.Commons.CommonUtilities;

public class CSM_CustomerManagerUsersPageObjs extends BaseDriver {

	private static final Logger LOG = LogManager.getLogger(CSM_CustomerManagerUsersPageObjs.class);

	public CommonUtilities cm = new CommonUtilities();

	By CSM_AddUsersbtn = By.xpath("//a[@id='onErrorShowModal']");

	public WebElement getCSM_AddUsersbtn() {
		return driver.findElement(CSM_AddUsersbtn);
	}

	By CSM_popupCancelbtn = By.xpath(
			"//form[contains(@name,'create_cs_operator')]//a[contains(@class,'button white-bordered js-overlayer-embed-close')][contains(text(),'CANCEL')]");

	public WebElement getCSM_popupCancelbtn() {
		return driver.findElement(CSM_popupCancelbtn);
	}

	By CSM_popupName = By.xpath("//input[@id='create_cs_operator_name']");

	public WebElement getCSM_popupName() {
		return driver.findElement(CSM_popupName);
	}

	By CSM_popupSurName = By.xpath("//input[@id='create_cs_operator_lastName']");

	public WebElement getCSM_popupSurName() {
		return driver.findElement(CSM_popupSurName);
	}

	By CSM_popupEmail = By.xpath("//input[@id='create_cs_operator_email']");

	public WebElement getCSM_popupEmail() {
		return driver.findElement(CSM_popupEmail);
	}

	By CSM_popupSave = By.xpath("//button[@id='create_cs_operator_submit']");

	public WebElement getCSM_popupSave() {
		return driver.findElement(CSM_popupSave);
	}

	By CSM_CMsearch = By.xpath("//input[@id='filter_cs_operator_search']");

	public WebElement getCSM_CMsearch() {
		return driver.findElement(CSM_CMsearch);
	}

	By CSM_CMsearchbtn = By.xpath("//button[@id='filter_cs_operator_submit']");

	public WebElement getCSM_CMsearchbtn() {
		return driver.findElement(CSM_CMsearchbtn);
	}

	By CSM_CMDeletebtn = By.xpath("//td[contains(text(),'kiranguru488@gmail.com')]/following::td[3]/a/i");

	public WebElement getCSM_CMDeletebtn() {
		return driver.findElement(CSM_CMDeletebtn);
	}

	By CSM_CMconfirmDeletebtn = By.xpath("//a[contains(@class,'button js-url-destination')]");

	public WebElement getCSM_CMconfirmDeletebtn() {
		return driver.findElement(CSM_CMconfirmDeletebtn);
	}

	By CSM_CMconfirmationMSG = By.xpath("//div[contains(@class,'alert-box success')]");

	public WebElement getCSM_CMconfirmationMSG() {
		return driver.findElement(CSM_CMconfirmationMSG);
	}
	By CSM_CMcanceldeletionbtn = By.xpath("//div[@class='modal loaded']//a[@class='button white-bordered js-overlayer-embed-close'][contains(text(),'CANCEL')]");

	public WebElement getCSM_CMcanceldeletionbtn() {
		return driver.findElement(CSM_CMcanceldeletionbtn);
	}
	
	public void add_Customeroperator() throws Exception {
		cm.jseClick(getCSM_AddUsersbtn());
		cm.wait(3);

	}

	public void cancel_Customeroperator() throws Exception {
		cm.HighlightElement(getCSM_popupCancelbtn());
		cm.jseClick(getCSM_popupCancelbtn());
		cm.wait(3);
		LOG.info("Clicked on POPUP Cancel button");
		
	}

	public void add_NewcustomerOperator(String name,String surname,String emailID) throws Exception {
		cm.jseClick(getCSM_AddUsersbtn());
		cm.jseTypeText(getCSM_popupName(), name);
		cm.jseTypeText(getCSM_popupSurName(), surname);
		cm.jseTypeText(getCSM_popupEmail(), emailID);
		LOG.info("Customer Operator details entered properly");
		cm.HighlightElement(getCSM_popupSave());
		cm.jseClick(getCSM_popupSave());
		LOG.info("Clicked on Customer operator SAVE button");
		cm.FluientWait(CSM_CMconfirmationMSG, 20,3);
		cm.HighlightElement(getCSM_CMconfirmationMSG());
		cm.validateTextMessage(getCSM_CMconfirmationMSG(), "The Customer Service account was successfully created");
		LOG.info("Customer Operator creation confirmation message displayed");

	}

	public void search_CustomerOperator(String Customeroperator) throws Exception {
		cm.jseTypeText(getCSM_CMsearch(), Customeroperator);
		cm.jseClick(getCSM_CMsearchbtn());
	    cm.FluientWait(CSM_CMDeletebtn, 20,3);
		cm.scrollToview(getCSM_CMDeletebtn());
		LOG.info("Customer search result sucessfully");
	}

	public void delete_CustomerOperator() throws Exception {
		cm.FluientWait(CSM_CMDeletebtn, 20,3);
		cm.scrollToview(getCSM_CMDeletebtn());
		cm.jseClick(getCSM_CMDeletebtn());
		LOG.info("Clicked on delete button");
		cm.jseClick(getCSM_CMcanceldeletionbtn());
		LOG.info("Clicked on Cancel deletion button");
		cm.jseClick(getCSM_CMDeletebtn());
		LOG.info("Again clicked on Delete button of the customer operator");
		cm.FluientWait(CSM_CMconfirmDeletebtn, 20,3);
		cm.HighlightElement(getCSM_CMconfirmDeletebtn());
		cm.jseClick(getCSM_CMconfirmDeletebtn());
		LOG.info("Clicked on delete customer confirmation button");
		cm.FluientWait(CSM_CMconfirmationMSG, 20,3);
		cm.HighlightElement(getCSM_CMconfirmationMSG());
		cm.validateTextMessage(getCSM_CMconfirmationMSG(), "Operator deleted");
		LOG.info("Customer Deleted sucessfully, Deleation message displayed correctly");
	}

}