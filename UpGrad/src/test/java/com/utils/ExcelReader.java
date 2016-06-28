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

     

	public  List<?> readExcel() throws Exception {

		String filename = "resources/movies.xlsx";
		List sheetData = new ArrayList();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filename);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet("Sheet1");
			Iterator rows = sheet.rowIterator();
			while (rows.hasNext()) {
				XSSFRow row = (XSSFRow) rows.next();
				Iterator cells = row.cellIterator();
				List data = new ArrayList();
				while (cells.hasNext()) {
					XSSFCell cell = (XSSFCell) cells.next();
					data.add(cell);
				}
				sheetData.add(data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				fis.close();
			}
		}
		List<String> resultList= new ArrayList<String>();
		
		
		
		for (int i = 0; i < sheetData.size(); i++) {
			List list = (List) sheetData.get(i);
			int colNo = 1;
			for (int j = 0; j < list.size(); j++, colNo++) {
				XSSFCell cell = (XSSFCell) list.get(j);
				String cellValue = cell.getStringCellValue();
				resultList.add(cellValue);
			}
		}
		return	resultList;
	}


}
