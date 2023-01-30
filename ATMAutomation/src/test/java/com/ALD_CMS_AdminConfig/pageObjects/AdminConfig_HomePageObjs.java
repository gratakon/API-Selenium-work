package com.ALD_CMS_AdminConfig.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ALD.Base.BaseDriver;
import com.ALD.Commons.CommonUtilities;

public class AdminConfig_HomePageObjs extends BaseDriver {
	private static final Logger LOG = LogManager.getLogger(AdminConfig_HomePageObjs.class);

	public CommonUtilities cm = new CommonUtilities();

	By AC_PlatformconfigurationLink = By.xpath("//li[contains(@class,'')]//span[contains(text(),'Platform configuration')]");

	public WebElement getAC_PlatformconfigurationLink() {
		return driver.findElement(AC_PlatformconfigurationLink);
	}
	By AC_UserNameLink = By.xpath("//span[@class='user-name']");

	public WebElement getAC_UserNameLink() {
		return driver.findElement(AC_UserNameLink);
	}
	By AC_LogoutBtn = By.xpath("//a[@class='user-action user-action-logout']");

	public WebElement getAC_LogoutBtn() {
		return driver.findElement(AC_LogoutBtn);
	}
		
	public void click_PlatformconfigurationLink() throws Exception
	{
		cm.FluientWait(AC_PlatformconfigurationLink, 10,3);
		cm.HighlightElement(getAC_PlatformconfigurationLink());
		cm.jseClick(getAC_PlatformconfigurationLink());
		LOG.info("Clicked on Platform configuration Link");
	}
	public void Click_logout() throws Exception
	{
		cm.jseClick(getAC_UserNameLink());
		cm.FluientWait(AC_LogoutBtn, 10,3);
		cm.HighlightElement(getAC_LogoutBtn());
		cm.jseClick(getAC_LogoutBtn());
		LOG.info("Admin Config sucessfully logged out ot CMS application");
		driver.quit();
	}
}
