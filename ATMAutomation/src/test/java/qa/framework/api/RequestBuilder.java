package qa.framework.api;

public interface RequestBuilder {
	
	public RequestBuilder setCertificate(String path, String password);
	public RequestBuilder buildurl();
	public RequestBuilder setProxy(String host, int port);
	public RequestBuilder setheader(String headerName, String headervalue);
	public RetriveResponse executeRequest(MethodType type);
	
	
	
	
	
	

}
