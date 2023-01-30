package qa.framework.api;

public interface ResponseBody {
	
	public Object jsonPath(String path);
	public String asString();

}
