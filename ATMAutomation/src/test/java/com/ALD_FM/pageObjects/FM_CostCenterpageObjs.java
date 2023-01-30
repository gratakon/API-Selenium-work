package com.ALD_FM.pageObjects;

import java.awt.AWTException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ALD.Base.BaseDriver;
import com.ALD.Commons.CommonUtilities;

public class FM_CostCenterpageObjs extends BaseDriver {

	private static final Logger LOG = LogManager.getLogger(FM_CostCenterpageObjs.class);

	public CommonUtilities cm = new CommonUtilities();

	By FM_Choosefilebtn = By.xpath("//label[@id='uploadCsvFilename']");

	public WebElement getFM_Choosefilebtn() {
		return driver.findElement(FM_Choosefilebtn);
	}

	By FM_Uploadbtn = By.xpath("//button[@id='form_submit']");

	public WebElement getFM_Uploadbtn() {
		return driver.findElement(FM_Uploadbtn);
	}

	By FM_TrashiconBtn = By.xpath("//tr[@id='center_cost_row_1']//i[contains(@class,'fa fa-trash badge-list__ico')]");

	public WebElement getFM_TrashiconBtn() {
		return driver.findElement(FM_TrashiconBtn);
	}

	By FM_SucessfuluploadAlertMsg = By.xpath("//div[contains(@class,'alert-box info')]");

	public WebElement getFM_SucessfuluploadAlertMsg() {
		return driver.findElement(FM_SucessfuluploadAlertMsg);
	}

	By FM_UploadInvalidFormatErrorMsg = By.xpath("//div[@class='mt-5']");

	public WebElement getFM_UploadInvalidFormatErrorMsg() {
		return driver.findElement(FM_UploadInvalidFormatErrorMsg);
	}

	By FM_DriverListModelBtn = By.xpath("//a[@class='button white-bordered mb-0 js-overlayer-embed-open']");

	public WebElement getFM_DriverListModelBtn() {
		return driver.findElement(FM_DriverListModelBtn);
	}

	By FM_DriverSearchField = By.xpath("//input[@id='driver_filter']");

	public WebElement getFM_DriverSearchField() {
		return driver.findElement(FM_DriverSearchField);
	}

	By FM_DriverSearchBtn = By.xpath("//a[@id='driver_filter_cta']");

	public WebElement getFM_DriverSearchBtn() {
		return driver.findElement(FM_DriverSearchBtn);
	}

	By FM_DriverSearchresultRow = By.xpath("//table[@class='table-style-1 no-hover']/tbody/tr");

	public WebElement getFM_DriverSearchresultRow() {
		return driver.findElement(FM_DriverSearchresultRow);
	}

	By FM_DriverlistModelCloseBtn = By.xpath(
			"//body[@class='not-inside-app modal']/div[@class='js-wrapper-website']/div[contains(@class,'container-website js-container-website')]/div[@id='overlayer']/div[@class='js-overlayer-embed-wrapper']/div[@class='modal loaded']/div[1]");

	public WebElement getFM_DriverlistModelCloseBtn() {
		return driver.findElement(FM_DriverlistModelCloseBtn);
	}

	By FM_CostcenterHelpBtn = By.xpath("//i[@class='fa fa-question-circle']");

	public WebElement getFM_CostcenterHelpBtn() {
		return driver.findElement(FM_CostcenterHelpBtn);
	}

	By FM_CostcenterHelpcontent = By.xpath(
			"//body[@class='not-inside-app modal']/div[@class='js-wrapper-website']/div[contains(@class,'container-website js-container-website')]/div[@id='overlayer']/div[@class='js-overlayer-embed-wrapper']/div[@class='modal loaded']/div");

	public WebElement getFM_CostcenterHelpcontent() {
		return driver.findElement(FM_CostcenterHelpcontent);
	}

	By FM_CDC_editBtn = By.xpath("//tr[1]//td[4]//div[1]//a[1]//i[1]");

