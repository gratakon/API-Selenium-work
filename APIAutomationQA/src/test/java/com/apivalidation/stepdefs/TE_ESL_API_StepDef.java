package com.apivalidation.stepdefs;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.codoid.products.exception.FilloException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TE_ESL_API_StepDef {

	private static final Logger LOG = LogManager.getLogger(TE_ESL_API_StepDef.class);

	public static RequestSpecification request;
	public static Response response;
	public static String requestJson;
	private static int fileCounter = 0;
	String url = "jdbc:mysql://localhost:3306/APIQAdbt?user=root&password=Ratakonda@70300";
	Connection conn;
	Statement stat;
	String endpointvalue;

	public String requestFile(String request) {
		// PropertyFileUtils property = new
		// PropertyFileUtils(".\\src\\main\\java\\extent.properties");

		// String reportDirPath = property.getProperty("extent.reporter.spark.out");
		// String reportDirPath =
		// "C:\\Users\\10676583\\eclipse-workspace\\APIAutomationQA\\target\\cucumber-reports\\Spark";
		String reportDirPath = "C:\\Users\\10676583\\git\\repository\\APIAutomationQA\\target\\cucumber-reports\\Spark";
		// LOG.info("The reportDirPath is:: " + reportDirPath);

		String fileName = "file-" + (++fileCounter) + ".json";
		// LOG.info("The fileName is:: " + fileName);
		String filePath = reportDirPath + "/" + fileName;
		LOG.info("The request file path is:: " + filePath);
		FileManager.getFileManagerObj().createFile(filePath);
		FileManager.getFileManagerObj().write(filePath, request);

		return fileName;

	}

	public String responseFile(String response) {
		// PropertyFileUtils property = new
		// PropertyFileUtils("./src/main/java/extent.properties");
		// String reportDirPath = property.getProperty("extent.reporter.spark.out");
		// String reportDirPath =
		// "C:\\Users\\10676583\\eclipse-workspace\\APIAutomationQA\\target\\cucumber-reports\\Spark";
		String reportDirPath = "C:\\Users\\10676583\\git\\repository\\APIAutomationQA\\target\\cucumber-reports\\Spark";
		// LOG.info("The reportDirPath is:: " + reportDirPath);
		String fileName = "file-" + (++fileCounter) + ".json";
		// LOG.info("The fileName is:: " + fileName);
		String filePath = reportDirPath + "/" + fileName;
		LOG.info("The response file path is:: " + filePath);
		FileManager.getFileManagerObj().createFile(filePath);
		FileManager.getFileManagerObj().write(filePath, response);

		return fileName;

	}

	@When("^base uri is set for \"([^\"]*)\" endpoint$")
	public void base_uri_is_set_for_something_endpoint(String DBTestdata_key) throws SQLException {
		RestAssured.reset();
		// String baseURI = baseurivalue;
		String baseURI = establish_sqlserver_connection(DBTestdata_key);
		LOG.info("The BaseURI Key to DB is : " + DBTestdata_key);
		RestApiUtils.setBaseURI(baseURI);
		Reporter.addStepLog("<strong>Base URI is set as:</strong>" + baseURI);

	}

	@And("^user set \"([^\"]*)\" for endpoints")
	public void user_set_something_for_endpoint(String DBTestdata_key) throws SQLException {
		// String basepath = endpointvalue;
		String basepath = establish_sqlserver_connection(DBTestdata_key);
		LOG.info("The Endpoint Key to DB is : " + DBTestdata_key);
		RestApiUtils.setBasePath(basepath);
		RestApiUtils.requestSpecification = RestAssured.given();
		request = RestApiUtils.requestSpecification;
		Reporter.addStepLog("<strong>Base path is set as:</strong>" + basepath);

	}

	@Given("^user generate qa authentication token for EISL endpoints parallel execution$")
	public void user_generate_qa_authentication_token_for_EISL_endpoints_parallel_execution() throws KeyManagementException, UnrecoverableKeyException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IOException {

		Common.generateQAToken_environment();
	}
	
	@Given("^user generate qa authentication token for EISL endpoints")
	public void user_generate_qa_authentication_token_for_EISL_endpoints(String Tokenvalue){

		Common.generateQAToken_ProvideToken(Tokenvalue);
	}

	@And("^user add request json \"([^\"]*)\" to request body$")
	public void user_add_request_json_something_to_request_body(String requestJsonFileName) {
		String userDir = System.getProperty("user.dir");

		String filePath = FileManager.getFileManagerObj().searchFile(userDir, requestJsonFileName);

		TE_ESL_API_StepDef.requestJson = FileManager.getFileManagerObj().readFile(filePath);

	}

	@And("^user set relaxed HTTPS for the current endpoint$")
	public void user_set_relaxed_HTTPS_for_the_current_endpoint() {
		RestApiUtils.requestSpecification.relaxedHTTPSValidation();
	}

	@And("^user set proxy details \"([^\"]*)\" host name and \"([^\"]*)\" port$")
	public void user_set_proxy_details_something_host_name_and_something_port(String hostname, String port) {
		RestApiUtils.requestSpecification.proxy(hostname, Integer.parseInt(port));
	}

	@And("^user execute \"([^\"]*)\" request \"([^\"]*)\" json$")
	public void user_execute_something_request_something_json(String methodtype, String jsonCondition) {
		user_execute_something_request_something_json(methodtype, jsonCondition, "application/json");
	}

	@And("^user execute \"([^\"]*)\" request \"([^\"]*)\" json \"([^\"]*)\" contentType$")
	public void user_execute_something_request_something_json(String methodType, String jsonCondition,
			String contentType) {
		methodType = methodType.trim().toLowerCase();
		jsonCondition = jsonCondition.trim().toLowerCase();

		if (jsonCondition.equals("without")) {
			// no code required
		} else if (jsonCondition.equals("with")) {

			RestApiUtils.requestSpecification.contentType(contentType);
			LOG.info("Content Type is set as: " + contentType);
			if (Objects.nonNull(requestJson) && !requestJson.isEmpty())
				;
			{
				RestApiUtils.requestSpecification.body(requestJson);
				LOG.info("The request Json is : " + requestJson);

				String requestJsonFileName = requestFile(requestJson);
				String html = "<lable><font color=#1E90FF>Click on link to see Request</font></lable>" + "<a href=\""
						+ requestJsonFileName
						+ "\" target=\"_blank\" style=\"float:right\"><img src=\"core-image-hyper-link.png\" style=\"background-color:aliceblue\"></a>";
				Reporter.addStepLog(html);

			}
		} else {
			Reporter.addStepLog(
					"<strong><font color=#DC143C>!!!! INCORRECT JSON CONDITION PROVIDED !!! </font></strong>"
							+ jsonCondition);
			Assert.fail("!!! INCORRECT JSON CONDTION PROVIDED !!!" + jsonCondition);
		}
		switch (methodType) {
		case "post": {
			response = RestApiUtils.requestSpecification.post();
			break;
		}
		case "put": {
			response = RestApiUtils.requestSpecification.put();
			break;
		}
		case "get": {
			response = RestApiUtils.requestSpecification.get();
			break;
		}
		case "delete": {
			response = RestApiUtils.requestSpecification.delete();
			break;
		}
		case "patch": {
			response = RestApiUtils.requestSpecification.patch();
			break;
		}
		default: {
			Reporter.addStepLog(
					"<strong><font color=#DC143C>!!!! INCORRECT HTTP METHOD TYPE PROVIDED !!! </font></strong>"
							+ methodType.toUpperCase());
			Assert.fail("!!! INCORRECT HTTP METHOD TYPE PROVIDED !!!" + methodType.toUpperCase());
		}
		}
		Reporter.addStepLog("<strong>HTTP Method Executed: </strong>" + methodType.toUpperCase());

		String responseBody = response.body().asString();
		LOG.info("The Response Json is : " + responseBody);
		if (responseBody.length() > 0) {
			String fileName = responseFile(responseBody);

			String html = "<lable><font color=#1E90FF>Click on link to see Response</font></lable>" + "<a href=\""
					+ fileName
					+ "\" target=\"_blank\" style=\"float:right\"><img src=\"core-image-hyper-link.png\" style=\"background-color:aliceblue\"></a>";
			Reporter.addStepLog(html);
		}
		long responseTime = response.getTimeIn(TimeUnit.SECONDS);
		if (responseTime > -1) {
			Reporter.addStepLog("<Strong>Response Time: </strong>" + responseTime + "<strong> Sec.</strong>");
		}

	}

	@Then("user verifies the response status code as \"([^\"]*)\"$")
	public void user_verifies_the_response_status_code_as_something(String expectedStatusCode) throws Throwable {
		int actResStatusCode = response.getStatusCode();

		if (expectedStatusCode.contains(String.valueOf(actResStatusCode))) {
			Reporter.addStepLog("Status verification passed !!");
			Reporter.addStepLog("<strong>Expected Status code: </strong>" + expectedStatusCode);
			Reporter.addStepLog("<strong>Actual Status code: </strong>" + actResStatusCode);

		} else {
			Reporter.addStepLog("Status verification failed !!");
			Reporter.addStepLog("<strong>Expected Status code: </strong>" + expectedStatusCode);
			Reporter.addStepLog("<strong>Actual Status code: </strong>" + actResStatusCode);
			Assert.fail("Status mismatch");
		}

	}

	@And("^user set \"([^\"]*)\" parameter (.+) as (.+) for current endpoint$")
	public void user_set_something_parameter_as_something_for_current_endpoint(String ParameterType,
			String ParameterName, String ParamaterValue) {
		ParameterName = ParameterName.replace("\"", "");
		ParamaterValue = ParamaterValue.replace("\"", "");

		ParameterType = ParameterType.trim().toLowerCase();

		switch (ParameterType) {
		case "path": {
			RestApiUtils.requestSpecification.pathParam(ParameterName, ParamaterValue);
			break;
		}
		case "query": {
			RestApiUtils.requestSpecification.queryParam(ParameterName, ParamaterValue);
			break;

		}
		case "form": {
			RestApiUtils.requestSpecification.formParam(ParameterName, ParamaterValue);
			break;

		}
		default: {
			Reporter.addStepLog(
					"<strong><font color=#DC143C>!!!! INCORRECT PARAMETER TYPE PROVIDED !!! </font></strong>"
							+ ParameterType.toUpperCase());
			Assert.fail("!!! INCORRECT PARAMETER TYPE PROVIDED !!!" + ParameterType.toUpperCase());
		}
		}
		Reporter.addStepLog("<strong>Parameter Type: </strong>" + ParameterType);
		Reporter.addStepLog("<strong>Parameter Name: </strong>" + ParameterName);
		Reporter.addStepLog("<strong>Paramater Value: </strong>" + ParamaterValue);

	}

	@Given("^Read all the data from '(.+)' in \"([^\"]*)\" for '(.+)'$")
	public void Read_all_the_data_from_something_in_something_for_Something(String SheetName, String ExcelsheetName,
			String rowName) throws FilloException {
		CaptureMultipleCompleteScenarioTestData(SheetName, ExcelsheetName, rowName);

	}

	public void CaptureMultipleCompleteScenarioTestData(String SheetName, String ExcelsheetName, String rowName) {

	}

	public String establish_sqlserver_connection(String DBTestdata_key) throws SQLException {

		DBConnectionManager DBInstance = DBConnectionManager.getInstance(url);
		LOG.info("The DB URL is :" + url);
		conn = DBInstance.getConnection();
		LOG.info("The DB connection is sucessfull!!!");
		stat = conn.createStatement();
		ResultSet rs = stat
				//.executeQuery("select Testdata_value from TestdataAPI where Testdata_key ='" + DBTestdata_key + "'");
		.executeQuery("select Testdata_uservalue from DummyTestdataAPI where Testdata_userkey ='" + DBTestdata_key + "'");

		while (rs.next()) {
			endpointvalue = rs.getNString(1);
			LOG.info("The Testdata value from DB is  : " + endpointvalue);

		}
		conn.close();
		LOG.info("The DB connection is Closed****");
		return endpointvalue;

	}

}
