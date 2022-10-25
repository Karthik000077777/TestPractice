package com.ken.RestAssured;

import java.util.Arrays;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteBooking {
	static String ss = null;
	static int statusCode = 0;
	static String endPoint = "notWorking";
	static String[][] data = ExcelRead.dataTable;
	static String statCode = null;

	public static void deleteBooking() {
		String[] pathParamArray = ReturnPathParam.pathParam("DeleteBooking");
		String[] contentType = Headers.getHeader("DeleteBooking", "contentType");
		System.out.println(Arrays.toString(contentType));
		String[] acceptType = Headers.getHeader("DeleteBooking", "acceptType");
		System.out.println(Arrays.toString(acceptType));
		String[] authorization = Headers.getHeader("DeleteBooking", "authorization");
		System.out.println(Arrays.toString(authorization));

		Response response = 
				RestAssured.given()
								.baseUri(GetExcelData.data(data, "DeleteBooking", "BaseURl"))
								.basePath(GetExcelData.data(data, "DeleteBooking", "BasePath"))
								.pathParam(pathParamArray[0], pathParamArray[1])
								.header(authorization[0], authorization[1])
							.when()
								.delete();
				response.then()
							.statusCode(201)
							.log()
							.all();

		String s1 = response.asPrettyString();

		statusCode = response.statusCode();
		statCode = String.valueOf(statusCode);

		String s2 = GetBooking.getBooking(pathParamArray[1]);

		ss = s1 + " "+"Calling GET with same ID and response: " + s2;

		if (statusCode == 201) {
			endPoint = "Reachable";
		} else {
			endPoint = "notReachable";
		}
	}

}
