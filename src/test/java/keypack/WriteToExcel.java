package keypack;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteToExcel {
	public static XSSFWorkbook book;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static String directory=System.getProperty("user.dir");
	public static String path=""+directory+"\\writeHere.xlsx";
	
	public void write( String valueOne, String valueTwo) throws Exception{
	//int rowOne, int colOne, String valueOne, int rowTwo, int colTwo, String valueTwo
	try {
		
		FileInputStream fileOut = new FileInputStream(path); 
		
		book=new XSSFWorkbook(fileOut);
		//sheet=new XSSFSheet();
		sheet = book.getSheet("student");
		
		 Row row = sheet.createRow(0);		
		 Cell cell = row.createCell(0);
		 cell.setCellValue("Activity");
		 
		 //Row row1 = sheet.createRow(0);		
		 Cell cell1 = row.createCell(1);
		 cell1.setCellValue("Total Time in Secs");
		 
		//Sheet sheet = wb.getSheetAt(0);
		for (int index = sheet.getLastRowNum(); index >= sheet.getFirstRowNum(); index--) {
			sheet.removeRow( sheet.getRow(index));
	    }
		 int rownum=sheet.getPhysicalNumberOfRows();
		 System.out.println(rownum);
		 
		 Row row1 = sheet.createRow(rownum);		
		 Cell cell2 = row1.createCell(0);
		 cell2.setCellValue(valueOne);
		 
		 Cell cell3 = row1.createCell(1);
		 cell3.setCellValue(valueTwo);
		 
		 File file=new File(path);
		 FileOutputStream out = new FileOutputStream(file);
         book.write(out);
         out.close();
		 
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
}
}