package com.apivalidation.stepdefs;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class RestApiUtils {
	
	public static RequestSpecification requestSpecification;
	
	public static void setBaseURI(String baseURI) {
		RestAssured.baseURI = baseURI;
	}
	
	public static void setBasePath(String basePathTerm)
	{
		RestAssured.basePath=basePathTerm;
	}

}
