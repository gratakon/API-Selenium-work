package com.ALD_CSM.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ALD.Base.BaseDriver;
import com.ALD.Commons.CommonUtilities;

public class CSM_HomePageObjs extends BaseDriver {

	private static final Logger LOG = LogManager.getLogger(CSM_HomePageObjs.class);

	public CommonUtilities cm = new CommonUtilities();

	By CSM_Userslink = By.xpath("//span[@class='title']");

	public WebElement getCSM_Userslink() {
		return driver.findElement(CSM_Userslink);
	}

	By CSM_Userprofilelink = By.xpath("//span[contains(@class,'role')]");

	public WebElement getCSM_Userprofilelink() {
		return driver.findElement(CSM_Userprofilelink);
	}

	By CSM_Logoutbtn = By.xpath("//a[contains(text(),'Logout')]");

	public WebElement getCSM_Logoutbtn() {
		return driver.findElement(CSM_Logoutbtn);
	}

	public void click_CSM_userslink() throws Exception {
		cm.jseClick(getCSM_Userslink());
		LOG.info("Clicked on Customer manager users link");
		cm.wait(3);
		
	}

	public void Logout() throws Exception {
		cm.ExplicitWaitelementclickable(getCSM_Userprofilelink());
		cm.jseClick(getCSM_Userprofilelink());
		cm.HighlightElement(getCSM_Logoutbtn());
		cm.jseClick(getCSM_Logoutbtn());
		LOG.info("Logout Sucessful as Customer Service Manager");
		driver.quit();

	}

}
