package com.tests;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.given;

public class JSONValidation {
	
	@Test
	void JSONSchema() {
		
		given().
		when().
		get("https://reqres.in/api/users/2").
		then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema.json"));
	}

}
