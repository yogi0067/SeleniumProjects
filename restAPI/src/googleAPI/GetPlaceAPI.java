package googleAPI;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import files.JsonDataFile;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class GetPlaceAPI {

	
	public static void main(String[] args) {
		//Add Place Code for first Time
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body(JsonDataFile.getPlaceData()).when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).extract().response().asString();
		
		//Fetching Place Id from the response after add response
		System.out.println(response);
		JsonPath jp= new JsonPath(response);
		String placeId=jp.getString("place_id");
		System.out.print(placeId);
		
		//Updating the address using existing Plcce id
		
		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body(JsonDataFile.getUpdatedPlaceData(placeId)).when().put("maps/api/place/update/json")
		.then().log().all().assertThat().statusCode(200)
		.body("msg", equalTo("Address successfully updated"));
		
		
		//Get the Please using place id
		
		String getResponse=given().log().all()
		.queryParam("key", "qaclick123")
		.queryParam("place_id", placeId)
		.when().get("maps/api/place/get/json").then().log().all().statusCode(200).extract().response().asString();
		
		System.out.println(getResponse);
		
		
		
	}
}
