package com.tests;

import org.testng.annotations.Test;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;


public class ListofElements {

	@Test
	public void method() {
		Response r = given().get("https://reqres.in/api/users?page");
		
		List <String> array = new ArrayList<>();
		
		array = r.jsonPath().get("data.email");
		
		for(String s: array) {
			System.out.println(s);
		}
		
	}
}
