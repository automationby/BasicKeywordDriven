package keypack;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Flow {
	
	public void method(String methodcall, WebDriver driver, ExtentReports extent, ExtentTest test) throws Exception
	{
		Utility start=new Utility();
		switch(methodcall)
		{	
		
		case "launch":
			start.launch(driver, extent, test);	
			break;
		
		case "end":
			start.end(extent, test);
			break;
		
		case "createMainOffer":
			start.createMainOffer(driver, extent, test);
			break;
		
		case "updateMainOffer":
			start.updateMainOffer(driver, extent, test);
			break;
		
		case "flush":
			start.flush(driver, extent);
			
		
		
		
		
		
		
		
		}
	}
}
