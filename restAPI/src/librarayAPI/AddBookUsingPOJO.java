package librarayAPI;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import pojo.BookPojo;

public class AddBookUsingPOJO {
	BookPojo bp= new BookPojo();
	
	public  BookPojo getBookPayload()
	{	 
		bp.setAuthor("Yogesh Bansal");
		bp.setAisle("aaa");
		bp.setIsbn("bbb01");
		bp.setName("Bansal Thinks");
		
		return bp;
	}
	
	@Test()
	public void addBookFromJsonFile() throws IOException {
		RestAssured.baseURI = "http://216.10.245.166";
		given().log().all()
				.body(getBookPayload())
				.when().post("Library/Addbook.php").then().log().all().statusCode(200);

}}
