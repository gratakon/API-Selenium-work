package com.ALD_Driver.pageObjects;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ALD.Base.BaseDriver;
import com.ALD.Commons.CommonUtilities;

public class Driver_LoginPageObjs extends BaseDriver {
	private static final Logger LOG = LogManager.getLogger(Driver_LoginPageObjs.class);

	public CommonUtilities cm = new CommonUtilities();

	By DUsername = By.xpath("//input[@id='username']");

	public WebElement getDUsername() {
		return driver.findElement(DUsername);
	}

	By DPassword = By.xpath("//input[@id='password']");

	public WebElement getDPassword() {
		return driver.findElement(DPassword);
	}

	By DLoginBtn = By.xpath("//button[@id='login-btn']");

	public WebElement getDLoginBtn() {
		return driver.findElement(DLoginBtn);
	}

	By DLoginfailueMsg = By.xpath("//div[contains(@class,'alert-box alert text-left mt-15')]");

	public WebElement getDLoginfailueMsg() {
		return driver.findElement(DLoginfailueMsg);
	}

	public void browserup() throws IOException {
		driver = initializeDriver();

	}

	public void DLogin(String Dusername, String Dpassword) throws Exception {
		open_CCSApplication();
		cm.typeTextToTextBox(getDUsername(), Dusername);
		cm.typeTextToTextBox(getDPassword(), Dpassword);
		cm.HighlightElement(getDLoginBtn());
		cm.clickElement(getDLoginBtn());
		LOG.info("Login Sucessfull as Driver");
		cm.wait(5);

	}

	public void Dloginfailure() throws Exception {
		cm.HighlightElement(getDLoginfailueMsg());
		cm.wait(3);
		LOG.info("Driver is not able to login : BAD CREDENTIALS");
		driver.quit();
	}

}
