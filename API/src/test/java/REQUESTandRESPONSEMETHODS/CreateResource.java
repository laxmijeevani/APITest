package REQUESTandRESPONSEMETHODS;

import java.io.Serializable;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateResource {
  @Test
  public void input() {
	  //initiating the payload
	  String[] requestBody= {"\"name\": \"morpheus\",\n"
	  		+ "    \"job\": \"leader\""};
	  //To specify input data format
	  RequestSpecification request=RestAssured.given();
	  request.header("contentType","application/json");
	  request.body(requestBody);
	  Response response=request.post("https://reqres.in/api/users");
			  int statuscode=response.getStatusCode();
	  System.out.println("status code is:"+statuscode);
	  //Serializable responseBody= response.getBody().asString();
	  //System.out.println("response is"+responseBody);
	  System.out.println("Status received => " + response.getStatusLine()); 
		System.out.println("Response=>" + response.prettyPrint());
	  
	  
	 
  }
}
