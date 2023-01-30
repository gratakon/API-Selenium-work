package com.ALD_FM.pageObjects;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ALD.Base.BaseDriver;
import com.ALD.Commons.CommonUtilities;

public class FM_LoginpageObjs extends BaseDriver {
	private static final Logger LOG = LogManager.getLogger(FM_LoginpageObjs.class);

	public CommonUtilities cm = new CommonUtilities();

	By FMUsername = By.xpath("//input[@id='username']");

	public WebElement getFMUsername() {
		return driver.findElement(FMUsername);
	}

	By FMPassword = By.xpath("//input[@id='password']");

	public WebElement getFMPassword() {
		return driver.findElement(FMPassword);
	}

	By FMLoginBtn = By.xpath("//button[@id='login-btn']");

	public WebElement getFMLoginBtn() {
		return driver.findElement(FMLoginBtn);
	}

	public void browserup() throws IOException {
		driver = initializeDriver();

	}

	public void DLogin(String FMusername, String FMpassword) throws Exception {
		open_CCSApplication();
		cm.typeTextToTextBox(getFMUsername(), FMusername);
		cm.typeTextToTextBox(getFMPassword(), FMpassword);
		cm.HighlightElement(getFMLoginBtn());
		cm.clickElement(getFMLoginBtn());
		LOG.info("Login Sucessfull as FleetManager");
		cm.wait(5);

	}
}
