package apptad.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadWriteFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		File f=new File("D:\\SeleniumTestNG\\StudentData.xlsx");
		FileInputStream fis=new FileInputStream(f);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheet=wb.getSheet("Sheet1");
		
		//read last data
		
		
		//Row row6=sheet.getRow(5);
		Row row6=sheet.getRow(sheet.getLastRowNum());
		//Cell cell1=row6.getCell(0);
		Cell cell1=row6.getCell(0);
		Cell cell2=row6.getCell(1);
		System.out.println(cell1+"----"+cell2);
		
		//write to last row
		FileOutputStream fos=new FileOutputStream(f);
		Row row7=sheet.getRow(5);
		Cell cell_7_1=row7.getCell(0);
		Cell cell_7_2=row7.getCell(1);
		cell_7_1.setCellValue("Akash");
		cell_7_2.setCellValue("21");
		System.out.println("Data Write Successfully");
	}

}
