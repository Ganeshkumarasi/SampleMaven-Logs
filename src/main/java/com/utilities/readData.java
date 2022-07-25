package com.utilities;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readData {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		FileInputStream fis = new FileInputStream("./testData/TestData.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheet("smoketest");

		int rowCount = sheet.getLastRowNum(); // return rows count details

		int columnsCount = sheet.getRow(0).getLastCellNum(); // return cloumns count details

		System.out.println("Rows count: " + rowCount);

		System.out.println("Columns Count: " + columnsCount);

		for (int i = 1; i <= rowCount; i++) {

			XSSFRow currentRow = sheet.getRow(i);

			String company = currentRow.getCell(0).toString();

			String contact = currentRow.getCell(1).toString();

			String country = currentRow.getCell(2).toString();


			System.out.println("FirstName and Address: " + company + " : " + country);

			System.out.println("--------------------");

		}

	}

}
