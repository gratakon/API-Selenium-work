package com.ALD_CS.pageObjects;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ALD.Base.BaseDriver;
import com.ALD.Commons.CommonUtilities;

public class CS_MultiparkingPageObjs extends BaseDriver {

	private static final Logger LOG = LogManager.getLogger(CS_MultiparkingPageObjs.class);

	public CommonUtilities cm = new CommonUtilities();

	By CS_SearchParkingAreaField = By.xpath("//input[@placeholder='Search for parking area']");

	public WebElement getCS_SearchParkingAreaField() {
		return driver.findElement(CS_SearchParkingAreaField);
	}
	By CS_Threedotsbutton = By.xpath("//span[contains(@class,'park-item__tools')]//span[1]");

	public WebElement getCS_Threedotsbutton() {
		return driver.findElement(CS_Threedotsbutton);
	}
	By CS_Editbutton = By.xpath("//button[contains(text(),'Edit')]");

	public WebElement getCS_Editbutton() {
		return driver.findElement(CS_Editbutton);
	}
	By CS_EditHubParkingLable = By.xpath("//div[contains(text(),'Edit hub parking area')]");

	public WebElement getCS_EditHubParkingLable() {
		return driver.findElement(CS_EditHubParkingLable);
	}
	By CS_removebutton = By.xpath("//button[contains(@class,'park-item__tool-box__button white-bordered js-overlayer-embed-open')]");

	public WebElement getCS_removebutton() {
		return driver.findElement(CS_removebutton);
	}
	By CS_CancelbuttonPopup = By.xpath("//a[contains(@class,'button white-bordered mb-0 js-overlayer-embed-close')]");

	public WebElement getCS_CancelbuttonPopup() {
		return driver.findElement(CS_CancelbuttonPopup);
	}
	By CS_Confirmbuttonpopup = By.xpath("//a[contains(@class,'button mb-0 js-overlayer-embed-close')]");

	public WebElement getCS_Confirmbuttonpopup() {
		return driver.findElement(CS_Confirmbuttonpopup);
	}
	By CS_EditpencileBtn = By.xpath("//span[@class='shared-parkings__edit-park__content__edit pointer']");

	public WebElement getCS_EditpencileBtn() {
		return driver.findElement(CS_EditpencileBtn);
	}
	By CS_CompanynameSearchfield = By.xpath("//input[@id='autosuggest__input']");

	public WebElement getCS_CompanynameSearchfield() {
		return driver.findElement(CS_CompanynameSearchfield);
	}
	By CS_SaveparkingareaBtn = By.xpath("//button[contains(text(),'Save parking area')]");

	public WebElement getCS_SaveparkingareaBtn() {
		return driver.findElement(CS_SaveparkingareaBtn);
	}
	By CS_CancelParkingassociationBtn = By.xpath("//button[@class='white-bordered']");

	public WebElement getCS_CancelParkingassociationBtn() {
		return driver.findElement(CS_CancelParkingassociationBtn);
	}
	By CS_AddnewParkingBtn = By.xpath("//a[@class='mb-0 button']");

	public WebElement getCS_AddnewParkingBtn() {
		return driver.findElement(CS_AddnewParkingBtn);
	}
	By CS_Addressfield = By.xpath("//input[@placeholder='Input a position']");

	public WebElement getCS_Addressfield() {
		return driver.findElement(CS_Addressfield);
	}
	By CS_TotalParkingSpacesAvailableField = By.xpath("//input[@placeholder='numero posti']");

	public WebElement getCS_TotalParkingSpacesAvailableField() {
		return driver.findElement(CS_TotalParkingSpacesAvailableField);
	}
	
	
	
	public void Search_for_parkingarea(String Parkingarea) throws Exception
	{
		cm.WaitForTheVisibilityOfElement(getCS_SearchParkingAreaField(), 20);
		cm.typeTextToTextBox(getCS_SearchParkingAreaField(), Parkingarea);
	}

	public void Click_Threedots() throws Exception {
		cm.WaitForTheVisibilityOfElement(getCS_Threedotsbutton(), 10);
		cm.jseClick(getCS_Threedotsbutton());
		LOG.info("Clicked on Threedots button");
	}
	
