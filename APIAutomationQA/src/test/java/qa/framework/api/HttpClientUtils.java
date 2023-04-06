package qa.framework.api;

import java.io.File;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLContext;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustAllStrategy;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.ssl.SSLContexts;

import io.restassured.path.json.JsonPath;

public class HttpClientUtils implements RequestBuilder, RetriveResponse, ResponseBody {

	public static String basePath;
	public static String baseUrl;
	private static List<NameValuePair> formparams;
	private static List<Header> headers;
	private static HttpClientBuilder httpClientBuilder;
	private static HttpClientUtils httpClientUtils;
	private String bodyAsString;
	private HttpResponse response;

	public static RequestBuilder given() {

		formparams = new ArrayList<NameValuePair>();
		headers = new ArrayList<Header>();
		httpClientBuilder = HttpClients.custom();

		httpClientUtils = new HttpClientUtils();
		return httpClientUtils;

	}

	@Override
	public Object jsonPath(String path) {
		// TODO Auto-generated method stub
		JsonPath j = new JsonPath(bodyAsString);
		return j.get(path);
	}

	@Override
	public String asString() {
		// TODO Auto-generated method stub

		return bodyAsString;
	}

	@Override
	public int getStatusCode() {
		// TODO Auto-generated method stub
		return response.getStatusLine().getStatusCode();
	}

	@Override
	public String getStatusLine() {
		// TODO Auto-generated method stub
		return response.getStatusLine().toString();
	}

	@Override
	public ResponseBody getBody() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RequestBuilder setCertificate(String path, String password) {
		try {
			final KeyStore store = KeyStore.getInstance("PKCS12");
			try (FileInputStream stream = new FileInputStream(new File(path))) {
				store.load(stream, password.toCharArray());

			}
			SSLContext sslContext = SSLContexts.custom().loadKeyMaterial(store, password.toCharArray())
					.loadTrustMaterial(store, TrustAllStrategy.INSTANCE).build();

			final SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext,
					NoopHostnameVerifier.INSTANCE);
			final Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
					.register("http", new PlainConnectionSocketFactory()).register("https", sslsf).build();

			// final PoolingClientConnectionManager cm = new
			// PoolingClientConnectionManager(registry);
			// cm.setMaxTotal(100);

			// httpClientBuilder.setSSLSocketFactory(sslsf).setConnectionManager(cm);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return httpClientUtils;
	}

	@Override
	public RequestBuilder buildurl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RequestBuilder setProxy(String host, int port) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RequestBuilder setheader(String headerName, String headervalue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RetriveResponse executeRequest(MethodType type) {
		// TODO Auto-generated method stub
		return null;
	}

}
