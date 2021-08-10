package googleAPI;

import static io.restassured.RestAssured.*;

import files.JsonDataFile;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class AddPlace2 {
public static void main(String[] args) {
	//in this program we first fetch Json Data from another file using JsonDataFile.getPlaceData() and also fetch the response from the output.
	//We stored the response into string and then convert that response into json format to get place ID
	
	RestAssured.baseURI="https://rahulshettyacademy.com";
	String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
	.body(JsonDataFile.getPlaceData()).when().post("maps/api/place/add/json").then().assertThat().statusCode(200).extract().response().asString();
	
	System.out.println(response);
	JsonPath jp= new JsonPath(response);
	String placeId=jp.getString("place_id");
	System.out.print(placeId);
	
	
}
}
