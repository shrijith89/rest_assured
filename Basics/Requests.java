package com.tests;

import org.testng.annotations.Test;	

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

public class Requests {
	int id;

	@Test
	public void postMethod() {

		baseURI = "https://reqres.in/";

		JSONObject json = new JSONObject();
		json.put("name", "morpheus");
		json.put("job", "leader");

		id = given().body(json.toString()).post("api/users").jsonPath().getInt("id");
	}

	@Test()
	public void getMethod() {
		given().contentType("application/json").get("https://reqres.in/api/users/2").then().body("data.id",equalTo(2));
	}

	@Test(dependsOnMethods = { "postMethod" })
	public void putMethod() {
		baseURI = "https://reqres.in/";

		JSONObject json = new JSONObject();

		json.put("name", "shrijith");
		json.put("job", "leader");

		given().contentType("application/json").body(json.toString()).put("api/users/" + id).then().body("name",
				equalTo("shrijith"));
	}

	@Test
	public void deleteMethod() {
		baseURI = "https://reqres.in/";

		given().contentType("application/json").delete("api/users/" + id).then().statusCode(204);
	}

}
