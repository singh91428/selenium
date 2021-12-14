package com.appted.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetData {
	public static String getDataFromExcel(String sheetName,int row,int col) {
		String data=null;
		try {
			File file=new File("D:\\SeleniumTestNG\\EcommerceDataTest.xlsx");
			FileInputStream fis= new FileInputStream(file);
			Workbook book=WorkbookFactory.create(fis);
			Sheet seet=book.getSheet(sheetName);
			Row r=seet.getRow(row);
			Cell c=r.getCell(col);
			data=c.toString();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
	}
}
