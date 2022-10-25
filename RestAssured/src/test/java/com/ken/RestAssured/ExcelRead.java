package com.ken.RestAssured;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	static String[][] dataTable = null;

	public static void main(String[] args) {
		String filePath = "C:\\Users\\ykareddy\\eclipse-workspace\\RestAssured\\Resource\\DataApiTesting.xlsx";
		FileInputStream fis = null;
		XSSFWorkbook wb = null ;
		try {
			fis = new FileInputStream(filePath);
			wb = new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		XSSFSheet sheet = wb.getSheetAt(0);
		String sheetName = "Sheet1";

		int rows = sheet.getPhysicalNumberOfRows();
		int cols = sheet.getRow(0).getLastCellNum();
		dataTable = new String[rows][cols];
		for (int i = 0; i < rows; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int k = 0; k < cols; k++) {
				XSSFCell cell = row.getCell(k);

				cell.setCellType(CellType.STRING);
				String value = cell.getStringCellValue();
				dataTable[i][k] = value;
			}
		}
		try {
			wb.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		int reqDescription = GetExcelData.returnColNumber(dataTable, "Req.Description");
		int execute = GetExcelData.returnColNumber(dataTable, "Execute");
		for (int a = 1; a <= rows - 1; a++) {
			switch (dataTable[a][reqDescription]) {
			case "CreateToken":
				if (dataTable[a][execute].equalsIgnoreCase("Y")) {
					CreateToken.createToken();
					WriteDataToExcel.writeData(filePath, sheetName, "CreateToken", "Req.ResponseBody", CreateToken.ss);
					WriteDataToExcel.writeData(filePath, sheetName, "CreateToken", "ActualStatusCode",CreateToken.statCode);
					WriteDataToExcel.writeData(filePath, sheetName, "CreateToken", "EndPoint", CreateToken.endPoint);
				}
				break;
			case "GetBookingIds":
				if (dataTable[a][execute].equalsIgnoreCase("Y")) {
					GetBookingIds.getBookingIds();
					WriteDataToExcel.writeData(filePath, sheetName, "GetBookingIds", "Req.ResponseBody",GetBookingIds.ss);
					WriteDataToExcel.writeData(filePath, sheetName, "GetBookingIds", "JSONPathValidation",GetBookingIds.jsonPathValidation);
					WriteDataToExcel.writeData(filePath, sheetName, "GetBookingIds", "ActualStatusCode",GetBookingIds.statCode);
					WriteDataToExcel.writeData(filePath, sheetName, "GetBookingIds", "EndPoint",GetBookingIds.endPoint);
				}
				break;
			case "GetBookingIdsByName":
				if (dataTable[a][execute].equalsIgnoreCase("Y")) {
					GetBookingIds.getBookingIdsByName();
					WriteDataToExcel.writeData(filePath, sheetName, "GetBookingIdsByName", "Req.ResponseBody",GetBookingIds.ss);
					WriteDataToExcel.writeData(filePath, sheetName, "GetBookingIdsByName", "JSONPathValidation",GetBookingIds.jsonPathValidation);
					WriteDataToExcel.writeData(filePath, sheetName, "GetBookingIdsByName", "ActualStatusCode",GetBookingIds.statCode);
					WriteDataToExcel.writeData(filePath, sheetName, "GetBookingIdsByName", "EndPoint",GetBookingIds.endPoint);
				}
				break;
			case "GetBookingIdsByCheckin/Checkout":
				if (dataTable[a][execute].equalsIgnoreCase("Y")) {
					GetBookingIds.getBookingIdsByCheckIn();
					WriteDataToExcel.writeData(filePath, sheetName, "GetBookingIdsByCheckin/Checkout","Req.ResponseBody", GetBookingIds.ss);
					WriteDataToExcel.writeData(filePath, sheetName, "GetBookingIdsByCheckin/Checkout","JSONPathValidation", GetBookingIds.jsonPathValidation);
					WriteDataToExcel.writeData(filePath, sheetName, "GetBookingIdsByCheckin/Checkout","ActualStatusCode", GetBookingIds.statCode);
					WriteDataToExcel.writeData(filePath, sheetName, "GetBookingIdsByCheckin/Checkout", "EndPoint",GetBookingIds.endPoint);
				}
				break;
			case "GetBooking":
				if (dataTable[a][execute].equalsIgnoreCase("Y")) {
					GetBooking.getBooking();
					WriteDataToExcel.writeData(filePath, sheetName, "GetBooking", "Req.ResponseBody", GetBooking.ss);
					WriteDataToExcel.writeData(filePath, sheetName, "GetBooking", "JSONPathValidation",GetBooking.jsonPathValidation);
					WriteDataToExcel.writeData(filePath, sheetName, "GetBooking", "ActualStatusCode",GetBooking.statCode);
					WriteDataToExcel.writeData(filePath, sheetName, "GetBooking", "EndPoint", GetBooking.endPoint);
				}
				break;
			case "CreateBooking":
				if (dataTable[a][execute].equalsIgnoreCase("Y")) {
					CreateBooking.createBooking();
					WriteDataToExcel.writeData(filePath, sheetName, "CreateBooking", "Req.ResponseBody",CreateBooking.ss);
					WriteDataToExcel.writeData(filePath, sheetName, "CreateBooking", "JSONPathValidation",CreateBooking.jsonPathValidation);
					WriteDataToExcel.writeData(filePath, sheetName, "CreateBooking", "ActualStatusCode",CreateBooking.statCode);
					WriteDataToExcel.writeData(filePath, sheetName, "CreateBooking", "EndPoint",CreateBooking.endPoint);
				}
				break;
			case "UpdateBooking":
				if (dataTable[a][execute].equalsIgnoreCase("Y")) {
					UpdateBooking.updateBooking();
					WriteDataToExcel.writeData(filePath, sheetName, "UpdateBooking", "Req.ResponseBody",UpdateBooking.ss);
					WriteDataToExcel.writeData(filePath, sheetName, "UpdateBooking", "JSONPathValidation",UpdateBooking.jsonPathValidation);
					WriteDataToExcel.writeData(filePath, sheetName, "UpdateBooking", "ActualStatusCode",UpdateBooking.statCode);
					WriteDataToExcel.writeData(filePath, sheetName, "UpdateBooking", "EndPoint",UpdateBooking.endPoint);
				}
				break;
			case "PartialUpdateBooking":
				if (dataTable[a][execute].equalsIgnoreCase("Y")) {
					PartialUpdateBooking.partialUpdateBooking();
					WriteDataToExcel.writeData(filePath, sheetName, "PartialUpdateBooking", "Req.ResponseBody",PartialUpdateBooking.ss);
					WriteDataToExcel.writeData(filePath, sheetName, "PartialUpdateBooking", "JSONPathValidation",PartialUpdateBooking.jsonPathValidation);
					WriteDataToExcel.writeData(filePath, sheetName, "PartialUpdateBooking", "ActualStatusCode",PartialUpdateBooking.statCode);
					WriteDataToExcel.writeData(filePath, sheetName, "PartialUpdateBooking", "EndPoint",PartialUpdateBooking.endPoint);
				}
				break;
			case "DeleteBooking":
				if (dataTable[a][execute].equalsIgnoreCase("Y")) {
					DeleteBooking.deleteBooking();
					WriteDataToExcel.writeData(filePath, sheetName, "DeleteBooking", "Req.ResponseBody",DeleteBooking.ss);
					WriteDataToExcel.writeData(filePath, sheetName, "DeleteBooking", "ActualStatusCode",DeleteBooking.statCode);
					WriteDataToExcel.writeData(filePath, sheetName, "DeleteBooking", "EndPoint",DeleteBooking.endPoint);
				}
				break;
			case "HealthCheck":
				if (dataTable[a][execute].equalsIgnoreCase("Y")) {
					HealthCheck.healthCheck();
					WriteDataToExcel.writeData(filePath, sheetName, "HealthCheck", "Req.ResponseBody", HealthCheck.ss);
					WriteDataToExcel.writeData(filePath, sheetName, "HealthCheck", "ActualStatusCode",HealthCheck.statCode);
					WriteDataToExcel.writeData(filePath, sheetName, "HealthCheck", "EndPoint", HealthCheck.endPoint);
				}
				break;
			default:
				break;
			}
		}
	}
}
