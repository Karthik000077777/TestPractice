package com.ken.RestAssured;

import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CreateBooking {
	static String jsonPath = null;
	static String ss = null;
	static String jsonPathValidation = null;
	static int statusCode = 0;
	static String endPoint = "notWorking";
	static String[][] data = ExcelRead.dataTable;
	static String statCode = null;

	public static void createBooking() {
		String[] contentType = Headers.getHeader("UpdateBooking", "contentType");
		Response response = 
				RestAssured.given()
								.baseUri(GetExcelData.data(data, "CreateBooking", "BaseURl"))
								.basePath(GetExcelData.data(data, "CreateBooking", "BasePath"))
								.header(contentType[0], contentType[1])
								.body(GetExcelData.data(data, "CreateBooking", "Req.Body"))
								.log()
								.all()
							.when()
								.post();
				response.then()
							.log()
							.all()
							.statusCode(200);
				String s5 = response.asPrettyString();
//		Object responseAsObject = response.as(Object.class);
//		Map responseAsMap = (Map) responseAsObject;
		ss =s5;// responseAsMap.entrySet().toString();

//		jsonPath = GetExcelData.data(data, "CreateBooking", "JSONPath");
//		String[] s3 = jsonPath.split(",");

		jsonPathValidation = ValidateJsonPath.validateJsonPath(response, "CreateBooking", "JSONPath");
		statusCode = response.statusCode();
		statCode = String.valueOf(statusCode);
		if (statusCode == 200) {
			endPoint = "Reachable";
		} else {
			endPoint = "notReachable";
		}
	}
}
