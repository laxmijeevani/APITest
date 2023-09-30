package GherkinKeywords;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateResource {
	@BeforeClass
	public void setup()
	{
		RestAssured.baseURI="https://reqres.in/api";
	}
	
	@Test
	public void updateResource()
	{
		String requestbody="{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"SSE\"\r\n"
				+ "}";
		//to update the user details
		Response response=RestAssured.given()
				.contentType(ContentType.JSON)
				.body(requestbody)
				.when() 
				.put("/users/2")
				.then()
				.extract().response();
		System.out.println("status code is"+response.getStatusCode());
		System.out.println("response is"+response.jsonPath().getString("name"));
		System.out.println("response is"+ response.jsonPath().getString("job"));
	}

}
