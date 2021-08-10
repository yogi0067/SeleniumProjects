package utilites;

import io.restassured.path.json.JsonPath;

public class JsonParser {

	public static JsonPath complexJson(String json)
	{
		JsonPath jp= new JsonPath(json);
		return jp;
	}
	
}
