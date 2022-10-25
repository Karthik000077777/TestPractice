package com.ken.RestAssured;

import java.util.List;

import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetBookingIds {

	static String ss = null;
	static String jsonPathValidation = null;
	static int statusCode = 0;
	static String endPoint = null;
	static String[][] data = ExcelRead.dataTable;
	static String statCode = null;

	public static void getBookingIds() {

		Response response = 
				RestAssured.given()
								.baseUri(GetExcelData.data(data, "GetBookingIds", "BaseURl"))
								.basePath(GetExcelData.data(data, "GetBookingIds", "BasePath"))
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
//		List responseAsList = (List) responseAsObject;
		ss = s5;//responseAsList.toString();

		jsonPathValidation = ValidateJsonPath.validateJsonPath(response, "GetBookingIds", "JSONPath");

		statusCode = response.statusCode();
		statCode = String.valueOf(statusCode);
		if (jsonPathValidation.equalsIgnoreCase("pass") && statusCode == 200) {
			endPoint = "Reachable";
		} else {
			endPoint = "notReachable";
		}
	}

	public static void getBookingIdsByName() {

		String[] queryParamArray = ReturnQueryParameters.queryParam("GetBookingIdsByName");

		Response response = 
				RestAssured.given()
								.baseUri(GetExcelData.data(data, "GetBookingIdsByName", "BaseURl"))
								.basePath(GetExcelData.data(data, "GetBookingIdsByName", "BasePath"))
								.queryParam(queryParamArray[0], queryParamArray[1])
								.queryParam(queryParamArray[2], queryParamArray[3])
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
//		List responseAsList = (List) responseAsObject;
		ss = s5;//responseAsList.toString();

		jsonPathValidation = ValidateJsonPath.validateJsonPath(response, "GetBookingIdsByName", "JSONPath");
		statusCode = response.statusCode();
		statCode = String.valueOf(statusCode);
		if (statusCode == 200) {
			endPoint = "Reachable";
		} else {
			endPoint = "notReachable";
		}
	}

	public static void getBookingIdsByCheckIn() {

		String[] QueryParamArray = ReturnQueryParameters.queryParam("GetBookingIdsByCheckin/Checkout");

		Response response = 
				RestAssured.given()
								.baseUri(GetExcelData.data(data, "GetBookingIdsByCheckin/Checkout", "BaseURl"))
								.basePath(GetExcelData.data(data, "GetBookingIdsByCheckin/Checkout", "BasePath"))
								.queryParam(QueryParamArray[0], QueryParamArray[1])
								.queryParam(QueryParamArray[2], QueryParamArray[3])
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
//		List responseAsList = (List) responseAsObject;
		ss =s5;// responseAsList.toString();

		jsonPathValidation = ValidateJsonPath.validateJsonPath(response, "GetBookingIdsByCheckin/Checkout", "JSONPath");
		statusCode = response.statusCode();
		statCode = String.valueOf(statusCode);
		if (statusCode == 200) {
			endPoint = "Reachable";
		} else {
			endPoint = "notReachable";
		}
	}
}
