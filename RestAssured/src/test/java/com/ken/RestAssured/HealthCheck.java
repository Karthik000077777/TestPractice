package com.ken.RestAssured;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class HealthCheck {
	static String ss = null;
	static int statusCode = 0;
	static String endPoint = "notWorking";
	static String[][] data = ExcelRead.dataTable;
	static String statCode = null;

	public static void healthCheck() {

		Response response = 
				RestAssured.given()
								.baseUri(GetExcelData.data(data, "HealthCheck", "BaseURl"))
								.basePath(GetExcelData.data(data, "HealthCheck", "BasePath"))
								.log()
								.all()
							.when()
								.get();
					response.then()
							.statusCode(201)
							.log()
							.all();

		ss = response.asPrettyString();
		statusCode = response.statusCode();
		statCode = String.valueOf(statusCode);
		if (statusCode == 201) {
			endPoint = "Reachable";
		} else {
			endPoint = "notReachable";
		}
	}
}
