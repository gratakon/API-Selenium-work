package com.apivalidation.stepdefs;

import qa.framework.api.HttpClientUtils;
import qa.framework.api.MethodType;
import qa.framework.api.RetriveResponse;

public class Common {
	
	public static String token;
	
	public static void generateQAToken_ProvideToken(String Tokenvalue)
	{
		String pfx = "./src/test/resources/te/EISL/BASL/Configuration/certificates/qa_uat/eislqauat_123.pfx";
		String pwd = "123";
		HttpClientUtils.baseUrl = "https://uat-apigateway.broadridge.com/unicorn/v3";
		HttpClientUtils.basePath ="/token";
		
		RetriveResponse response = HttpClientUtils.given().setCertificate(pfx, pwd).buildurl().setProxy("10.98.21.24", 8080).setheader("subject", Tokenvalue).executeRequest(MethodType.POST);
		
		token = String.valueOf(response.getBody().jsonPath("token"));
		System.out.println("************Bearer token generated successful*********** ::" + token);
		
	}
	

}
