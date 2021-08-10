package googleAPI;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import files.JsonDataFile;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class UpdatePlace1 {
	//in this program we first fetch Json Data from another file using JsonDataFile.getPlaceData() and also fetch the response from the output.
		//We stored the response into string and then convert that response into json format to get place ID
		//Now we will update the address of the recently added place using another method into body JsonDataFile.getUpdatedPlaceData
		public static void main(String[] args) {
			RestAssured.baseURI="https://rahulshettyacademy.com";
			String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
			.body(JsonDataFile.getPlaceData()).when().post("maps/api/place/add/json").then().assertThat().statusCode(200).extract().response().asString();
			
			System.out.println(response);
			JsonPath jp= new JsonPath(response);
			String placeId=jp.getString("place_id");
			System.out.print(placeId);
			
			
			
			given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
			.body(JsonDataFile.getUpdatedPlaceData(placeId)).when().put("maps/api/place/update/json").then().log().all().assertThat().statusCode(200)
			.body("msg", equalTo("Address successfully updated"));
			
			
			
			
			
		}
}
