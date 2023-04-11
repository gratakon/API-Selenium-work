package com.apivalidation.stepdefs;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.net.ssl.SSLContext;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import gherkin.deps.com.google.gson.JsonObject;
import gherkin.deps.net.iharder.Base64.InputStream;

import qa.framework.api.HttpClientUtils;
import qa.framework.api.MethodType;
import qa.framework.api.RetriveResponse;

public class Common {
	
	public static String token;
	public static ThreadLocal<String> tokeen = new ThreadLocal<String>();
	
	
	//Method for normal execution with dynamic token
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
	//Method for parallel execution with dynamic token
	public static void generateQAToken(String Tokenvalue) throws KeyManagementException, UnrecoverableKeyException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IOException
	{
		HttpClientUtils.basePath ="/token";
		tokeen.set(sslConnect("./src/test/resources/te/EISL/BASL/Configuration/certificates/qa_uat/eislqauat_123.pfx",
				"V005ANIK","https://uat-apigateway.broadridge.com/unicorn/v3/token"));
		
		System.out.println("*************Bearer toekn generated successful******* ::" +token);
		
		
	}
	
	
	
	//method for parallel execution - environment and subject specific also 
	public static void generateQAToken_environment() throws KeyManagementException, UnrecoverableKeyException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IOException
	{
		
		HttpClientUtils.baseUrl = "https://uat-apigateway.broadridge.com/unicorn/v3";
		HttpClientUtils.basePath ="/token";
		
		FileInputStream fis;
		String env="";
		String qasub ="";
		String uatsub ="";
		String subject="";
		try {
			fis = new FileInputStream("./config.properties");
			Properties prop = new Properties();
			prop.load(fis);
			env=prop.getProperty("environment");
			qasub=prop.getProperty("qa_token");
			uatsub= prop.getProperty("uat_token");
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		if(env.equals("QA")) {
			subject=qasub;
		}
		else if(env.equals("UAT"))
		{
			subject=uatsub;
		}
		else {
			System.out.println("The given environment is invalid");
		}
		
		tokeen.set(sslConnect("./src/test/resources/te/EISL/BASL/Configuration/certificates/qa_uat/eislqauat_123.pfx",
				subject,"https://uat-apigateway.broadridge.com/unicorn/v3/token"));
		System.out.println("Generating token for "+env+" environment with subject : "+subject);
		System.out.println("*************Bearer toekn generated successful******* ::" +tokeen.get());
	}

		
		
		
	
	//method is not static in code
	public static String sslConnect(String path,String subjectName, String URL) throws NoSuchAlgorithmException, CertificateException, IOException, KeyStoreException, KeyManagementException, UnrecoverableKeyException
	{
		KeyStore keyStore = KeyStore.getInstance("pkcs12");
		FileInputStream keyStoreInput = new FileInputStream(path);
		keyStore.load(keyStoreInput, "123".toCharArray());
		
		@SuppressWarnings("deprecation")
		SSLContext sslContext = SSLContexts.custom().loadKeyMaterial(keyStore, "123".toCharArray()).useTLS().build();
		
		List<Header> headers = new ArrayList<Header>();
		HttpClientBuilder builder = HttpClientBuilder.create();
		@SuppressWarnings("deprecation")
		SSLConnectionSocketFactory sslConnectionFactory = new SSLConnectionSocketFactory(sslContext,SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
		builder.setSSLSocketFactory(sslConnectionFactory);
		Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create().register("https", sslConnectionFactory)
				.register("http", new PlainConnectionSocketFactory()).build();
		HttpClientConnectionManager ccm = new BasicHttpClientConnectionManager(registry);
		builder.setConnectionManager(ccm);
		headers.add(new BasicHeader("subject", subjectName));
		builder.setDefaultHeaders(headers);
		HttpHost proxy = new HttpHost("10.98.21.24", 8080);
		builder.setProxy(proxy);
		
		String token ="";
		try(CloseableHttpClient httpClient = builder.build()){
			
			final HttpPost httpget = new HttpPost(URL);
			ThreadLocal<HttpPost> httpgetThreadLocal = new ThreadLocal<HttpPost>() {
				@Override
				protected HttpPost initialValue() {
					return httpget;
				}
			};
			
			try(CloseableHttpResponse response = httpClient.execute(httpgetThreadLocal.get())){
				HttpEntity entity = response.getEntity();
				
				if(entity !=null) {
					JSONObject myObject = new JSONObject(EntityUtils.toString(entity));
					token = myObject.get("token").toString();
					
				}
				EntityUtils.consume(entity);
			}
		}
		
		if(token.isEmpty()) {
			return null;
		}else {
			return token;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	

}
