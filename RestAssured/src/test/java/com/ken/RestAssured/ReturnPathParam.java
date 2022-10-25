package com.ken.RestAssured;

public class ReturnPathParam {
	static String[][] data = ExcelRead.dataTable;

	public static String[] pathParam(String reqDescription) {
//		String[] arr = new String[1];
		String pathParameter = GetExcelData.data(data, reqDescription, "PathParam");
		String[] arr = pathParameter.split("=");

		return arr;
	}
}
