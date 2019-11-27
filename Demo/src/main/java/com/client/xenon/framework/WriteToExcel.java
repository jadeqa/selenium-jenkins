package com.client.xenon.framework;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/***
 * 
 * @author shivani.rane
 *
 */

public class WriteToExcel {

	public void writeDataToExcel(int rowcount, int columncount, String filepath, String Sheetname, String value) throws IOException {
		XSSFWorkbook wb = null;
		try {
			FileInputStream input = new FileInputStream(filepath);
			wb = new XSSFWorkbook(input);
			XSSFSheet sh = wb.getSheet(Sheetname);
			XSSFRow row = sh.getRow(rowcount);
			FileOutputStream webdata = new FileOutputStream(filepath);
			row.createCell(columncount).setCellValue(value);
			wb.write(webdata);
			wb.close();
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
