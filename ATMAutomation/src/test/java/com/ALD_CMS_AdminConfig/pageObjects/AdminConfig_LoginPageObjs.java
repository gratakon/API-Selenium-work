package com.ALD_CMS_AdminConfig.pageObjects;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ALD.Base.BaseDriver;
import com.ALD.Commons.CommonUtilities;


public class AdminConfig_LoginPageObjs extends BaseDriver {
	private static final Logger LOG = LogManager.getLogger(AdminConfig_LoginPageObjs.class);

	public CommonUtilities cm = new CommonUtilities();

	By AC_Username = By.xpath("//input[@id='username']");

	public WebElement getAC_Username() {
		return driver.findElement(AC_Username);
	}
	By AC_Password = By.xpath("//input[@id='password']");

	public WebElement getAC_Password() {
		return driver.findElement(AC_Password);
	}
	By AC_LoginBtn = By.xpath("//button[@class='btn btn-primary btn-lg btn-block']");

	public WebElement getAC_LoginBtn() {
		return driver.findElement(AC_LoginBtn);
	}
	public void browserup() throws IOException {
		driver = initializeDriver();

	}
	
	public void AdminConfig_Login(String AC_LUsername,String AC_LPassword) throws Exception
	{
		open_CMSApplication();
		cm.typeTextToTextBox(getAC_Username(), AC_LUsername);
		cm.typeTextToTextBox(getAC_Password(), AC_LPassword);
		cm.HighlightElement(getAC_LoginBtn());
		cm.clickElement(getAC_LoginBtn());
		LOG.info("Login sucessful into CMS application as Admin config");
		
	}
	
	
	
	
	
	
	
}
