package com.ALD_CS.pageObjects;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import com.ALD.Base.BaseDriver;
import com.ALD.Commons.CommonUtilities;

public class CS_LoginPageObjs extends BaseDriver {

	private static final Logger LOG = LogManager.getLogger(CS_LoginPageObjs.class);

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

	By langset1 = By.xpath("//span[@class='js-lang-current']");

	public WebElement getlangset1() {
		return driver.findElement(langset1);
	}

	By langset2 = By.xpath("//div[contains(text(),'ENGLISH')]");

	public WebElement getlangset2() {
		return driver.findElement(langset2);
	}

	public void browserup() throws IOException {
		driver = initializeDriver();

	}

	public void CSLogin(String username, String password) throws Exception {
		open_CCSApplication();
		// cm.jseClick(getlangset1());
		// cm.jseClick(getlangset2());
		cm.jseTypeText(getUsername(), username);
		cm.jseTypeText(getPassword(), password);
		cm.HighlightElement(getLoginBtn());
		cm.clickElement(getLoginBtn());
		LOG.info("Login Sucessfull as Customer Service");
		cm.wait(5);

	}

}
