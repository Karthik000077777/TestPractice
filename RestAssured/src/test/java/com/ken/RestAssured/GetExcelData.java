package com.ken.RestAssured;

public class GetExcelData {

	static int rowNum = 0;
	static int colNum = 0;
	static int i = 0;
	static int k = 0;

	public static String data(String[][] dataInExcel, String ReqDescription, String excelHeader) {
		for (i = 0; i < dataInExcel.length; i++) {
			for (k = 0; k < dataInExcel[0].length; k++) {
				if (dataInExcel[i][k].equalsIgnoreCase(ReqDescription)) {
					rowNum = i;
					break;
				}
			}
		}
		for (i = 0; i < dataInExcel.length; i++) {
			for (k = 0; k < dataInExcel[0].length; k++) {
				if (dataInExcel[i][k].equalsIgnoreCase(excelHeader)) {
					colNum = k;
					break;
				}
			}
		}
		return dataInExcel[rowNum][colNum];
	}

	public static int returnColNumber(String[][] dataInExcel, String excelHeader) {
		int columnNumber = 0;
		for (i = 0; i < dataInExcel.length; i++) {
			for (k = 0; k < dataInExcel[0].length; k++) {
				if (dataInExcel[i][k].equalsIgnoreCase(excelHeader)) {
					columnNumber = k;
					break;
				}
			}
		}
		return columnNumber;
	}

}
