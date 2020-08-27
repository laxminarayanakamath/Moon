/**
 * @author:Avaneesha K
   @Company: Bixbytes Solutions
 */
package com.bixbytes.qa.cbooster.commonmethods;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.bixbytes.qa.cbooster.base.Base_Main;

public class GetTableData extends Base_Main {

	/* Method to cross verify in the Grid already inserted product exist Or not */
	public String getGridRows(String rowsxpath, String colpath, String beforexpath, String afterxpath,
			String producttypes) {
		int i = 0, j = 0;
		String content = null;
		String finalxpath = null;

		List<WebElement> rows = driver.findElements(By.xpath(rowsxpath));
		int rowcount = rows.size();

		List<WebElement> cols = driver.findElements(By.xpath(colpath));
		int colcount = cols.size() - 1;

		for (i = 1; i <= rowcount; i++) {
			for (j = 1; j <= colcount; j++) {

				finalxpath = beforexpath + i + afterxpath + j + "]";
				content = driver.findElement(By.xpath(finalxpath)).getText();

				if (content.equalsIgnoreCase(producttypes)) {
					System.out.println("Respective added product Is:" + producttypes
							+ "And product name taken from Grid:" + content + "are matching");
					break;
				}
				break;

			}

			break;
		}
		return content;

	}

}
