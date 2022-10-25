package com.ken.RestAssured;

import java.util.Map;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetBooking {
	static String jsonPath = null;
	static String ss = null;
	static String jsonPathValidation = null;
	static int statusCode = 0;
	static String endPoint = "";
	static String[][] data = ExcelRead.dataTable;
	static String statCode = null;

	public static void getBooking() {

		String[] pathParamArray = ReturnPathParam.pathParam("GetBooking");

		Response response = 
					RestAssured.given()
									.baseUri(GetExcelData.data(data, "GetBooking", "BaseURl"))
									.basePath(GetExcelData.data(data, "GetBooking", "BasePath"))
									.pathParam(pathParamArray[0], pathParamArray[1])
									.log()
									.all()
								.when()
									.get();

					response.then()
								.statusCode(200)
								.log()
								.all();
					String s5 = response.asPrettyString();
//		Object responseAsObject = response.as(Object.class);
//		Map responseAsMap = (Map) responseAsObject;
		ss =s5;// responseAsMap.entrySet().toString();

		jsonPathValidation = ValidateJsonPath.validateJsonPath(response, "GetBooking", "JSONPath");
		statusCode = response.statusCode();
		statCode = String.valueOf(statusCode);
		if (statusCode == 200) {
			endPoint = "Reachable";
		} else {
			endPoint = "notReachable";
		}
	}

	public static String getBooking(String id) {
		Response response = 
				RestAssured.given()
								.baseUri("https://restful-booker.herokuapp.com/")
								.basePath("booking/{id}")
								.pathParam("id", id)
								.log()
								.all()
							.when()
							.get();
				response.then()
							.statusCode(404)
							.log()
							.all();
				
		return response.asString();
	}
}
