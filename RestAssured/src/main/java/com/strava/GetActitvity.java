package com.strava;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetActitvity {
	
	public static void main(String[] args) {
		
	Response response = RestAssured.given()
										.baseUri("https://www.strava.com/")
										.basePath("api/v3/athlete/activities")
										.queryParam("access_token","b5452a442716822feaeed94b095a6f5cc6a95170")
										.accept("application/json")
										.log()
										.all()
									.when()
										.get();
					response.then()
								.statusCode(200)
								.log()
								.all();
	}
}
