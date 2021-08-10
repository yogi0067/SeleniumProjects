package oath2concept;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.path.json.JsonPath;

public class Oath2Test {
	public static void main(String[] args) throws InterruptedException {
		
		/*WebDriverManager.iedriver().setup();
		WebDriver driver = new InternetExplorerDriver();
		try {
		driver.get("https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php");
		}
		catch(Exception e)
		{}
		
		driver.findElement(By.xpath("//*[@type='email']")).sendKeys("yogom");
		driver.findElement(By.xpath("//*[@type='email']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys("");
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys(;*/
		
		//NOTE: the Above Code is not supported now as google can not permist automation script to login 
		//Now copy the above Url and fill your information of email and passwrod and then copy the generated url below. 
		
			String url= "https://rahulshettyacademy.com/getCourse.php?code=4%2F0AX4XfWj2VdS1iYdZIRLkCFQ45Bi855DgGmbHkUJmy_1a6vbUBr_UWGkciBt4P7_BqAJ8yw&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=none#";
			System.out.println(url);
			String code=url.split("code=")[1].split("&scope")[0];
			System.out.println(code);
		
		 
		

		String response = given()
				.urlEncodingEnabled(false)//this is for if code variable have some special character it will not treated as integer
				.queryParams("code", code)
				.queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
				.queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
				.queryParams("grant_type", "authorization_code").when()
				.post("https://www.googleapis.com/oauth2/v4/token").asString();
		
		
		
		JsonPath js= new JsonPath(response);
		String accessToken=js.getString("access_token");
		
		
		
		String courses=given()
		.queryParam("access_token", accessToken)
		.when()
		.get("https://rahulshettyacademy.com/getCourse.php").asString();
		System.out.println(courses);
		
		

	}

}