package com.naveenautomation.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.naveenautomation.base.TestBase;

public class ExcelUtils extends TestBase {

	public static FileInputStream fi;

	public static XSSFWorkbook wb;

	public static XSSFSheet ws;

	public static XSSFRow row;

	public static XSSFCell cell;

	public static int getRowCount(String xFile, String sheetName) throws IOException {

		int rowCount;

		// read input file,xfile is path
		fi = new FileInputStream(xFile);

		// find the workbook from file
		wb = new XSSFWorkbook(fi);

		// from workbook find the sheet by using sheet name
		ws = wb.getSheet(sheetName);

		// gives the last row count
		rowCount = ws.getLastRowNum();

		// closing the workbook and fi to avoid the memory leak

		wb.close();

		fi.close();

		System.out.println("Total Rows in " + sheetName + ": " + rowCount);

		return rowCount;

	}

	public static int getColumnCount(String xFile, String sheetName, int rowNo) throws IOException {

		int columnCount;

		fi = new FileInputStream(xFile);

		wb = new XSSFWorkbook(fi);

		ws = wb.getSheet(sheetName);

		// For getting the column count the last row of excel sheet to be considered.
		row = ws.getRow(rowNo);

		// From last row last cell number fetched and that would be the column number
		columnCount = row.getLastCellNum();

		wb.close();

		fi.close();

		System.out.println("Column Count in " + sheetName + ": " + columnCount);

		return columnCount;

	}

	public static String getCellData(String xFile, String sheetName, int rowNo, int colNo) throws IOException {

		String data = "";

		fi = new FileInputStream(xFile);

		wb = new XSSFWorkbook(fi);

		ws = wb.getSheet(sheetName);

		row = ws.getRow(rowNo);

		// Found row, and using column number to find the cell
		cell = row.getCell(colNo);

		// Any data from cell treated as String
		cell.setCellType(cell.CELL_TYPE_STRING);

		data = cell.getStringCellValue();

		return data;

	}

}
