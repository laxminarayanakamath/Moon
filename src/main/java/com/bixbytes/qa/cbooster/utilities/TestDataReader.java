/**
 * @author:Avaneesha K
   @Company: Bixbytes Solutions
 */

package com.bixbytes.qa.cbooster.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.bixbytes.qa.cbooster.base.Base_Main;

public class TestDataReader extends Base_Main {

	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static HSSFWorkbook hwb;
	public static HSSFSheet hws;
	public static HSSFRow hrow;
	public static HSSFCell hcell;
	public static XSSFWorkbook xwb;
	public static XSSFSheet xws;
	public static XSSFRow xrow;
	public static XSSFCell xcell;

	public static String path = System.getProperty("user.dir")
			+ "\\src\\main\\java\\com\\bixbytes\\qa\\cbooster\\testdata\\TestData.xls";
	public static String extension = FilenameUtils.getExtension(path);

	/* Method to get the Row count */
	public static int getRowCount(String xlsheet) throws IOException {
		fis = new FileInputStream(path);
		int rowcount = 0;

		System.out.println(extension);

		if (extension == "xls") {

			hwb = new HSSFWorkbook(fis);
			hws = hwb.getSheet(xlsheet);
			rowcount = hws.getLastRowNum();
			hwb.close();
			fis.close();

		} else if (extension == "xlsx") {
			xwb = new XSSFWorkbook(fis);
			xws = xwb.getSheet(xlsheet);
			rowcount = xws.getLastRowNum();
			xwb.close();
			fis.close();

		} else {
			logger.info("Wrong Excel file extension detected");

		}
		return rowcount;
	}

	/* Method to get the Cell count */
	public static int getCellCount(String xlsheet) throws IOException {
		int rownum = 0;
		int cellcount = 0;
		fis = new FileInputStream(path);

		if (extension == "xls") {
			hwb = new HSSFWorkbook(fis);
			hws = hwb.getSheet(xlsheet);
			hrow = hws.getRow(rownum);
			cellcount = hrow.getLastCellNum() - 1;
			hwb.close();
			fis.close();
		} else if (extension == "xlsx") {
			xwb = new XSSFWorkbook(fis);
			xws = xwb.getSheet(xlsheet);
			xrow = xws.getRow(rownum);
			cellcount = xrow.getLastCellNum() - 1;
			xwb.close();
			fis.close();
		} else {
			logger.info("Wrong Excel file extension detected");
		}
		return cellcount;
	}

	/* Method to get the cell data in an array as return */
	public static String[][] getcelldata(String xlsheet) throws IOException {
		fis = new FileInputStream(path);
		int rowcounts = 0;
		String[][] rowcol = null;

		if (extension == "xls") {

			hwb = new HSSFWorkbook(fis);
			hws = hwb.getSheet(xlsheet);

			rowcounts = hws.getLastRowNum();
			hrow = hws.getRow(0);
			int cellcounts = hrow.getLastCellNum() - 1;

			int i = 0, j = 0;
			String cellData = null;
			rowcol = new String[rowcounts + 1][cellcounts + 1];

			for (i = 1; i <= rowcounts; i++) {
				for (j = 0; j <= cellcounts; j++) {
					hrow = hws.getRow(i);
					hcell = hrow.getCell(j);
					DataFormatter formatter = new DataFormatter();
					cellData = formatter.formatCellValue(hcell);
					rowcol[i][j] = cellData;
				}
				j = i;

			}

		} else if (extension == "xlsx") {
			xwb = new XSSFWorkbook(fis);
			xws = xwb.getSheet(xlsheet);

			rowcounts = xws.getLastRowNum();
			xrow = xws.getRow(0);
			int cellcounts = xrow.getLastCellNum() - 1;

			int i = 0, j = 0;
			String cellData = null;
			rowcol = new String[rowcounts + 1][cellcounts + 1];

			for (i = 1; i <= rowcounts; i++) {
				for (j = 0; j <= cellcounts; j++) {
					xrow = xws.getRow(i);
					xcell = xrow.getCell(j);
					DataFormatter formatter = new DataFormatter();
					cellData = formatter.formatCellValue(xcell);
					rowcol[i][j] = cellData;
				}
				j = i;

			}

		} else {
			logger.info("Wrong Excel file extension detected");
		}
		return rowcol;

	}

	/* Method to get the data in the cell */
	public static String getCellData(String xlsheet, int rownum, int colnum) throws IOException {

		fis = new FileInputStream(path);
		String data = null;
		if (extension == "xls") {

			hwb = new HSSFWorkbook(fis);
			hws = hwb.getSheet(xlsheet);
			hrow = hws.getRow(rownum);
			hcell = hrow.getCell(colnum);

			try {
				DataFormatter formatter = new DataFormatter();
				String cellData = formatter.formatCellValue(hcell);
				return cellData;
			} catch (Exception e) {
				data = "";
			}
			hwb.close();
			fis.close();
		} else if (extension == "xlsx") {
			xwb = new XSSFWorkbook(fis);
			xws = xwb.getSheet(xlsheet);
			xrow = xws.getRow(rownum);
			xcell = xrow.getCell(colnum);

			try {
				DataFormatter formatter = new DataFormatter();
				String cellData = formatter.formatCellValue(xcell);
				return cellData;
			} catch (Exception e) {
				data = "";
			}
			xwb.close();
			fis.close();
		}

		else {
			logger.info("Wrong Excel file extension detected");
		}
		return data;
	}

	/* Method to get the update the cell data */
	public static void setCellData(String path, String xlsheet, int rownum, int colnum, String data)
			throws IOException {
		fis = new FileInputStream(path);

		if (extension == "xls") {
			hwb = new HSSFWorkbook(fis);
			hws = hwb.getSheet(xlsheet);
			hrow = hws.getRow(rownum);
			hcell = hrow.createCell(colnum);
			hcell.setCellValue(data);
			fos = new FileOutputStream(path);
			hwb.write(fos);
			hwb.close();
			fis.close();
			fos.close();
		} else if (extension == "xlsx") {
			xwb = new XSSFWorkbook(fis);
			xws = xwb.getSheet(xlsheet);
			xrow = xws.getRow(rownum);
			xcell = xrow.createCell(colnum);
			xcell.setCellValue(data);
			fos = new FileOutputStream(path);
			xwb.write(fos);
			xwb.close();
			fis.close();
			fos.close();
		} else {
			logger.info("Wrong Excel file extension detected");
		}

	}

}
