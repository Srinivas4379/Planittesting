package base;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;

public class BaseTest {
	
	
	@BeforeClass
	public void setup(){
		RestAssured.baseURI="http://google.com";
		RestAssured.basePath="/products/search.php";
		
	}

}
