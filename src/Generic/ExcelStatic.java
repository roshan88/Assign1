package Generic;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;

import junit.framework.Assert;

public class  ExcelStatic implements AutoConst
{
	
   public static String getCellValue(String Path,String Sheet, int row,int cell)
   { 
	      String str="";
	  
	   try
	   {
		   FileInputStream fis=new FileInputStream(Path);
		   Workbook wb=  WorkbookFactory.create(fis);
		   Cell c =wb.getSheet(Sheet).getRow(row).getCell(cell);
		   str=c.getStringCellValue();
		   
	   }
	   catch(Exception e)
	   {
		   Reporter.log("path is invalie",true);
		   Assert.fail();
		   
	   }
    
	   return str;
	   
   }
  
   
}
