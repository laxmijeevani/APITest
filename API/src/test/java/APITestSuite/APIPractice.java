package APITestSuite;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

public class APIPractice {
	
	@BeforeClass
	public void setup()
	{
		RestAssured.baseURI="https://reqres.in/api";
	}
	@Test
	public void createResource()
	{
		//To store the data
		String requestbody="{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}";
		//To send the post request and capture the response and to specify the type of i/p data format
		Response response=RestAssured.given()
				.contentType(ContentType.JSON)
				.body(requestbody)
				.when()
				.post("/users")
				.then()
				.extract().response();
		//Assertions
		Assert.assertEquals(201, response.getStatusCode());
		Assert.assertEquals("morpheus", response.jsonPath().getString("name"));
		Assert.assertEquals("leader", response.jsonPath().getString("job"));
		System.out.println("status code is"+response.getStatusCode());
		System.out.println("response is"+response.getBody().asString());
	}
	@Test
	
	public void getResource()
	{
		//to send the getrequest and capture the response
		Response response=RestAssured.given()
				.when()
				.get("/users/2")
				.then()
				.extract().response();
		Assert.assertEquals(200, response.getStatusCode());
		Assert.assertEquals("Janet",response.jsonPath().getString("data.first_name"));
		Assert.assertEquals("Weaver",response.jsonPath().getString("data.last_name"));
		Assert.assertEquals("janet.weaver@reqres.in",response.jsonPath().getString("data.email"));
		//print status code and response body
		System.out.println("status code is"+response.getStatusCode());
		System.out.println("response is"+response.getBody().asString());
		System.out.println("First name:"+response.jsonPath().getString("data.first_name"));
		System.out.println("Last name:"+response.jsonPath().getString("data.last_name"));
		System.out.println("email:"+response.jsonPath().getString("data.email"));
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
