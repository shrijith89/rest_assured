package com.sample;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

public class VerifyFieldGetReq {
	
	@BeforeTest
	public void setUp() {
		baseURI = "https://reqres.in/";
	}

	@Test
	public void test() {
		given().get("api/users/2").then().body("data.first_name", equalTo("Ja1net"));
	}

}
