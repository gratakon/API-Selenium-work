package com.ALD_FM.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ALD.Base.BaseDriver;
import com.ALD.Commons.CommonUtilities;

public class FM_GroupsandSegmentspageObjs extends BaseDriver {

	private static final Logger LOG = LogManager.getLogger(FM_GroupsandSegmentspageObjs.class);

	public CommonUtilities cm = new CommonUtilities();

	By FM_AddNewGroupbtn = By.xpath("//a[@class='controls-button add-button outside add-driverGroup-button']");

	public WebElement getFM_AddNewGroupbtn() {
		return driver.findElement(FM_AddNewGroupbtn);
	}

	By FM_AddGroupName = By.xpath("//input[contains(@id,'driver_groups_driverGroups') and @placeholder='Name']");

	public WebElement getFM_AddGroupName() {
		return driver.findElement(FM_AddGroupName);
	}

	By FM_AddGroupDescription = By
			.xpath("//input[contains(@id,'driver_groups_driverGroups') and @placeholder='Description']");

	public WebElement getFM_AddGroupDescription() {
		return driver.findElement(FM_AddGroupDescription);
	}

	By FM_AddGroupSegment = By.xpath("//div[contains(@class,'ms-parent js-new-select-segment select-segment')]");

	public WebElement getFM_AddFM_AddGroupSegment() {
		return driver.findElement(FM_AddGroupSegment);
	}

	By FM_AddGroupSAVEbtn = By.xpath("//button[@class='create-groups-submit-btn save-tags']");

	public WebElement getFM_AddGroupSAVEbtn() {
		return driver.findElement(FM_AddGroupSAVEbtn);
	}

	By FM_NewgroupSucessmsg = By.xpath("//div[contains(text(),'Driver groups updated.')]");

	public WebElement getFM_NewgroupSucessmsg() {
		return driver.findElement(FM_NewgroupSucessmsg);
	}

	By FM_assignnewgroupdrppdown = By.xpath("//select[contains(@class,'mb-40')]");

	public WebElement getFM_assignnewgroupdrppdown() {
		return driver.findElement(FM_assignnewgroupdrppdown);
	}
	By FM_assignnewgroupbtn = By.xpath("//a[@id='btnClose']");

	public WebElement getFM_assignnewgroupbtn() {
		return driver.findElement(FM_assignnewgroupbtn);
	}
	
	public void AddnewBusinessGroup(String group_Name, String group_Description, String cartype) throws Exception {
		cm.FluientWait(FM_AddNewGroupbtn, 20,3);
		cm.moveToObject(getFM_AddNewGroupbtn());
		cm.jseClick(getFM_AddNewGroupbtn());
		cm.FluientWait(FM_AddGroupName, 20,3);
		cm.moveToObject(getFM_AddGroupName());
		cm.typeTextToTextBox(getFM_AddGroupName(), group_Name);
		LOG.info("New Group name provided as: " + group_Name);
		cm.typeTextToTextBox(getFM_AddGroupDescription(), group_Description);
		LOG.info("New Group Description provided");
		cm.jseClick(getFM_AddFM_AddGroupSegment());
		WebElement Car_typename = driver.findElement(By.xpath(
				"//div[contains(@class,'ms-parent js-new-select-segment select-segment')]//span[contains(text(),'"
						+ cartype + "')]"));
		LOG.info("New Group segment selected");
		cm.jseClick(Car_typename);
		cm.jseClick(getFM_AddGroupSAVEbtn());
		cm.HighlightElement(getFM_AddGroupSAVEbtn());
		LOG.info("New Group creation changes SAVED");
		cm.HighlightElement(getFM_NewgroupSucessmsg());
		LOG.info("NEW Group creation sucess message displayed");
	}
	public void DeleteBusinessgroup(String groupname_delete, String newgroup_assign) throws Exception {
		WebElement Bgroup_removebtn = driver.findElement(
				By.xpath("//input[contains(@id,'driver_groups_driverGroups') and @value='" + groupname_delete
						+ "']/following::a[@class='controls-button remove-button remove-driver-group']"));
		cm.moveToObject(Bgroup_removebtn);
		cm.HighlightElement(Bgroup_removebtn);
		cm.jseClick(Bgroup_removebtn);
		cm.FluientWait(FM_assignnewgroupdrppdown, 20,3);
		cm.wait(2);
		cm.selectDropdown(getFM_assignnewgroupdrppdown(), newgroup_assign);
		cm.HighlightElement(getFM_assignnewgroupbtn());
		cm.jseClick(getFM_assignnewgroupbtn());
		LOG.info("Driver is assigned to a new Group :" +newgroup_assign);
		LOG.info("New Group with name " + groupname_delete + " is Deleted");
		cm.jseClick(getFM_AddGroupSAVEbtn());
		cm.HighlightElement(getFM_AddGroupSAVEbtn());
		LOG.info("New Group deletion changes SAVED");
		cm.HighlightElement(getFM_NewgroupSucessmsg());
		LOG.info("NEW Group Deletion sucess message displayed");
	}
	

}
