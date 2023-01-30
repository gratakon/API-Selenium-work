package com.ALD_CSM.pageObjects;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ALD.Base.BaseDriver;
import com.ALD.Commons.CommonUtilities;

public class CSM_LoginPageObjs extends BaseDriver {

	private static final Logger LOG = LogManager.getLogger(CSM_LoginPageObjs.class);

	public CommonUtilities cm = new CommonUtilities();

	By Username = By.xpath("//input[@id='username']");

	public WebElement getUsername() {
		return driver.findElement(Username);
	}

	By Password = By.xpath("//input[@id='password']");

	public WebElement getPassword() {
		return driver.findElement(Password);
	}

	By LoginBtn = By.xpath("//button[@id='login-btn']");

	public WebElement getLoginBtn() {
		return driver.findElement(LoginBtn);
	}

	public void browserup() throws IOException {
		driver = initializeDriver();

	}

	public void CSMLogin(String username, String password) throws Exception {
		open_CCSApplication();
		cm.typeTextToTextBox(getUsername(), username);
		cm.typeTextToTextBox(getPassword(), password);
		cm.HighlightElement(getLoginBtn());
		cm.clickElement(getLoginBtn());
		LOG.info("Login Sucessfull as Customer Service Manager");
		cm.wait(5);

	}

}
 

