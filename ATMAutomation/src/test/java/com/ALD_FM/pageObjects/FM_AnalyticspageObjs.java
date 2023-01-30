package com.ALD_FM.pageObjects;

import java.awt.AWTException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ALD.Base.BaseDriver;
import com.ALD.Commons.CommonUtilities;

public class FM_AnalyticspageObjs extends BaseDriver {

	private static final Logger LOG = LogManager.getLogger(FM_AnalyticspageObjs.class);

	public CommonUtilities cm = new CommonUtilities();

	By FM_UseOfParkingLotsTab = By.xpath("//a[contains(text(),'Use of parking lots')]");

	public WebElement getFM_UseOfParkingLotsTab() {
		return driver.findElement(FM_UseOfParkingLotsTab);
	}
	
	By FM_MaintenanceTab = By.xpath("//a[contains(text(),'MAINTENANCE')]");

	public WebElement getFM_MaintenanceTab() {
		return driver.findElement(FM_MaintenanceTab);
	}
	By FM_MaintenanceTab_ParkingDropdown = By.xpath("//a[contains(text(),'MAINTENANCE')]/following::select");

	public WebElement getFM_MaintenanceTab_ParkingDropdown() {
		return driver.findElement(FM_MaintenanceTab_ParkingDropdown);
	}
	By FM_MaintenanceTab_SearchBtn = By.xpath("//button[@class='full-width']");

	public WebElement getFM_MaintenanceTab_SearchBtn() {
		return driver.findElement(FM_MaintenanceTab_SearchBtn);
	}
	By FM_MaintenanceTab_FromDateField = By.xpath("//input[@type='text' and @placeholder='From']");

	public WebElement getFM_MaintenanceTab_FromDateField() {
		return driver.findElement(FM_MaintenanceTab_FromDateField);
	}
	By FM_MaintenanceTab_ToDateField = By.xpath("//input[@type='text' and @placeholder='To']");

	public WebElement getFM_MaintenanceTab_ToDateField() {
		return driver.findElement(FM_MaintenanceTab_ToDateField);
	}
	By FM_MaintenanceTab_Averagevalue = By.xpath("//div[contains(text(),'0%')]");

	public WebElement getFM_MaintenanceTab_Averagevalue() {
		return driver.findElement(FM_MaintenanceTab_Averagevalue);
	}
	By FM_MaintenanceTab_ExportXLSbtn = By.xpath("//button[contains(text(),'EXPORT XLS')]");

	public WebElement getFM_MaintenanceTab_ExportXLSbtn() {
		return driver.findElement(FM_MaintenanceTab_ExportXLSbtn);
	}
	
	
	
	
	
	public void click_UseOfParkingLotsTab() throws Exception
	{
		cm.FluientWait(FM_UseOfParkingLotsTab, 10,3);
		cm.HighlightElement(getFM_UseOfParkingLotsTab());
		cm.jseClick(getFM_UseOfParkingLotsTab());
		LOG.info("Clicked on Use Of Parking Lots Tab");
	}
	
	public void click_MaintenanceTab() throws Exception
	{
		cm.FluientWait(FM_MaintenanceTab, 10,3);
		cm.HighlightElement(getFM_MaintenanceTab());
		cm.jseClick(getFM_MaintenanceTab());
		LOG.info("Clicked on Maintenance Tab");
		
	}
	public void verify_hubparkingoptionsNOTpresent_ParkingDropdown() throws Exception
	{
		cm.FluientWait(FM_MaintenanceTab_ParkingDropdown, 10,3);
		LOG.info("Parking list drop down is visible");
		cm.click(getFM_MaintenanceTab_ParkingDropdown());
		LOG.info("Clicked on Parking Dropdown");
		cm.Print_AllDropdownValues(FM_MaintenanceTab_ParkingDropdown);
		cm.Verify_DropDownOption_NotAvailable(getFM_MaintenanceTab_ParkingDropdown(), "Via Telemaco Signorini, 2, Bologna, Metropolitan City of Bologna, Italy");
	    cm.Verify_DropDownOption_NotAvailable(getFM_MaintenanceTab_ParkingDropdown(), "Via di Ferraglia, Ferraglia, Metropolitan City of Florence, Italy");
	    cm.Verify_DropDownOption_NotAvailable(getFM_MaintenanceTab_ParkingDropdown(), "Viale dei Mille, 4, Florence, Metropolitan City of Florence, Italy");
	    cm.Verify_DropDownOption_NotAvailable(getFM_MaintenanceTab_ParkingDropdown(), "Via Paolo Sarpi, 1, Milan, Metropolitan City of Milan, Italy");
	    cm.Verify_DropDownOption_NotAvailable(getFM_MaintenanceTab_ParkingDropdown(), "Corso di Francia, 3, Rome, Metropolitan City of Rome, Italy");
	    cm.Verify_DropDownOption_NotAvailable(getFM_MaintenanceTab_ParkingDropdown(), "Via delle Robinie, 3, Rome, Metropolitan City of Rome, Italy");
	    cm.Verify_DropDownOption_NotAvailable(getFM_MaintenanceTab_ParkingDropdown(), "Via di Trasone, 1, Rome, Metropolitan City of Rome, Italy");
	}
	
