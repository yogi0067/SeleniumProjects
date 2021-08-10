package librarayAPI;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.JsonDataFile;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EndtoEndProcess {

	// in this code we will first add the book into database and then get it with
	// Book id and Book Author and the delete the book with book iD

	@Test(enabled = false)
	public void addBookFromJsonFile() throws IOException {
		RestAssured.baseURI = "http://216.10.245.166";
		given().log().all()
				.body(new String(Files.readAllBytes(
						Paths.get("C:\\Users\\think\\eclipse-workspace\\restAPI\\src\\files\\PayLoad.json"))))
				.when().post("Library/Addbook.php").then().log().all().statusCode(200);

	}
	@Test(dataProvider = "getData")
	public void addBookFromDataProvider(String isbn, String aisle) {
		RestAssured.baseURI = "http://216.10.245.166";
		given().log().all().body(JsonDataFile.getBookData(isbn, aisle)).when().post("Library/Addbook.php").then().log()
				.all().statusCode(200);
	}
	@DataProvider
	public Object[][] getData() {
		Object[][] data = { { "zz", "11" }, { "zz", "12" }, { "zz", "13" } };
		return data;
	}
}
