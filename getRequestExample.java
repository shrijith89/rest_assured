package com.restAssured;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class getRequestExample {

	/**
	 * Rest assured is a java library for testing RESTful web services, REST Assured is implemented in groovy
	 */
	
	@Test
	public void method() {
		baseURI = "https://reqres.in/api/";
		Response response = get("users?page=2");
		int responseCode = response.getStatusCode();
		System.out.println("The response code is "+responseCode +" The response is "+response.body().asPrettyString());
		Assert.assertEquals(responseCode, 200);
		
	}
	
}
