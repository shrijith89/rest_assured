package com.tests;



import org.testng.annotations.Test;	

import static io.restassured.RestAssured.*;

public class API_Key {
	
	@Test
	void method() {
		given()
		.queryParam("appid", "fffa04868748026cfa5396d0b9702010")
		.when()
		.get("https://api.openweathermap.org/data/2.5/weather?lat=44.34&lon=10.99")
		.then()
		.log().all();
	}
	
}
