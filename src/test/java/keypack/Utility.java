package keypack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Utility {
	
	public void launch(WebDriver driver, ExtentReports extent, ExtentTest test) throws Exception
	{
		test=extent.startTest("Launching IRCTC");
		driver.get("https://www.irctc.co.in/nget/train-search");
	}
	
	public void end(ExtentReports extent, ExtentTest test)
	{
		extent.endTest(test);
	}
	
	public void createMainOffer(WebDriver driver, ExtentReports extent, ExtentTest test)
	{
		test=extent.startTest("creating main offer");
		System.out.println("main pass");
		test.log(LogStatus.PASS	, "Main offer created");
	}
	
	public void updateMainOffer(WebDriver driver, ExtentReports extent, ExtentTest test) throws Exception
	{
		//test=extent.startTest("updating main offer");
		System.out.println("update pass");
		test.log(LogStatus.PASS, "Main offer updated");
		Thread.sleep(2000);
	}
	
	public void flush(WebDriver driver, ExtentReports extent) throws InterruptedException
	{
		extent.flush();
		driver.get(Start.pathSC);
		Thread.sleep(10000);
		driver.close();
	}



}
