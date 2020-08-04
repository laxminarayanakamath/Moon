/**
 * @author:Avaneesha K
   @Company: Bixbytes Solutions
 */

package com.bixbytes.qa.cbooster.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestDataReader {

	public void readdata(String Path, String FileName, String Sheetname) throws IOException {
		File file = new File(Path + "\\" + FileName);

		FileInputStream fis = new FileInputStream(Path);
		Workbook wb = null;
		String fileExtensionName = FileName.substring(FileName.indexOf("."));

		if (fileExtensionName.equals(".xlsx")) {
			wb = new XSSFWorkbook(fis);

		}

		else if (fileExtensionName.equals(".xls")) {

			wb = new HSSFWorkbook(fis);

		}

		// Read sheet inside the workbook by its name

		Sheet sht = wb.getSheet(Sheetname);
		int rowCount = sht.getLastRowNum() - sht.getFirstRowNum();

		for (int i = 0; i < rowCount + 1; i++) {

			Row rw = sht.getRow(i);
			for (int j = 0; j < rw.getLastCellNum(); j++) {

				System.out.print(rw.getCell(j).getStringCellValue() + "|| ");

			}

			System.out.println();
		}

	}

	private void main(String args[]) throws IOException {
		// TODO Auto-generated method stub
		String path = ".\\Users\\OFFICE\\git\\repository\\cboostertest\\src\\main\\java\\com\\bixbytes\\qa\\cbooster\\testdata";
		String Filename = "TestData.xls";
		String Sheetname = "Login";

		TestDataReader td = new TestDataReader();

		td.readdata(path, Filename, Sheetname);

	}

}
