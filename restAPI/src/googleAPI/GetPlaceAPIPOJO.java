package googleAPI;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import files.JsonDataFile;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import pojo.GetPlace;

public class GetPlaceAPIPOJO {

	
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
		
		GetPlace getPlace=given()
		.queryParam("key", "qaclick123")
		.queryParam("place_id", placeId).expect().defaultParser(Parser.JSON) //this is used so we want response should be in jason format
		.when().get("maps/api/place/get/json").then().statusCode(200).extract().response().as(GetPlace.class);
		
		//System.out.println(getResponse);
		
		System.out.println(getPlace.getLanguage());
		System.out.println(getPlace.getLocation().getLatitude());
		
		
		
		
		
		
		
	}
}
