package com.utility;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	public static String readParticularData(String sheetName, int rowNum, int columnNum)
			throws InvalidFormatException, IOException {

		File file = new File("D:\\Greens Java Selenium\\SQL Tutorial\\DataDriven.xlsx");

		@SuppressWarnings("resource")
		Workbook excel = new XSSFWorkbook(file);

		Sheet sheet = excel.getSheet(sheetName);

		Row row = sheet.getRow(rowNum);

		Cell cell = row.getCell(columnNum);

		DataFormatter dataformat = new DataFormatter();

		String data = dataformat.formatCellValue(cell);

		System.out.println(data);

		return data;
	}

	@SuppressWarnings({ "unused", "resource" })
	public static void readAllCellData(String sheet) throws InvalidFormatException, IOException {

		File file = new File(sheet);

		Workbook excel = new XSSFWorkbook(file);

		Sheet sheet1 = excel.getSheetAt(0);

		int lastRowNum = sheet1.getLastRowNum();

		short lastCellNum = sheet1.getRow(1).getLastCellNum();

		Row row = sheet1.getRow(1);

		for (int i = 0; i < lastCellNum; i++) {
			DataFormatter dataformat = new DataFormatter();
			Cell cell = row.getCell(i);
			String data = dataformat.formatCellValue(cell);
			System.out.println(data);
		}

	}

	public static void readAllData(String sheet) throws InvalidFormatException, IOException {

		File file = new File(sheet);

		@SuppressWarnings("resource")
		Workbook excel = new XSSFWorkbook(file);

		Sheet sheet2 = excel.getSheetAt(0);

		int lastRowNum = sheet2.getLastRowNum();

		short lastCellNum = sheet2.getRow(0).getLastCellNum();

		for (int i = 1; i <= lastRowNum; i++) {

			Row row = sheet2.getRow(i);

			for (int j = 0; j < lastCellNum; j++) {

				DataFormatter dataformat = new DataFormatter();
				Cell cell = row.getCell(j);
				String data = dataformat.formatCellValue(cell);
				System.out.println(data);
			}
		}
	}

	public static void createExcelData() {

	}

	public static void main(String[] args) {
		createExcelData();
	}
}