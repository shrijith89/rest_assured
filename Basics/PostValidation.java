package com.tests;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class PostValidation {
	
	@Test
	public void method() {
		baseURI = "https://reqres.in/";

		JSONObject json = new JSONObject();
		json.put("name", "morpheus");
		json.put("job", "leader");

		Response res = given().contentType("application/json").body(json.toString()).post("api/users");
		
		String actual = res.jsonPath().get("name");
		System.out.println("Actual value "+actual);
		Assert.assertEquals(actual, "morpheus");
	}

}
