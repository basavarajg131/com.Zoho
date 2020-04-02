package com.zoho.genericLib;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This generic class is required to handle external files
 * like excel sheet and property file
 * @author Basavaraj
 *
 */
public class FileLib {

	/**
	 * This generic method is used to read the 
	 * value of a key from property file
	 * @param path
	 * @param key
	 * @return String
	 * @throws Throwable
	 */
	public String getKeyPropertyValue(String path, String key) throws Throwable {
		FileInputStream readProp = new FileInputStream(path);
		Properties prop = new Properties();
		prop.load(readProp);
		return prop.getProperty(key, "The Mentioned Key is not Present in proprty file");

	}
	
	/**
	 * This is a generic method used to read the data from excel sheet
	 * @param propPath
	 * @param sheet
	 * @param r
	 * @param c
	 * @return String
	 * @throws Throwable
	 */
	public String getExcelData(String propPath, String sheet, int r, int c) throws Throwable {
		FileInputStream readExcel = new FileInputStream(propPath);
		Workbook wb = WorkbookFactory.create(readExcel);
		return wb.getSheet(sheet).getRow(r).getCell(c).toString();

	}

	/**
	 * This generic method is used to count the no of rows
	 * @param path
	 * @param sheet
	 * @return int
	 * @throws Throwable
	 */
	public int getRowCount(String path, String sheet) throws Throwable {
		FileInputStream readExcel = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(readExcel);
		return wb.getSheet(sheet).getLastRowNum();
	}
	
	
/**
 * This generic method is used to write data into excel sheet
 * @param excelPath
 * @param sheet
 * @param r
 * @param c
 * @param value
 * @throws Throwable
 */
	public void setExcelData(String excelPath, String sheet, int r, int c, String value) throws Throwable {
		FileInputStream readExcel = new FileInputStream(excelPath);
		Workbook wb = WorkbookFactory.create(readExcel);
		wb.getSheet(sheet).createRow(r).createCell(c).setCellValue(value);

		FileOutputStream writeExcel = new FileOutputStream(excelPath);
		wb.write(writeExcel);
		wb.close();
	}

}
