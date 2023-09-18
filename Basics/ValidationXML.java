package com.tests;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.util.List;

public class ValidationXML {
	
	@Test
	public void method() {
		Response response = given().contentType("application/xml").
				get("http://restapi.adequateshop.com/api/Traveler");
		
		List<String> list = response.xmlPath().getList("TravelerinformationResponse.travelers.Travelerinformation.name");
		
		for(String s: list) {
			System.out.println(s);
		}
	}
}
