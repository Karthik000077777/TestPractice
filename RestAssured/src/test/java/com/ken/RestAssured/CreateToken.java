package com.ken.RestAssured;

import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CreateToken {
	static String ss = null;
	static int statusCode = 0;
	static String endPoint = "notWorking";
	static String[][] data = ExcelRead.dataTable;
	static String statCode = null;

	public static void createToken() {
		String[] contentType = Headers.getHeader("UpdateBooking", "contentType");

		Response response = 
				RestAssured.given()
								.baseUri(GetExcelData.data(data, "CreateToken", "BaseURl"))
								.basePath(GetExcelData.data(data, "CreateToken", "BasePath"))
								.header(contentType[0], contentType[1])
								.body(GetExcelData.data(data, "CreateToken", "Req.Body"))
								.log()
								.all()
							.when()
								.post();
		
				response.then()
							.log()
							.all()
							.body("token", Matchers.notNullValue())
							.body("token.length()", Matchers.is(15))
							.body("token", Matchers.matchesRegex("^[a-z0-9]+$"))
							.statusCode(200);

				String s5 = response.asPrettyString();
//				System.out.println(s5);
//		Object responseAsObject = response.as(Object.class);
//		Map responseAsMap = (Map) responseAsObject;
		ss = s5;//responseAsMap.entrySet().toString();

		statusCode = response.statusCode();
		statCode = String.valueOf(statusCode);
		if(statusCode == 200) {
			endPoint = "Reachable";
		} else {
			endPoint = "notReachable";
		}
	}
}
