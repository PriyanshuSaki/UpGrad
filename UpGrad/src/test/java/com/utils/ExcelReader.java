package com.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class ExcelReader {

     

	public  String[][] readExcel() throws Exception {

		String filename = "resources/movies.xlsx";
		String[][] sheetData = new String[250][3];
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filename);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet("Sheet1");
			int rowCount=0;
			Iterator rows = sheet.rowIterator();
			while (rows.hasNext()) {
				XSSFRow row = (XSSFRow) rows.next();
				Iterator cells = row.cellIterator();
				int colCount=0;
				while (cells.hasNext()) {
					XSSFCell cell = (XSSFCell) cells.next();
					sheetData[rowCount][colCount]=cell.getStringCellValue();
					colCount++;
				}
				rowCount++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				fis.close();
			}
		}
		/*List<String> resultList= new ArrayList<String>();
		
		
		
		for (int i = 0; i < sheetData.size(); i++) {
			List list = (List) sheetData.get(i);
			int colNo = 1;
			for (int j = 0; j < list.size(); j++, colNo++) {
				XSSFCell cell = (XSSFCell) list.get(j);
				String cellValue = cell.getStringCellValue();
				resultList.add(cellValue);
			}
		}*/
		return	sheetData;
	}


}
