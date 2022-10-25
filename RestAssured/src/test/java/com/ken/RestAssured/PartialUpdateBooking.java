package com.ken.RestAssured;

import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PartialUpdateBooking {
	static String jsonPath = null;
	static String ss = null;
	static String jsonPathValidation = null;
	static String endPoint = "notWorking";
	static String[][] data = ExcelRead.dataTable;
	static String statCode = null;
	static int statusCode = 0;

	public static void partialUpdateBooking() {
		String[] pathParamArray = ReturnPathParam.pathParam("PartialUpdateBooking");
		String[] contentType = Headers.getHeader("PartialUpdateBooking", "contentType");
		String[] acceptType = Headers.getHeader("PartialUpdateBooking", "acceptType");
		String[] authorization = Headers.getHeader("PartialUpdateBooking", "authorization");

		Response response = 
				RestAssured.given()
								.baseUri(GetExcelData.data(data, "PartialUpdateBooking", "BaseURl"))
								.basePath(GetExcelData.data(data, "PartialUpdateBooking", "BasePath"))
								.pathParam(pathParamArray[0], pathParamArray[1])
								.header(authorization[0], authorization[1])
								.header(contentType[0], contentType[1])
								.header(acceptType[0], acceptType[1])
								.body(GetExcelData.data(data, "PartialUpdateBooking", "Req.Body"))
								.log()
								.all()
							.when()
								.patch();
					response.then()
								.log()
								.all()
								.statusCode(200);

					String s5 = response.asPrettyString();
//		Object responseAsObject = response.as(Object.class);
//		Map responseAsMap = (Map) responseAsObject;
		ss = s5;//responseAsMap.entrySet().toString();

		jsonPathValidation = ValidateJsonPath.validateJsonPath(response, "PartialUpdateBooking", "JSONPath");
		statusCode = response.statusCode();
		statCode = String.valueOf(statusCode);
		if (jsonPathValidation.equalsIgnoreCase("pass") && statusCode == 200) {
			endPoint = "Reachable";
		} else {
			endPoint = "notReachable";
		}
	}
}