	public WebElement getFM_CDC_editBtn() {
		return driver.findElement(FM_CDC_editBtn);
	}

	By FM_CDC_dropdown = By.xpath("//div[contains(@class,'select-here text-center')]//select[@id='selected_cdc']");

	public WebElement getFM_CDC_dropdown() {
		return driver.findElement(FM_CDC_dropdown);
	}

	By FM_CDC_dropdown_Cancel = By.xpath("//tr[1]//td[4]//div[1]//a[2]//i[1]");

	public WebElement getFM_CDC_dropdown_Cancel() {
		return driver.findElement(FM_CDC_dropdown_Cancel);
	}

	By FM_CDC_Association_Deletebtn = By.xpath("//tr[1]//td[5]//div[1]//a[1]//i[1]");

	public WebElement getFM_CDC_Association_Deletebtn() {
		return driver.findElement(FM_CDC_Association_Deletebtn);
	}

	By FM_CDC_Association_Confirmbtn = By.xpath(
			"//div[contains(@class,'modal loaded')]//a[contains(@class,'button mb-0 delete-confirm')][contains(text(),'Confirm')]");

	public WebElement getFM_CDC_Association_Confirmbtn() {
		return driver.findElement(FM_CDC_Association_Confirmbtn);
	}

	By FM_MassiveActions_Dropdown = By.xpath("//select[@id='massive_action']");

	public WebElement getFM_MassiveActions_Dropdown() {
		return driver.findElement(FM_MassiveActions_Dropdown);
	}

	By FM_ChangeCDC_Dropdown = By.xpath("//select[@id='selected_cdc']");

	public WebElement getFM_ChangeCDC_Dropdown() {
		return driver.findElement(FM_ChangeCDC_Dropdown);
	}

	By FM_ApplyBtn = By.xpath("//button[@id='apply_button']");

	public WebElement getFM_ApplyBtn() {
		return driver.findElement(FM_ApplyBtn);
	}
	By FM_ConfirmMassiveDeleteBtn = By.xpath("//a[contains(@class,'button mb-0 delete-confirm-massive')]");

	public WebElement getFM_ConfirmMassiveDeleteBtn() {
		return driver.findElement(FM_ConfirmMassiveDeleteBtn);
	}
	
	

	public void click_ChoosefileButton() throws Exception {
		cm.FluientWait(FM_Choosefilebtn, 10,3);
		cm.HighlightElement(getFM_Choosefilebtn());
		cm.clickElement(getFM_Choosefilebtn());
		LOG.info("Clicked on Choose file to upload button on cost center page");
	}

	public void uploadCSV_UserID_incorrectCDC() throws AWTException {
		cm.uploadfile_to_app(
				"C:\\Users\\IT-SERVICE-OFFSH2\\Documents\\CostCenter files\\template_cost_center_UserID_Incorrect_cdc.csv");
		LOG.info("The CSV file with correct Driver USERID and incorrect CDC uploaded sucessfully");
	}

	public void uploadCSV_Taxcode_incorrectCDC() throws AWTException {
		cm.uploadfile_to_app(
				"C:\\Users\\IT-SERVICE-OFFSH2\\Documents\\CostCenter files\\template_cost_center_Taxcode_Incorrect_cdc.csv");
		LOG.info("The CSV file with correct Driver TAXCODE and incorrect CDC uploaded sucessfully");
	}

	public void uploadCSV_Taxcode_correctCDC() throws AWTException {
		cm.uploadfile_to_app(
				"C:\\Users\\IT-SERVICE-OFFSH2\\Documents\\CostCenter files\\template_cost_center_Taxcode_correct_cdc.csv");
		LOG.info("The CSV file with correct Driver Taxcode and correct CDC uploaded sucessfully");
	}

	public void uploadCSV_UserID_correctCDC_pooler() throws AWTException {
		cm.uploadfile_to_app(
				"C:\\Users\\IT-SERVICE-OFFSH2\\Documents\\CostCenter files\\template_cost_center_Pooler_correct_UserID.csv");
		LOG.info("The CSV file with correct POOLER USERID and correct CDC uploaded sucessfully");
	}

