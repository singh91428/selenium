package com.appted.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetData {
	public static String getDataFromExcel(String sheetName,int row,int col) {
		String data=null;
		try {
			File file=new File("D:/Autimation_Suite.xlsx");
			FileInputStream fis= new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
	        // spreadsheet object
	        XSSFSheet spreadsheet= workbook.getSheet(sheetName);
	        XSSFRow row1=spreadsheet.getRow(row);
	        XSSFCell cell1=row1.getCell(col);
			data=cell1.getStringCellValue();
			System.out.println(data);
			fis.close();
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
	public static void writeDataToExcel(String sheet,int row,int col,String data) {
		try {
			File file=new File("D:/Autimation_Suite.xlsx");
			FileOutputStream fos=new FileOutputStream(file);
			 XSSFWorkbook workbook = new XSSFWorkbook();
			 XSSFSheet spreadsheet= workbook.createSheet(sheet);
			 XSSFRow erow= spreadsheet.createRow(row);
			 Cell ecell = erow.createCell(col);
			 ecell.setCellValue(data);
			 workbook.write(fos);
			 fos.close();
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
	}
	public static void main(String[] args) {
		try {
			File file=new File("D:/Autimation_Suite.xlsx");
			FileOutputStream fos=new FileOutputStream(file);
			//FileInputStream fis=new FileInputStream(file);
			 XSSFWorkbook workbook = new XSSFWorkbook();
			 XSSFSheet spreadsheet= workbook.getSheet("Scenario");
			 XSSFRow erow= spreadsheet.getRow(2);
			 Cell ecell = erow.getCell(5);
			 ecell.setCellValue("pass");
			 workbook.write(fos);
			 workbook.close();
			 fos.close();
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
		System.out.println("data have writen");
	}
}
