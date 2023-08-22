package com.apivalidation.stepdefs;

import org.apache.logging.log4j.Logger;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class RestApiUtils2 {
	
	public static ThreadLocal<String> path; //Rest request path
	public static ThreadLocal<RequestSpecification> requestSpecification = new ThreadLocal<RequestSpecification>();
	//public static ThreadLocal<Logger> Log = new ThreadLocal.withInitial(() -> LoggerHelper.getLogger(RestApiUtils2.class));
	
	
	
	
	public static void setBaseURI(String baseURI) {
		RestAssured.baseURI = baseURI;
	}
	
	public static void setBasePath(String basePathTerm)
	{
		RestAssured.basePath=basePathTerm;
	}

}
