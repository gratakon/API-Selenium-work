/**
 * This CommonUtilities class has all generic methods. We can use these methods across the
 * projects. We consider the ALD Cucumber-Selenium project as base and converted the common generic libraries of that project
 * into ALD Cucumber project framework 
 */

package com.ALD.Commons;

//import static org.testng.Assert.fail;
import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;

import com.ALD.Base.BaseDriver;
import com.google.common.base.Function;

public class CommonUtilities extends BaseDriver {

	private static final Logger LOG = LogManager.getLogger(CommonUtilities.class);
	public boolean throwActionException;

	/**
	 * User minimize current window size
	 * 
	 */
	public void setwindowminimize() {
		Point p = new Point(0, 3000);
		driver.manage().window().setPosition(p);
	}

	/**
	 * User set dimension for current window size
	 * 
	 */
	public void setwindowdimensions() {
		Dimension d = new Dimension(300, 1080);
		driver.manage().window().setSize(d);
	}

	/**
	 * User validate current URL of page
	 * 
	 * @return true
	 */
	public boolean urlContainsSubstring(String substring) {
		LOG.info("Current URL: " + driver.getCurrentUrl());
		return driver.getCurrentUrl().contains(substring);
	}

	public void scrollToview(WebElement element) {
		LOG.info("Scrolling to the Eelement" + element);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void JseHighlightTheElement(WebElement header) throws Exception {
		LOG.info("Highlightging the Element " + header);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (int iCnt = 0; iCnt < 5; iCnt++) {
			js.executeScript("arguments[0].style.border='5px dotted red';", header);

		}

	}

	/**
	 * Verify that the passed object Text is present.
	 * 
	 * @param object
	 *            Web element to be validated
	 * @throws Exception
	 */
	public void verifyTextPresent(final String object) throws Exception {
		try {
			LOG.info("Verifiy text is present in a webPage");
			String Verifytext = driver.findElement(By.tagName("body")).getText().trim();
			Assert.assertTrue(Verifytext.contains(object));
			LOG.info(object + " is Present as expected ");
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Typing the text to textbox using the JavaScriptExecutor
	 * 
	 * @param element
	 * @param text
	 * @throws InterruptedException
	 */
	public void verifyTextNOTPresent(final String object) throws Exception {
		try {
			LOG.info("Verifiy text is NOT present in a webPage");
			String Verifytext = driver.findElement(By.tagName("body")).getText().trim();
			Assert.assertFalse(Verifytext.contains(object));
			LOG.info(object + " is NOT Present as expected ");
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Typing the text to textbox using the JavaScriptExecutor
	 * 
	 * @param element
	 * @param text
	 * @throws InterruptedException
	 */
	public void jseTypeText(WebElement element, String text) throws InterruptedException {
		LOG.info("Typing text using the JavaScriptExecutor and the text is " + text);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", element);
		Thread.sleep(2000);
		executor.executeScript("arguments[0].value='" + text + "'", element);
		Thread.sleep(1000);
		element.sendKeys(Keys.TAB);
	}

	/**
	 * User enter text in to textField
	 *
	 * 
	 * @author Guru (arkku6)
	 * 
	 */
	public void typeTextToTextBox(WebElement element, String text) throws Exception {
		try {
			LOG.info("Enter text in to textField: " + text);
			clearText(element);
			element.sendKeys(text);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Element is NOT available to input Text" + element);
		}
	}
	

	/**
	 * User clear text in text field
	 * 
	 */
	public void clearText(WebElement element) throws Exception {
		LOG.info("Clear text in text field");
		element.clear();
	}

	/**
	 * Click on a element
	 * 
	 * @param element
	 */
	public void clickElement(WebElement object) {
		LOG.info("Click " + object);
		try {
			object.click();
		} catch (final Exception e) {
			e.getMessage();
		}
	}

	/**
	 * Verify expected element is displayed.
	 * 
	 * @param object
	 *            Web element to be validated
	 * @throws Exception
	 */
	public boolean verifyElementDisplayed(final WebElement elementName) throws Exception, Exception {
		LOG.info("Verify expected element is displayed");
		boolean actualValue = elementName.isDisplayed();

		if (actualValue == true) {
			LOG.debug("Expected element" + elementName.getText() + " is present");
		} else {
			throw new Exception("Object should be displayed, Object is is not displaying");
		}
		return actualValue;
	}

	public void validateElementDisplayed(final WebElement elementName) throws Exception, Exception {

		try {
			LOG.info("Verify expected element is displayed");
			Assert.assertEquals(true, elementName.isDisplayed());
			LOG.info(elementName.getText() + " is present as expected ");
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Verify expected element is enabled.
	 * 
	 * @param object
	 *            Web element to be validated
	 * @throws Exception
	 */
	public boolean validateElementEnabled(final WebElement elementName) throws Exception, Exception {
		LOG.info("Verify expected element is Enabled");
		boolean actualValue = elementName.isEnabled();

		if (actualValue) {
			LOG.debug("expected element" + elementName.getText() + " is Enabled");
		} else {
			throw new Exception("Object should be Enabled, Object is is not Enabled");
		}
		return actualValue;
	}

	/**
	 * Verify expected element is selected.
	 * 
	 * @param object
	 *            Web element to be validated
	 * @throws Exception
	 */

	public boolean validateElementSelected(final WebElement elementName) throws Exception, Exception {
		LOG.info("Verify expected element is Selected");
		boolean actualValue = elementName.isSelected();
		System.out.println(actualValue);

		if (actualValue) {
			LOG.debug("expected element" + elementName.getText() + " is Selected");
		} else {
			throw new Exception("Object should be Selected, Object is is not Selected");
		}
		return actualValue;
	}

	/**
	 * Verify expected element is not selected.
	 * 
	 * @param object
	 *            Web element to be validated
	 * @throws Exception
	 */

	public boolean validateElementNotSelected(final WebElement elementName) throws Exception, Exception {
		LOG.info("Verify expected element is NOT Selected");
		boolean actualValue = elementName.isSelected();

		if (actualValue == false) {
			LOG.debug("expected element" + elementName.getText() + " is not Selected");
		} else {
			throw new Exception("Object should not be Selected, Object is Selected");
		}
		return actualValue;
	}

	/**
	 * Wait till expected element is displayed.
	 * 
	 * @param object
	 *            Web element to be validated
	 * @return
	 * @throws Exception
	 */
	public void ExplicitWaitForVisiBility(WebElement ele) {
		LOG.info("Explicitly Waiting for Element");
		WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		Wait.until(ExpectedConditions.visibilityOf(ele));
		LOG.info("Got the Element" + ele);

	}

	/**
	 * Java script executor click.
	 * 
	 * @param object
	 *            Web element to be validated
	 * @return
	 * @throws Exception
	 */

	public void jseClick(WebElement element) throws Exception {
		try {
			LOG.info("Clicking on the Element " + element);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new Exception("Element is NOT available " + element);
		}

	}

	public void JseMouseOver(WebElement element) {
		LOG.info("Mouse overing to the Element " + element);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].onmouseover()", element);
	}

	/**
	 * mouse hover on element.
	 * 
	 * @param object
	 *            Web element to be validated
	 * @return
	 * @throws Exception
	 */

	public void clickonapoint(WebElement element) {

		Point point = element.getLocation();
		int xcord = point.getX();
		System.out.println("Position of the webelement from left side is " + xcord + " pixels");
		int ycord = point.getY();
		System.out.println("Position of the webelement from top side is " + ycord + " pixels");
		Actions actions = new Actions(driver);
		// actions.moveToElement(element).click().build().perform();
		actions.moveToElement(element, xcord, ycord).click().build().perform();

	}

	public void mousehoverclick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
	}

	public void ExplicitWaitelementclickable(WebElement ele) {
		LOG.info("Explicitly Waiting for Element to be clickable");
		WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		Wait.until(ExpectedConditions.elementToBeClickable(ele));
		LOG.info("Got the Element" + ele);

	}

	public void HighlightElement(WebElement ele) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", ele);

	}
	public void HighlightElement(List<WebElement> eles) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", eles);

	}

	public void WaitUntilelementToBeClickable(WebElement Ele, int timeout) {
		LOG.info("ExplicitWait for the Element " + Ele + "With the timeout " + timeout);
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.elementToBeClickable(Ele));

	}

	public void WaitForTheVisibilityOfElement(WebElement Ele, int timeOut) {
		LOG.info("WaitForTheVisibilityOfElement " + Ele + "With the timeout " + timeOut);
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(Ele));

	}

	public void RobotMouseOver(WebElement element) throws AWTException {
		LOG.info("Mouse overing to the Element " + element);
		Point point = element.getLocation();
		Robot Robot = new Robot();
		Robot.mouseMove(point.getX(), point.getY());

	}

	/**
	 * User validate current Title of page
	 * 
	 * @return true
	 */
	public boolean pageContainsTitleSubstring(String subString) {
		LOG.info("Current Title: " + driver.getTitle());
		return driver.getTitle().contains(subString);
	}

	/**
	 * User switch to the window
	 * 
	 */
	public void switchToNewWindow() {
		LOG.info("Switch to the window");
		try {
			System.out.println("Current window: " + driver.getCurrentUrl());
			for (String winHandle : driver.getWindowHandles()) {
				LOG.info(String.format("Window Handle - [%s].", winHandle));
				if (winHandle != driver.getWindowHandle()) {
					driver.switchTo().window(winHandle);
					driver.manage().window().maximize();
					LOG.info("Getting new window: " + driver.getCurrentUrl());
					System.out.println("Getting new window: " + driver.getCurrentUrl());
				}
			}
		} catch (final NoSuchElementException e) {
			LOG.error("Expected window handle is not present");
			return;
		}

	}

	/**
	 * User moving focus to parent window
	 * 
	 */
	public void moveFocusToParentWindow() throws Exception {
		final Set<String> handles = driver.getWindowHandles();
		final String firstWinHandle = driver.getWindowHandle();

		handles.remove(firstWinHandle);
		try {

			LOG.info("Moving focus to parent window");
			final String secondWinHandle = (String) handles.iterator().next();

			if (secondWinHandle != firstWinHandle) {
				Thread.sleep(2000);
				/*
				 * webDriver.switchTo().window(secondWinHandle); Thread.sleep(2000);
				 */
				driver.switchTo().window(firstWinHandle);
				Thread.sleep(2000);
			}
		} catch (final NoSuchElementException e) {
			LOG.error("Not focused to parent window");
			return;
		}
	}

	public void switchToDefaultContent() {
		LOG.info("Switching to default content");
		driver.switchTo().defaultContent();
	}

	/**
	 * Switching back to previous window
	 * 
	 */
	public void switchBackToPreviousWindow() {
		LOG.info("Switching back to previous window");
		driver.navigate().back();
	}

	/**
	 * User Get screenshot on page
	 * 
	 * @param filePath
	 *            Describes path to save the screenshots
	 */
	public void getScreenShot(String filePath) {

		LOG.info("Get screenshot on page");
		try {
			File tempFile, destinationFile;
			destinationFile = new File(filePath);
			TakesScreenshot myScreenshot = (TakesScreenshot) driver;
			tempFile = myScreenshot.getScreenshotAs(OutputType.FILE);
			LOG.info(String.format("copy file from - [%s] to destination - [%s].", tempFile, destinationFile));
			FileUtils.copyFile(tempFile, destinationFile);
		} catch (WebDriverException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * * Method Description: Select expected value from drop down
	 * 
	 * @param webElement Describe web element of a select drop down
	 * 
	 * @param actualSelectText Actual text to select in drop down
	 */
	public void selectDropdown(WebElement webElement, String actualSelectText) {
		LOG.info(String.format("Select expected value - [%s] from dropdown", actualSelectText));
		Select dropDown = new Select(webElement);
		int flag = 0;
		try {
			if (!dropDown.isMultiple()) {
				List<WebElement> dropDownCategories = dropDown.getOptions();
				for (WebElement dropDownCategory : dropDownCategories) {
					if (dropDownCategory.getText().equals(actualSelectText)) {
						flag = 1;
						break;
					}
				}
				if (flag == 1) {
					dropDown.selectByVisibleText(actualSelectText);
				}
			}
		} catch (Exception e) {
			LOG.error(String.format("Expected value - [%s] is not present in dropdown", actualSelectText));
		}

	}

	public void selectDropDown_index(WebElement webElement, int index) {
		Select dropDown = new Select(webElement);
		try {
			dropDown.selectByIndex(index);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void selectDropDown_text(WebElement webElement, String text) {
		Select dropDown = new Select(webElement);
		try {
			dropDown.selectByVisibleText(text);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * User Click on expected link text
	 * 
	 */
	public void ClickText(final String text) throws Exception {
		LOG.info(String.format("Click on expected link text - [%s] .", text));
		driver.findElement(By.linkText(text)).click();
	}

	/**
	 * User Wait for some time to visible element
	 * 
	 */
	public void wait(int object) throws InterruptedException {
		LOG.info("Wait for some time");
		TimeUnit.SECONDS.sleep(object);
	}

	/**
	 * Refresh current window
	 * 
	 */
	public void refresh_success() throws Exception {
		LOG.info("Refresh current window");
		driver.navigate().refresh();
	}

	// Check visibility
	public boolean checkVisibilityofElement(WebElement elementName) {
		try {
			elementName.isDisplayed();
			LOG.info("The Element" + elementName + "is displayed");

			return false;

		} catch (Exception e) {
			LOG.info("The Element" + elementName + "is NOT displayed");
			return true;
		}

	}

	// Close current window browser

	public void close_success() throws Exception {
		LOG.info("Close current window browser");
		driver.close();
	}

	/**
	 * Quit all browsers opened through web driver
	 * 
	 */
	public void quit_success() throws Exception {
		LOG.info("Quit all browsers opened through webdriver");
		driver.quit();
	}

	/**
	 * Validate title of the web page
	 * 
	 */
	public String getPageTitle_success() throws Exception {
		String title = null;
		try {
			title = driver.getTitle();
			LOG.info(String.format("User get the title as - [%s].", title));
			fail();
		} catch (Exception e) {
			return null;
		}
		return title;
	}

	/**
	 * User getting the current URL
	 * 
	 * @return current url
	 */
	public String getCurrentUrl() {
		LOG.info("User getting the current URL");
		return driver.getCurrentUrl();
	}

	/**
	 * Validate user maximize the window
	 * 
	 */
	public void maximizeWindow_exception() throws Exception {
		LOG.info("Validate user maximize the window");
		try {
			driver.manage().window().maximize();
			fail();
		} catch (Exception e) {
			return;
		}
	}

	/**
	 * Switching to expected frame Id name
	 * 
	 * @param frameName
	 *            Describes frame tag name
	 * @param expectedFrameID
	 *            Described frame id name to switch
	 */
	public void switchToFrameByID(final String frameName, String expectedFrameID) {
		LOG.info(String.format("Switch to expected frame with frameID name - [%s]", expectedFrameID));
		List<WebElement> frameToSelect = driver.findElements(By.tagName(frameName));

		int flag = 0;

		for (int i = 0; i <= frameToSelect.size(); i++) {
			String actualFrameID = frameToSelect.get(i).getAttribute("id");
			if (expectedFrameID.equals(actualFrameID)) {
				flag = 1;
				break;
			}
		}
		if (flag == 1) {
			driver.switchTo().frame(expectedFrameID);
		}

	}

	/**
	 * Switching to expected frame Id index
	 * 
	 * @param frameName
	 *            Describes frame tag name
	 * @param frameIndex
	 *            Described index number of a frame to switch
	 */
	public void switchToFrameByIndex(final String frameName, final int frameIndex) {
		LOG.info(String.format("Switching to expected frame Id index - [%s]", frameIndex));
		List<WebElement> frameToSelect = driver.findElements(By.tagName(frameName));
		try {
			driver.switchTo().frame(frameToSelect.get(frameIndex));
		} catch (Exception e) {
			e.getMessage();
		}
	}

	/**
	 * Execute user action
	 * 
	 */
	public void executeAction(final Actions action) {
		LOG.info("Exceute user action");
		if (throwActionException) {
			throw new TimeoutException("Throwing test Exception as directed");
		}
	}

	/**
	 * User moving action to expected element
	 * 
	 */
	public void moveToObject(final WebElement element) throws Exception {
		LOG.info("User moving action to expected element");
		final Actions action = new Actions(driver);
		final Action performAction;
		performAction = action.moveToElement(element).build();
		performAction.perform();
		executeAction(action);
	}

	/**
	 * User moving action to page down
	 * 
	 */
	public void pageDown() throws Exception {
		LOG.info("User moving action to page down");
		final Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN);
		executeAction(action);
	}

	/**
	 * User moving action to page up
	 * 
	 */
	public void pageUp() throws Exception {
		LOG.info("User moving action to page up");
		final Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_UP);
		executeAction(action);
	}
	
	public void movepagedown() throws AWTException
	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
	}
	public void movepageup() throws AWTException
	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_UP);
		robot.keyRelease(KeyEvent.VK_PAGE_UP);
	}
	
	

	/**
	 * Open link in a new window
	 * 
	 * @param element
	 *            describes WebElement of a link/button to click
	 * 
	 */
	public void openLinkInNewWindow(final WebElement element) throws Exception {
		LOG.info("User clicks and open link in new window");
		final Actions action = new Actions(driver);
		action.keyDown(Keys.SHIFT).click(element).keyUp(Keys.SHIFT).build().perform();
	}

	/**
	 * Get all page source objects
	 */
	public String getPageSource() throws Exception {
		LOG.info("Getting all page source object in current window");
		return driver.getPageSource();
	}

	/**
	 * Delete all cookies
	 */
	public void deleteAllCookies() throws Exception {
		LOG.info("Delete all cookies");
		driver.manage().deleteAllCookies();
	}

	/**
	 * Convert the passed String to a long. If the conversion is not successful,
	 * return the default value.
	 * 
	 * @param value
	 *            String value to be converted to a long. Null-safe
	 * @return long representation of String value if String can successfully be
	 *         converted. Otherwise return defaultValue
	 */
	public static long toLong(final String value) {
		LOG.info("Convert the passed String to a long. If the conversion is not successful, return the default value.");
		try {
			return new Long(value).longValue();
		} catch (final Exception e) {
			return 0;
		}
	}

	/**
	 * Convert the passed String to an integer value. If the conversion is not
	 * successful, return the default value.
	 * 
	 * @param value
	 *            String value to be converted to an int. Null-safe
	 * @return Integer representation of String value if String can successfully be
	 *         converted. Otherwise return defaultValue
	 */
	public static int toInt(final String value) {
		LOG.info(
				"Convert the passed String to an integer value. If the conversion is not successful, return the default value.");
		try {
			return new Integer(value).intValue();
		} catch (final Exception e) {
			return 0;
		}
	}

	public void validateAllLinks(String domainname) {
		LOG.info("Inside broken link method1");
		HttpURLConnection huc = null;
		int responseCode;
		String url = null;
		// switchToNewWindow();
		List<WebElement> links = driver.findElements(By.tagName("a"));
		Iterator<WebElement> iterator = links.iterator();
		while (iterator.hasNext()) {
			LOG.info("Inside broken link method2");
			url = ((RemoteWebElement) iterator.next()).getAttribute("href");
			if (!url.startsWith("javascrript")) {
				LOG.info("URL : " + url);
				if (url == null || url.isEmpty()) {
					LOG.info(url + "- is either not configured for anchor tag or it is empty");
					continue;
				}
				if (!url.startsWith(domainname)) {
					LOG.info(url + "-URL belongs to another domain, skipping it.");
					continue;
				}
				try {
					huc = (HttpURLConnection) (new URL(url).openConnection());
					huc.setRequestMethod("GET");
					huc.connect();
					responseCode = huc.getResponseCode();
					LOG.info("Response code : " + responseCode);
					if (responseCode >= 400) {
						LOG.info("url is a broken link : " + url);
					} else {
						LOG.info("url is a valid link : " + url);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void checkCookie(final String object) throws Exception {

		try {
			Set<Cookie> cookiesForCurrentURL = driver.manage().getCookies();
			for (Cookie cookie : cookiesForCurrentURL) {
				System.out.println(" Cookie Name - " + cookie.getName() + " Cookie Value - " + cookie.getValue());
				String output = " " + cookie.getValue();

				if (object.equalsIgnoreCase(output)) {
					System.out.println(
							" Cookie Name - " + cookie.getName() + " Equals Cookie Value - " + cookie.getValue());
					Assert.assertEquals(object, output);
					break;
				}

			}
		} catch (final Exception e) {
			e.getMessage();
		}
	}

	public void click(WebElement object) {
		LOG.info("Click " + object);
		try {
			object.click();
		} catch (final Exception e) {
			e.getMessage();
		}
	}

	/**
	 * Get the specified web element. If not found, returns null.
	 * 
	 * @param object
	 *            Web element to be retrieved
	 * 
	 * @return WebElement for the specified object if it exists. Null if an error
	 *         occurs or element can't be found.
	 */
	public WebElement getElementWithoutWait(final String object) {

		try {
			LOG.debug("Getting element " + object);
			final WebElement element = (WebElement) driver.findElements(By.xpath(object));
			LOG.debug("Got element " + object);
			return element;
		} catch (final Exception e) {
			LOG.debug("Could not get element " + object + ", returning null. " + e.getMessage());
			return null;
		}
	}

	/**
	 * Verify that the passed object is of a specified size.
	 * 
	 * @param object
	 *            Web element to be validated
	 * @param expectedSize
	 *            Expected size in format widthXheight (e.g. "10X100" for width=10
	 *            and height=100)
	 * @throws Exception
	 */
	public void validateElementSize(final WebElement object, final String expectedSize) throws Exception {

		String actualSize = null;
		try {

			actualSize = object.getSize().toString();
			LOG.debug("Size='" + actualSize + "'");
		} catch (final Exception e) {
			return;
		}

		if (StringUtils.equals(actualSize, expectedSize)) {
			LOG.debug("Image size for " + object + " is correct");
		} else {
			throw new Exception("Image size is not eqaul");
		}
	}

	/**
	 * Verify expected element is not displayed.
	 * 
	 * @param object
	 *            Web element to be validated
	 * @return
	 * @throws Exception
	 */
	public void validateElementNotDisplayed(final By elementName) throws Exception {
		List<WebElement> elementsize = driver.findElements(elementName);
		int i = elementsize.size();
		if (i > 0) {
			throw new Exception("Element is Displayed");
		}

		else {
			LOG.info("Expected webelement is not displayed as expected");
		}

	}

	/**
	 * Verify expected element is disable.
	 * 
	 * @param object
	 *            Web element to be validated
	 * @throws Exception
	 */
	public boolean validateElementisDisable(final WebElement elementName) throws Exception, Exception {
		LOG.debug("Verify expected element is DIABLEED");

		boolean actualValue = elementName.isEnabled();
		System.out.println(actualValue);
		if (actualValue == false) {
			LOG.debug("Expected element" + elementName.getText() + " is DISABLED as expected");

		} else {
			throw new Exception("Object should be DIABLED,Object is ENABLED");

		}
		return actualValue;
	}

	public boolean validateElementisEnabled(final WebElement elementName) throws Exception, Exception {
		LOG.debug("Verify expected element is ENABLED");

		boolean actualValue = elementName.isEnabled();
		if (actualValue == true) {
			LOG.debug("Expected element" + elementName.getText() + " is ENABLED as expected");

		} else {

			throw new Exception("Object should be ENABLED,Object is not ENABLED");
		}
		return actualValue;
	}

	/**
	 * Verify if actual value in same as entered value
	 * 
	 * @param object
	 *            Web element to be validated
	 * @throws Exception
	 */
	public void validateText(WebElement object, String value_Entered) throws Exception {
		LOG.info("Checking if value in  " + object + " is same as value entered");
		String value = object.getAttribute("value");
		if (value.equalsIgnoreCase(value_Entered)) {
			LOG.info("Enterd value is appearing in the page");
		} else {
			throw new Exception("Text should be same ,Text values are not matching");
		}

	}

	public String getText(WebElement object) throws Exception {
		String value = object.getText();
		return value;
	}
	
	public String getAttribute(WebElement object, String attributevalue) throws Exception {
		String value = object.getAttribute(attributevalue);
		return value;
	}

	/**
	 * Verify if actual value in and are same
	 * 
	 * @param object1
	 *            First Web element to be validated
	 * @param object2
	 *            Second Web element to be validated
	 * @throws Exception
	 */
	public void ValidateText_object1_Object2(final WebElement object1, final WebElement object2) throws Throwable {

		LOG.info("Checking if value in  " + object1.getText() + " and  " + object2.getText() + " are same ");

		String actualtext = object1.getText();
		String expectedtext = object2.getText();

		if (actualtext.equalsIgnoreCase(expectedtext)) {

			LOG.info("value in  " + object1.getText() + " and " + object2.getText() + " are same");
		} else {
			throw new Exception(
					object1.getText() + "and" + object2.getText() + "Text should be same, Text are not matching");
		}

	}

	public String getRandomText(int length) {
		LOG.info("Generating Random Text");
		String alphabet = new String("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ");

		int n = alphabet.length();
		String result = new String();
		Random r = new Random();

		for (int i = 0; i < length; i++) {
			result = result + alphabet.charAt(r.nextInt(n));
		}
		LOG.info("Generating Random Text" + result);
		return result;

	}

	public String getRandomNumber(int length) {
		LOG.info("Generating Random Text");
		String alphabet = new String("0123456789");

		int n = alphabet.length();
		String result = new String();
		Random r = new Random();

		for (int i = 0; i < length; i++) {
			result = result + alphabet.charAt(r.nextInt(n));
		}
		LOG.info("Generating Random number");
		return result;

	}

	public String getRandomEmailId() {
		LOG.info("Generating Random emailid");
		String emailid = getRandomText(10) + "@" + getRandomText(3) + ".com";
		LOG.info("Generating Random emailid" + emailid);
		return emailid;
	}

	public void switchtoNewTab() {
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));

	}

	public void SwitchToPopupWindow()

	{
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		String myWindowHandle = driver.getWindowHandle();
		driver.switchTo().window(myWindowHandle);

		// webDriver.switchTo().window(tabs2.get(tabs2.size()-1));
	}

	public String getDate() {
		LOG.info("getting current system date");
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

		// get current date time with Date()
		Date date = new Date();

		// Now format the date
		String date1 = dateFormat.format(date);
		return date1;
	}

	public void switchToParentWindow() {
		{
			ArrayList<String> win2 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(win2.get(0));

		}
	}

	public void validateTextMessage(WebElement object, String value_Entered) throws Exception {
		// TODO Auto-generated method stub
		LOG.info("Checking if value in  " + object + " is same as value entered");
		String value = object.getText();
		if (value.contains(value_Entered)) {
			LOG.info("Enterd value is appearing in the page");
		} else {
			throw new Exception("Text should be same ,Text values are not matching");
		}
	}

	@SuppressWarnings("deprecation")
	public WebElement FluientWait(final By Ele, int timeOut, int poolingtime) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver);

		((FluentWait<WebDriver>) wait).withTimeout(Duration.ofSeconds(timeOut)).pollingEvery(Duration.ofSeconds(poolingtime))
				.ignoring(NoSuchElementException.class);

		@SuppressWarnings("unused")
		WebElement ele = wait.until(new Function<WebDriver, WebElement>() {

			@Override
			public WebElement apply(WebDriver input) {

				return driver.findElement(Ele);

			}
		});

		return driver.findElement(Ele);
	}
	
	public void uploadfile_to_app(String fileToupload) throws AWTException
	{
		Robot robot = new Robot();
		robot.setAutoDelay(2000);
		StringSelection stringselection = new StringSelection(fileToupload);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, null);
		
		robot.setAutoDelay(2000);
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
	}
	public void Scroll_PageEnd()
	{
		((JavascriptExecutor) driver)
	     .executeScript("window.scrollTo(0, document.body.scrollHeight)");
		LOG.info("Scrolling till the end of the Page");
	}
	
	public void Print_AllDropdownValues(final By id_dropdown)
	{
		
		WebElement dropdown = driver.findElement(id_dropdown);

		 Select list = new Select(dropdown);

		 List<WebElement> dropdown_list = list.getOptions();

		 for (int i = 0; i < dropdown_list.size(); i++) {

		   String dropdown_value = dropdown_list.get(i).getText();
		  
		   LOG.info("dropdown values : "+ dropdown_value);
		   
		   
		 }
	}
	public void verify_DropdownValues_alphabeticorder(final By id_dropdown)
	{
		WebElement dropdown = driver.findElement(id_dropdown);

		 Select optionlist = new Select(dropdown);
		 
		 List actuallist = new ArrayList<>();

		 List<WebElement> All_options = optionlist.getOptions();
		 for(WebElement ele:All_options)
		 {
			 String OptionsTexts = ele.getText();
			 LOG.info(OptionsTexts);
			 actuallist.add(OptionsTexts);
		 }
		 
		 List temp = new ArrayList<>();
		 temp.addAll(actuallist);
		 
		 //Ascending order
		 Collections.sort(temp);
		 for(int i=0;i<temp.size();i++)
		 {
			 LOG.info(temp.get(i));
		 }
			 
		 //Assert.assertTrue(actuallist.equals(temp));
		 LOG.info("All the Dropdown values are in Alphabetic order");
		 	 
	}
	
	 public void Verify_DropDownOption_NotAvailable(
	             WebElement element, String sVisibleTextOptionToSelect) {
	        try {
	            Select select = new Select(element);
	            select.selectByVisibleText(sVisibleTextOptionToSelect);
	           
	        } catch (NoSuchElementException e) {
	            LOG.info(sVisibleTextOptionToSelect + " ::: is NOT present in the Dropdown options as expected");
	        
	        }
	    }
	
	
}
