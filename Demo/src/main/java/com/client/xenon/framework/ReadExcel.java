package com.client.xenon.framework;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.SkipException;

/**
 * 
 * @author P
 * @param xlsFilePath
 * @param sheetName
 * @param cell
 * @param columnTitle
 * @return Object
 */
public class ReadExcel {

	private Logger logger = Logger.getLogger(ReadExcel.class);
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFCell cell = null;
	static String path = "src\\main\\resources\\Excel\\SAL_Invoicing_Test_Data.xlsx";

	public Object[][] getData(String xlsFilePath, String sheetName) throws Exception {
		logger.info("Reading xlsx file: " + xlsFilePath + " for factory method.");
		Object[][] tabArray = null;
		int ci = 0, cj = 0, noOfRow = 0, noOfCols = 0;
		cell = null;
		FileInputStream file = new FileInputStream(new File(xlsFilePath));
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet(sheetName);
		noOfRow = sheet.getLastRowNum();
		noOfCols = workbook.getSheet(sheetName).getRow(0).getLastCellNum();
		tabArray = new Object[noOfRow][noOfCols];
		int celcounter = 0;
		cj = 0;
		int totCol = sheet.getRow(0).getLastCellNum();
		for (ci = 0; ci < noOfRow; ci++) {
			cj = celcounter;
			for (int c = 0; c < totCol; c++) {
				cell = sheet.getRow(ci).getCell(c, Row.RETURN_BLANK_AS_NULL);
				tabArray[ci][cj] = getCellValueAsString(cell);
				cj++;
			}
		}
		file.close();
		return (tabArray);
	}

	private String getCellValueAsString(Cell cell) {
		String strCellValue = null;
		if (cell != null) {
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_STRING:
				strCellValue = cell.toString();
				break;
			case Cell.CELL_TYPE_NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
					strCellValue = dateFormat.format(cell.getDateCellValue());
				} else {
					Double value = cell.getNumericCellValue();
					Long longValue = value.longValue();
					strCellValue = new String(longValue.toString());
				}
				break;
			case Cell.CELL_TYPE_BOOLEAN:
				strCellValue = new String(new Boolean(cell.getBooleanCellValue()).toString());
				break;
			case Cell.CELL_TYPE_BLANK:
				strCellValue = "";
				break;
			}
		} else {
			strCellValue = "";
		}
		return strCellValue;
	}

	public static Object getCellValueByRowColumn(String sheetName, int row, String columnTitle) {
		ReadExcel readexcel = new ReadExcel();
		Object[][] data = null;
		int columnPosition = 0;

		if (row < 0 && columnTitle.isEmpty() || columnTitle == null) {
			throw new SkipException("Row and column title is not as expected");
		} else {
			try {
				data = readexcel.getData(path, sheetName);
				if (data == null) {
					throw new SkipException("Data is null");
				}
				columnPosition = Arrays.asList(data[0]).indexOf(columnTitle.trim());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return data[row][columnPosition] != null ? data[row][columnPosition] : null;
		}

	}

}