	public void Veirfy_Searchbutton_disabled() throws Exception
	{
		cm.FluientWait(FM_MaintenanceTab_SearchBtn, 10,3);
		cm.validateElementisDisable(getFM_MaintenanceTab_SearchBtn());
	}
	public void Select_ParkingDropdown() throws AWTException
	{
		cm.FluientWait(FM_MaintenanceTab_ParkingDropdown, 10,3);
		cm.click(getFM_MaintenanceTab_ParkingDropdown());
		cm.selectDropDown_text(getFM_MaintenanceTab_ParkingDropdown(), "FI, Firenze, Piazzale Michelangelo");
		
	}
	public void Input_fromdate(String startmonth, String date) throws Exception
	{
		cm.FluientWait(FM_MaintenanceTab_FromDateField, 10,3);
		//cm.scrollToview(getFM_MaintenanceTab_FromDateField());
		cm.HighlightElement(getFM_MaintenanceTab_FromDateField());
		cm.wait(5);
		cm.clickElement(getFM_MaintenanceTab_FromDateField());
		while (true) {
			String text = driver.findElement(By.xpath(
					"(//div[contains(@class,'vdp-datepicker')]//following::span[contains(@class,'day__month_btn up')])[1]"))
					.getText();
			System.out.println(text);

			if (text.equals(startmonth)) {
				break;
			}
			else {
				driver.findElement(By.xpath(
						"(//span[@class='prev'])[1]"))
						.click();
				
			}
		}
		driver.findElement(By.xpath("((//div[contains(@class,'vdp-datepicker')]//following::span[contains(@class,'day__month_btn up')])[1]/following::span[contains(text(),"+ date +")])[1]")).click();
		
		LOG.info("Date entered into the FROM DATE field");
	}
	public void Input_Todate(String startmonth, String date) throws Exception
	{
		cm.FluientWait(FM_MaintenanceTab_ToDateField, 10,3);
		//cm.scrollToview(getFM_MaintenanceTab_ToDateField());
		cm.HighlightElement(getFM_MaintenanceTab_ToDateField());
		cm.wait(5);
		cm.clickElement(getFM_MaintenanceTab_ToDateField());
		while (true) {
			String text = driver.findElement(By.xpath(
					"(//div[contains(@class,'vdp-datepicker')]//following::span[contains(@class,'day__month_btn up')])[2]"))
					.getText();
			System.out.println(text);

			if (text.equals(startmonth)) {
				break;
			}
			else {
				
				driver.findElement(By.xpath(
						"(//span[@class='prev'])[4]"))
						.click();
				
			}
		}
		driver.findElement(By.xpath("((//div[contains(@class,'vdp-datepicker')]//following::span[contains(@class,'day__month_btn up')])[2]/following::span[contains(text(),"+ date +")])[1]")).click();
		
		LOG.info("Date entered into the TO DATE field");
	}
	
	public void Verify_Searchbutton_enabled() throws Exception
	{
		cm.FluientWait(FM_MaintenanceTab_SearchBtn, 10,3);
		cm.validateElementEnabled(getFM_MaintenanceTab_SearchBtn());
		cm.HighlightElement(getFM_MaintenanceTab_SearchBtn());
		cm.jseClick(getFM_MaintenanceTab_SearchBtn());
		LOG.info("Search button is clicked");
		
	}
	public void Verify_Click_ExportXLSBtn() throws Exception
	{
		cm.FluientWait(FM_MaintenanceTab_Averagevalue, 10,3);
		cm.HighlightElement(getFM_MaintenanceTab_Averagevalue());
		LOG.info(getFM_MaintenanceTab_Averagevalue().getText()+" : is the Average value ");
		cm.HighlightElement(getFM_MaintenanceTab_ExportXLSbtn());
		cm.jseClick(getFM_MaintenanceTab_ExportXLSbtn());
		LOG.info("Clicked on EXPORT XLS button");
	}
}
