package keypack;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.Test;

public class Start {	
	
	public static WebDriver driver;
	public static XSSFWorkbook Excelbook;
	public static XSSFSheet Excelsheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static String directory=System.getProperty("user.dir");
	public static String path=""+directory+"\\testdata.xlsx";
	public static String pathSC=""+directory+"\\SC\\report.html";
	public static String driverpath=""+directory+"\\Driver\\chromedriver.exe";

	public static void main(String[] args) throws Exception {
		
		WriteToExcel obj=new WriteToExcel();
		obj.write("log 1", "10");
		obj.write("log 2", "50");
		
		ExtentReports extent;
		ExtentTest test;
		extent= new ExtentReports(pathSC);
		test=extent.startTest("Initializing...");
		
		System.setProperty("webdriver.chrome.driver", driverpath);
		ChromeOptions o = new ChromeOptions();
		o.addArguments("disable-extensions");
		o.addArguments("--start-maximized");
		WebDriver driver=new ChromeDriver(o);
		
		File file=new File(Start.path);
		FileInputStream fin= new FileInputStream(file);
		Excelbook= new XSSFWorkbook(fin);
		Excelsheet= Excelbook.getSheet("class");
		int row=Excelsheet.getPhysicalNumberOfRows();
		System.out.println("Number of rows:"+row);
		for(int i=0; i<row; i++)
		{
			cell=Excelsheet.getRow(i).getCell(1);
			String flag=cell.getStringCellValue();
			int noOfColumns = Excelsheet.getRow(i).getLastCellNum();
			System.out.println("Number of columns:"+noOfColumns);
			if(flag.equals("Y"))
			{
				for (int j=2; j<noOfColumns; j++)
				{					
					cell=Excelsheet.getRow(i).getCell(j);
					String method=cell.getStringCellValue();
					System.out.println(method);
					Flow call=new Flow();
					call.method(method, driver, extent, test);
				}
			}
		}
	}

}
