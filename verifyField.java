package com.sample;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class verifyField {

	@BeforeTest
	public void setUp() {
		baseURI = "https://reqres.in/";
	}

	@Test
	public void test() {
		String firstName =  given().get("api/users/2").body().jsonPath().get("data.first_name");
		System.out.println("The firstname is "+firstName);
		assertEquals(firstName, "Janet");
	}

}
