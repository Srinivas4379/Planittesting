package testscripts;

import org.testng.annotations.Test;

import base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import util.ProductPayload;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.*;

import java.util.List;
import java.util.Map;

public class ProductAPITest extends BaseTest {

	@Test
	public void testProductSearchAPI() {
		Response response = RestAssured.given().header("Authorization", "Bearer token").contentType(ContentType.JSON)
				.queryParam("query", "laptop").queryParam("Price", "900").body(ProductPayload.getPayload()).when()
				.post().then().statusCode(200).extract().response();

		String status = response.path("status");

		assertThat("Status should be 'success'", status, equalTo("success"));

		@SuppressWarnings("unchecked")
		List<Map<String, Object>> requestProducts = (List<Map<String, Object>>) ProductPayload.getPayload().get("products");
		List<Map<String, Object>> responseProducts = response.jsonPath().getList("products");

		assertThat("Number of products should match", responseProducts.size(), equalTo(requestProducts.size()));

	}

}
