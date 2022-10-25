package com.ken.RestAssured;

import java.util.ArrayList;

public class Headers {
	public static String contentType = null;
	public static String acceptType = null;
	public static String authorization = null;
	public static String[][] data = ExcelRead.dataTable;
	public static ArrayList<String> aList = new ArrayList<String>();
//	public static String[] h = new String[4];

	public static String[] getHeader(String reqDescription, String headerValue) {
		String headersData = GetExcelData.data(data, reqDescription, "Headers");
		String[] headers = headersData.split(",");
		for (String s : headers) {
			String[] arr4 = s.split(":");
			if (s.contains("Content-Type")) {
				contentType = arr4[1];
			} else if (s.contains("Accept")) {
				acceptType = arr4[1];
			} else if (s.contains("Authorization")) {
				authorization = arr4[1];
			}
		}
		if (headerValue.equals("contentType")) {
			return new String[] { "Content-Type", contentType };
		} else if (headerValue.equals("acceptType")) {
			return new String[] { "Accept-Type", acceptType };
		} else if (headerValue.equals("authorization")) {
			return new String[] { "Authorization", authorization };
		}
		return null;
	}
}
