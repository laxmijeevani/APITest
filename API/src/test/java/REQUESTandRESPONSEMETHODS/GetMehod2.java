package REQUESTandRESPONSEMETHODS;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class GetMehod2 {
	
	@Test
	public void messageBody()
	{
		RestAssured.baseURI = "https://reqres.in/api";
		RequestSpecification request = RestAssured.given();
		//request.header("authorization bearertoken ")
		//Response response = request.get("https://reqres.in/api/users");
        Response response=RestAssured.delete("/users");
		// Retrieve the body of the Response
		ResponseBody<?> body = response.getBody();
		int statuscode=response.getStatusCode();
		System.out.println("status code is"+statuscode);

		// By using the ResponseBody.asString() method, we can convert the  body
		// into the string representation.
		System.out.println("Response Body is: " + body.asString());
	}

}