	public void uploadCSV_Taxcode_correctCDC_pooler() throws AWTException {
		cm.uploadfile_to_app(
				"C:\\Users\\IT-SERVICE-OFFSH2\\Documents\\CostCenter files\\template_cost_center_Pooler_correct_Taxcode.csv");
		LOG.info("The CSV file with correct POOLER Taxcode and correct CDC uploaded sucessfully");
	}

	public void uploadFile_invalidformat() throws AWTException {
		cm.uploadfile_to_app("C:\\Users\\IT-SERVICE-OFFSH2\\Documents\\CostCenter files\\incorrect_format_file.txt");
		LOG.info("The file with invalid or NON CSV format is uploaded sucessfully");
	}

	public void click_uploadButton() throws Exception {
		cm.FluientWait(FM_Uploadbtn, 10,3);
		cm.scrollToview(getFM_Uploadbtn());
		cm.HighlightElement(getFM_Uploadbtn());
		cm.jseClick(getFM_Uploadbtn());
		LOG.info("Clicked on Upload button");
	}

	public void click_TrashiconButton() throws Exception {
		cm.FluientWait(FM_TrashiconBtn, 10,3);
		cm.scrollToview(getFM_TrashiconBtn());
		cm.HighlightElement(getFM_TrashiconBtn());
		cm.wait(2);
		cm.jseClick(getFM_TrashiconBtn());
		LOG.info("Clicked on TRASH icon");
	}

	public void Verify_AlertMessgaeDisplayed() {
		cm.FluientWait(FM_SucessfuluploadAlertMsg, 10,3);
		cm.HighlightElement(getFM_SucessfuluploadAlertMsg());
		String Alertmessage = getFM_SucessfuluploadAlertMsg().getText();
		LOG.info(Alertmessage + "  message is diaplyed");
	}

	public void Verify_ErrorMessage_invalidaFileFormat() {
		cm.FluientWait(FM_UploadInvalidFormatErrorMsg, 10,3);
		cm.scrollToview(getFM_UploadInvalidFormatErrorMsg());
		cm.HighlightElement(getFM_UploadInvalidFormatErrorMsg());
		String errormessagefileformat = getFM_UploadInvalidFormatErrorMsg().getText();
		LOG.info(errormessagefileformat + " message is dsiplayed");
	}

	public void Click_DriverlistModel() throws Exception {
		cm.FluientWait(FM_DriverListModelBtn, 10,3);
		cm.HighlightElement(getFM_DriverListModelBtn());
		cm.jseClick(getFM_DriverListModelBtn());
		LOG.info("Clicked on Driver List Model Button");
	}

	public void Enter_DriverToSearch(String TextToSearch) throws Exception {
		cm.FluientWait(FM_DriverSearchField, 10,3);
		cm.wait(2);
		cm.typeTextToTextBox(getFM_DriverSearchField(), TextToSearch);
		cm.HighlightElement(getFM_DriverSearchBtn());
		cm.jseClick(getFM_DriverSearchBtn());
		LOG.info("Searching for the :: " + TextToSearch);
	}

	public void verify_SearchResults() throws InterruptedException {
		//cm.FluientWait(FM_DriverSearchresultRow, 10);
		//LOG.info("Driver search result for  is verified");
		cm.wait(3);
		List<WebElement> Searchresultscount = driver.findElements(By.xpath("//table[@class='table-style-1 no-hover']/tbody/tr"));
		LOG.info("No. of search results displayed is : "+ Searchresultscount.size());
		//cm.HighlightElement(getFM_DriverSearchresultRow());
		List<WebElement> Searchresults = driver.findElements(By.xpath("//table[@class='table-style-1 no-hover']/tbody/tr/td"));
		for(WebElement results : Searchresults)
			LOG.info(results.getText());
	}
	

