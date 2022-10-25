package com.ken.RestAssured;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDataToExcel {
	static XSSFRow ro_w = null;
	static XSSFSheet sheet = null;
	static XSSFCell cell = null;
	static XSSFWorkbook workbook;
	static String[][] data = ExcelRead.dataTable;
	static int rowNum = 0;
	static int colNum = 0;
	static int i = 0;
	static int k = 0;

	public static int getRow(String ReqDescription) {
		for (i = 0; i < data.length; i++) {
			for (k = 0; k < data[0].length; k++) {
				if (data[i][k].equalsIgnoreCase(ReqDescription)) {
					rowNum = i;
					return rowNum;
				}
			}
		}
		return 0;
	}

	public static int getCol(String excelHeader) {
		for (i = 0; i < data.length; i++) {
			for (k = 0; k < data[0].length; k++) {
				if (data[i][k].equalsIgnoreCase(excelHeader)) {
					colNum = k;
					return colNum;
				}
			}
		}
		return 0;
	}

	public static void writeData(String filePath, String sheetName, String rowName, String colName, String write) {

		try {
//			System.out.println(filePath);
			FileInputStream fis = new FileInputStream(filePath);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);
			ro_w = null;
			cell = null;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		CellStyle style1 = workbook.createCellStyle();
		style1.setFillForegroundColor(IndexedColors.BRIGHT_GREEN.index);
//		style1.setFillBackgroundColor(IndexedColors.BRIGHT_GREEN.index);
		style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		CellStyle style2 = workbook.createCellStyle();

		style2.setFillForegroundColor(IndexedColors.RED.index);
		style2.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		if (colName.equalsIgnoreCase("Req.ResponseBody")) {
			int rowNum1 = getRow(rowName);
			int colNum1 = getCol(colName);
			ro_w = sheet.getRow(rowNum1);
			cell = ro_w.getCell(colNum1);
			cell.setCellValue(StringUtils.substring(write, 0, 32767));
		} else if (colName.equalsIgnoreCase("JSONPathValidation")) {
			int rowNum1 = getRow(rowName);
			int colNum1 = getCol(colName);
			ro_w = sheet.getRow(rowNum1);
			cell = ro_w.getCell(colNum1);
			cell.setCellValue(write);
			if (write.equalsIgnoreCase("pass")) {
				cell.setCellStyle(style1);
			} else {
				cell.setCellStyle(style2);
			}

			System.out.println("jsonValid");
		} else if (colName.equalsIgnoreCase("ActualStatusCode")) {
			int rowNum1 = getRow(rowName);
			int colNum1 = getCol(colName);
			ro_w = sheet.getRow(rowNum1);
			cell = ro_w.getCell(colNum1);
			cell.setCellValue(write);
		} else if (colName.equalsIgnoreCase("EndPoint")) {
			int rowNum1 = getRow(rowName);
			int colNum1 = getCol(colName);
			ro_w = sheet.getRow(rowNum1);
			cell = ro_w.getCell(colNum1);
			cell.setCellValue(write);
			if (write.equalsIgnoreCase("Reachable")) {
				cell.setCellStyle(style1);
			} else {
				cell.setCellStyle(style2);
			}
		}

		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(filePath);
			workbook.write(fos);
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
