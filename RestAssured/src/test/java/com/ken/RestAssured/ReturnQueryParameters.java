package com.ken.RestAssured;

import java.util.ArrayList;
import java.util.Arrays;

public class ReturnQueryParameters {
	static String[][] data = ExcelRead.dataTable;
	static ArrayList<String> aList = new ArrayList<String>();
	static String[] QueryParamArray = new String[10];
//	static String[] QueryParamArray;

	public static String[] queryParam(String reqDescription) {

		aList.clear();
		String queryParameters = GetExcelData.data(data, reqDescription, "QueryParam");
		String[] arr1 = queryParameters.split(",");
		for (int i = 0; i < arr1.length; i++) {
			String[] arr2 = arr1[i].split("=");
			aList.addAll(Arrays.asList(arr2));
		}
		aList.toArray(QueryParamArray);

		return QueryParamArray;
	}
}
