package com.ken.RestAssured;

import io.restassured.response.Response;

public class ValidateJsonPath {

	static String jsonPath = null;
	static String[][] data = ExcelRead.dataTable;

	public static String validateJsonPath(Response response, String reqDescription, String JsonPathcolName) {

		String strPass = "";
		String strFail = "";

		jsonPath = GetExcelData.data(data, reqDescription, JsonPathcolName);
		String[] s3 = jsonPath.split(",");

		for (String s : s3) {
			String[] jValid = s.split("=");
			String object = jValid[0];
			String value0 = jValid[1];
			String value1 = response.jsonPath().getString(object);
			System.out.println(object + " = " + value1);
			if (value1.contains(value0)) {
				strPass = "Pass";
			} else {
				strFail += "Fail" + s + " " + "was " + value1 + "\n";
			}
		}
		if (strFail.equals("")) {
			return strPass;
		} else {
			return strFail;
		}
	}
}