	public void close_DriverlistModel() throws Exception {
		cm.HighlightElement(getFM_DriverlistModelCloseBtn());
		cm.jseClick(getFM_DriverlistModelCloseBtn());
		LOG.info("Driver List Model pop up closed");
	}

	public void click_CostCenterHelpButton() throws Exception {
		cm.FluientWait(FM_CostcenterHelpBtn, 10,3);
		cm.jseClick(getFM_CostcenterHelpBtn());
		LOG.info("Clicked on HELP button on CostCenter page");
		// cm.FluientWait(FM_CostcenterHelpcontent, 10);
		// scm.HighlightElement(getFM_CostcenterHelpcontent());
	}

	public void click_pencilIcon() throws Exception {
		cm.scrollToview(getFM_CDC_editBtn());
		cm.HighlightElement(getFM_CDC_editBtn());
		cm.jseClick(getFM_CDC_editBtn());
		LOG.info("Clicked on pencil button to edit new CDC value");
	}

	public void select_newCostcenter(String NewCDCvalue) throws Exception {
		cm.wait(3);
		cm.click(getFM_CDC_dropdown());
		cm.selectDropDown_text(getFM_CDC_dropdown(), NewCDCvalue);
		LOG.info("New CDC value is selected from the dropdown");
	}

	public void click_CDCSelection_cancelBtn() throws Exception {
		cm.wait(3);
		cm.jseClick(getFM_CDC_dropdown_Cancel());
		LOG.info("Clicked on Cancel button beside the CDC dropdown box");
	}

	public void delete_singleAssociation() throws Exception {
		cm.wait(3);
		cm.scrollToview(getFM_CDC_Association_Deletebtn());
		cm.HighlightElement(getFM_CDC_Association_Deletebtn());
		cm.jseClick(getFM_CDC_Association_Deletebtn());
		LOG.info("Clicked on DELETE button for a single Assocation of CDC");
		cm.WaitUntilelementToBeClickable(getFM_CDC_Association_Confirmbtn(), 10);
		cm.HighlightElement(getFM_CDC_Association_Confirmbtn());
		cm.jseClick(getFM_CDC_Association_Confirmbtn());
		LOG.info("Clicked on CONFIRM button for a single Assocation of CDC");
	}

	public void Select_CDCAssociations_Dropdown() throws Exception {
		cm.wait(3);
		cm.HighlightElement(getFM_MassiveActions_Dropdown());
		cm.jseClick(getFM_MassiveActions_Dropdown());
		cm.selectDropDown_text(getFM_MassiveActions_Dropdown(), "Change CdC");
		cm.wait(3);
		cm.HighlightElement(getFM_ChangeCDC_Dropdown());
		cm.jseClick(getFM_ChangeCDC_Dropdown());
		cm.selectDropDown_text(getFM_ChangeCDC_Dropdown(), "IT");
		cm.wait(3);
	}

		public void Select_CDC_Items() throws Exception
		{
			List<WebElement> selectbulkCDC = driver.findElements(By.xpath("//tr//td[1]//input[1]"));
			int itemcount = selectbulkCDC.size();
			System.out.println(itemcount);
			for(int i=0;i<itemcount;i++)
			{
			WebElement itemCDCcountEach = selectbulkCDC.get(i);
			cm.HighlightElement(itemCDCcountEach);
			cm.jseClick(itemCDCcountEach);
			}
		}

	public void Click_ApplyBtn() throws Exception {
		cm.WaitUntilelementToBeClickable(getFM_ApplyBtn(), 10);
		cm.scrollToview(getFM_ApplyBtn());
		cm.HighlightElement(getFM_ApplyBtn());
		cm.jseClick(getFM_ApplyBtn());
		cm.wait(3);
	}
	public void click_MassiveDeleteconfirmButton() throws Exception
	{
		cm.WaitUntilelementToBeClickable(getFM_ConfirmMassiveDeleteBtn(), 10);
		cm.HighlightElement(getFM_ConfirmMassiveDeleteBtn());
		cm.jseClick(getFM_ConfirmMassiveDeleteBtn());
		cm.wait(5);
	}

}
