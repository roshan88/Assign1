package Generic;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class Standard_Test implements StandardCons
{
	public WebDriver driver;
	ExtentReports reports;
	ExtentTest tests;
	
	@BeforeSuite
	public void init()
	{
		String path = reportPath;
		reports = new ExtentReports(path);
	}
	
	@BeforeClass
	public void brow()
	{
		System.setProperty(chrome_key, chrome_value);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@BeforeMethod
	public void openApplication(Method testName)
	{	
		
		DataExraction de =new DataExraction();
		String url = DataExraction.getCellValue(path, "Sheet1", 0, 0);
		driver.get(url);
		String name = testName.getName();
		tests = reports.startTest(name);
		
	}
	
	@AfterMethod
	public void closeApplication(ITestResult results) throws IOException 
	{
		int status = results.getStatus();
		String name = results.getName();
		if(status==1)
		{
			tests.log(LogStatus.PASS,"pass");
			DataExraction.screenShot(image,driver,name);
		}
		else
		{
			tests.log(LogStatus.FAIL,"fail");
			DataExraction.screenShot(image,driver,name);
		}
		reports.endTest(tests);
	
	}
	/*public void screenShot(String name) throws IOException
	{
		TakesScreenshot screen = (TakesScreenshot) driver;
		File source = screen.getScreenshotAs(OutputType.FILE);
		String date  = new Date().toString().replaceAll(":", "-");
		String img = image+date+name+".jpeg";
		File destination = new File(img);
		FileUtils.copyFile(source, destination);
	}*/
	
	@AfterClass
	public void close()
	{
		driver.quit();
	}
	
	@AfterSuite
	public void end()
	{
		reports.flush();
		
	}
	
}
