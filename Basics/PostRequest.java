package com.sample;

import static io.restassured.RestAssured.baseURI;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;
import static io.restassured.RestAssured.*;

public class PostRequest {

	@BeforeTest
	public void setUp() {
		baseURI = "https://reqres.in/";
	}

	@SuppressWarnings("unchecked")
	@Test
	public void test() {
		JSONObject json = new JSONObject();
		json.put("name", "morpheus");
		json.put("job", "leader");
		Response response = given().accept(ContentType.JSON).body(json).when().post("api/users");
		System.out.println(response.getBody().asPrettyString());
	}
}
