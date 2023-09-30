package DataDrivenTesting;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

public class APITest {

	@Test
	public void postRequest()
	{
		//Provide the JSON file path
		String jsonFilePath="C:\\Users\\jeevani\\Desktop\\DataDriven\\data.json";
		//To read the data from JSON File
		String jsonData="";
		try
		{
			jsonData=new String(Files.readAllBytes(Paths.get(jsonFilePath)));
		}
		catch(IOException e)
		{
			//to handle exception
			e.printStackTrace();
		}
		//String name="morpheus";
		//String job="leader";
		//To send the post request
		Response response=RestAssured.given()
				
		.contentType(ContentType.JSON)
		.body(jsonData)
		.when()
		.put("https://reqres.in/api/users/2")
		.then()
		.extract().response();
		///To print the response and status code
		String responseBody=response.getBody().asString();
		int statuscode=response.getStatusCode();
		System.out.println("the status code is"+statuscode+"\n"+"responsebody is:"+responseBody);
		Assert.assertEquals(200, response.getStatusCode());
		Assert.assertEquals("laxmi",response.jsonPath().getString("name"));
		Assert.assertEquals("TA",response.jsonPath().getString("job"));
		Assert.assertEquals("xyz@gmail.com",response.jsonPath().getString("email"));
		Assert.assertEquals("25",response.jsonPath().getString("age"));
		Assert.assertEquals("9999999999",response.jsonPath().getString("phonenumber"));
		System.out.println("name:"+response.jsonPath().getString("name"));
		System.out.println("job:"+response.jsonPath().getString("job"));
		System.out.println("email is:"+response.jsonPath().getString("email"));
		
		
	}
}