	public void Click_editbutton() throws Exception
	{
		cm.WaitForTheVisibilityOfElement(getCS_Editbutton(), 10);
		cm.HighlightElement(getCS_Editbutton());
		cm.jseClick(getCS_Editbutton());
		LOG.info("Clicked on EDIT button");
	}
	public void Verify_EditHubParkingLable_displayed()
	{
		cm.WaitForTheVisibilityOfElement(getCS_EditHubParkingLable(), 10);
		cm.HighlightElement(getCS_EditHubParkingLable());
		LOG.info("The Edit HUB Parking lable is displayed on EDIT Page");
	}
	public void Click_removebutton() throws Exception
	{
		cm.WaitForTheVisibilityOfElement(getCS_removebutton(), 10);
		cm.HighlightElement(getCS_removebutton());
		cm.jseClick(getCS_removebutton());
		LOG.info("Clicked on REMOVE button");	
	}
	public void Click_Cancelbutton() throws Exception
	{
		cm.WaitForTheVisibilityOfElement(getCS_CancelbuttonPopup(), 10);
		cm.HighlightElement(getCS_CancelbuttonPopup());
		cm.wait(3);
		cm.jseClick(getCS_CancelbuttonPopup());
		LOG.info("Clicked on CANCEL button on delete parking popup");
		
	}
	public void Click_Confirmbutton() throws Exception
	{
		cm.WaitForTheVisibilityOfElement(getCS_Confirmbuttonpopup(), 10);
		cm.HighlightElement(getCS_Confirmbuttonpopup());
		cm.wait(3);
		cm.jseClick(getCS_Confirmbuttonpopup());
		LOG.info("Clicked on CONFIRM button on the delete parking popup");
	}
	
	public void Click_ClickEditpencileButton() throws Exception
	{
		cm.WaitForTheVisibilityOfElement(getCS_EditpencileBtn(), 10);
		cm.HighlightElement(getCS_EditpencileBtn());
		cm.jseClick(getCS_EditpencileBtn());
		LOG.info("Clicked on pencile Edit button on the ");
	}
	public void Search_Companyname_To_Associate(String CompanyToAssociate) throws Exception
	{
		cm.WaitForTheVisibilityOfElement(getCS_CompanynameSearchfield(), 10);
		cm.typeTextToTextBox(getCS_CompanynameSearchfield(), CompanyToAssociate);
		cm.wait(3);
		Robot rbt = new Robot();
		rbt.keyPress(KeyEvent.VK_DOWN);
		rbt.keyRelease(KeyEvent.VK_DOWN);
		rbt.keyPress(KeyEvent.VK_ENTER);
		rbt.keyRelease(KeyEvent.VK_ENTER);
		cm.wait(3);
	}
	public void Click_CancelBtn_To_AssociateCompany() throws Exception
	{
		cm.WaitForTheVisibilityOfElement(getCS_CancelParkingassociationBtn(), 10);
		cm.scrollToview(getCS_CancelParkingassociationBtn());
		cm.HighlightElement(getCS_CancelParkingassociationBtn());
		cm.jseClick(getCS_CancelParkingassociationBtn());
		LOG.info("Click on CANCEL button to Associate the Company");
	}
	public void Click_SaveParkingAreaBtn() throws Exception
	{
		cm.scrollToview(getCS_SaveparkingareaBtn());
		cm.HighlightElement(getCS_SaveparkingareaBtn());
		cm.jseClick(getCS_SaveparkingareaBtn());
		LOG.info("Clicked on Save parking area button");
	}
	public void Click_AddParkingBtn() throws Exception
	{
		cm.WaitForTheVisibilityOfElement(getCS_AddnewParkingBtn(), 10);
		cm.HighlightElement(getCS_AddnewParkingBtn());
		cm.jseClick(getCS_AddnewParkingBtn());
		LOG.info("Clicked on ADD NEW PARKING button");
	}
	public void Fill_AddressDetails(String Addressvalue) throws Exception
	{
		cm.WaitForTheVisibilityOfElement(getCS_Addressfield(), 10);
		cm.typeTextToTextBox(getCS_Addressfield(), Addressvalue);
		cm.wait(3);
		Robot rbt = new Robot();
		rbt.keyPress(KeyEvent.VK_DOWN);
		rbt.keyRelease(KeyEvent.VK_DOWN);
		rbt.keyPress(KeyEvent.VK_ENTER);
		rbt.keyRelease(KeyEvent.VK_ENTER);
		cm.wait(3);
		
		LOG.info("Address Details entered as: "+Addressvalue);
		
	}
	public void Fill_parkingSpaceDetails(String ParkingSpacecount) throws Exception
	{
		cm.clearText(getCS_TotalParkingSpacesAvailableField());
		cm.typeTextToTextBox(getCS_TotalParkingSpacesAvailableField(),ParkingSpacecount);
		LOG.info("Parking spaces available is enter as: "+ ParkingSpacecount);
	}
}

