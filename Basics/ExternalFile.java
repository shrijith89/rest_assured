package com.tests;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;


public class ExternalFile {
	
	@Test
	public void method() throws FileNotFoundException {
		
		File f = new File(".\\ex.json");
		
		FileReader fr = new FileReader(f);
		JSONTokener jt = new JSONTokener(fr);
		JSONObject data = new JSONObject(jt);
		
		String s = given().contentType("application/json").body(data.toString()).post("https://reqres.in/api/users").asPrettyString();
		
		System.out.println(s);
		
	}

}
