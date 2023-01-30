package com.ALD.Listeners;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.ALD.Base.BaseDriver;

public class ITestListenerImpl extends BaseDriver implements ITestListener {

	private static final Logger LOG = LogManager.getLogger(ITestListenerImpl.class);

	// onStart
	// onTestStart
	// onTestSuccess

	public void onStart(ITestContext context) {
		LOG.info("Execution started on UAT env...");
		// extent = setUp();

	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

		LOG.info("Test Case execution Started: " + result.getInstanceName().getClass());

	}

	public void onTestSuccess(ITestResult result) {

	}

	public void onTestFailure(ITestResult result) {

//		try {
//			captureScreenShot();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		driver.quit();
//		LOG.info("Test Case " + result.getInstanceName() + " execution Failed");

	}

	public void onTestSkipped(ITestResult result) {
		LOG.info("Test Case " + result.getInstanceName() + " execution Skiped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		LOG.info("Execution completed on UAT env...");
		// extent.flush();
		LOG.info("Generated Report. . .");

	}

}
