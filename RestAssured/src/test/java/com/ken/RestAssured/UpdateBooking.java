package com.ken.RestAssured;

import java.util.Arrays;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UpdateBooking {
	static String jsonPath = null;
	static String ss = null;
	static String jsonPathValidation = null;
	static String endPoint = "notWorking";
	static String[][] data = ExcelRead.dataTable;
	static String statCode = null;
	static int statusCode = 0;

	public static void updateBooking() {
		String[] pathParamArray = ReturnPathParam.pathParam("UpdateBooking");
		String[] contentType = Headers.getHeader("UpdateBooking", "contentType");
		System.out.println(Arrays.toString(contentType));
		String[] acceptType = Headers.getHeader("UpdateBooking", "acceptType");
		System.out.println(Arrays.toString(acceptType));
		String[] authorization = Headers.getHeader("UpdateBooking", "authorization");
		System.out.println(Arrays.toString(authorization));

		Response response = 
				RestAssured.given()
								.baseUri(GetExcelData.data(data, "UpdateBooking", "BaseURl"))
								.basePath(GetExcelData.data(data, "UpdateBooking", "BasePath"))
								.pathParam(pathParamArray[0], pathParamArray[1])
								.header(authorization[0], authorization[1])
								.header(contentType[0], contentType[1])
								.header(acceptType[0], acceptType[1])
								.body(GetExcelData.data(data, "UpdateBooking", "Req.Body"))
								.log()
								.all()
							.when()
								.put();
					response.then()
								.log()
								.all()
								.statusCode(200);

					String s5 = response.asPrettyString();
		Object responseAsObject = response.as(Object.class);
		Map responseAsMap = (Map) responseAsObject;
		ss = s5;//responseAsMap.entrySet().toString();

		jsonPathValidation = ValidateJsonPath.validateJsonPath(response, "UpdateBooking", "JSONPath");
		statusCode = response.statusCode();
		statCode = String.valueOf(statusCode);
		if (statusCode == 200) {
			endPoint = "Reachable";
		} else {
			endPoint = "notReachable";
		}
	}
}
