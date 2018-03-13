package Generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class DataExraction implements StandardCons 
{
	public static String getCellValue(String PATH, String sheet, int row, int cell)
	{
		String str=" ";
		
		try 
		{
			FileInputStream fis = new FileInputStream(path);
			Workbook wb = WorkbookFactory.create(fis);
			Cell c = wb.getSheet(sheet).getRow(row).getCell(cell);
			str = c.getStringCellValue();
			
		} 
		catch (Exception e) 
		{
			Reporter.log("the given path is invalid");
		}
		return str;
		
	}
	
	
	
	
	public static void screenShot(String folder, WebDriver driver, String name) throws IOException
	{
		TakesScreenshot screen = (TakesScreenshot) driver;
		File source = screen.getScreenshotAs(OutputType.FILE);
		String date  =new Date().toString().replaceAll(":", "_"); /*new Date().toString().replaceAll(":", "-");*/ 
		//String img = folder+date+name+".jpeg";
		String img = folder+date+".jpeg";
		File destination = new File(img);
		FileUtils.copyFile(source, destination);
	}
	
}
